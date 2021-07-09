<!DOCTYPE html>
<html>
<head  lang="en">
    <meta charset="utf-8"/>
    <title>登录页面</title>
</head>
<body>
<h1>注册页面</h1>
<div class="uinArea">
    <lable class="input_tips" style="display: block;">ID</lable>
    <div class="inputpass">
        <input type="text">
    </div>
</div>
<div class="uinArea">
    <lable class="input_tips" style="display: block;">用户名登录</lable>
    <div class="inputuser">
        <input type="text">
    </div>
</div>
<div class="uinArea">
    <lable class="input_tips" style="display: block;">密码</lable>
    <div class="inputpass">
        <input type="text">
    </div>
</div>
<div class="uinArea">
    <lable class="input_tips" style="display: block;">昵称</lable>
    <div class="inputpass">
        <input type="text">
    </div>
</div>
<div class="uinArea">
    <lable class="input_tips" style="display: block;">登录</lable>
    <div class="inputpass">
        <input type="submit">
    </div>
</div>













${name}
<#if sex=="0">
    男
    <#else>
    女
</#if>
<#list userlist as user>
    ${user}
</#list>
</body>
</html>
