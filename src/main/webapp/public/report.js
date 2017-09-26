/**
 * Created by YsKun on 2016/6/27.
 */
"use strict";


var api = "/api/report";
var url = "";
(function ($) {
    $.extend({
        urlGet: function () {
            var aQuery = window.location.href.split("?"); //取得Get参数
            var aGET = [];
            if (aQuery.length > 1) {
                var aBuf = aQuery[1].split("&");
                for (var i = 0, iLoop = aBuf.length; i < iLoop; i++) {
                    var aTmp = aBuf[i].split("="); //分离key与Value
                    aGET[aTmp[0]] = aTmp[1];
                }
            }
            return aGET;
        }
    });
})(jQuery);

$.fn.serializeObject = function () {
    var o = {};
    var a = this.serializeArray();
    $.each(a,
        function () {
            if (o[this.name]) {
                if (!o[this.name].push) {
                    o[this.name] = [o[this.name]];
                }
                o[this.name].push(this.value || "");
            } else {
                o[this.name] = this.value || "";
            }
        });
    return o;
};

function judge() {
    if ($("#report-detail").val() === "")
        return false;
    return true;
}

function sendMessage() {
    if (judge()) {
        $("#address").val(url);
        var report = $(".report-form").serializeObject();
        $.post(api, report)
            .done(function (data) {
                if (data.state === 0) {
                    $("#send_module").fadeOut(600);
                    $("#finished_module").delay(600).fadeIn(600);
                } else {
                    $("#send_module").fadeOut(600);
                    $("#error_module").delay(600).fadeIn(600);
                }
            })
            .error(function (data) {
                $("#send_module").fadeOut(600);
                $("#error_module").delay(600).fadeIn(600);
            });
    } else
        alert("请输入详细情况");

}

$(document)
    .ready(function () {
        url = $.urlGet().Url;
        $("#address").val(window.location.host + url);
        $("#region").val(returnCitySN.cname);
        $("#ip_address").val(returnCitySN.cip);
        $("#url")
            .click(function () {
                window.open(url);
            });
        $("#send_btn")
            .click(function () {
                $("#send_page").fadeIn();
                sendMessage();
            });
        $(".close_btn")
            .click(function () {
                window.location = "http://" + window.location.host;
            });
    });