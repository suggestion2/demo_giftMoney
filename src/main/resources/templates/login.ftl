<html>
<body>
<div>
    test Login

    <input type="button" value="login" onclick="login()"/><br>
</div>
</body>


<script language="javascript" type="text/javascript">
    function login(){
        window.location.href = "https://open.weixin.qq.com/connect/oauth2/authorize?appid=APPID&redirect_uri=REDIRECT_URI&response_type=code&scope=snsapi_userinfo&state=STATE#wechat_redirect";
    }
</script>
</html>