<html>
<head>
    <style type="text/css">
        body{ font-size:12px; line-height:24px;}.exp{font-size:x-large;}
    </style>
</head>
<body>
<div class="exp">
    test Login2

    code:<input class="textbox" type="text" id="code" size="15"
                                     value="${code}"/><br>
    result:<input class="textbox" type="text" id="result" size="15"
                value=""/><br>
    <input type="button" value="login" onclick="login()"/><br>


    articleId:<input class="textbox" type="text" id="articleId" size="15"
                     value="4"/><br>
    <input type="button" value="详情" onclick="detail()"/><br>
    <input type="button" value="领红包" onclick="detail()"/><br>
</div>
</body>

<script src="/resources/js/jquery-1.10.2.js"></script>
<script src="/resources/js/jquery-ui.js"></script>
<script src="/resources/js/JsonParser/JsonParser.js"></script>

<script language="javascript" type="text/javascript">
    function login(){
        $.ajax({
            type: "POST",
            url: "/api/customer/login",
            dataType: "json",
            data: JSON.stringify({
                "code": $("#code").val()
            }),
            contentType: "application/json",
            processData: true,
            async : true,
            success: function (data) {
                $("#result").val("success");
            }
            error:function(data){
                $("#result").val("fail");
            }
        })
    }
    function detail(){
        $.ajax({
            type: "GET",
            url: "/api/article/detail?articleId=" + $("#articleId").val(),
            dataType: "json",
            contentType: "application/json",
            processData: true,
            async : true,
            success: function (data) {
                $("#result").val("success detail");
            }
            error:function(data){
                $("#result").val("fail detail");
            }
        })
    }
    function draw(){
        $.ajax({
            type: "GET",
            url: "/api/giftMoney/draw",
            dataType: "json",
            contentType: "application/json",
            processData: true,
            async : true,
            success: function (data) {
                $("#result").val("success draw");
            }
            error:function(data){
                $("#result").val("fail draw");
            }
        })
    }
</script>
</html>