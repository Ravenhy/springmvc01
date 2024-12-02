package com.controller;

import com.pojo.SmbmsUser;
import com.utils.ResultJSON;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Arrays;
import java.util.Map;

@Controller
@RequestMapping("/abc")
//以上两个相当于@RestController
public class indexController {

    @RequestMapping("/index")
    public ModelAndView index(
            @RequestParam(value = "username", required = false, defaultValue = "小明") String name) {
        ModelAndView modelAndView = new ModelAndView();
        // 设置视图名称
        modelAndView.setViewName("/index.jsp");
        // 将 name 属性添加到 Model
        modelAndView.addObject("name", name);
        return modelAndView;
    }

    @RequestMapping("/qqq")
    public String aaa(SmbmsUser smbmsUser) {
        System.out.println(smbmsUser.getUserName());
        return "smbmsUser";
    }

    @RequestMapping("/bbb")
    public ModelAndView www(SmbmsUser smbmsUser) {
        ModelAndView modelAndView = new ModelAndView("/index.jsp");
        modelAndView.addObject("smbmsUser", smbmsUser);
        return modelAndView;
    }

    //只用这个
    @RequestMapping("/ccc")
    public String index(SmbmsUser smbmsUser, Model model) {
        model.addAttribute("smbmsUser", smbmsUser);
        return "/index.jsp";
    }

    //或者这个
    @RequestMapping("/ddd")
    public String index1(SmbmsUser smbmsUser, Map<String, Object> map) {
        map.put("smbmsUser", smbmsUser);
        return "/index.jsp";
    }

    @RequestMapping(value = "/ggg")
    public String index1(@ModelAttribute("smbmsUser") SmbmsUser smbmsUser) {
        smbmsUser.setUserName("张三");
        return "/index.jsp";
    }

    @ResponseBody //返回json数据 一般用于方法上
    @RequestMapping(value = "/testjson/{userid}.html")
    public ResultJSON jsons(@PathVariable int userid) {
        SmbmsUser smbmsUser = new SmbmsUser();
        smbmsUser.setUserName("小王企鹅");

        SmbmsUser smbmsUser1 = new SmbmsUser();
        smbmsUser1.setUserName("Da王企鹅");

        SmbmsUser smbmsUser2 = new SmbmsUser();
        smbmsUser2.setUserName("帝王企鹅");

        return ResultJSON.success(Arrays.asList(smbmsUser, smbmsUser1, smbmsUser2));
    }

}
