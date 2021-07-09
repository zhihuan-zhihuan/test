package com.zhizhuan.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
/**
 * 启动类
 * 报错：Failed to configure a DataSource: ‘url’ attribute is not specified and no embedd
 * 解决方法：@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
 * 原因：引入了数据库mvn包但是在检查到数据库驱动的时候没有配置数据库url的属性
 *
 * @EnableAutoConfiguration 当前类的方法注入到启动类
 * @ComponentScan SpringMVC提供，扫描当前启动类同级包以及子类包，需要定义范围
 * @SpringBootApplication 包含了EnableAutoConfiguration+ComponentScan
 *
 * 传统项目分层：
 * contortller：视图层，控制层
 * service：业务逻辑（接口层）
 * dao：数据库访问层
 *
 * 分布式/微服务 可能会前后端分离，专业的人做专业的事，前端渲染页面，后端提供接口
 *
 * Spring  Boot使用模板引擎，帮助seo找到网页
 * 模板引擎避免使用JSP：
 * thymeleaf
 * freemarker
 * 还有3种不常用：velocity，Groovy，mustache
 *
 * Field jdbcTemplate in com.zhizhuan.demo.service.UserService required a bean of type 'org.springframework.jdbc.core.JdbcTemplate' that could not be found.
 * 配置了数据库后去掉exclude = DataSourceAutoConfiguration.class
 */
@SpringBootApplication()
@EnableAutoConfiguration
//扫包注解
//@ComponentScan("com.zhizhuan.demo")
public class SpringbootdemoApplication {
	//主方法入口
	public static void main(String[] args) {
		SpringApplication.run(SpringbootdemoApplication.class, args);
	}

}
