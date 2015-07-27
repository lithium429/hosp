
//验证身份证号码
var flag = new Array();
//obj就是身份证输入的文本框，ErrorObjId就是如果身份证不正确，要显示错误信息的Obj的Id
function isChinaIDCard(obj, ErrorObjId) {
    alert(23);
    var $this = $(obj);
    var StrNo = $this.val();
    StrNo = StrNo.toString()
    if (StrNo.length == 18) {
        var a, b, c
        if (!isInteger(StrNo.substr(0, 17))) {
            return false 
        }
        a = parseInt(StrNo.substr(0, 1)) * 7 + parseInt(StrNo.substr(1, 1)) * 9 + parseInt(StrNo.substr(2, 1)) * 10;
        a = a + parseInt(StrNo.substr(3, 1)) * 5 + parseInt(StrNo.substr(4, 1)) * 8 + parseInt(StrNo.substr(5, 1)) * 4;
        a = a + parseInt(StrNo.substr(6, 1)) * 2 + parseInt(StrNo.substr(7, 1)) * 1 + parseInt(StrNo.substr(8, 1)) * 6;
        a = a + parseInt(StrNo.substr(9, 1)) * 3 + parseInt(StrNo.substr(10, 1)) * 7 + parseInt(StrNo.substr(11, 1)) * 9;
        a = a + parseInt(StrNo.substr(12, 1)) * 10 + parseInt(StrNo.substr(13, 1)) * 5 + parseInt(StrNo.substr(14, 1)) * 8;
        a = a + parseInt(StrNo.substr(15, 1)) * 4 + parseInt(StrNo.substr(16, 1)) * 2;
        b = a % 11;

        if (b == 2) //最后一位为校验位
        {
            c = StrNo.substr(17, 1).toUpperCase(); //转为大写X
        }
        else {
            c = parseInt(StrNo.substr(17, 1));
        }

        switch (b) {
            case 0: if (c != 1) {
                    informationMsg("您的身份证号码输入有误！");
                    $this.addClass("input-validation-error");
                    $("#" + ErrorObjId).removeClass("dn");
                    flag[2] = 0;
                    //                        $$("txtnianling").value = "";
                    //                        $$("txtxingbie").value = "";
                    if (!util.isNull($("#Birthday"))) {
                        $$("Birthday").value = "";
                    }
                    return false;
                } break;
            case 1: if (c != 0) {
                    informationMsg("您的身份证号码输入有误！");
                    $this.addClass("input-validation-error");
                    $("#" + ErrorObjId).removeClass("dn");
                    flag[2] = 0;
                    //                        $$("txtnianling").value = "";
                    //                        $$("txtxingbie").value = "";
                    if (!util.isNull($("#Birthday"))) {
                        $$("Birthday").value = "";
                    }
                    return false;
                } break;
            case 2: if (c != "X") {
                    informationMsg("您的身份证号码输入有误！");
                    $this.addClass("input-validation-error");
                    $("#" + ErrorObjId).removeClass("dn");
                    flag[2] = 0;
                    //                        $$("txtnianling").value = "";
                    //                        $$("txtxingbie").value = "";
                    if (!util.isNull($("#Birthday"))) {
                        $$("Birthday").value = "";
                    }
                    return false;
                } break;
            case 3: if (c != 9) {
                    informationMsg("您的身份证号码输入有误！");
                    $this.addClass("input-validation-error");
                    $("#" + ErrorObjId).removeClass("dn");
                    flag[2] = 0;
                    //                        $$("txtnianling").value = "";
                    //                        $$("txtxingbie").value = "";
                    if (!util.isNull($("#Birthday"))) {
                        $$("Birthday").value = "";
                    }
                    return false;
                } break;
            case 4: if (c != 8) {
                    informationMsg("您的身份证号码输入有误！");
                    $this.addClass("input-validation-error");
                    $("#" + ErrorObjId).removeClass("dn");
                    flag[2] = 0;
                    //                        $$("txtnianling").value = "";
                    //                        $$("txtxingbie").value = "";
                    if (!util.isNull($("#Birthday"))) {
                        $$("Birthday").value = "";
                    }
                    return false;
                } break;
            case 5: if (c != 7) {
                    informationMsg("您的身份证号码输入有误！");
                    $this.addClass("input-validation-error");
                    $("#" + ErrorObjId).removeClass("dn");
                    flag[2] = 0;
                    //                        $$("txtnianling").value = "";
                    //                        $$("txtxingbie").value = "";
                    if (!util.isNull($("#Birthday"))) {
                        $$("Birthday").value = "";
                    }
                    return false;
                } break;
            case 6: if (c != 6) {
                    informationMsg("您的身份证号码输入有误！");
                    $this.addClass("input-validation-error");
                    $("#" + ErrorObjId).removeClass("dn");
                    flag[2] = 0;
                    //                         $$("txtnianling").value = "";
                    //                         $$("txtxingbie").value = "";
                    if (!util.isNull($("#Birthday"))) {
                        $$("Birthday").value = "";
                    }
                    return false;
                } break;
            case 7: if (c != 5) {
                    informationMsg("您的身份证号码输入有误！");
                    $this.addClass("input-validation-error");
                    $("#" + ErrorObjId).removeClass("dn");
                    flag[2] = 0;
                    //                          $$("txtnianling").value = "";
                    //                          $$("txtxingbie").value = "";
                    if (!util.isNull($("#Birthday"))) {
                        $$("Birthday").value = "";
                    }
                    return false;
                } break;
            case 8: if (c != 4) {
                    informationMsg("您的身份证号码输入有误！");
                    $this.addClass("input-validation-error");
                    $("#" + ErrorObjId).removeClass("dn");
                    flag[2] = 0;
                    //                           $$("txtnianling").value = "";
                    if (!util.isNull($("#Birthday"))) {
                        $$("Birthday").value = "";
                    }
                    $$("txtchusheng").value = "";
                    return false;
                } break;
            case 9: if (c != 3) {
                    informationMsg("您的身份证号码输入有误！");
                    $this.addClass("input-validation-error");
                    $("#" + ErrorObjId).removeClass("dn");
                    flag[2] = 0;
                    //                           $$("txtnianling").value = "";
                    //                           $$("txtxingbie").value = "";
                    if (!util.isNull($("#Birthday"))) {
                        $$("Birthday").value = "";
                    }
                    return false;
                } break;
            case 10: if (c != 2) {
                    informationMsg("您的身份证号码输入有误！");
                    $this.addClass("input-validation-error");
                    $("#" + ErrorObjId).removeClass("dn");
                    flag[2] = 0;
                    //                           $$("txtnianling").value = "";
                    //                           $$("txtxingbie").value = "";
                    if (!util.isNull($("#Birthday"))) {
                        $$("Birthday").value = "";
                    }
                    return false
                }
        }
    }
    else //15位身份证号
    {
        if (!isInteger(StrNo)) {
            if (StrNo == "") {
                informationMsg("身份证号码不能为空！");
                $this.addClass("input-validation-error");
                $("#" + ErrorObjId).removeClass("dn");
                flag[2] = 0;
                return false; 
            }
            else {
                informationMsg("您的身份证号码输入有误,前15位不能含有英文字母！");
                $("#" + ErrorObjId).removeClass("dn");
                $this.addClass("input-validation-error");
                //                    $$("txtnianling").value = "";
                //                    $$("txtxingbie").value = "";
                if (!util.isNull($("#Birthday"))) {
                    $$("Birthday").value = "";
                }
                return false;
            }
        }
    }

    switch (StrNo.length) {
        case 15:
            if (isValidDate("19" + StrNo.substr(6, 2), StrNo.substr(8, 2) - 1, StrNo.substr(10, 2), StrNo)) {
                //$("#" + ErrorObjId).addClass("dn");
                return true; 
            }
            else {
                $("#" + ErrorObjId).removeClass("dn");
                return false; 
            }
        case 18:
            if (isValidDate(StrNo.substr(6, 4), StrNo.substr(10, 2) - 1, StrNo.substr(12, 2), StrNo)) {
                //$("#" + ErrorObjId).addClass("dn");
                return true; 
            }
            else {
                $("#" + ErrorObjId).removeClass("dn");
                return false; 
            }
    }
    informationMsg("输入的身份证号码必须为15位或者18位！");
    $this.addClass("input-validation-error");
    $("#" + ErrorObjId).removeClass("dn");
    //        $$("txtnianling").value = "";
    //        $$("txtxingbie").value = "";
    if (!util.isNull($("#Birthday"))) {
        $$("Birthday").value = "";
    }
    flag[2] = 0;
    return false
}

