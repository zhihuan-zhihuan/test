package com.zhizhuan.demo.service;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;


/**
     * RESTful风格POST请求接口
     * 前端centen-type不同
     * 可选择存入数据库，要保持数据一致，参考Userservice类的方法
     * */
@RestController
public class MyPostMethodService{
    /**
     *
     *  接收 form-data 格式的 POST 数据：
     *
     * */
    @PostMapping("/postNameAge")
    public String formmethod(@RequestParam("name") String name,
                        @RequestParam("age") Integer age) {
        return "postname：" + name + "\npostage：" + age;
    }

    /**
     *
     *  接收 JSON 格式的 POST 数据，输入JSON格式数据
     *
     * */

    @PostMapping("/postJson")
    public Object postJson(@RequestBody String name){
        if (name.equals("{\n" +
                "\t\"name\":\"zhihuan\"\n" +
                "}")){
            return "十分草率的接口，主要验证JSON请求参数";
        }
        else {
            return "参数错误";
        }

    }
}
