function ajax(url,methodType,data,callback) {
    var method="";
    if(1==methodType){
        method="POST";
    }else{
        method="GET";
    }

    $.ajax({
        url:url,
        method:method,
        data:data,
        success:function (resp) {
            if(resp.code!=1){
                alert(resp.desc);
                return;
            }

            callback(resp);
        }
    })
}