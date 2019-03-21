<html>
<head>
    <style type="text/css">
        body{ font-size:12px; line-height:24px;}.exp{font-size:x-large;}
    </style>
</head>
<body>
<div class="exp">
    test Login

    <input type="button" value="login" size="15" onclick="login()"/><br>
</div>
</body>


<script language="javascript" type="text/javascript">
    function login(){
        window.location.href = "https://open.weixin.qq.com/connect/oauth2/authorize?appid=wx53e400e835707585&redirect_uri=http://hb.renmings.com/wechat/auth&response_type=code&scope=snsapi_userinfo&state=STATE#wechat_redirect";
    }
</script>
</html>