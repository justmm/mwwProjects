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

import com.mm.cs.service.UserService;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.Preparable;
import com.mm.cs.entities.User;

public class UserAction extends ActionSupport implements RequestAware,SessionAware,
ModelDriven<User>, Preparable
{
	private static final long serialVersionUID = 1L;
	private UserService userService;
	
	public void setUserService(UserService userService) 
	{
		this.userService = userService;
	}
	
	private String username;
	private String password;
	private Integer id;

	public void setUsername(String username) {
		this.username = username;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	//ע�ᰴť��ת
	public String registerMain()
	{
		return "registerMain";
	}
		
	//注册跳转*******************************************************************
	public String register()
	{
		return "register";
	}
	
	//系统信息*****************************************************************
	public String sysInfo()
	{
		return "sysInfo";
	}
	
	//Ajax判断用户名是否存在**********************************************************
	public String validateUserName() throws UnsupportedEncodingException
	{
		if(userService.userNameIsValid(username))
		{
			inputStream = new ByteArrayInputStream("1".getBytes("UTF-8"));			
		}
		else
		{
			inputStream = new ByteArrayInputStream("0".getBytes("UTF-8"));			
		}
		return "ajax-success";
	}
	
	//register的prepare
	public void prepareRegister() 
	{
		//System.out.println(id+"prepare1");
		if(id!=null)
		{
			model = userService.get(id);
			//System.out.println(model+"prepare2");
		}
		else
		{
			//System.out.println(model+"prepare3");
			session.put("id", null);
		}
	}
	//prepare 注册保存
	public void prepareRegisterSave()
	{
		if(id == null)
		{
			//System.out.println(model+"prepareR4");
			model = new User();//��id Ϊnull ����г�ʼ��
		}
		else
		{
			//System.out.println(model+"prepareR5");
			model =userService.get(id);//�� ��Ϊnull ���ȡuser_Id
		}
	}
	//注册保存
	public String registerSave()
	{
		//userService.saveOrUpdate(model);//ִ�б������
		//System.out.println("�������");
		try 
		{
			//System.out.println("try");
			System.out.println(model+"try");
			userService.saveOrUpdate(model);//ִ�б������
			inputStream = new ByteArrayInputStream("1".getBytes("UTF-8"));
			//System.out.println(inputStream+"in1");
		} 
		catch (UnsupportedEncodingException e) 
		{
			System.out.println("catch");
			// TODO Auto-generated catch block
			e.printStackTrace();
			try 
			{
				inputStream = new ByteArrayInputStream("0".getBytes("UTF-8"));
				//System.out.println(inputStream+"in0");
			} catch (UnsupportedEncodingException e1) 
			{
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		return "ajax-success";
	}
	//用户列表*******************************************************************
	public String list()
	{
		request.put("user", userService.getAll());
		return "list";
	}
	//登录确认
	public String loginCheck()
	{
		return "loginCheck";
	}
	
	//登录
	public String loginSave()
	{
		//request.put("users", userService.loginSave(c_Username,c_Password,c_Id));
		
		List<User> getValue = userService.loginSave(username,password, id);
		//System.out.println(getValue+"zzz");
		//
		if(getValue.size()>0)
		{
			//******************************************//
			request.put("r_userAll", userService.loginSave(username,password,id));
			
			session.put("id", getValue.get(0).getId());
			
			return SUCCESS;
		}
		else
		{
			return ERROR;
		}
		
	}
	//判断用户等级
	public String judgeLevel()
	{
		HttpServletRequest req = ServletActionContext.getRequest();
		Object u_Id = req.getSession().getAttribute("id");
		id = new Integer((Integer) u_Id);
		
		List<User> getUserLevel=userService.getUserById(id);
		String getLevel = getUserLevel.get(0).getUsertype();
		if(getLevel.equals("1")){
			try {
				inputStream = new ByteArrayInputStream("1".getBytes("UTF-8"));
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else if(getLevel.equals("2")){
			try {
				inputStream = new ByteArrayInputStream("2".getBytes("UTF-8"));
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
						
		}
		else if(getLevel.equals("3")){
			try {
				inputStream = new ByteArrayInputStream("3".getBytes("UTF-8"));
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return "ajax-success";
	}
	
	//删除用户
	public String delete()
	{
		
		try 
		{
			userService.delete(id);
			inputStream = new ByteArrayInputStream("1".getBytes("UTF-8"));
		} catch (UnsupportedEncodingException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();			
			try 
			{
				inputStream = new ByteArrayInputStream("0".getBytes("UTF-8"));
			} catch (UnsupportedEncodingException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
						
		return "ajax-success";
	}
	
	//ajax
	private InputStream inputStream;
	
	//Request
	private Map<String, Object> request;
		
	//model
	private User model;

	//Session
	private Map<String, Object> session;
	

	public InputStream getInputStream()
	{
		return inputStream;
	}
	@Override
	public void setRequest(Map<String, Object> arg0) 
	{
		// TODO Auto-generated method stub
		this.request = arg0;
	}

	@Override
	public void prepare() throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public User getModel() {
		// TODO Auto-generated method stub
		return model;
	}

	@Override
	public void setSession(Map<String, Object> arg0) {
		// TODO Auto-generated method stub
		this.session = arg0;
	}
}
