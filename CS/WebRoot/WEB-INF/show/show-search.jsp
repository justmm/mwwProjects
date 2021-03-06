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
     <script type="text/javascript" src="scripts/jquery-1.9.1.min.js"></script>
     <script type="text/javascript">
     	$(function(){
     		//是否需要删除信息
     		$(".delete").click(function(){
     			
     			var t_Name = $(this).next(":input").val();
     			var flag = confirm("确定需要删除  ' "+t_Name+" ' 的信息吗?");
     			if(flag){
     				var $tr = $(this).parent().parent().parent();//当前行 
     				var url = this.href;
     				var args = {"time":new Date()};
     				$.post(url,args,function(data){
     					if(data == "1"){
     						alert("删除成功!");
     						$tr.remove();//删除当前行
     					}
     					else{
     						alert("删除失败!");
     					}
     				});
     			}
     			
     			//取消默认连接
     			return false;			
     		});	
     	}); 
     </script>   
	 

  </head>
  
  <body>
  	<br>
    <h2 align="center">查询</h2>
    <s:form action="show-select" method="post">
    	<table width="350" height="50" border="0" align="center" cellspacing="0">
          <tr>
            <td><div align="left">条件:</div></td>
            <td>
              <div align="left">
                <s:select name="selectInfo" list="#{'1':'技术需求名称','2':'科技活动类型','3':'我的需求'}" headerKey="0" headerValue="--请选择--"  multiple="false"/>                			
              </div>
             </td>
              <td>
                <s:textfield name="inputInfo"></s:textfield>
              </td>
          </tr>   
          <s:hidden name="user_IdS" value="%{#session.id}"/>    
        </table>
        <center>
        	<s:submit value="查询"></s:submit>
        </center>        
    </s:form>
    
    <!-- 显示查询的信息*************************************************************** -->
   	<s:if test="#requestSkill.selectSkills == null || #requestSkill.selectSkills.size() == 0">
   		没有此技术信息！
   	</s:if>
   	
   	<s:else>
   		<table width="850" height="40" border="1" align="center" cellspacing="0">
   			<tr>
    			<td width="5%"><div align="center">序号</div></td>
    			<td width="20%"><div align="center">技术需求名称</div></td>
    			<td width="15%"><div align="center">需求时限</div></td>
    			<td width="20%"><div align="center">科技活动类型</div></td>
    			<td width="15%"><div align="center">审核状态</div></td>
    			
    			<td width="5%"><div align="center">编辑</div></td>
    			<td width="5%"><div align="center">查看</div></td>
    			<td width="5%"><div align="center">删除</div></td>
  			</tr>
  			
  			<!-- 进行遍历 -->
  			<s:iterator value="#request.selectSkills">
  				<tr>
    				<td width="77" height="40"><div align="center">${skill_Id }</div></td>
    				<td width="236" height="40"><div align="center">${t_Name }</div></td>
    				<td width="147" height="40"><div align="center">${t_TimeMin }年至${t_TimeMax }年</div></td>
    				<td width="173" height="40"><div align="center">${t_Type }</div></td>
    				<td width="100"><div align="center">${status }</div></td>
    				
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
    						<a href="show-delete?skill_Id=${skill_Id }" class="delete">删除</a>
    						<input type="hidden" value="${t_Name }">
    					</div>
    				</td>
  			</tr>
  			</s:iterator>
   		</table>
   	</s:else>
    
    
    
  </body>
</html>
