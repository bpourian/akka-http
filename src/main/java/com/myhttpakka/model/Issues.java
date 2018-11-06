package com.myhttpakka.model;

import java.util.ArrayList;
import java.util.List;

public class Issues {

    private final List<Issue> issues;

    public Issues(){

        this.issues = new ArrayList<Issue>();
    }

    public Issues(List<Issue> issues){
        this.issues = issues;
    }

    public List<Issue> getIssues() {
        return issues;
    }
}
