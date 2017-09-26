/**
 * Created by YsKun on 2016/6/27.
 */
"use strict";
var api = "/api/judge";

var warning_div = "<div class='modal fade' id='myModal' tabindex='-1' role='dialog' aria-labelledby='myModalLabel'> " +
    "<div class='modal-dialog' role='document'> " +
    "<div class='modal-content'> " +
    "<div class='modal-header'> " +
    "<button type='button' class='close' data-dismiss='modal' aria-label='Close'><span aria-hidden='true'>&times;</span></button> " +
    "<h4 class='modal-title' id='myModalLabel'>警告</h4> " +
    "</div>" +
    "<div class='modal-body'> " +
    "<h3>注意：该网页内容被多人举报，并已经进入处理流程。</h3> <br>该网页可能会引起您的不适<br>如果该网页对您造成了不良的影响，请点击网页上的举报按钮。 " +
    "</div> " +
    "<div class='modal-footer'> " +
    "<button type='button' class='btn btn-default' data-dismiss='modal'>Close</button> " +
    "</div> " +
    "</div> " +
    "</div> " +
    "</div>";

var report_btn = "<div id='report' class='btn btn-default' onclick='reportThis()'>举报</div>";

function judgeTheWeb() {
    var url = window.location.pathname;
    $.post(api, { "Url": url })
        .done(function(data) {
            if (data.ret === 2) {
                $("body").append(warning_div);
                $("#myModal").modal();
            }
            if (data.ret === 3) {
                window.location = "Forbidden.html";
            }
        });
}

judgeTheWeb();

function add_report_btn() {
    $("body").append(report_btn);
}

function reportThis() {
    var url = window.location.pathname;
    var apiReport = "report.html?Url=";
    window.location = apiReport + url;
}

$(document)
    .ready(function() {
        add_report_btn();
    });