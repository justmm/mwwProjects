package com.mm.cs.service;

import com.mm.cs.dao.SkillDao;
import com.mm.cs.entities.Skill;

public class SkillService 
{
	private SkillDao skillDao;

	public void setSkillDao(SkillDao skillDao) {
		this.skillDao = skillDao;
	}
	
	//Ìí¼Ó±£´æÐÞ¸Ä
	public void saveOrUpdate(Skill skill)
	{
		skillDao.saveOrUpdate(skill);
		
	}
}
