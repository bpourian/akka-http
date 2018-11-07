package com.myakkastreams.model;

public class Issue {

    private final String status;
    private final String title;
    private final String issueType;
    private final String description;
    private final String createdAt;
    private final String closedAt;
    private final String user;

    public Issue() {
        this.status = "";
        this.title = "";
        this.issueType = "";
        this.description = "";
        this.createdAt = "";
        this.closedAt = "";
        this.user = "";

    }

    public Issue(String status, String title, String issueType, String description, String createdAt, String closedAt, String user) {
        this.status = status;
        this.title = title;
        this.issueType = issueType;
        this.description = description;
        this.createdAt = createdAt;
        this.closedAt = closedAt;
        this.user = user;
    }

    public String getStatus() {
        return status;
    }

    public String getTitle() {
        return title;
    }

    public String getIssueType() {
        return issueType;
    }

    public String getDescription() {
        return description;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public String getClosedAt() {
        return closedAt;
    }

    public String getUser() {
        return user;
    }

    @Override
    public String toString() {
        return "Issue{" +
                "status='" + status + '\'' +
                ", title='" + title + '\'' +
                ", issueType='" + issueType + '\'' +
                ", description='" + description + '\'' +
                ", createdAt='" + createdAt + '\'' +
                ", closedAt='" + closedAt + '\'' +
                ", user='" + user + '\'' +
                '}';
    }
}