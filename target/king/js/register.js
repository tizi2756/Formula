$(function(){
	$(":input").focus(function(){
	   	$(this).addClass("focus");
	   }).blur(function(){
	   	$(this).removeClass("focus");
	   })
	   
	   
	   
	$("form :input.required").each(function(){  
	   	var $required=$("<strong class='high'>*</strong>");
	   	$(this).parent().append($required);
	})
	
	$("form :input").blur(function(){   
		// 为表单元素添加失去焦点事件
	   	var $parent=$(this).parent();
	   	$parent.find(".formtips").remove();   //去掉先前的提醒
	   	// 验证用户名
	   	if($(this).is("#username")){
	   		if(this.value==""||this.value.length<1){
	   			var errorMsg="请输入用户名";
	   			$parent.append("<span class='formtips onError'>"+errorMsg+"</span>");
	   		}
	   		else{
	   			var okMsg="OK";
	   			$parent.append("<span class='formtips onSuccess'>"+okMsg+"</span>")
	   		}
	   	}
	   	// 验证电话
	   	if($(this).is("#tel")){
	   		if(this.value==""||( this.value!="" && ! /^1[34578]\d{9}$/.test(this.value) ) ){
	   			var errorMsg="请输入正确的电话";
	   			$parent.append("<span class='formtips onError'>"+errorMsg+"</span>");
	   		}
	   		else{
	   			var okMsg="输入正确";
	   			$parent.append("<span class='formtips onSuccess'>"+okMsg+"</span>");
	   		}
	   	}
	   	
	   	
	   	if($(this).is("#pwd")){
	   		if(this.value==""||this.value.length<1){
	   			var errorMsg="请输入密码";
	   			$parent.append("<span class='formtips onError'>"+errorMsg+"</span>");
	   		}
	   		else{
	   			var okMsg="OK";
	   			$parent.append("<span class='formtips onSuccess'>"+okMsg+"</span>")
	   		}
	   	}
	  
	});
})



function validate() {
	var pwd = $("#pwd").val();
	var pwd1 = $("#pwd1").val();
	//对比两次输入的密码 
	if(pwd1 == pwd){
	    $("#tishi").html("两次密码相同");
	    $("#tishi").css("color","green");
	}
	else{
	    $("#tishi").html("两次密码不相同");
	    $("#tishi").css("color","red");
    }
}