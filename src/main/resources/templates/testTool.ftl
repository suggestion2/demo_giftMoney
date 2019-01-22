<!doctype html>
<html>
<head>
    <meta charset="utf-8">
    <title>demo_</title>
    <link href="/resources/images/favicon.ico" rel="icon" type="image/x-icon"/>
    <link rel="stylesheet" href="/resources/css/jquery-ui.css">
    <link rel="stylesheet" href="/resources/css/style.css">
    <link rel="stylesheet" href="/resources/css/tab.css">
    <link rel="stylesheet" href="/resources/js/mask/mask.css">
    <link rel="stylesheet" href="/resources/js/JsonParser/JsonParser.css">
</head>
<body>
<div id="tabs" class="ui-widget-content">
    <div class="tab">
        <button class="tablinks" onclick="openTab(1)">api</button>
        <button class="tablinks" onclick="openTab(2)">management</button>
    </div>
    <div id="tabs-1" style="width: 2000px;display: none">

    </div>
    <div id="tabs-2" style="width: 2000px;display: block">
        <div style="float: left; width: 400px;">
            <h2>基本功能(common)</h2>
            <div>
                <strong>[登录]</strong><br/>
                用户名:<input class="textbox" type="text" id="login-name" style="width: 100px;"
                           value="admin"/>
                密码:<input class="textbox" type="text" id="login-password" style="width: 100px;"
                          value="123456"/>
                <input type="button" value="登录" onclick="commonModule.login()"/><br>
            </div>
            <div>
                <strong>[当前用户]</strong><br/>
                <input type="button" value="获取" onclick="commonModule.currentUser()"/><br>
            </div>
            <div>
                <strong>[登出]</strong><br/>
                <input type="button" value="登出" onclick="commonModule.logout()"/><br>
            </div>

            <h2>客户(customer)</h2>
            <div>
                <strong>[list]</strong><br/>
                content:<input class="textbox" type="text" id="customer-list-content" style="width: 100px;"
                           value=""/><br>
                pageIndex:<input class="textbox" type="text" id="customer-list-pageIndex" style="width: 100px;"
                                  value="0"/>
                pageSize:<input class="textbox" type="text" id="customer-list-pageSize" style="width: 100px;"
                                value="10"/><br>
                <input type="button" value="getList" onclick="customerModule.list()"/><br>
            </div>
            <div>
                <strong>[enable/disable]</strong><br/>
                id:<input class="textbox" type="text" id="customer-status-id" style="width: 100px;"
                           value="1"/>
                status:<select class="textbox" id="customer-status-status" style="width: 100px;">
                <option value="0">disable</option>
                <option value="1">enable</option>
            </select><br>
                <input type="button" value="change" onclick="customerModule.status()"/><br>
            </div>

            <h2>红包(giftMoney)</h2>
            <div>
                <strong>[list]</strong><br/>
                content:<input class="textbox" type="text" id="giftMoney-list-content" style="width: 100px;"
                               value=""/>
                type:<select class="textbox" id="giftMoney-list-type" style="width: 100px;">
                <option value="1">base</option>
                <option value="2">statistic</option>
            </select><br>
                pageIndex:<input class="textbox" type="text" id="giftMoney-list-pageIndex" style="width: 100px;"
                                 value="0"/>
                pageSize:<input class="textbox" type="text" id="giftMoney-list-pageSize" style="width: 100px;"
                                value="10"/><br>
                <input type="button" value="getList" onclick="giftMoneyModule.list()"/><br>
            </div>
            <div>
                <strong>[detail]</strong><br/>
                id:<input class="textbox" type="text" id="giftMoney-detail-id" style="width: 100px;"
                               value=""/><br>
                <input type="button" value="detail" onclick="giftMoneyModule.detail()"/><br>
            </div>
            <div>
                <strong>[create]</strong><br/>
                title:<input class="textbox" type="text" id="giftMoney-create-title" style="width: 100px;"
                               value=""/>
                totalAmount:<input class="textbox" type="text" id="giftMoney-create-totalAmount" style="width: 100px;"
                             value=""/><br>
                low:<input class="textbox" type="text" id="giftMoney-create-low" style="width: 100px;"
                             value=""/>
                upper:<input class="textbox" type="text" id="giftMoney-create-upper" style="width: 100px;"
                                   value=""/><br>
                startDate:<input class="textbox" type="text" id="giftMoney-create-startDate" style="width: 100px;"
                           value=""/>
                endDate:<input class="textbox" type="text" id="giftMoney-create-endDate" style="width: 100px;"
                             value=""/><br>
                areaId:<select class="textbox" id="giftMoney-create-areaId" style="width: 100px;">
                <option value="0">全部</option>
                <option value="1">暂时代表有地区</option>
            </select>
                province:<input class="textbox" type="text" id="giftMoney-create-province" style="width: 100px;"
                               value=""/><br>
                city:<input class="textbox" type="text" id="giftMoney-create-city" style="width: 100px;"
                                 value=""/>
                county:<input class="textbox" type="text" id="giftMoney-create-county" style="width: 100px;"
                               value=""/><br>
                sharingPath:<select class="textbox" id="giftMoney-create-sharingPath" style="width: 100px;">
                <option value="1">朋友圈</option>
                <option value="2">微信群</option>
                <option value="3">both</option>
            </select>
                sharingLimit:<input class="textbox" type="text" id="giftMoney-create-sharingLimit" style="width: 100px;"
                              value=""/><br>
                <input type="button" value="create" onclick="giftMoneyModule.create()"/><br>
            </div>
            <div>
                <strong>[update]</strong><br/>
                id:<input class="textbox" type="text" id="giftMoney-update-id" style="width: 100px;"
                             value=""/>
                title:<input class="textbox" type="text" id="giftMoney-update-title" style="width: 100px;"
                             value=""/><br>
                totalAmount:<input class="textbox" type="text" id="giftMoney-update-totalAmount" style="width: 100px;"
                                   value=""/>
                remainAmount:<input class="textbox" type="text" id="giftMoney-update-remainAmount" style="width: 100px;"
                                   value=""/><br>
                low:<input class="textbox" type="text" id="giftMoney-update-low" style="width: 100px;"
                           value=""/>
                upper:<input class="textbox" type="text" id="giftMoney-update-upper" style="width: 100px;"
                             value=""/><br>
                startDate:<input class="textbox" type="text" id="giftMoney-update-startDate" style="width: 100px;"
                                 value=""/>
                endDate:<input class="textbox" type="text" id="giftMoney-update-endDate" style="width: 100px;"
                               value=""/><br>
                areaId:<select class="textbox" id="giftMoney-update-areaId" style="width: 100px;">
                <option value="0">全部</option>
                <option value="1">暂时代表有地区</option>
            </select>
                province:<input class="textbox" type="text" id="giftMoney-update-province" style="width: 100px;"
                                value=""/><br>
                city:<input class="textbox" type="text" id="giftMoney-update-city" style="width: 100px;"
                            value=""/>
                county:<input class="textbox" type="text" id="giftMoney-update-county" style="width: 100px;"
                              value=""/><br>
                sharingPath:<select class="textbox" id="giftMoney-update-sharingPath" style="width: 100px;">
                <option value="1">朋友圈</option>
                <option value="2">微信群</option>
                <option value="3">both</option>
            </select>
                sharingLimit:<input class="textbox" type="text" id="giftMoney-update-sharingLimit" style="width: 100px;"
                                    value=""/><br>
                <input type="button" value="update" onclick="giftMoneyModule.update()"/><br>
            </div>
            <div>
                <strong>[enable/disable]</strong><br/>
                id:<input class="textbox" type="text" id="giftMoney-status-id" style="width: 100px;"
                          value="1"/>
                status:<select class="textbox" id="giftMoney-status-status" style="width: 100px;">
                <option value="0">disable</option>
                <option value="1">enable</option>
            </select><br>
                <input type="button" value="change" onclick="giftMoneyModule.status()"/><br>
            </div>
        </div>
        <div style="float: left; width: 400px;">
            <h2>文章(article)</h2>
            <div>
                <strong>[list]</strong><br/>
                content:<input class="textbox" type="text" id="article-list-content" style="width: 100px;"
                               value=""/>
                type:<select class="textbox" id="article-list-type" style="width: 100px;">
                <option value="1">base</option>
                <option value="2">statistic</option>
            </select><br>
                pageIndex:<input class="textbox" type="text" id="article-list-pageIndex" style="width: 100px;"
                                 value="0"/>
                pageSize:<input class="textbox" type="text" id="article-list-pageSize" style="width: 100px;"
                                value="10"/><br>
                <input type="button" value="getList" onclick="articleModule.list()"/><br>
            </div>
            <div>
                <strong>[detail]</strong><br/>
                id:<input class="textbox" type="text" id="article-detail-id" style="width: 100px;"
                          value=""/><br>
                <input type="button" value="detail" onclick="articleModule.detail()"/><br>
            </div>
            <div>
                <strong>[create]</strong><br/>
                title:<input class="textbox" type="text" id="article-create-title" style="width: 100px;"
                             value=""/>
                author:<input class="textbox" type="text" id="article-create-author" style="width: 100px;"
                                   value=""/><br>
                img:<input class="textbox" type="text" id="article-create-img" style="width: 100px;"
                           value=""/>
                content:<input class="textbox" type="text" id="article-create-content" style="width: 100px;"
                             value=""/><br>
                giftMoneyId:<input class="textbox" type="text" id="article-create-giftMoneyId" style="width: 100px;"
                                 value=""/><br>
                <input type="button" value="create" onclick="articleModule.create()"/><br>
            </div>
            <div>
                <strong>[update]</strong><br/>
                id:<input class="textbox" type="text" id="article-update-id" style="width: 100px;"
                          value=""/>
                title:<input class="textbox" type="text" id="article-update-title" style="width: 100px;"
                             value=""/><br>
                author:<input class="textbox" type="text" id="article-update-author" style="width: 100px;"
                              value=""/>
                img:<input class="textbox" type="text" id="article-update-img" style="width: 100px;"
                           value=""/><br>
                content:<input class="textbox" type="text" id="article-update-content" style="width: 100px;"
                               value=""/>
                giftMoneyId:<input class="textbox" type="text" id="article-update-giftMoneyId" style="width: 100px;"
                                   value=""/><br>
                <input type="button" value="update" onclick="articleModule.update()"/><br>
            </div>
            <div>
                <strong>[enable/disable]</strong><br/>
                id:<input class="textbox" type="text" id="article-status-id" style="width: 100px;"
                          value="1"/>
                status:<select class="textbox" id="article-status-status" style="width: 100px;">
                <option value="0">disable</option>
                <option value="1">enable</option>
            </select><br>
                <input type="button" value="change" onclick="articleModule.status()"/><br>
            </div>
        </div>
    </div>

    <div style="clear: both;"></div>
