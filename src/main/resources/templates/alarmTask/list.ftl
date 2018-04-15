<!DOCTYPE html>
<html>
<head>
    <title>Title</title>
<#include "../base/header.ftl">

</head>
<body>

<div class="container">
    <#include "../base/nav.ftl">


    <table class="table table-bordered">
        <thead>
        <tr>
            <th scope="col">告警日期</th>
            <th scope="col">提前小时数</th>
            <th scope="col">描述</th>
            <th scope="col">告警次数</th>
            <th scope="col">状态</th>
        </tr>
        </thead>
    <#list alarmTaskList as alarmTask>
        <tr>
           <#-- <td>${alarmTask.id}</td>-->
            <td>${alarmTask.alarmTime?datetime}</td>
            <td>${alarmTask.alarmFix}</td>
            <td>${alarmTask.alarmDesc}</td>
            <td>${alarmTask.alarmCount}</td>
            <td>${alarmTask.status}</td>
        </tr>
    </#list>
    </table>
</div>


<#include "../base/footer.ftl">
<script type="text/javascript">
    jQuery(function(){
        console.log("hello");
    })

</script>
</body>
</html>
