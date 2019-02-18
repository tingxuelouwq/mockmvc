package com.kevin.controller;

import com.kevin.entity.Member;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 * 类名: ModelController<br/>
 * 包名：com.kevin.controller<br/>
 * 作者：kevin<br/>
 * 时间：2019/2/18 11:14<br/>
 * 版本：1.0<br/>
 * 描述：
 */
@Controller
@RequestMapping("/model")
public class ModelController {

    @ModelAttribute
    public void dummyMember(@RequestParam(value = "id", required = false) Integer id,
                            Model model) {
        if (id != null) {
            // 模拟从数据库中根据id取出Member对象
            System.out.println("从数据库中取出成员信息");
            Member member = new Member(1, "kevin", "123456", "kevin@126.com", 27);
            model.addAttribute("member", member);
        }
    }

    @RequestMapping(value = "", method = RequestMethod.GET)
    public String index() {
        return "model";
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    public String updateMember(Member member) {
        System.out.println("更新" + member);
        return "success";
    }
}
