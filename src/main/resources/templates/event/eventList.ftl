<!DOCTYPE html>
<html>
<head>
    <title>Title</title>

    <#include "../base/header.ftl">

</head>
<body>

<div class="container">
    <div class="row">
        <div class="col-12">
            <ul class="nav">
                <li class="nav-item">
                    <a class="nav-link active" href="#">Active</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="#">Link</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="#">Link</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link disabled" href="#">Disabled</a>
                </li>
            </ul>
        </div>
    </div>


    <table class="table table-bordered">
        <thead>
        <tr>
            <th scope="col">id</th>
            <th scope="col">发生时间</th>
            <th scope="col">事件类型</th>
            <th scope="col">准确率</th>
            <th scope="col">预测类型</th>
            <th scope="col">创建时间</th>
        </tr>
        </thead>
    <#list eventList as event>
        <tr>
            <td>${event.id}</td>
            <td>${event.eventTime?date}</td>
            <td>${event.eventType}</td>
            <td>${event.correctScale}</td>
            <td>${event.predictType}</td>
            <td>${event.createTime?datetime}</td>
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
