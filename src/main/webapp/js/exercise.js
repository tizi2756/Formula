// $(function(){
//
// 	$(":input").focus(function(){
// 	   	$(this).addClass("focus");
// 	   }).blur(function(){
// 	   	$(this).removeClass("focus");
// 	   })
//
// 	$("form :input.required").each(function(){
// 		//如果是必填的，则加红星标识.
// 	   	var $required=$("<strong class='high'>*</strong>");
// 	   	$(this).parent().append($required);
// 	})
//
// 	    //文本框失去焦点后
// 	$("form :input").blur(function(){
// 		// 为表单元素添加失去焦点事件
// 	   	var $parent=$(this).parent();
// 	   	$parent.find(".formtips").remove();   //去掉先前的提醒
// 	   	// 验证答案
// 	   	if($(this).is("#answer")){
// 	   		if(this.value==""||this.value.length<1){
// 	   			var errorMsg="请输入答案";
// 	   			$parent.append("<span class='formtips onError'>"+errorMsg+"</span>");
// 	   		}
// 	   		else{
// 	   			var okMsg="已输入";
// 	   			$parent.append("<span class='formtips onSuccess'>"+okMsg+"</span>")
// 	   		}
// 	   	}
//
//
// })


//
// //---------------考试倒计时----------开始------------------------------------------
// //设置页面时间控件方法
// function GetRTime(t){
//     var d=0;
//     var h=0;
//     var m=0;
//     var s=0;
//     if(t>=0){
//       d=Math.floor(t/1000/60/60/24);
//       h=Math.floor(t/1000/60/60%24);
//       m=Math.floor(t/1000/60%60);
//       s=Math.floor(t/1000%60);
//     }
// //     document.getElementById("t_d").innerHTML = d + "天";
//     document.getElementById("t_h").innerHTML = h + "时";
//     document.getElementById("t_m").innerHTML = m + "分";
//     document.getElementById("t_s").innerHTML = s + "秒";
//  }
//  //运行时间控件，倒计时完毕调用交卷方法
// function setTimeContral(dtSjInfo){
// 	//开始考试时间加考试设置的考试分钟数减去当前时间为考试剩余时间（为了防止不同电脑的同一次考试登陆，时间不同，当前时间从后台服务器获取）
// 	var sysCurrentTime="${(sysCurrentTime)!""}";//系统当前时间（来自服务器java后台，为试卷戳）
// 	var startExamTime=dtSjInfo.ksdt;//开始考试时间
// 	var minute=dtSjInfo.kssc;
// 	var examTime=startExamTime+(minute*60*1000)-sysCurrentTime;
// 	var t=examTime;
// 	var closeId=setInterval(function(){
// 		GetRTime(t);
// 		if(t<=0){
// 			clearInterval(closeId);//关闭时间控件
// 			//----提交试卷---------
// 			jiaoJuan(true);
// 		}
// 		t=t-1000;
// 	},1000);//每一秒调用一次
// }
// function jiaoJuan(flag){
// 	console.debug("交卷操作");
// }

/**
 * 构建XMLHttpRequest对象并请求服务器
 * @param reqType：请求类型（GET或POST）
 * @param url：服务器地址
 * @param async：是否异步请求
 * @param resFun：响应的回调函数
 * @param parameter :请求参数
 * @return :XMLHttpRequest对象
 */
function httpRequest(reqType,url,async,resFun,parameter){
    var request = null;
    if( window.XMLHttpRequest ){                  //非IE浏览器，创建XMLHttpRequest对象
        request = new XMLHttpRequest();
    }else if( window.ActiveXObject ){                     //IE浏览器，创建XMLHttpRequest对象
        var arrSignatures = ["Msxml2.XMLHTTP", "Microsoft.XMLHTTP", "Microsoft.XMLHTTP", "MSXML2.XMLHTTP.5.0", "MSXML2.XMLHTTP.4.0", "MSXML2.XMLHTTP.3.0", "MSXML2.XMLHTTP"];
        for( var i = 0; i < arrSignatures.length; i++ ){
            request = new ActiveXObject( arrSignatures[i] );
            if( request || typeof( request ) == "object" )
                break;
        }
    }
    if( request || typeof( request ) == "object" ){
        if(reqType.toLowerCase()=="post"){            //以POST方式提交
            request.open(reqType, url, true);            //打开服务器连接
            //设置MIME类型
            request.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
            request.onreadystatechange = resFun;     //设置处理响应的回调函数
            parameter = encodeURI(parameter); //将参数字符串进行编码
            request.send(parameter);          //发送请求
        }
        else{                                    //以GET方式提交
            url = url+"?"+parameter;
            request.open(reqType, url, true);            //打开服务器连接
            request.onreadystatechange = resFun;     //响应回调函数
            request.send(null);                  //发送请求
        }
    }
    else{
        alert( "该浏览器不支持Ajax！" );
    }
    return request;
}
function showWindow(){
	window.open('StartExam?action=startExam','','width=750,height=500,scrollbars=1');
}