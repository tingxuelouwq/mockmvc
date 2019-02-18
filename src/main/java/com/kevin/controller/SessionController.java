package com.kevin.controller;

import com.kevin.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

import java.io.UnsupportedEncodingException;
import java.util.Arrays;

/**
 * 类名: SessionController<br/>
 * 包名：com.kevin.controller<br/>
 * 作者：kevin<br/>
 * 时间：2019/1/25 16:14<br/>
 * 版本：1.0<br/>
 * 描述：
 */
@Controller
@RequestMapping("/session")
@SessionAttributes(value = {"attr1"})
public class SessionController {

    @RequestMapping(value = "", method = RequestMethod.GET)
    public ModelAndView sessionAnnotation() {
        ModelAndView mv = new ModelAndView("forward:/session/obtain");
        mv.addObject("attr1", "attr1Value");
        return mv;
    }

    @RequestMapping(value = "/obtain", method = RequestMethod.GET)
    public ModelAndView sessionObtain(Model model) {
        ModelAndView mv = new ModelAndView("session");
        System.out.println(model.containsAttribute("attr1"));
        mv.addObject("attr2", "attr2Value");
        return mv;
    }

    @RequestMapping(value = "/clear", method = RequestMethod.GET)
    public String clearSessionAnnotation(SessionStatus sessionStatus) {
        sessionStatus.setComplete();
        return "session";
    }

    @RequestMapping(value = "/model", method = RequestMethod.GET)
    public String modelAnnotation(User attr1) {
        System.out.println("attr1: " + attr1);
        return "session";
    }
}