function isValidDate(iY, iM, iD, sn) {
    var a = new Date(iY, iM, iD);
    var y = a.getFullYear();
    var m = a.getMonth();
    var d = a.getDate();
    if (y != iY || m != iM || d != iD) {
        informationMsg("身份证号码内日期错误！");
        flag[2] = 0;
        //            $$("txtnianling").value = "";
        //            $$("txtxingbie").value = "";
        if (!util.isNull($("#Birthday"))) {
            $$("Birthday").value = "";
        }
        return false;
    }
    //alertright("您的身份证号码输入正确！");
    //        $$("txtnianling").value = idcard_getage(sn);
    //        $$("txtxingbie").value = idcard_getsex(sn);
    $$("Birthday").value = idcard_getbirthday(sn);
    flag[2] = 1;


    //$$("IDinfo").innerHTML = "<span class=\"mess1\">性别：</span><span><input name=\"sex\" id=\"sex\" readonly=true class=\"input_1\"  value=\"" + idcard_getsex(sn) +"\"/></span><span class=\"mess2\">出生日期：</span><span><input name=\"born\" id=\"born\" class=\"input_2\" readonly=true value=\"" + idcard_getbirthday(sn) + "\"/></span>"
    return true;
}

function isInteger(str) {
    if (!/^\d+$/.test(str)) {
        return false;
    }
    return true;
}


