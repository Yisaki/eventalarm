<!DOCTYPE html>
<html>
<head>
    <title>Title</title>
   <#include "../base/header.ftl">

</head>
<body>

<div class="container">
    <#include "../base/nav.ftl">

    <form method="post" action="${basePath}/alarmTask/add.htm">
        <div class="form-group">
            <label for="alarmTime">告警日期</label>
            <input type="text" class="form-control" id="alarmTime" placeholder="eg:2018-01-01 01:01:01" name="alarmTime" />
        </div>
        <div class="form-group">
            <label for="alarmFix">提前小时</label>
            <input type="text" class="form-control" id="alarmFix" placeholder="0" name="alarmFix" value="0"/>
        </div>
        <div class="form-group">
            <label for="alarmFix">描述</label>
            <input type="text" class="form-control" id="alarmDesc" placeholder="描述" name="alarmDesc" />
        </div>
        <div class="form-group">
            <label for="alarmTarget">告警目标</label>
            <select class="form-control" id="alarmTarget" name="alarmTarget.id">
                <#list alarmTargetlist as alarmTarget>
                    <option value="${alarmTarget.id}">${alarmTarget.target}-${alarmTarget.type}</option>
                </#list>
            </select>
        </div>

        <button type="submit" class="btn btn-primary mb-2">保存</button>
    </form>
</div>


<#include "../base/footer.ftl">
<script type="text/javascript">
    jQuery(function(){
        console.log("hello");
    })

</script>
</body>
</html>
