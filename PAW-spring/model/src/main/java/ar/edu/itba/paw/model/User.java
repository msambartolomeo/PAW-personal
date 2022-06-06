package ar.edu.itba.paw.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "users_userid_seq")
    @SequenceGenerator(allocationSize = 1, name = "users_userid_seq", sequenceName = "users_userid_seq")
    private Long userId;
    @Column(length = 100, nullable = false, unique = true)
    private String username;
    @Column(length = 100, nullable = false)
    private String password;

    @OneToMany(mappedBy = "assignedTo")
    private List<Issue> assignedIssues;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "reportedBy")
    private List<Issue> reportedIssues;

    User() {}

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    @Deprecated
    public User(long id, String username, String password) {
        this.userId = id;
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public Long getUserId() {
        return userId;
    }

    public List<Issue> getAssignedIssues() {
        return assignedIssues;
    }

    public List<Issue> getReportedIssues() {
        return reportedIssues;
    }

    public Issue reportNewIssue(String description, Priority priority) {
        Issue issue = new Issue(description, this, priority);
        reportedIssues.add(issue);
        return issue;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
