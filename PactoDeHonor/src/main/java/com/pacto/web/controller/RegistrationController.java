
package com.pacto.web.controller;

import javax.validation.Valid;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import com.pacto.web.model.User;
import com.pacto.web.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;



@Controller
public class RegistrationController {

    @Autowired
    private UserService userService;



    @RequestMapping(value="/registration", method = RequestMethod.GET)
    public ModelAndView registration(){
        ModelAndView mv = new ModelAndView();
        User user = new User();
        mv.addObject("user", user);
        mv.setViewName("registration");
        return mv;
    }

    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public ModelAndView createNewUser(@Valid User user, BindingResult bindingResult) throws InterruptedException {
        ModelAndView mv = new ModelAndView();
        User userExists = userService.findUserByEmail(user.getEmail());
        if (bindingResult.hasErrors()) {
            mv.setViewName("registration");
        } else {
            userService.saveUser(user);
            mv.addObject("user", new User());
           // mv.wait();
            mv.setViewName("login");
        }
        return mv;
    }}
