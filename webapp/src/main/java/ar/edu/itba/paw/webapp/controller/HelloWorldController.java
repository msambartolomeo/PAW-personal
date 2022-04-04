package ar.edu.itba.paw.webapp.controller;

import ar.edu.itba.paw.interfaces.UserService;
import ar.edu.itba.paw.model.User;
import ar.edu.itba.paw.webapp.exception.UserNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloWorldController {

    private final UserService userService;

    @Autowired
    public HelloWorldController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(value = "/", method = { RequestMethod.GET, RequestMethod.HEAD })
    public ModelAndView helloWorld(@RequestParam(name = "userId", defaultValue = "1") final long userId) {
        final ModelAndView mav = new ModelAndView("index");
        mav.addObject("user", userService.getUserById(userId).orElseThrow(UserNotFoundException::new));
        return mav;
    }

    @RequestMapping(value = "/profile/{userId}", method = { RequestMethod.GET, RequestMethod.HEAD })
    public ModelAndView userProfile(@PathVariable("userId") final long userId) {
        final ModelAndView mav = new ModelAndView("index");
        mav.addObject("user", userService.getUserById(userId).orElseThrow(UserNotFoundException::new));
        return mav;
    }

    @RequestMapping(value = "/create", method = { RequestMethod.GET })
    public ModelAndView createForm() {
        return new ModelAndView("helloworld/register");
    }

    @RequestMapping(value = "/create", method = { RequestMethod.POST })
    public ModelAndView create(@RequestParam(value = "user") final String username, @RequestParam(value = "pass") final String password) {



        final User user = userService.create(username, password);
        return new ModelAndView("redirect:/profile/" + user.getId());
    }

    @ExceptionHandler(UserNotFoundException.class)
    @ResponseStatus(code = HttpStatus.NOT_FOUND)
    public ModelAndView handleUserNotFoundException() {
        return new ModelAndView("error/404");
    }

}
