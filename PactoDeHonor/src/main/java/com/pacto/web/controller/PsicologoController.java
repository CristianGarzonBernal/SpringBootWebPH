package com.pacto.web.controller;

import com.pacto.web.model.Misiones;
import com.pacto.web.model.User;
import com.pacto.web.service.MisionesService;
import com.pacto.web.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Map;

@Controller
public class PsicologoController {

    @Autowired
    private UserService userService;
    @Autowired
    private MisionesService misionesService;


    @RequestMapping(value = "/psicologo/home", method = RequestMethod.GET)
    public ModelAndView home(ModelMap map) {
        ModelAndView mv = new ModelAndView();
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User user = userService.findUserByEmail(auth.getName());
        Collection<Misiones> misiones = misionesService.findByAutor(user.getSurname());
        Integer array[] = new Integer[misiones.size()];
        int index = 0;
        for (Misiones mision : misiones) {
            array[index++] = mision.getIdMision();
        }
        Collection<Map> tabla = misionesService.findMisionesByIds(array);
        map.put("tabla", tabla);
        mv.setViewName("psicologo/home");
        return mv;
    }
}