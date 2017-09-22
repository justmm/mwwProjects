<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>    
     <title>填报信息显示</title>
  </head> 
  
  <body>
 
    <!-- 显示查询的信息*************************************************************** --> 	
  		<s:hidden name="user_IdS" value="%{#session.id}"/> 
  		<s:if test="#requestSkill.selfSkills == null || #requestSkill.selfSkills.size() == 0">无技术信息</s:if>
  		<s:else>
  			<table width="850" height="40" border="1" align="center" cellspacing="0">
	  			<tr>
		   			<td width="77"><div align="center">序号</div></td>
		   			<td width="236"><div align="center">技术需求名称</div></td>
		   			<td width="147"><div align="center">需求时限</div></td>
		   			<td width="173"><div align="center">科技活动类型</div></td>
		   			<td width="100"><div align="center">审核状态</div></td>
					<td width="100"><div align="center">审核意见</div></td>
		   			<td width="65"><div align="center">编辑</div></td>
		   			<td width="65"><div align="center">操作</div></td>
		   			<td width="65"><div align="center">删除</div></td>
	 			</tr>
	 			 
	 			<!-- 进行遍历 -->
	 			<s:iterator value="#request.selfSkills">
		 			<tr>
		   				<td width="77" height="40"><div align="center">${skill_Id }</div></td>
		   				<td width="236" height="40"><div align="center">${t_Name }</div></td>
		   				<td width="147" height="40"><div align="center">${t_TimeMin }年至${t_TimeMax }年</div></td>
		   				<td width="173" height="40"><div align="center">${t_Type }</div></td>
		   				<td width="100"><div align="center">审核</div></td>
		   				<td width="100"><div align="center"></div></td>
		   				<td width="65" height="40">
		   					<div align="center">
		   						<a href="show-edit?skill_Id=${skill_Id }">编辑</a>
		   					</div>    				
		   				</td>
		   				<td width="65" height="40">
		   					<div align="center">
		   						<a href="show-check?skill_Id=${skill_Id }">查看</a>
		   					</div>
		   				</td>
		   				<td width="65" height="40">
		   					<div align="center">
		   						<a href="show-delete?skill_Id=${skill_Id }">删除</a>
		   					</div>
		   				</td>
		 			</tr>
	 			</s:iterator>
	  		</table>
  		</s:else>
  		
  </body>
</html>
