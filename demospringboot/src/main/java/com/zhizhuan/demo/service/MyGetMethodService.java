package com.zhizhuan.demo.service;

import com.zhizhuan.demo.SpringbootdemoApplication;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * 读取模板的接口
 */
//SpringMVC 写法
//@Controller
//public class MyGetMethodService {
//    /**
//     * @Controller 返回的是页面跳转
//     * @ResponseBody 需要返回JSON时添加
//     *
//     */
//    @RequestMapping("/getUser")
//    @ResponseBody
//    public String getUser(){
//        return "zhihuan";
//    }
//}

@RestController
public class MyGetMethodService {
    @Value("${demo.name}")
    private String name;
    @Value("${demo.age}")
    private String age;

    /**
     * @RestController 与 @Controller 的区别
     * 在类前添加RestController注解，表示在该类中的所有SpringMVC映射返回的都是JSON格式
     * RestController=Controller+ResponseBody
     * @RestController 是SpringMVC提供，不是Spring Boot提供
     * Rest 微服务接口开发使用Rest风格 数据传输格式是json格式  HTTP协议
     * @RequestMapping 定义URL映射
     * @Controller 是控制层注解，SpringMVC接口映射默认返回页面，想要返回json就要加上ResponseBody注解
     * @Value 读取本地配置，Spring提供
     */
    @RequestMapping("/getUser")
    public String getUser(){
        return "zhihuan";
    }
    @RequestMapping("/getPropertis")
    public String getPropertis(){
        return name+"---"+age;
    }
//    public static void main(String[] args) {
//        /**
//         * 启动类入口
//         * @EnableAutoConfiguration 需添加启动配置
//         */
//        SpringApplication.run(MyGetMethodService.class, args);
//    }
}


