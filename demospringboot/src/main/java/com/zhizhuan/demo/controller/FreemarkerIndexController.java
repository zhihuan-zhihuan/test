package com.zhizhuan.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Map;

@Controller
public class FreemarkerIndexController {
    @GetMapping("/freemarkerIndex")
    public String freemarkerIndex(Model model){
        /**
         *读取页面的接口
         * @Controller返回的是页面跳转
         * 转发数据到页面展示 key：name  value：zhihuan
         */
        model.addAttribute("name","lili");
        model.addAttribute("age","22");
        model.addAttribute("sex","0");
        ArrayList<String> userlist = new ArrayList<String>();
        userlist.add("wangxiaoer");
        userlist.add("zhangshan");
        model.addAttribute("userlist",userlist);

        return "freemarkerindex";

    }
}
