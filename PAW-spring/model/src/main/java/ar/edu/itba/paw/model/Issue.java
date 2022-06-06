package ar.edu.itba.paw.model;

import javax.persistence.*;

@Entity
public class Issue {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "issues_issueid_seq")
    @SequenceGenerator(allocationSize = 1, name = "issues_issueid_seq", sequenceName = "issues_issueid_seq")
    private Long id;

    @Column(nullable = false, length = 1024)
    private String description;

    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private User reportedBy;

    @ManyToOne(fetch = FetchType.EAGER)
    private User assignedTo;

    @Enumerated(EnumType.STRING)
    private Status status;

    @Enumerated(EnumType.STRING)
    private Priority priority;

    Issue() {}

    public Issue(String description, User reportedBy, Priority priority) {
        super();
        this.description = description;
        this.reportedBy = reportedBy;
        this.status = Status.NOT_STARTED;
        this.priority = priority;
        this.assignedTo = null;
    }

    public void setAssignedTo(User assignedTo) {
        this.assignedTo = assignedTo;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public void setPriority(Priority priority) {
        this.priority = priority;
    }

    public Long getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public User getReportedBy() {
        return reportedBy;
    }

    public User getAssignedTo() {
        return assignedTo;
    }

    public Status getStatus() {
        return status;
    }

    public Priority getPriority() {
        return priority;
    }
}
