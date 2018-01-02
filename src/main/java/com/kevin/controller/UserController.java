package com.kevin.controller;

import com.kevin.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/users")
public class UserController {

    @RequestMapping("/{id}")
    public ModelAndView view(@PathVariable("id") Long id,
                             HttpServletRequest request) {
        User user = new User();
        user.setId(id);
        user.setName("test");

        ModelAndView mv = new ModelAndView();
        mv.addObject("user", user);
        mv.setViewName("user/view");
        return mv;
    }
}
