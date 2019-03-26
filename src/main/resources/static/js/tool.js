$(function () {

    window.jsonParser = new JsonParser("");

    /*$("#secretKey").val($("option:selected", $("#selClient")).attr("secretKey"));

    $("#selClient").change(function(){
        var optionSelected = $("option:selected", this);
        $("#secretKey").val($(optionSelected).attr("secretKey"));

        $("#p_clientId").val( $("#selClient").val());
        $("#p_secretKey").val( $("#secretKey").val());
    });

    $("#p_clientId").val( $("#selClient").val());
    $("#p_secretKey").val( $("#secretKey").val());*/

});

function openTab(tab) {
    if (tab === 1) {
        $("#tabs-2").hide();
        $("#tabs-1").show();
    } else if (tab === 2) {
        $("#tabs-1").hide();
        $("#tabs-2").show();
    }
}

function uuid() {
    var s = [];
    var hexDigits = "0123456789abcdef";
    for (var i = 0; i < 36; i++) {
        s[i] = hexDigits.substr(Math.floor(Math.random() * 0x10), 1);
    }
    s[14] = "4";  // bits 12-15 of the time_hi_and_version field to 0010
    s[19] = hexDigits.substr((s[19] & 0x3) | 0x8, 1);  // bits 6-7 of the clock_seq_hi_and_reserved to 01
    s[8] = s[13] = s[18] = s[23] = "-";

    var uuid = s.join("");
    return uuid;
}

function showResult(settings) {
    $.fn.mask();

    $("#requestedUrl").val($("#requestedUrl").attr("domain") + settings.url);
    $("#requestedMethod").text(settings.type);
    $("#p_data").text(settings.data == null ? "" : settings.data);

    var timestamp = Math.round(new Date().getTime());
    /*var requestId = uuid();
    var visitorId = $("#visitorId").val();*/

    /*var signature = [];
    signature.push("uri=" + settings.url);
    signature.push("&method=" + settings.type.toUpperCase());
    if (settings.data != null && settings.data.length > 0)
        signature.push("&body=" + settings.data);
    signature.push("&timestamp=" + timestamp);
    signature.push("&requestId=" + requestId);
    if(visitorId != null && visitorId.length > 0)
        signature.push("&visitorId=" + visitorId);
    console.log(signature.join(''));
    var signatureStr =  CryptoJS.HmacSHA1(signature.join(''),$("#secretKey").val()).toString(CryptoJS.enc.Base64);
    console.log(signatureStr);*/

    $.ajax({
        type: settings.type,
        url: settings.url,
        dataType: settings.dataType,
        data: settings.data,
        contentType: settings.contentType === null ? settings.contentType : "application/json",
        processData: settings.processData === null ? settings.processData : true,
        async : settings.async  === null ? settings.async  : true,
        headers: {
            "Timestamp": timestamp
            /*,"Client-Id": $("#selClient").val(),
            "Visitor-Id" : $("#visitorId").val(),
            "Request-Id" : requestId,
            "Client-Signature": signatureStr*/
        },
        success: function (data) {

            window.jsonParser.jsonContent = JSON.stringify(data);
            window.jsonParser.init();

            if (settings.success)
                settings.success(data);

            $.fn.mask.close();
        },
        error: function (data) {
            window.jsonParser.jsonContent = JSON.stringify(data);
            window.jsonParser.init();
            $.fn.mask.close();
        }
    });
}

var commonModule = {
    wechatLogin: function () {
        var settings = {
            type: "POST",
            url: "/api/customer/login",
            dataType: "json",
            data: JSON.stringify({
                "code": $("#login-code").val(),
                "customerId": $("#login-customerId").val(),
                "articleId": $("#login-articleId").val()
            })
        };
        showResult(settings);
    },
    shareParams: function () {
        var settings = {
            type: "POST",
            url: "/api/shareParams",
            dataType: "json",
            data: JSON.stringify({
                "url": $("#wechat-js-url1").val()
            })
        };
        showResult(settings);
    },
    login: function () {
        var settings = {
            type: "POST",
            url: "/management/login",
            dataType: "json",
            data: JSON.stringify({
                "name": $("#login-name").val(),
                "password": $("#login-password").val()
            })
        };
        showResult(settings);
    },
    currentUser: function () {
        var settings = {
            type: "GET",
            url: "/management/current",
            dataType: "json"
        };
        showResult(settings);
    },
    uploadParams: function () {
        var settings = {
            type: "GET",
            url: "/management/uploadParams",
            dataType: "json"
        };
        showResult(settings);
    },
    resetPassword: function () {
        var settings = {
            type: "PUT",
            url: "/management/password/reset",
            dataType: "json",
            data: JSON.stringify({
                "originPassword": $("#reset-originPassword").val(),
                "newPassword": $("#reset-newPassword").val()
            })
        };
        showResult(settings);
    },
    logout: function () {
        var settings = {
            type: "GET",
            url: "/management/logout",
            dataType: "json"
        };
        showResult(settings);
    }
};

var customerModule = {
    list: function () {
        var settings = {
            type: "POST",
            url: "/management/customer/list",
            dataType: "json",
            data: JSON.stringify({
                "content": $("#customer-list-content").val(),
                "pageIndex": $("#customer-list-pageIndex").val(),
                "pageSize": $("#customer-list-pageSize").val()
            })
        };
        showResult(settings);
    },
    status: function () {
        var settings = {
            type: "PUT",
            url: "/management/customer/status",
            dataType: "json",
            data: JSON.stringify({
                "id": $("#customer-status-id").val(),
                "status": $("#customer-status-status").val()
            })
        };
        showResult(settings);
    }
};

