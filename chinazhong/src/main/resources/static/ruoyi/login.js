$(function() {
	validateRule();
	$(".i-checks").iCheck({
		checkboxClass : "icheckbox_square-green-login"
	});
	$('.imgcode').click(
			function() {
				var url = ctx + "checkImage?type=" + captchaType + "&s="
						+ Math.random();
				$(".imgcode").attr("src", url);
			});
});

$.validator.setDefaults({
	submitHandler : function() {
		login();
	}
});

function login() {
	$.modal.loading($("#btnSubmit").data("loading"));
	var userName = $("input[name='username']").val().trim();
	var passWord = $("input[name='password']").val().trim();
	var validateCode = $("input[name='validateCode']").val();
	var rememberMe = $("input[name='rememberme']").is(':checked');
	$.ajax({
		type : "post",
		url : ctx + "login",
		data : {
			userName : userName,
			passWord : passWord,
			validateCode : validateCode,
			rememberMe : rememberMe
		},
		success : function(data) {
			if (data.code == 200) {
				location.href = ctx + 'index';
			} else {
				$.modal.closeLoading();
				$('.imgcode').click();
				$.modal.msg(data.desc);
			}
		}
	});
}

function validateRule() {
	var icon = "<i class='fa fa-times-circle'></i> ";
	$("#signupForm").validate({
		rules : {
			username : {
				required : true
			},
			password : {
				required : true
			}
		},
		messages : {
			username : {
				required : icon + "请输入您的用户名",
			},
			password : {
				required : icon + "请输入您的密码",
			}
		}
	})
}
