package com.mm.cs.dao;

import java.util.List;

import com.mm.cs.entities.Department;

public class DepartmentDao extends BaseDao
{
	public List<Department> getAll()
	{
		String hql ="from Department";
		return getSession().createQuery(hql).list();
	}
}
