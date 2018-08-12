/**
 * 工具类
 * @param exp
 * @returns {boolean}
 */
function str2bytes(str){
    var bytes = [];
    for (var i = 0, len = str.length; i < len; ++i) {
        var c = str.charCodeAt(i);
        var byte = c & 0xff;
        bytes.push(byte);
    }
    return bytes;
}

function formatEmpty(exp){
    if(!isEmpty(exp))return exp.trim();
    else return '';
}


function timeStamp2String (time){
    var datetime = new Date();
    datetime.setTime(time);
    var year = datetime.getFullYear();
    var month = datetime.getMonth() + 1;
    var date = datetime.getDate();
    var hour = datetime.getHours();
    var minute = datetime.getMinutes();
    var second = datetime.getSeconds();
    var mseconds = datetime.getMilliseconds();
    return year + "-" + month + "-" + date+" "+hour+":"+minute+":"+second+"."+mseconds;
};
function timeStamp2String2 (time){
    var datetime = new Date();
    datetime.setTime(time);
    var year = datetime.getFullYear();
    var month = datetime.getMonth() + 1;
    var date = datetime.getDate();
    var hour = datetime.getHours();
    var minute = datetime.getMinutes();
    var second = datetime.getSeconds();
    return year + "-" + month + "-" + date+" "+hour+":"+minute+":"+second;
};
function getNowFormatDate() {
    var date = new Date();
    var seperator1 = "-";
    var seperator2 = ":";
    var month = date.getMonth() + 1;
    var strDate = date.getDate();
    if (month >= 1 && month <= 9) {
        month = "0" + month;
    }
    if (strDate >= 0 && strDate <= 9) {
        strDate = "0" + strDate;
    }
    var currentdate = date.getFullYear() + seperator1 + month + seperator1 + strDate
        + " " + date.getHours() + seperator2 + date.getMinutes()
        + seperator2 + PrefixInteger(date.getSeconds(),2);
    return currentdate;
}
function PrefixInteger(num, length) {
    return (Array(length).join('0') + num).slice(-length);
}
function formatTime(exp){
    return new Date(exp).toLocaleDateString();
}
function isEmpty(exp){
    if (!exp && typeof(exp)!="undefined" && exp!=0 ){
        return true;
    }else if(exp==null){
        return true;
    }else if(exp=="null"){
        return true;
    }else if(typeof(exp) == "null"){
        return true;
    }else if(exp.length==0){
        return true;
    }
    return false;
}
function formatSize(size){
    if(size>1024){
        size=size/1024;
        if(size>1024){
            size=size/1024;
            if(size>1024){
                size=size/1024;
                if(size>1024){
                    size=size/1024;
                    return size.toFixed(2)+"TB";
                }else return size.toFixed(2)+"GB";
            }else return size.toFixed(2)+"MB";
        }else return size.toFixed(2)+"KB";
    }else{
        return size+"Byte";
    }
}
function formatDuration(size){
    if(size>1000){
        size=size/1000;
        if(size>60){
            size=size/60;
            if(size>60){
                size=size/60;
                return size.toFixed(2)+"小时";
            }else return size.toFixed(2)+"分钟";
        }else return size.toFixed(2)+"秒";
    }else{
        return size+"毫秒";
    }
}

function formatDuration_ceil(size){
    if(size>1000){
        size=size/1000;
        if(size>60){
            size=size/60;
            if(size>60){
                size=size/60;
                return Math.ceil(size)+"小时";
            }else return Math.ceil(size)+"分钟";
        }else return Math.ceil(size)+"秒";
    }else{
        return size+"毫秒";
    }
}
function formatDuration_floor(size){
    if(size>1000){
        size=size/1000;
        if(size>60){
            size=size/60;
            if(size>60){
                size=size/60;
                return Math.floor(size)+"小时";
            }else return Math.floor(size)+"分钟";
        }else return Math.floor(size)+"秒";
    }else{
        return size+"毫秒";
    }
}

Date.prototype.Format = function (fmt) { //author: meizz
    var o = {
        "M+": this.getMonth() + 1, //月份
        "d+": this.getDate(), //日
        "h+": this.getHours(), //小时
        "m+": this.getMinutes(), //分
        "s+": this.getSeconds(), //秒
        "q+": Math.floor((this.getMonth() + 3) / 3), //季度
        "S": this.getMilliseconds() //毫秒
    };
    if (/(y+)/.test(fmt)) fmt = fmt.replace(RegExp.$1, (this.getFullYear() + "").substr(4 - RegExp.$1.length));
    for (var k in o)
        if (new RegExp("(" + k + ")").test(fmt)) fmt = fmt.replace(RegExp.$1, (RegExp.$1.length == 1) ? (o[k]) : (("00" + o[k]).substr(("" + o[k]).length)));
    return fmt;
}