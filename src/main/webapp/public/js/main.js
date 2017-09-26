/**
 * Created by YsKun on 2016/5/29.
 */

var form_num=1;
var pic_sel=null;

$.fn.serializeObject = function()
{
    var o = {};
    var a = this.serializeArray();
    $.each(a, function() {
        if (o[this.name]) {
            if (!o[this.name].push) {
                o[this.name] = [o[this.name]];
            }
            o[this.name].push(this.value || '');
        } else {
            o[this.name] = this.value || '';
        }
    });
    return o;
};

function Log(s) {
    var txt = $('.debugger_layer');
    txt.html(txt.html() + '</br>' + s);
}


function btn_click() {
    if (form_num == 1)
        $('#Password').val($.md5($('#Password').val()));
    var JsonUserInfo = $('.form_' + form_num).serializeObject();
    if (form_num == 1)
        $('#gender').val( $('#email').val());
    // document.getElementById("gender").value = document.getElementById("email").val();
    Log('form_' + form_num + '输出数据:' + JSON.stringify(JsonUserInfo) + "user:" + $("#gender").val());
    var jqxhr = $.post('api/Register',{
        "json":JSON.stringify(JsonUserInfo)
    },function(data){
         Log('返回数据:' + data);
    },"application/json");
       
}

function finBtn_click() {
    var JsonUserInfo = $('.form_6').serializeObject();
    Log('form_' + form_num + '输出数据:' + JSON.stringify(JsonUserInfo));
    var jqxhr = $.getJSON('Handler/register' + form_num + '.ashx', { "json": JSON.stringify(JsonUserInfo), "user": $("#gender").val() })
        .done(function (data) {
            window.location.href="http://"+location.host+'/'+data;
            Log('返回数据:' + data);
        })
        .fail(function (xhr, status) {
            Log('失败: ' + xhr.status + ', 原因: ' + status);
        })
        .always(function () {

            // Log('请求完成: 无论成功或失败都会调用');

        });
}

$(document).ready(
    function () {

        $('.form_1').fadeIn();

        $('.btn-next').click(function () {
            btn_click();

            $('.form_'+form_num).fadeOut();

            form_num++;
            $('.form_'+form_num).delay(500).fadeIn();
            if(form_num==7)
                $(".background_layer").addClass(
                    "background_layer-noBlur"
                );
            if(form_num==3)
                form_num++;
        });

        $('.btn-fin').click(function () {
            finBtn_click();
            $('.form_6').fadeOut();
            $(".background_layer").addClass(
                "background_layer-noBlur"
            );
        });

    }
);
