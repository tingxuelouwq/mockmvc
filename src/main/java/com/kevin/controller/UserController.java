package com.kevin.controller;

import com.kevin.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/users")
public class UserController {

    @RequestMapping(value = "", method = RequestMethod.GET)
    public String index() {
        return "user";
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    public ModelAndView add(User user) {
        ModelAndView mv = new ModelAndView();
        mv.addObject("user", user);
        mv.setViewName("show");
        return mv;
    }

    @RequestMapping("/{id}")
    public ModelAndView getByUserId(@PathVariable("id") Long id) {
        User user = new User();
        user.setId(id + "");
        user.setName("test");

        ModelAndView mv = new ModelAndView();
        mv.addObject("user", user);
        mv.setViewName("show");
        return mv;
    }
}