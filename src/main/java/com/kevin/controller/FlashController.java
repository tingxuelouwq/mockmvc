package com.kevin.controller;

import com.kevin.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 * 类名: FlashController<br/>
 * 包名：com.kevin.controller<br/>
 * 作者：kevin<br/>
 * 时间：2019/2/18 16:26<br/>
 * 版本：1.0<br/>
 * 描述：
 */
@Controller
@RequestMapping("/flash")
public class FlashController {

    @RequestMapping(value = "", method = RequestMethod.POST)
    public ModelAndView add(User user, RedirectAttributes redirectAttributes) {
        redirectAttributes.addAttribute("test", "1243");
        redirectAttributes.addFlashAttribute("user", user);

        ModelAndView mv = new ModelAndView();
        mv.addObject("test", "123");
        mv.setViewName("redirect:/flash/show");
//        mv.setViewName("redirect:/show.jsp");
        return mv;
    }

    @RequestMapping(value = "show")
    public ModelAndView showUser(String test,
//                                 @ModelAttribute("user") User user,
                                 User user) {
        if (test != null) {
            System.out.println(test);
        }
        if (user != null) {
            System.out.println(user);
        }

        ModelAndView mv = new ModelAndView();
        mv.setViewName("show");
        return mv;
    }
}
