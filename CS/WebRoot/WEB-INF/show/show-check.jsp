<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>查看信息</title>
    

  </head>
  
  <body>
    	<h2 align="center">重大技术信息表</h2>
    	
    	<table width="870" height="477" border="1" align="center" cellspacing="0">
			
			<!-- 基础信息********************************************************** -->
			<s:iterator value="#request.getBasicInfos">
 	 			<tr>
    				<td width="110" height="34" align="center" valign="middle">*机构全称</td>
    				<td height="34" colspan="2" align="center" valign="middle">
        				${c_Name }</td>
  	    			<td height="34" colspan="2" align="center" valign="middle">归口管理部门</td>
      		 		<td height="34" align="center" valign="middle">
        				${department.departmentName }     
       				</td>
    			</tr>
  
    			<tr>
    				<td height="35" align="center" valign="middle">*通讯地址</td>
    				<td height="34" colspan="2" align="center" valign="middle">
    					${c_AddressT }</td>
    				<td height="34" colspan="2" align="center" valign="middle">*所在地域</td>
   	  				<td height="34" align="center" valign="middle">
	  					${area.areaName }
         			</td>
    			</tr>
  
    			<tr>
    				<td align="center" valign="middle">网址</td>
    				<td colspan="2" align="center" valign="middle">       
        				${c_AddressW }    	</td>
    				<td width="250" align="center" valign="middle">*电子信箱</td>
    				<td colspan="2" align="center" valign="middle">   
        				${c_AddressE }    </td>
   				</tr>
  
  				<tr>
    				<td align="center" valign="middle">*法人代表</td>
    				<td colspan="2" align="center" valign="middle">    
        				${c_Person }    	</td>
    				<td width="250" align="center" valign="middle">邮政编码</td>
    				<td colspan="2" align="center" valign="middle">   
        				${c_Code }    </td>
  				</tr>
  
  				<tr>
    				<td height="69" rowspan="2" align="center" valign="middle">*联系人</td>
    				<td width="250" rowspan="2" align="center" valign="middle">   
      					${c_Contact }       
      				</td>       
    				<td width="90" align="center" valign="middle">*电话</td>
    				<td width="250" colspan="2" align="left" valign="middle">
    					<p>&nbsp;固定&nbsp;
            			${c_Phone }
    					</p>   	   
    				</td>   
   	 				<td width="250" align="left" valign="middle">&nbsp;手机&nbsp;  
      					${c_Telephone }    </td>
  				</tr>
  
  				<tr>
    				<td width="90" align="center" valign="middle">传真</td>
   					<td colspan="3" align="center" valign="middle">
        				${c_Mail } 	
        			</td>
  				</tr>
  
  				<tr>
    				<td align="center" valign="middle">*机构属性</td>
   	   				<td colspan="5" align="center" valign="middle">
   	     				${c_Property }
         			</td>
    			</tr>
  
  				<tr>
    				<td align="center" valign="middle">*机构简介(限200字)</td>
   	 				<td colspan="5" align="center" valign="middle">
      	  				<p>
      	    				<textarea cols="80" rows="5" readonly="readonly" disabled="disabled">${c_Introduction }</textarea>
      	  				</p>
      					<p>&nbsp;</p>
      				</td>	
  				</tr>
  			</s:iterator>
  			
  			<!-- 技术信息********************************************************** -->
  			<s:iterator value="#request.getSkillInfos">
  				<tr>
    				<td width="110" height="45" align="center" valign="middle">*技术需求名称</td>
    				<td width="280" height="45" colspan="2" align="center" valign="middle" >
						${t_Name }
    				<td width="200" height="45" align="center" valign="middle">*需求时限</td>
    				<td width="280" height="45" align="center" valign="middle">
      				<label>
						${t_TimeMin }        
        			年至
    					${t_TimeMax }
    				年     
    				</label>
    				</td>
 				</tr>
 
 				<tr>
     				<td width="110" height="184" rowspan="3" align="center" valign="middle">*科技需求概述(限500字)</td>
     				<td height="182" colspan="4" align="center" valign="middle"><p align="left">主要问题</p>       				
	   					<textarea cols="80" rows="5" readonly="readonly" disabled="disabled">${t_MainProblem }</textarea>
	   					<br>
	   				</td>
  				</tr>
  
  				<tr>
   					<td height="188" colspan="4" align="center" valign="middle"><p align="left">技术关键</p>     			
       					<textarea cols="80" rows="5" readonly="readonly" disabled="disabled">${t_SkillKey }</textarea>
     				</td>
 				</tr>
 
 				<tr>
   					<td height="184" colspan="4" align="center" valign="middle"><p align="left">预期目标 </p>    
       					<textarea cols="80" rows="5" readonly="readonly" disabled="disabled">${t_Aim }</textarea>
       				</td>
 				</tr>
 
 				<tr>
    				<td height="67" align="center" valign="middle">*关键字(1-5个顺序输入)</td>
    				<td colspan="4" align="center" valign="middle">
						${t_Key1 }
						&nbsp;
						${t_Key2 }
						&nbsp;
						${t_Key3 }
						&nbsp;
						${t_Key4 }
						&nbsp;
						${t_Key5 }						
   					</td>
  				</tr>
  
  				<tr>
    				<td height="67" align="center" valign="middle">拟投入自有资金总额</td>
    				<td colspan="4" align="center" valign="middle">
						${t_MoneySet }万元
					</td>
  				</tr>
  
  				<tr>
    				<td height="67" rowspan="2" align="center" valign="middle">*技术需求解决方式</td>
    				<td height="41" colspan="4" align="center" valign="middle">						
						${t_Cooperate }
   	     			</td>
  				</tr>
  
				<tr>
    				<td height="40" colspan="4" align="center" valign="middle"><span class="STYLE1">合作意向单位</span>
      					${t_Unit }
    					&nbsp;	(选填)</td>
  				</tr>
  
  				<tr>
    				<td height="67" align="center" valign="middle">*科技活动类型</td>   
    				<td colspan="4" align="center" valign="middle">
        				${t_Type } </td>
  				</tr>  
  
  				<tr id="tr_subject" style="display:none;">									
					<td height="61" align="center" valign="middle">			
						<p>*学科分类</p>
    					<p>（限基础研究填写）</p>
    				</td>    		
    				<td colspan="4" align="center" valign="middle">  
    					 ${listFirst.listFirstName } &nbsp;	
						 ${listSecond.listSecondName }&nbsp;	
						 ${listThird.listThirdName }&nbsp;					
					</td>
				</tr>
 
 				<tr id="tr_skillPlace" style="display:none;">
    				<td height="96" align="center" valign="middle"><p>*需求技术所属领域(非基础研究填写)</p>    </td>
    				<td colspan="4" align="center" valign="middle">
				    <p id="ssly">
				    	${t_Territory }
				    </p>
					</td>
				</tr>
  	
    			<tr id="tr_skillTrade" style="display:none;">
					<td height="47" align="center" valign="middle">
    				<p>*需求技术应用行业(非基础研究填写)</p></td>
					<td colspan="4" align="center" valign="middle">
						
						${tradeFirst.tradeFirstName }&nbsp;
						${tradeSecond.tradeSecondName }&nbsp;
						${tradeThird.tradeThirdName } &nbsp;
					
					</td>
				</tr>
			</s:iterator>
		</table>
  </body>
</html>
