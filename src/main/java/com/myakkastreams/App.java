package com.myakkastreams;


import java.util.concurrent.ExecutionException;

public class App
{
    public static void main( String[] args ) throws ExecutionException, InterruptedException {
        SprintOne sprintOne = new SprintOne();

        sprintOne.demonstrateSource();
    }
}
