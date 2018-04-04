<!DOCTYPE html>
<html>
<head>
    <title>Title</title>
   <#include "base/header.ftl">

</head>
<body>

<div class="container">
    <h1>${msg!}</h1>

    <form method="post" action="${basePath}/login">
        <div class="form-group">
            <label for="userName">用户名</label>
            <input type="text" class="form-control" id="userName"  name="userName" />
        </div>
        <div class="form-group">
            <label for="password">密码</label>
            <input type="text" class="form-control" id="password"  name="password">
        </div>



        <button type="submit" class="btn btn-primary mb-2">登陆</button>
    </form>
</div>


<#include "base/footer.ftl">
<script type="text/javascript">
    jQuery(function(){
        console.log("hello");
    })

</script>
</body>
</html>
