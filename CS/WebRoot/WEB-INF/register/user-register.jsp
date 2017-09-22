<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'user-register.jsp' starting page</title>
   <script type="text/javascript" src="scripts/jquery-1.9.1.min.js"></script>
    <script type="text/javascript">
    		
    		$(function(){
    		$(":input[name=username]").change(function()
    		{
    			//alert("k1");
    			var val = $(this).val();
    			val  = $.trim(val);
    			var $this = $(this);
    			
    			if(val != ""){
    				//把当前节点后面的所有font 兄弟节点删除
    				$this.nextAll("font").remove();
    				
    				
    				var url = "user-validateUserName";
    				
    				var args = {"username":val,"time":new Date()};
    	  			
    	  			$.post(url,args,function(data){   	  				
    	  				
    	  				//表示可用
    					if(data == "1"){
    						$this.after("<font color='green'>用户名可用!</font>");
    					}
    					//表示不可用
    					else if(data == "0"){
    						$this.after("<font color='red'>用户名不可用!</font>");
    					}
    					//服务器错误
    					else{
    						alert("服务器错误!"+data);
    					}
    	  				
    	  			});
    	  			
    			}
    			else
    			{
    				alert("不能为空！");
    				$(this).val("");
    			}
    			
    		});
    		
    		$("form").submit(function()
    		{
    			//alert("submit");
    			var username = document.getElementById("user");
    			var pwd = document.getElementById("pwd");
    			var type = document.getElementById("type");
    		
    			var url = "user-registerSave?username="+username.value+"&password="+pwd.value+"&usertype="+type.value;
    			//alert("4_"+username.value);
    			//alert("5_"+pwd.value);
    			//alert("6_"+type.value);
    			var args = {"time":new Date()};
    			
    			$.post(url,args,function(data)
    			{
    				//alert("post");
    				if(data == "1")
    				{
    					alert("添加成功");
    				}
    				else
    				{
    					alert("添加失败");
    				}
    			});
    			return false;
    		});
    	});
    </script>

  </head>
  
  <body>
    <s:if test="#session.id!=null">
    		<h2 align="center">修改用户信息</h2><br>
    	</s:if>
    	
  		<s:else>
  			<h2 align="center">注册用户信息</h2><br>
  		</s:else>
  		
  		<s:form action="user-registerSave" method="post" id="form">
  		<table  border="0" align="center" cellspacing="0">
  			<s:if test="#session.id!=null">
  				<tr>
  					<td>
  						用户名：<s:textfield name="username"  disabled="true"></s:textfield>
  					</td>
  				</tr>
  				<tr>
  					<td>
  						密 &nbsp&nbsp码：<s:textfield name="password" type="password"></s:textfield>
  					</td>
  				</tr>
  				<s:hidden name="id"></s:hidden>
  				<s:hidden name="username"></s:hidden>
  				<s:hidden name="usertype" value="3"></s:hidden>
  			</s:if>
  			
  			<s:else>
  				<tr>
  					<td>
  						用户名：<s:textfield name="username" id="user"></s:textfield>
  					</td>
  				</tr>
  				<tr>
  					<td>
  						密 &nbsp&nbsp码：<s:textfield name="password" type="password" id="pwd"></s:textfield>
  					</td>
  				</tr>
  				<s:hidden name="usertype" value="3" id="type"></s:hidden>
  			</s:else>
  				
  			
  			<!-- 确认密码 -->
  			
  		</table>
  		<center>
  			<br><br>
  			<s:submit value="确定"></s:submit>
  		</center>
  		</s:form>
  </body>
</html>