</div>

<div style="margin-top: 7px; height:27px;" class="ui-tabs ui-widget ui-widget-content ui-corner-all">
    <b>Requested URL: </b>
    <input type="text" id="requestedUrl" style="width:60%;"
           domain="${request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()?c}"/>
</div>

<div id="d_param" class="ui-tabs ui-corner-all">
    <div style="float:left;width:300px; margin:0 10px 10px 0;height: 450px;"
         class="ui-tabs ui-widget ui-widget-content ui-corner-all">
        <strong style="margin-left: 5px;">Requested Method:</strong>

        <lable id="requestedMethod"></lable>
        <br/><br/>
        <strong style="margin-left: 5px;">HTTP Header:</strong>
        <table id="tb_h_param">
        <#--<tr>
            <td>ClientId:</td>
            <td><input type="text" id="p_clientId"/></td>
        </tr>
        <tr>
            <td>SecretKey:</td>
            <td><input type="text" id="p_secretKey"/></td>
        </tr>-->
            <tr>
                <td colspan="2"><textarea id="p_data" rows="20" cols="35"></textarea></td>
            </tr>
        </table>
    </div>

    <div style="margin-left:315px; z-index:9999; position:relative;">

        <div id="resultShow"></div>
    </div>
</div>


</body>

<script src="/resources/js/jquery-1.10.2.js"></script>
<script src="/resources/js/jquery-ui.js"></script>
<script src="/resources/js/JsonParser/JsonParser.js"></script>
<script src="/resources/js/crypto/hmac-sha1.js"></script>
<script src="/resources/js/crypto/enc-base64-min.js"></script>
<script src="/resources/js/tool.js"></script>
<script src="/resources/js/mask/mask.js"></script>

</html>
