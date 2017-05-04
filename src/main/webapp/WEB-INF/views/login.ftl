<!DOCTYPE html> <!-- 使用 HTML5 doctype，不区分大小写 -->
<html lang="zh-cmn-Hans"> <!-- 更加标准的 lang 属性写法 -->
<head>
    <!-- 声明文档使用的字符编码 -->
    <meta charset='utf-8'>
    <!-- 优先使用 IE 最新版本和 Chrome -->
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1"/>

    <title>RSA加密登录示例</title>
</head>

<body>
<div class="content" style="position:absolute;left:50%;transform:translate(-50%);">
    <!-- BEGIN LOGIN FORM -->
    <form class="login-form" action="/login" method="POST">
        <h3 class="form-title">RSA加密登陆测试</h3>
        <div class="alert alert-danger display-hide">
            <span>请输入用户名和密码！</span>
        </div>
        <div class="form-group">
            <div class="input-icon">
                <i class="fa fa-user"></i>
                <input class="form-control placeholder-no-fix" type="text" autocomplete="off" placeholder="用户名"
                       name="username"/>
            </div>
        </div>
        <div class="form-group">
            <div class="input-icon">
                <i class="fa fa-lock"></i>
                <input class="form-control placeholder-no-fix" type="password" autocomplete="off" placeholder="密码"
                       name="password"/>
            </div>
        </div>
        <div>
            <button type="button" id="btnLogin" class="btn green pull-right">登陆</button>
        </div>
        <div>
            <span>演示用户名1: admin, 密码: admin</span> <br/>
            <span>演示用户名2: lihu, 密码: 123456</span>
        </div>
    </form>
</div>

<script src="resources/scripts/jquery-1.10.2.min.js" type="text/javascript"></script>
<script src="resources/scripts/jsencrypt.min.js" type="text/javascript"></script>
<script src="resources/scripts/login.js" type="text/javascript"></script>

<script>
    jQuery(document).ready(function () {
        Login.init();
    });
</script>
</body>