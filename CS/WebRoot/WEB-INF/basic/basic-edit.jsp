<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    
    <title>基础信息编辑</title>
    <script type="text/javascript" src="js/jquery-1.4.js"></script>
<script type="text/javascript" src="js/unitInf.js"></script>
<script type="text/javascript">
function Introduction()
{
	var maxl = 500;
	var count1=0;
	var textIIntro=document.getElementById("introduction").value;
	var lenIIntro=textIIntro.length;
	for(var i=0;i<lenIIntro;i++)
	{
		var enter1=textIIntro.substr(i,1);
		if(enter1=="\n")
		{
			count1++;
		}
	}
	lenIIntro-=count1;
	var showIIntro=lenIIntro;
	if(showIIntro > maxl){
		document.getElementById("introduction").value = document.getElementById("introduction").value.substr(0,maxl-1);
	}
	document.getElementById("Introduction1").innerHTML = showIIntro;
}

function Check1()
{
	if(basic.institution.value=="")
	{
		alert("机构全称不能为空");
		return false;
	}
	else if(basic.addressp.value=="")
	{
		alert("通讯地址不能为空");
		return false;
	}
	else if(basic.shi.value=="")
	{
		alert("所属地域不能为空");
		return false;
	}
	else if(basic.email.value=="")
	{
		alert("电子信箱不能为空");
		return false;
	}
	else if(basic.respresentative.value=="")
	{
		alert("法人代表不能为空");
		return false;
	}
	else if(basic.contactman.value=="")
	{
		alert("联系人不能为空");
		return false;
	}
	else if(basic.institutiontype.value=="")
	{
		alert("机构属性不能为空");
		return false;
	}
	else if(basic.introduction.value=="")
	{
		alert("机构简介不能为空");
		return false;
	}
	else
	{
		basic.submit();
	}
}
		//最大输入字数***********************************************************
   		function getNum(textarea,span){
   			//alert("sasa");
   			 var len = document.getElementById(textarea).value.length;
   			if(len>199){
   				document.getElementById(textarea).value = 
   					document.getElementById(textarea).value.substring(0,200);
   			}
   			document.getElementById(span).innerHTML = len; 
   		}
</script>
  </head>
  		<h2 align="center">基础信息编辑</h2>
  		
  		<s:form action="basic-editSave" method="post">
  			<table width="870" height="477" border="1" align="center" cellspacing="0">
 	 			<tr>
    				<td width="110" height="34" align="center" valign="middle">*&nbsp;机构全称</td>
    				<td height="34" colspan="2" align="center" valign="middle">
        				<s:textfield name="c_Name" disabled="true"></s:textfield></td>
  	    			<td height="34" colspan="2" align="center" valign="middle">归口管理部门</td>
      		 		<td height="34" align="center" valign="middle">
        				<s:select list="#request.departments"
								listKey="department_Id" listValue="departmentName" name="department.department_Id">				
						</s:select>
       
       				</td>
    			</tr>
  
    			<tr>
    				<td height="35" align="center" valign="middle">*&nbsp;通讯地址</td>
    				<td height="34" colspan="2" align="center" valign="middle">
    					<s:textfield name="c_AddressT"></s:textfield></td>
    				<td height="34" colspan="2" align="center" valign="middle">*&nbsp;所在地域</td>
   	  				<td height="34" align="center" valign="middle">
	  					<s:select list="#request.areas"
						listKey="area_Id" listValue="areaName" name="area.area_Id" >				
						</s:select>
         			</td>
    			</tr>
  
    			<tr>
    				<td align="center" valign="middle">网址</td>
    				<td colspan="2" align="center" valign="middle">       
        				<s:textfield name="c_AddressW"></s:textfield>    	</td>
    				<td width="250" align="center" valign="middle">*&nbsp;电子信箱</td>
    				<td colspan="2" align="center" valign="middle">   
        				<s:textfield name="c_AddressE"></s:textfield>    </td>
   				</tr>
  
  				<tr>
    				<td align="center" valign="middle">*&nbsp;法人代表</td>
    				<td colspan="2" align="center" valign="middle">    
        				<s:textfield name="c_Person"></s:textfield>    	</td>
    				<td align="center" valign="middle">邮政编码</td>
    				<td colspan="2" align="center" valign="middle">   
        				<s:textfield name="c_Code"></s:textfield>    </td>
  				</tr>
  
  				<tr>
    				<td height="69" rowspan="2" align="center" valign="middle">*&nbsp;联系人</td>
    				<td width="250" rowspan="2" align="center" valign="middle">   
      					<s:textfield name="c_Contact"></s:textfield>       
      				</td>       
    				<td width="90" align="center" valign="middle">*&nbsp;电话</td>
    				<td colspan="2" align="left" valign="middle">
    					<p>固定
            			<s:textfield name="c_Phone"></s:textfield>
    					</p>   	   
    				</td>   
   	 				<td width="250" align="left" valign="middle">手机  
      					<s:textfield name="c_Telephone"></s:textfield>    </td>
  				</tr>
  
  				<tr>
    				<td align="center" valign="middle">传真</td>
   					<td colspan="3" align="center" valign="middle">
        				<s:textfield name="c_Mail"></s:textfield>   	
        			</td>
  				</tr>
  
  				<tr>
    				<td align="center" valign="middle">*&nbsp;机构属性</td>
   	   				<td colspan="5" align="center" valign="middle">
   	     				<s:radio list="#{'企业':'企业','高等院校':'高等院校','研究机构':'研究机构','其他':'其他'}" name="c_Property" />
   	     
         			</td>
    			</tr>
  
  				<tr>
    				<td align="center" valign="middle">*&nbsp;机构简介(限200字)</td>
   	 				<td colspan="5" align="center" valign="middle">
      	  				<p>
      	    			<s:textarea  name="c_Introduction" id="c_Introduction" cols="80" rows="5" onkeyup="getNum('c_Introduction','c_IntroductionNum')" cssStyle="resize:none"/>
      	  				</p>
      					<span id="c_IntroductionNum">0</span>/200字
      				</td>	
  				</tr>
  				<s:hidden name="user.user_Id" value="%{#session.user_Id}"></s:hidden>
  				<s:hidden name="basic_Id" value="%{#session.basic_Id}"></s:hidden>
		</table>
			
			<center>
			<br><br>			
				<s:submit value="确定"></s:submit>	
			</center>
			
  		</s:form>
  <body>
    
  </body>
</html>
