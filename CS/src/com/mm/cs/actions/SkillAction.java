package com.mm.cs.actions;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.RequestAware;
import org.apache.struts2.interceptor.SessionAware;
import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

import com.mm.cs.entities.ListFirst;
import com.mm.cs.entities.ListSecond;
import com.mm.cs.entities.ListThird;
import com.mm.cs.entities.Skill;
import com.mm.cs.entities.TradeFirst;
import com.mm.cs.entities.TradeSecond;
import com.mm.cs.entities.TradeThird;
import com.mm.cs.service.ListFirstService;
import com.mm.cs.service.ListSecondService;
import com.mm.cs.service.ListThirdService;
import com.mm.cs.service.SkillService;
import com.mm.cs.service.TradeFirstService;
import com.mm.cs.service.TradeSecondService;
import com.mm.cs.service.TradeThirdService;

import com.mm.cs.service.UserService;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.Preparable;


public class SkillAction extends ActionSupport implements RequestAware,SessionAware,
ModelDriven<Skill>,Preparable
{
	private static final long serialVerisonUID = 1L;
	
	//*****************
	private SkillService skillService;

	public void setSkillService(SkillService skillService) {
		this.skillService = skillService;
	}
	
	private UserService userService;
	
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	
	
	private ListFirstService listFirstService;
	
	public void setListFirstService(ListFirstService listFirstService) {
		this.listFirstService = listFirstService;
	}
	
	private ListSecondService listSecondService;

	public void setListSecondService(ListSecondService listSecondService) {
		this.listSecondService = listSecondService;
	}
	
	private ListThirdService listThirdService;
	
	public void setListThirdService(ListThirdService listThirdService) {
		this.listThirdService = listThirdService;
	}
	
	
	private TradeFirstService tradeFirstService;

	public void setTradeFirstService(TradeFirstService tradeFirstService) {
		this.tradeFirstService = tradeFirstService;
	}
	 
	private TradeSecondService tradeSecondService;

	public void setTradeSecondService(TradeSecondService tradeSecondService) {
		this.tradeSecondService = tradeSecondService;
	}
	
	private TradeThirdService tradeThirdService;

	public void setTradeThirdService(TradeThirdService tradeThirdService) {
		this.tradeThirdService = tradeThirdService;
	}

	
	//ֵ
	private String ListFirstId;

	public void setListFirstId(String listFirstId) {
		ListFirstId = listFirstId;
	}
	
	private String ListSecondId;

	public void setListSecondId(String listSecondId) {
		ListSecondId = listSecondId;
	}
	
	private String ListThirdId;

	public void setListThirdId(String listThirdId) {
		ListThirdId = listThirdId;
	}
	
	private String TradeFirstId;

	public void setTradeFirstId(String tradeFirstId) {
		TradeFirstId = tradeFirstId;
	}
	
	private String TradeSecondId;

	public void setTradeSecondId(String tradeSecondId) {
		TradeSecondId = tradeSecondId;
	}
	
	private String TradeThirdId;

	public void setTradeThirdId(String tradeThirdId) {
		TradeThirdId = tradeThirdId;
	}
	//InputStream
	private InputStream inputStream;

	public InputStream getInputStream() {
		return inputStream;
	}
	
	//***************************************
	public void prepareInput()
	{
		
	}
	//
	public String input()
	{
		request.put("listFirsts", listFirstService.getAll());
		request.put("tradeFirsts", tradeFirstService.getAll());
		return "input";
		//****************************userID***********
		//HttpServletRequest req = ServletActionContext.getRequest();
		//Object user_IdS  = req.getSession().getAttribute("id");
		
	}
	//*********************
	//***************************1-2*****************
	public String linkageSecondList() throws JsonGenerationException, JsonMappingException, IOException 
	{
		String listFirstId=ListFirstId.substring(0, 2);
		try
		{
			List<ListFirst> listFirstResult = listFirstService
					.getSecondList(listFirstId);
			ObjectMapper mapper = new ObjectMapper();
			String result = mapper.writeValueAsString(listFirstResult);
			inputStream = new ByteArrayInputStream(result.getBytes("UTF-8"));
		} catch (UnsupportedEncodingException e) 
		{
			// TODO: handle exception
			e.printStackTrace();
		}
		return "ajax-success";
	}
	//***************************2-3*****************
	public String linkageThirdList() throws JsonGenerationException, JsonMappingException, IOException
	{
		String listSecondId = ListSecondId.substring(0, 5);
		try
		{
			List<ListSecond> listSecondResult = listSecondService
					.getThirdList(listSecondId);
			ObjectMapper mapper = new ObjectMapper();
			String result = mapper.writeValueAsString(listSecondResult);
			inputStream = new ByteArrayInputStream(result.getBytes("UTF-8"));
		} catch (UnsupportedEncodingException e) 
		{
			// TODO: handle exception
			e.printStackTrace();
		}
		return "ajax-success";
	}
	
	//***************************1-2*****************
	public String linkageSecondTrade() throws JsonGenerationException, JsonMappingException, IOException
	{
		String tradeFirstId = TradeFirstId.substring(0, 1);
		try 
		{
			List<TradeFirst> tradeFirstResult = tradeFirstService
					.getSecondTrade(tradeFirstId);
			ObjectMapper mapper = new ObjectMapper();
			String result = mapper.writeValueAsString(tradeFirstResult);
			inputStream = new ByteArrayInputStream(result.getBytes("UTF-8"));
		} catch (UnsupportedEncodingException e)
		{
			// TODO: handle exception
			e.printStackTrace();
		}
		return "ajax-success";
	}
	//***************************2-3*****************
	public String linkageThirdTrade() throws JsonGenerationException, JsonMappingException, IOException
	{
		String tradeSecondId = TradeSecondId.substring(0, 3);
		try 
		{
			List<TradeSecond> tradeSecondResult = tradeSecondService.getThirdTrade(tradeSecondId); 
			ObjectMapper mapper = new ObjectMapper();
			String result = mapper.writeValueAsString(tradeSecondResult);
			inputStream = new ByteArrayInputStream(result.getBytes("UTF-8"));
		} catch (UnsupportedEncodingException e)
		{
			// TODO: handle exception
			e.printStackTrace();
		}
		return "ajax-success";
	}
	
	//************************
	
	//************************
	public void prepareSave()
	{
		model = new Skill();
	}
	public String save()
	{
		//****
		/*ListFirst listFirst = listFirstService.getListFirst(model.getListFirst().getListFirstId()).get(0);
		model.setListFirst(listFirst);
		
		ListSecond listSecond = listSecondService.getListSecond(model.getListSecond().getListSecondId()).get(0);
		model.setListSecond(listSecond);
		
		ListThird listThird = listThirdService.getListThird(model.getListThird().getListThirdId()).get(0);
		model.setListThird(listThird);
		
		TradeFirst tradeFirst = tradeFirstService.getTradeFirst(model.getTradeFirst().getTradeFirstId()).get(0);
		model.setListFirst(listFirst);
		
		TradeSecond tradeSecond = tradeSecondService.getTradeSecond(model.getTradeSecond().getTradeSecondId()).get(0);
		model.setListSecond(listSecond);
		
		TradeThird tradeThird = tradeThirdService.getTradeThird(model.getTradeThird().getTradeThirdId()).get(0);
		model.setListThird(listThird);*/
		//****
		skillService.saveOrUpdate(model);
		return SUCCESS;
	}
	//*****************
	private Map<String, Object> session;
	private Skill model;
	private Map<String, Object> request;
	@Override
	public void setRequest(Map<String, Object> arg0) {
		// TODO Auto-generated method stub
		this.request = arg0;
	}
	
	@Override
	public void setSession(Map<String, Object> arg0) {
		// TODO Auto-generated method stub
		this.session = arg0;
	}

	@Override
	public Skill getModel() {
		// TODO Auto-generated method stub
		return model;
	}

	@Override
	public void prepare() throws Exception {
		// TODO Auto-generated method stub
		
	}

}
