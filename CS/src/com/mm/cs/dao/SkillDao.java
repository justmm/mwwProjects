package com.mm.cs.dao;

import com.mm.cs.entities.Skill;

public class SkillDao extends BaseDao
{
	//�������
	public void saveOrUpdate(Skill skill)
	{
		getSession().saveOrUpdate(skill);
		//System.out.println("h2");
	}
}
