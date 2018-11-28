package com.pacto.web.controller;

import com.pacto.web.model.User;
import com.pacto.web.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class OtherController2
{

    @Autowired
    private UserService userService;
    @RequestMapping(value="/landing", method = RequestMethod.GET)
    public ModelAndView landing(){
        ModelAndView mv = new ModelAndView();
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User user = userService.findUserByEmail(auth.getName());
        mv.setViewName("landing");
        return mv;
    }


}
