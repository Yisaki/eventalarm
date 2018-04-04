<!DOCTYPE html>
<html>
<head>
    <title>Title</title>
<#include "../base/header.ftl">

</head>
<body>

<div class="container">



    <table class="table table-bordered">
        <thead>
        <tr>
            <th scope="col">id</th>
            <th scope="col">告警日期</th>
            <th scope="col">提前小时数</th>
            <th scope="col">描述</th>
            <th scope="col">告警次数</th>
            <th scope="col">状态</th>
            <th scope="col">创建时间</th>
        </tr>
        </thead>
    <#list alarmTaskList as alarmTask>
        <tr>
            <td>${alarmTask.id}</td>
            <td>${alarmTask.alarmTime?datetime}</td>
            <td>${alarmTask.alarmFix}</td>
            <td>${alarmTask.alarmDesc}</td>
            <td>${alarmTask.alarmCount}</td>
            <td>${alarmTask.status}</td>
            <td>${alarmTask.createTime?datetime}</td>
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
