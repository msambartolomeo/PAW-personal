package ar.edu.itba.paw.webapp.dto;

import ar.edu.itba.paw.model.User;

import javax.ws.rs.core.UriBuilder;
import javax.ws.rs.core.UriInfo;
import java.net.URI;
import java.net.URL;

public class UserDto {

    private String username;
    private URI self;
    private URI assignedIssues;
    private URI reportedIssues;

    public static UserDto fromUser(final UriInfo uriInfo, final User user) {
        final UserDto dto = new UserDto();

        dto.username = user.getUsername();

        final UriBuilder userUriBuilder = uriInfo.getAbsolutePathBuilder().replacePath("users").path(String.valueOf(user.getUserId()));

        dto.self = userUriBuilder.build();

        final UriBuilder issuesUriBuilder = uriInfo.getAbsolutePathBuilder().replacePath("issues");

        dto.assignedIssues = issuesUriBuilder.queryParam("assignedTo", String.valueOf(user.getUserId())).build();
        dto.reportedIssues = issuesUriBuilder.queryParam("reportedBy", String.valueOf(user.getUserId())).build();

        return dto;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public URI getSelf() {
        return self;
    }

    public void setSelf(URI self) {
        this.self = self;
    }

    public URI getAssignedIssues() {
        return assignedIssues;
    }

    public void setAssignedIssues(URI assignedIssues) {
        this.assignedIssues = assignedIssues;
    }

    public URI getReportedIssues() {
        return reportedIssues;
    }

    public void setReportedIssues(URI reportedIssues) {
        this.reportedIssues = reportedIssues;
    }
}
