package com.mm.cs.actions;


import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.RequestAware;
import org.apache.struts2.interceptor.SessionAware;

import com.mm.cs.entities.Basic;
import com.mm.cs.service.AreaService;
import com.mm.cs.service.BasicService;
import com.mm.cs.service.DepartmentService;
import com.mm.cs.service.UserService;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.Preparable;

public class BasicAction extends ActionSupport implements RequestAware,SessionAware,
ModelDriven<Basic>, Preparable

{
	private static final long serialVersionUID = 1L;
	
	private BasicService basicService;
	public void setBasicService(BasicService basicService)
	{
		this.basicService = basicService;
	}
	
	private DepartmentService departmentService;
	public void setDepartmentService(DepartmentService departmentService) 
	{
		this.departmentService = departmentService;
	}
	
	private AreaService areaService;
	public void setAreaService(AreaService areaService) 
	{
		this.areaService = areaService;
	}
	
	public UserService userService;
	public void setUserService(UserService userService)
	{
		this.userService = userService;
	}
	
	private Integer basic_Id;
	public void setBasic_Id(Integer basic_Id)
	{
		this.basic_Id = basic_Id;
	}
	
	
	//添加基础信息
	public void prepareInput()
	{
		
	}
	public String input()
	{
		request.put("departments", departmentService.getAll());
		request.put("areas", areaService.getAll());
		
		//获取id
		HttpServletRequest req = ServletActionContext.getRequest();
		Object user_id = req.getSession().getAttribute("id");
		Integer id = new Integer(user_id.toString());
		
		//获取basic_Id
		List<Basic> getU_Id = basicService.input(id);
		
		if(getU_Id.size()>0)
		{
			session.put("basic_Id", getU_Id.get(0).getBasic_Id());
			request.put("basics", basicService.getAll(id));
		}
		else
		{
			session.put("basic_Id", null);
		}
		return INPUT;
	}
	
	//保存添加的基本信息
	public void prepareSave()
	{
		if(basic_Id==null)
		{
			model=new Basic();
		}
		else 
		{
			model=basicService.get(basic_Id);
		}
	}
	public String save()
	{
		basicService.saveOrUpdate(model);
		return SUCCESS;
	}
	//编辑信息
	public void prepareEdit()
	{
		if(basic_Id!=null)
		{
			model = basicService.get(basic_Id);
		}
	}
	public String edit()
	{
		request.put("departments", departmentService.getAll());
		request.put("areas", areaService.getAll());
		return "edit";
	}
	
	//保存编辑信息
	public void prepareEditSave()
	{
		model = basicService.get(basic_Id);
	}
	public String editSave()
	{
		basicService.saveOrUpdate(model);
		return "editSave";
	}
	
	//********************************************************
	private Map<String, Object> request;
	
	private Map<String,Object> session;
	
	private Basic model;
	
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
	public Basic getModel() {
		// TODO Auto-generated method stub
		return model;
	}

	@Override
	public void prepare() throws Exception {
		// TODO Auto-generated method stub
		
	}

}