function IDUpdate(StrNo) {

    if (!isChinaIDCard(StrNo)) { return false }
    if (StrNo.length == 15) {
        var a, b, c
        StrNo = StrNo.substr(0, 6) + "19" + StrNo.substr(6, 9)
        a = parseInt(StrNo.substr(0, 1)) * 7 + parseInt(StrNo.substr(1, 1)) * 9 + parseInt(StrNo.substr(2, 1)) * 10;
        a = a + parseInt(StrNo.substr(3, 1)) * 5 + parseInt(StrNo.substr(4, 1)) * 8 + parseInt(StrNo.substr(5, 1)) * 4;
        a = a + parseInt(StrNo.substr(6, 1)) * 2 + parseInt(StrNo.substr(7, 1)) * 1 + parseInt(StrNo.substr(8, 1)) * 6;
        a = a + parseInt(StrNo.substr(9, 1)) * 3 + parseInt(StrNo.substr(10, 1)) * 7 + parseInt(StrNo.substr(11, 1)) * 9;
        a = a + parseInt(StrNo.substr(12, 1)) * 10 + parseInt(StrNo.substr(13, 1)) * 5 + parseInt(StrNo.substr(14, 1)) * 8;
        a = a + parseInt(StrNo.substr(15, 1)) * 4 + parseInt(StrNo.substr(16, 1)) * 2;
        b = a % 11;

        switch (b) {
            case 0: { StrNo = StrNo + "1"; } break;
            case 1: { StrNo = StrNo + "0"; } break;
            case 2: { StrNo = StrNo + "X"; } break;
            case 3: { StrNo = StrNo + "9"; } break;
            case 4: { StrNo = StrNo + "8"; } break;
            case 5: { StrNo = StrNo + "7"; } break;
            case 6: { StrNo = StrNo + "6"; } break;
            case 7: { StrNo = StrNo + "5"; } break;
            case 8: { StrNo = StrNo + "4"; } break;
            case 9: { StrNo = StrNo + "3"; } break;
            case 10: { StrNo = StrNo + "3"; }
        }
    }
    return StrNo;
}

//function informationMsg(m) {
//    alert(m);
//}

function idcard_getsex(id) {
    var id = String(id);
    return sex = id.slice(14, 17) % 2 ? "男" : "女"
}

function idcard_getbirthday(id) {
    var id = String(id);
    var birthday;
    if (id.length == 15) {
        birthday = "19" + id.substr(6, 2) + "-" + id.substr(8, 2) + "-" + id.substr(10, 2)
    } else if (id.length == 18) {
        birthday = id.substr(6, 4) + "-" + id.substr(10, 2) + "-" + id.substr(12, 2)
    } else {
        return false;
    }
    return birthday;
}

function idcard_getage(id) {
    var id = String(id);
    var birthday;
    var age;
    if (id.length == 15) {
        birthday = "19" + id.substr(6, 2)
    } else if (id.length == 18) {
        birthday = id.substr(6, 4)
    } else {
        return false;
    }
    age = new Date().getFullYear() - birthday;
    return age;
}