package com.mm.cs.actions;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.RequestAware;
import org.apache.struts2.interceptor.SessionAware;

import com.mm.cs.entities.Skill;
import com.mm.cs.service.ListFirstService;
import com.mm.cs.service.ListSecondService;
import com.mm.cs.service.ListThirdService;
import com.mm.cs.service.ShowService;
import com.mm.cs.service.TradeFirstService;
import com.mm.cs.service.TradeSecondService;
import com.mm.cs.service.TradeThirdService;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.Preparable;


public class ShowAction extends ActionSupport implements RequestAware,SessionAware,ModelDriven<Skill>,Preparable
{

	private static final long serialVersionUID = 1L;
	private ShowService showService;
	public void setShowService(ShowService showService) {
		this.showService = showService;
	}
	private ListFirstService listFirstService;
	private ListSecondService listSecondService;
	private ListThirdService listThirdService;
	private TradeFirstService tradeFirstService;
	private TradeSecondService tradeSecondService;
	private TradeThirdService tradeThirdService;
	//********************
	public Integer user_IdS;
	public void setUser_IdS(Integer user_IdS) {
		this.user_IdS = user_IdS;
	}
	
	public Integer user_IdB;
	public void setUser_IdB(Integer user_IdB) {
		this.user_IdB = user_IdB;
	}
	
	public String inputInfo;
	public void setInputInfo(String inputInfo) {
		this.inputInfo = inputInfo;
	}
	
	public String selectInfo;
	public void setSelectInfo(String selectInfo) {
		this.selectInfo = selectInfo;
	}
	
	public Integer skill_Id;
	public void setSkill_Id(Integer skill_Id) {
		this.skill_Id = skill_Id;
	}
	
//	public String ifPass;
//	public void setIfPass(String ifPass) {
//		this.ifPass = ifPass;
//	}
//	
	public String advice;
	public void setAdvice(String advice) {
		this.advice = advice;
	}
	public String t_Type;
	public void setT_Type(String t_Type) {
		this.t_Type = t_Type;
	}
//	
	//*************************
	
	//
	public String select()
	{
		//System.out.println("q1"+selectInfo);
		if(selectInfo.equals("1"))
		{
			System.out.println("q1"+inputInfo);
			request.put("selectSkills", showService.getSkillByName(inputInfo,user_IdS));
		}
		else if(selectInfo.equals("2"))
		{
			request.put("selectSkills", showService.getSkillByType(inputInfo,user_IdS));
		}
		else if(selectInfo.equals("0"))
		{
			request.put("selectSkills", showService.getSkillAll());
		}
		else if(selectInfo.equals("3"))
		{
			request.put("selectSkills", showService.getSkillById(user_IdS));
		}
		return "select";
	}
	
	//basic+skill
	public String check()
	{
		HttpServletRequest req = ServletActionContext.getRequest();
		Object u_Id =req.getSession().getAttribute("id");
		user_IdB=new Integer(u_Id.toString());
		user_IdS=user_IdB;
		request.put("getBasicInfos", showService.getAllBasic(user_IdB));
		
		System.out.println("***************************************************");
		
	
		System.out.println("q1"+"skill_Id");
		System.out.println("***************************************************");
		
		request.put("getSkillInfos", showService.getSkillId(user_IdS,skill_Id));
		
		return "check";
	}
	
	public String auditList()
	{
		request.put("skills",showService.getSkillAll());
		return "auditList";
	}
	
	
	public String audit()
	{
		List<Skill> getUser_Id = showService.getSkillByIdAudit(skill_Id);
		user_IdS = getUser_Id.get(0).getUser_IdS();
		user_IdB = user_IdS;
		request.put("getBasicInfos", showService.getAllBasic(user_IdB));
		request.put("getSkillInfos", showService.getSkillId(user_IdS, skill_Id));
		return "audit";
	}
	
	
	public void prepareAuditPass()
	{
		modelSkill = showService.getSkill(skill_Id);
		//System.out.print(modelSkill);
	}
	public String auditPass()
	{
		
		modelSkill.setStatus("已通过形式审核");
//		System.out.println("********************************");
//		System.out.println(modelSkill.getStatus());
//		System.out.println("********************************");
		showService.saveOrUpdate(modelSkill);
		request.put("skills",showService.getSkillAll());
		return "auditPass";
	}
	
	public String auditPassNo()
	{
		session.put("skill_IdPassNo", skill_Id);
		
		HttpServletRequest req = ServletActionContext.getRequest();
		Object u_Id = req.getSession().getAttribute("id");
		System.out.println("passno "+u_Id);
		user_IdB = new Integer(u_Id.toString());
		
		user_IdS = user_IdB;
		request.put("getSkillInfosPassNo", showService.getSkillId(user_IdS, skill_Id));
		return "auditPassNo";
	}
	
	public String auditInfoSave()
	{
		modelSkill.setStatus(advice);
		modelSkill.setStatus("未通过形式审核");
		showService.saveOrUpdate(modelSkill);
		request.put("skills",showService.getSkillAll());
		return "auditInfoSave";
	}
	
