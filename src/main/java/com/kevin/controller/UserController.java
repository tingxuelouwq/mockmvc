package com.kevin.controller;

import com.kevin.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.FlashMap;
import org.springframework.web.servlet.FlashMapManager;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.support.RequestContextUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/users")
public class UserController {

    @RequestMapping("/{id}")
    public ModelAndView getByUserId(@PathVariable("id") Long id) {
        User user = new User();
        user.setId(id);
        user.setName("test");

        ModelAndView mv = new ModelAndView();
        mv.addObject("user", user);
        mv.setViewName("user/show");
        return mv;
    }

//    /**
//     * forward
//     * @param user
//     * @param request
//     * @return
//     */
//    @RequestMapping(value = "", method = RequestMethod.POST)
//    public ModelAndView add(User user, HttpServletRequest request) {
//        request.setAttribute("user", user);
//
//        ModelAndView mv = new ModelAndView();
//        mv.setViewName("show");
//        return mv;
//    }

    /**
     * redirect
     * @param user
     * @param redirectAttributes
     * @return
     */
    @RequestMapping(value = "", method = RequestMethod.POST)
    public ModelAndView add(User user, RedirectAttributes redirectAttributes) {
        redirectAttributes.addAttribute("test", "1243");
        redirectAttributes.addFlashAttribute("user", user);

        ModelAndView mv = new ModelAndView();
        mv.addObject("test", "123");
        mv.setViewName("redirect:/users/show");
//        mv.setViewName("redirect:/show.jsp");
        return mv;
    }

    @RequestMapping(value = "show")
    public ModelAndView showUser(@RequestParam("test") String test,
//                                 @ModelAttribute("user") User user,
                                 User user) {
        if (test != null) {
            System.out.println(test);
        }
        if (user != null) {
            System.out.println(user.getName());
        }

        ModelAndView mv = new ModelAndView();
        mv.setViewName("show");
        return mv;
    }
}