var giftMoneyModule = {
    draw: function () {
        var settings = {
            type: "GET",
            url: "/api/giftMoney/draw",
            dataType: "json"
        };
        showResult(settings);
    },
    list: function () {
        var settings = {
            type: "POST",
            url: "/management/giftMoney/list",
            dataType: "json",
            data: JSON.stringify({
                "content": $("#giftMoney-list-content").val(),
                "type": $("#giftMoney-list-type").val(),
                "pageIndex": $("#giftMoney-list-pageIndex").val(),
                "pageSize": $("#giftMoney-list-pageSize").val()
            })
        };
        showResult(settings);
    },
    detail: function () {
        var settings = {
            type: "GET",
            url: "/management/giftMoney/" + $("#giftMoney-detail-id").val(),
            dataType: "json"
        };
        showResult(settings);
    },
    create: function () {
        var settings = {
            type: "POST",
            url: "/management/giftMoney/create",
            dataType: "json",
            data: JSON.stringify({
                "title": $("#giftMoney-create-title").val(),
                "totalAmount": $("#giftMoney-create-totalAmount").val(),
                "low": $("#giftMoney-create-low").val(),
                "upper": $("#giftMoney-create-upper").val(),
                "startDate": $("#giftMoney-create-startDate").val(),
                "endDate": $("#giftMoney-create-endDate").val(),
                "areaId": $("#giftMoney-create-areaId").val(),
                "province": $("#giftMoney-create-province").val(),
                "city": $("#giftMoney-create-city").val(),
                "county": $("#giftMoney-create-county").val(),
                "sharingPath": $("#giftMoney-create-sharingPath").val(),
                "sharingLimit": $("#giftMoney-create-sharingLimit").val()
            })
        };
        showResult(settings);
    },
    update: function () {
        var settings = {
            type: "PUT",
            url: "/management/giftMoney/update",
            dataType: "json",
            data: JSON.stringify({
                "id": $("#giftMoney-update-id").val(),
                "title": $("#giftMoney-update-title").val(),
                "remainAmount": $("#giftMoney-update-remainAmount").val(),
                "totalAmount": $("#giftMoney-update-totalAmount").val(),
                "low": $("#giftMoney-update-low").val(),
                "upper": $("#giftMoney-update-upper").val(),
                "startDate": $("#giftMoney-update-startDate").val(),
                "endDate": $("#giftMoney-update-endDate").val(),
                "areaId": $("#giftMoney-update-areaId").val(),
                "province": $("#giftMoney-update-province").val(),
                "city": $("#giftMoney-update-city").val(),
                "county": $("#giftMoney-update-county").val(),
                "sharingPath": $("#giftMoney-update-sharingPath").val(),
                "sharingLimit": $("#giftMoney-update-sharingLimit").val()
            })
        };
        showResult(settings);
    },
    status: function () {
        var settings = {
            type: "PUT",
            url: "/management/giftMoney/status",
            dataType: "json",
            data: JSON.stringify({
                "id": $("#giftMoney-status-id").val(),
                "status": $("#giftMoney-status-status").val()
            })
        };
        showResult(settings);
    }
};

var articleModule = {
    apiDetail: function () {
        var settings = {
            type: "GET",
            url: "/api/article/detail?articleId=" + $("#article-detail-articleId").val() + "&customerId=" + $("#article-detail-customerId").val(),
            dataType: "json"
        };
        showResult(settings);
    },
    share: function () {
        var settings = {
            type: "GET",
            url: "/api/article/share?path=" + $("#article-share-path").val(),
            dataType: "json"
        };
        showResult(settings);
    },
    shareParams: function () {
        var settings = {
            type: "POST",
            url: "/api/article/shareParams",
            dataType: "json",
            data: JSON.stringify({
                "url": $("#wechat-js-url").val()
            })
        };
        showResult(settings);
    },
    list: function () {
        var settings = {
            type: "POST",
            url: "/management/article/list",
            dataType: "json",
            data: JSON.stringify({
                "content": $("#article-list-content").val(),
                "type": $("#article-list-type").val(),
                "pageIndex": $("#article-list-pageIndex").val(),
                "pageSize": $("#article-list-pageSize").val()
            })
        };
        showResult(settings);
    },
    detail: function () {
        var settings = {
            type: "GET",
            url: "/management/article/" + $("#article-detail-id").val(),
            dataType: "json"
        };
        showResult(settings);
    },
    create: function () {
        var settings = {
            type: "POST",
            url: "/management/article/create",
            dataType: "json",
            data: JSON.stringify({
                "title": $("#article-create-title").val(),
                "author": $("#article-create-author").val(),
                "img": $("#article-create-img").val(),
                "content": $("#article-create-content").val(),
                "giftMoneyId": $("#article-create-giftMoneyId").val()
            })
        };
        showResult(settings);
    },
    update: function () {
        var settings = {
            type: "PUT",
            url: "/management/article/update",
            dataType: "json",
            data: JSON.stringify({
                "id": $("#article-update-id").val(),
                "title": $("#article-update-title").val(),
                "author": $("#article-update-author").val(),
                "img": $("#article-update-img").val(),
                "content": $("#article-update-content").val(),
                "giftMoneyId": $("#article-update-giftMoneyId").val()
            })
        };
        showResult(settings);
    },
    status: function () {
        var settings = {
            type: "PUT",
            url: "/management/article/status",
            dataType: "json",
            data: JSON.stringify({
                "id": $("#article-status-id").val(),
                "status": $("#article-status-status").val()
            })
        };
        showResult(settings);
    }
};