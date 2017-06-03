/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
		$(document).ready(function(){
			var placeholder;
			var pos;
			$("#revel_password").click(function(){
				if($("#register_password").attr("type") === "password")
				{
					$("#register_password").attr("type","text");
				}
				else
				{
					$("#register_password").attr("type","password");	
				}
			});

			$("#username").click(function(){
				  placeholder = $("#username").attr("placeholder");
				  pos= $("#username").position();
				  //change here ***//
				  $("#dynamically_set_text_login").text(placeholder);
				  $("#dynamically_set_text_login").hide();
				  // ***//
				  $("#dynamically_set_text_login").fadeIn(500);
				  $("#sign_in_container").parent().css({postion:'relative'});
				  $("#dynamically_set_text_login").css({left:(parseInt(pos.top)-15),top:(parseInt(pos.left)+170),position: 'absolute'});
				  $("#sign_in_container").css({"background-size": "cover"});
				  $("#dynamically_set_text_login").css({"border-left-style":"groove"});
				  $("#dynamically_set_text_login").css({"border-right-style":"groove"});
				  $("#dynamically_set_text_login").css({"background-color":"white"});
				  $("#dynamically_set_text_login").delay(5000);
				  $("#dynamically_set_text_login").fadeOut();	
			});

			$("#password").click(function(){
				  placeholder = $("#password").attr("placeholder");
				  pos= $("#password").position();
				  $("#dynamically_set_text_login").text(placeholder);
				  $("#dynamically_set_text_login").hide();
				  // ***//
				  $("#dynamically_set_text_login").fadeIn(500);
				  $("#sign_in_container").parent().css({postion:'relative'});
				  $("#dynamically_set_text_login").css({left:(parseInt(pos.top)+45),top:(parseInt(pos.left)+115),position: 'absolute'});
				  $("#sign_in_container").css({"background-size": "cover"});
				  $("#dynamically_set_text_login").css({"border-left-style":"groove"});
				  $("#dynamically_set_text_login").css({"border-right-style":"groove"});
				  $("#dynamically_set_text_login").css({"background-color":"white"});
				  $("#dynamically_set_text_login").delay(5000);
				  $("#dynamically_set_text_login").fadeOut();	
			});
			$("#register_username").click(function(){
				  placeholder = $(this).attr("placeholder");
				  pos= $(this).position();
				  //change here ***//
				  $("#dynamically_set_text_register").text(placeholder);
				  $("#dynamically_set_text_register").hide();
				  // ***//
				  $("#dynamically_set_text_register").fadeIn(500);
				  $("#Register_container").parent().css({postion:'relative'});
				  $("#dynamically_set_text_register").css({left:(parseInt(pos.top)+30),top:(parseInt(pos.left)+115),position: 'absolute'});
				  $("#Register_container").css({"background-size": "cover"});
				  $("#dynamically_set_text_register").css({"border-left-style":"groove"});
				  $("#dynamically_set_text_register").css({"border-right-style":"groove"});
				  $("#dynamically_set_text_register").css({"background-color":"white"});
				  $("#dynamically_set_text_register").delay(5000);
				  $("#dynamically_set_text_register").fadeOut()
			});

			$("#register_password").click(function(){
				  placeholder = $(this).attr("placeholder");
				  pos= $(this).position();
				  $("#dynamically_set_text_register").text(placeholder);
				  $("#dynamically_set_text_register").hide();
				  $("#dynamically_set_text_register").fadeIn(500);
				  $("#Register_container").parent().css({postion:'relative'});
				  $("#dynamically_set_text_register").css({left:(parseInt(pos.top)-25),top:(parseInt(pos.left)+170),position: 'absolute'});
				  $("#Register_container").css({"background-size": "cover"});
				  $("#dynamically_set_text_register").css({"border-left-style":"groove"});
				  $("#dynamically_set_text_register").css({"border-right-style":"groove"});
				  $("#dynamically_set_text_register").css({"background-color":"white"});
				  $("#dynamically_set_text_register").delay(5000);
				  $("#dynamically_set_text_register").fadeOut();	
			});
});

