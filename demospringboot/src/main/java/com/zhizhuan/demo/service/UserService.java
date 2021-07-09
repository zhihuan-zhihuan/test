package com.zhizhuan.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.Map;

@RestController
public class UserService {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    /**
     * 读取数据库的接口
     * @Autowired 通过反射生成set方法进行的赋值，自动装配
     * JdbcTemplate：Jdbc模板
     * insetUser方法完成插入数据库接口
     * @return
     *
     * 先建表结构：
     * CREATE TABLE `users`(
     * `id` INT PRIMARY KEY,
     * `username` VARCHAR(32) NOT NULL,
     * `password` VARCHAR(32) NOT NULL,
     * `nickname` varCHAR(128) DEFAULT '没有昵称呢'
     * )
     * COLLATE='utf8_general_ci';
     *
     * SELECT * FROM users;
     * INSERT INTO users VALUES (NULL,'zhihuan',18);
     * DELETE FROM `zhihuan`.`users` WHERE  `id`= 1;
     */
    @RequestMapping("/register")
    public String register(String userName,Integer passWord,String nickName){
        //防止SQL注入使用?
        int update =jdbcTemplate.update("INSERT INTO users VALUES (1,?,?,?);",userName,passWord,nickName);
        //执行sql的受影响记录行数给到一个变量，判断是否执行成功
        return update>0 ? "注册成功":"注册失败";
    }

    @RequestMapping("/login")
    public String login(String userName, String passWord){
        String sql1 ="SELECT password FROM users WHERE username=?;";
        /**
         * 单个字段返回用单个类型接收
         */
        //数据库取值判断
        String password = jdbcTemplate.queryForObject(sql1, new Object[]{userName}, String.class);
        if (passWord.equals(password)){
            return "登录成功";
        }
        else {
            return "用户名密码不正确！";
        }
    }

    //以下方法是Get请求
    @RequestMapping("/selectnickName")
    public String selectnickName(Integer id){
        String sql1 ="SELECT nickname FROM users WHERE id=?;";
        /**
         * 单个字段返回用单个类型接收
         */
        String nickName = jdbcTemplate.queryForObject(sql1, new Object[]{id}, String.class);
        return nickName;
    }

    @RequestMapping("/queryJson")
    public Map<String, Object> queryJson(String id) {
        /**
         * queryForMap 实现单行查询，返回一个对象
         * 定义方法需要定义成一个对象Json格式
         */
        String sql ="SELECT username,password,nickname FROM users WHERE id=?;";
        Map<String, Object> map = jdbcTemplate.queryForMap(sql, id);
        return map;
    }

}
