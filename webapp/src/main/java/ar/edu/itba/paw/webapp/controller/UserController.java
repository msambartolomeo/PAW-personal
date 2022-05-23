package ar.edu.itba.paw.webapp.controller;

import ar.edu.itba.paw.interfaces.UserService;
import ar.edu.itba.paw.model.User;
import ar.edu.itba.paw.webapp.dto.UserDto;
import ar.edu.itba.paw.webapp.form.UserForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.*;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Path("users")
@Component
public class UserController {

    @Autowired
    private UserService userService;

    @Context
    private UriInfo uriInfo;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    // GET /users
    @GET
    @Produces(value = { MediaType.APPLICATION_JSON })
    public Response listUsers(@QueryParam("page") @DefaultValue("0") int page) {
        final List<UserDto> userList = userService.getAll(page).stream().map(u -> UserDto.fromUser(uriInfo, u)).collect(Collectors.toList());
        if (userList.isEmpty()) {
            return Response.noContent().build();
        }

        return Response.ok(new GenericEntity<List<UserDto>>(userList){})
                .link(uriInfo.getAbsolutePathBuilder().queryParam("page", page - 1).build(), "prev")
                .link(uriInfo.getAbsolutePathBuilder().queryParam("page", page + 1).build(), "next")
                .link(uriInfo.getAbsolutePathBuilder().queryParam("page", 0).build(), "first")
                .link(uriInfo.getAbsolutePathBuilder().queryParam("page", 999).build(), "last")
                .build();
    }

    @Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_FORM_URLENCODED })
    @POST
    public Response createUser(@Valid final UserForm userForm) {

        final User user = userService.create(userForm.getUsername(), userForm.getPassword());

        return Response.created(uriInfo.getAbsolutePathBuilder().path(String.valueOf(user.getUserId())).build()).build();
    }

    @GET
    @Path("/{id}")
    public Response getUser(@PathParam("id") long id) {
        Optional<UserDto> user = userService.getUserById(id).map(u -> UserDto.fromUser(uriInfo, u));

        if (user.isPresent()) {
            return Response.ok(user.get()).build();
        }

        return Response.status(Response.Status.NOT_FOUND).build();
    }

    @DELETE
    @Path("/{id}")
    public Response deleteUser(@PathParam("id") long id) {
        userService.deleteById(id);
        return Response.noContent().build();
    }
}
