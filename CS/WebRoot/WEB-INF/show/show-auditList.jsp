<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'show-auditList.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
  <h2 align="center">审核信息</h2>
    	<s:if test="#request.skills == null || #request.skills.size() == 0">
    		没有技术信息
    	</s:if>
    	
    	<s:else>
    		<table width="1050" height="40" border="1" align="center" cellspacing="0">
	   			<tr>
	    			<td width="77"><div align="center">序号</div></td>
	    			<td width="236"><div align="center">技术需求名称</div></td>
	    			<td width="147"><div align="center">需求时限</div></td>
	    			<td width="173"><div align="center">科技活动类型</div></td>
	    			<td width="100"><div align="center">审核状态</div></td>	
	    			<td width="100"><div align="center">审核</div></td> 			
	  			</tr>
    			<!-- 进行遍历  -->
    			<s:iterator value="#request.skills">
    				<tr>
	    				<td width="77" height="40"><div align="center">${skill_Id }</div></td>
	    				<td width="236" height="40"><div align="center">${t_Name }</div></td>
	    				<td width="147" height="40"><div align="center">${t_TimeMin }年至${t_TimeMax }年</div></td>
	    				<td width="173" height="40"><div align="center">${t_Type }</div></td>
	    				<td width="100"><div align="center" style="color: red">${status }</div>
	    				<td width="100">
	    					<div align="center">	    					
	    						<a href="show-audit?skill_Id=${skill_Id }">审核</a>
	    					</div>
	    				</td>
    					
    				</tr>
    			</s:iterator>
    		</table>
    	</s:else>
  </body>
</html>
