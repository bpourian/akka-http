package com.myakkastreams;

import akka.stream.*;
import akka.stream.javadsl.*;

import akka.Done;
import akka.NotUsed;
import akka.actor.ActorSystem;
import akka.util.ByteString;

import java.nio.file.Paths;
import java.math.BigInteger;
import java.time.Duration;
import java.util.concurrent.CompletionStage;
import java.util.concurrent.ExecutionException;


public class SprintOne {

    public void demonstrateSource() throws ExecutionException, InterruptedException {

        //#create-materializer
        final ActorSystem system = ActorSystem.create("QuickStart");
        final Materializer materializer = ActorMaterializer.create(system);

        //#create-source
        final Source<Integer, NotUsed> source = Source.range(1, 100);

        //#run-source
//        source.runForeach(System.out::println, materializer);
        source.runForeach(i -> System.out.println(i), materializer);

        //#transform-source
        final Source<BigInteger, NotUsed> factorials = source.scan(BigInteger.ONE, (acc, next) -> acc.multiply(BigInteger.valueOf(next)));

        final CompletionStage<IOResult> result =
                factorials
                        .map(num -> ByteString.fromString(num.toString() + "\n"))
                        .runWith(FileIO.toPath(Paths.get("factorials.txt")), materializer);

        //#use-transformed-sink
        factorials.map(BigInteger::toString).runWith(lineSink("factorial2.txt"), materializer);

        //#add-streams
        factorials
                .zipWith(Source.range(0, 99), (num, idx) -> String.format("%d! = %s", idx, num))
                .throttle(1, Duration.ofSeconds(1))
                //#add-streams
                .take(2)
                //#add-streams
                .runForeach(s -> System.out.println(s), materializer);

        //#run-source-and-terminate
        final CompletionStage<Done> done =
                source.runForeach(i -> System.out.println(i), materializer);

        done.thenRun(() -> system.terminate());

        done.toCompletableFuture().get();



    }

    //#transform-sink
    public Sink<String, CompletionStage<IOResult>> lineSink(String filename) {
        return Flow.of(String.class)
                .map(s -> ByteString.fromString(s.toString() + "\n"))
                .toMat(FileIO.toPath(Paths.get(filename)), Keep.right());
    }
}
