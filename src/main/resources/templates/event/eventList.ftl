<!DOCTYPE html>
<html>
<head>
    <title>Title</title>

    <#include "../base/header.ftl">

</head>
<body>

<div class="container">

    <#include "../base/nav.ftl">

    <div class="row">&nbsp;</div>
    <!-- Button trigger modal -->
    <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#analysisInfo" id="analysisButton">分析结果</button>

    <div class="row">&nbsp;</div>

    <table class="table table-bordered">
        <thead>
        <tr>
            <#--<th scope="col">id</th>-->
            <th scope="col">发生时间</th>
            <th scope="col">事件类型</th>
            <th scope="col">准确率</th>
            <#--<th scope="col">创建时间</th>-->
        </tr>
        </thead>


    <#list eventList as event>
        <#--事件类型-->
        <#if event.eventType ==1 >
            <#assign eventTypeDesc="coming!">
            <#assign trClass="table-primary">
        <#elseif event.eventType ==2>
            <#assign eventTypeDesc="go~">
            <#assign trClass="">
        </#if>

        <#if event.predictType ==1 >

            <#assign trClass="table-danger">
        </#if>



        <tr class="${trClass}">
            <#--<td>${event.id}</td>-->
            <td>${event.eventTime?date}</td>
            <td>${eventTypeDesc}</td>
            <td>${event.correctScale}</td>
<#--            <td>${(event.predictType==1)?string('是','否')}</td>-->

        </tr>
    </#list>
    </table>

    <!-- Modal -->
    <div class="modal fade" id="analysisInfo" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="exampleModalLabel">分析结果</h5>
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                </div>
                <div class="modal-body">
                    <ul class="list-group" id="analysisResult">
                        <li class="list-group-item"><label>平均持续天数：</label><span></span></li>
                        <li class="list-group-item list-group-item-primary"><label>平均间隔天数：</label><span></span></li>
                        <li class="list-group-item list-group-item-success"><label>下次大姨妈来：</label><span></span></li>
                        <li class="list-group-item list-group-item-danger"><label>下次大姨妈走：</label><span></span></li>
                    </ul>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                    <button type="button" class="btn btn-primary" id="saveEvent">保存为预测</button>

                </div>
            </div>
        </div>
</div>


<#include "../base/footer.ftl">
<script type="text/javascript">

    jQuery(function(){
        jQuery("#analysisButton").click(function(){
            jQuery.ajax({
                url:"${basePath}/event/analysis.do",
                method:"GET",
                success:function (resp) {
                    if(resp.code!=1){
                        alert(resp.desc);
                        return;
                    }

                    var Jresult=jQuery("#analysisResult li");
                    Jresult.eq(0).children("span").html(resp.data.avgLastDay);
                    Jresult.eq(1).children("span").html(resp.data.avgGapDay);
                    Jresult.eq(2).children("span").html(resp.data.nextCome);
                    Jresult.eq(3).children("span").html(resp.data.nextGo);
                }
            })
        })
        
        jQuery("#saveEvent").click(function () {
            var Jresult=jQuery("#analysisResult li");
            //Jresult.eq(0).children("span").html();
            //Jresult.eq(1).children("span").html();
            var nextCome=Jresult.eq(2).children("span").html();
            var nextGo=Jresult.eq(3).children("span").html();

            jQuery.ajax({
                url:"${basePath}/event/saveMextBigAunt.do",
                method:"POST",
                data:{'come':nextCome,'go':nextGo},
                success:function (resp) {
                    if(resp.code!=1){
                        alert(resp.desc);
                        return;
                    }

                    location.reload(true);
                }
            })
        })
    })

</script>
</body>
</html>
