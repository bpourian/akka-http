//package com.myakkastreams;
//
//
//import akka.actor.ActorSystem;
//import akka.http.Http;
//import akka.http.model.HttpRequest;
//import akka.http.model.HttpResponse;
//import akka.stream.javadsl.Flow;
//import akka.stream.javadsl.Sink;
//import akka.stream.javadsl.Source;
//
//import java.util.concurrent.CompletionStage;
//
//public class JiraApi {
//
//    private String uri = "https://jira.intdigital.ee.co.uk/rest/api/2/issue/DEL-79343";
//
//
//    public void test() {
//
//        final ActorSystem system = ActorSystem.create();
//        final ActorMaterializer materializer = ActorMaterializer.create(system);
//
//        final Flow<HttpRequest, HttpResponse, CompletionStage<Http.OutgoingConnection>> connectionFlow =
//                Http.get(system).outgoingConnection(toHost("akka.io", 80));
//        final CompletionStage<HttpResponse> responseFuture =
//                Source.single(HttpRequest.create("/"))
//                        .via(connectionFlow)
//                        .runWith(Sink.<HttpResponse>head(), materializer);
//    }
//
//
//}
//
//
