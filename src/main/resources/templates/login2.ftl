<html>
<body>
<div>
    test Login2

    code:<input class="textbox" type="text" id="code" style="width: 100px;"
                                     value="${code}"/><br>
    result:<input class="textbox" type="text" id="result" style="width: 100px;"
                value=""/><br>
    <input type="button" value="login" onclick="login()"/><br>
</div>
</body>


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
</script>
</html>