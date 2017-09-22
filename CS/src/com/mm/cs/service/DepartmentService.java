package com.mm.cs.service;



import java.util.List;

import com.mm.cs.dao.DepartmentDao;
import com.mm.cs.entities.Department;

public class DepartmentService 
{
	private DepartmentDao departmentDao;

	public void setDepartmentDao(DepartmentDao departmentDao) {
		this.departmentDao = departmentDao;
	}
	
	public List<Department> getAll()
	{
		return departmentDao.getAll();
	}
}