	public void prepareAuditInfoSave()
	{
		modelSkill = showService.getSkill(skill_Id);
	}
	
	//***********
	public void prepareEdit()
	{
		if(skill_Id!=null){
			
			modelSkill = showService.getSkill(skill_Id);
		}
	}
	public String edit()
	{
		
		//skill_Id存入session
		session.put("skill_Id", skill_Id);
		
		//request回显list trade
		request.put("listFirstsEdit", listFirstService.getAll());
		request.put("listSecondsEdit", listSecondService.getAll());
		request.put("listThirdsEdit", listThirdService.getAll());
		request.put("tradeFirstsEdit", tradeFirstService.getAll());
		request.put("tradeSecondsEdit", tradeSecondService.getAll());
		request.put("tradeThirdsEdit", tradeThirdService.getAll());
		
		return "edit";
	}
	
	public void prepareEditSave(){
		modelSkill = showService.getSkill(skill_Id);
	}
	
	public String editSave()
	{
		//System.out.println(t_Type);
		if(t_Type.equals("基础研究")){
			System.out.println("hh");
			modelSkill.setT_Territory(null);
			modelSkill.setTradeFirst(null);
			modelSkill.setTradeSecond(null);
			modelSkill.setTradeThird(null);
		}
		else{
			modelSkill.setListFirst(null);
			modelSkill.setListSecond(null);
			modelSkill.setListThird(null);
		}
		showService.saveOrUpdate(modelSkill);
		return "editSave";
	}
	//������˵�
//	public void prepareAuditIfPass()
//	{
//		//List<Skill> getId = showService.getSkillByIdAudit(skill_Id);//**********//
//		//skill_Id = getId.get(0).getSkill_Id();
//		System.out.println("******************************");
//		System.out.println(skill_Id);
//		System.out.println("******************************");
//		request.get(skill_Id);///////////////////////////////////////////////////////////////////
//		System.out.println("******************************");
//		System.out.println("get"+skill_Id);
//		System.out.println("******************************");
//		modelSkill = showService.getSkill(skill_Id);
//	}
//	public String auditIfPass()
//	{
//		System.out.println("********************************");
//		System.out.println(ifPass);
//		System.out.println(advice);
//		System.out.println("********************************");
//		modelSkill.setStatus(ifPass);
//		modelSkill.setAdvice(advice);
//		showService.saveOrUpdate(modelSkill);
//		return "auditIfPass";
//	}
	//高级查询的相关值
	private String selectTypes[];
	
	public void setSelectTypes(String[] selectTypes) {
		this.selectTypes = selectTypes;
	}
	
	private String selectInputsType[];
	
	public void setSelectInputsType(String[] selectInputsType) {
		this.selectInputsType = selectInputsType;
	}
	
	private String includeOrNot[];
	
	public void setIncludeOrNot(String[] includeOrNot) {
		this.includeOrNot = includeOrNot;
	}
	
	private String selectInputsInclude[];
	
	public void setSelectInputsInclude(String[] selectInputsInclude) {
		this.selectInputsInclude = selectInputsInclude;
	}
	
	private String exactOrNot[];
	
	public void setExactOrNot(String[] exactOrNot) {
		this.exactOrNot = exactOrNot;
	}
	
	private String selectAnother[];
	
	public void setSelectAnother(String[] selectAnother) {
		this.selectAnother = selectAnother;
	}
	
	//selectComplex***********************
	public String selectComplex()
	{
		System.out.println(selectTypes+"s1"+selectInputsType+"s2"+includeOrNot+"s3"+ selectInputsInclude+"s4"+ exactOrNot+"s5"+ selectAnother);
		
		request.put("selectSkillHigh", showService.getSkillByHigh(selectTypes, selectInputsType, includeOrNot, selectInputsInclude, exactOrNot, selectAnother, user_IdS));
		return "selectComplex";
	}
	//**************
	private InputStream inputStream;
	public InputStream getInputStream() {
		return inputStream;
	}
	
	public String delete()
	{
		try 
		{
			showService.delete(skill_Id);
			inputStream = new ByteArrayInputStream("1".getBytes("UTF-8"));
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			try {
				inputStream = new ByteArrayInputStream("0".getBytes("UTF-8"));
			} catch (UnsupportedEncodingException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		return "ajax-success";
	}
	//**************************
	public String search()
	{
		return "search";
	}
	public String searchComplex()
	{
		return "searchComplex";
	}
	
	
	
	
	//**************************
	private Skill modelSkill;
	private Map<String, Object> session;
	private Map<String, Object> request;
	@Override
	public void setRequest(Map<String, Object> arg0) {
		// TODO Auto-generated method stub
		this.request=arg0;
	}

	@Override
	public void setSession(Map<String, Object> arg0) {
		// TODO Auto-generated method stub
		this.session=arg0;
	}

	@Override
	public Skill getModel() {
		// TODO Auto-generated method stub
		return modelSkill;
	}

	@Override
	public void prepare() throws Exception {
		// TODO Auto-generated method stub
		
	}

}
