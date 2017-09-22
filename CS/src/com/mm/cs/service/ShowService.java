package com.mm.cs.service;

import java.util.List;

import com.mm.cs.dao.ShowDao;
import com.mm.cs.entities.Basic;
import com.mm.cs.entities.Skill;

public class ShowService 
{
	private ShowDao showDao;
	public void setShowDao(ShowDao showDao) {
		this.showDao = showDao;
	}
	
	//**********
	public List<Skill> getSkillId(Integer user_IdS,Integer skill_Id)
	{
		return showDao.getSkillId(user_IdS, skill_Id);
	}
	//***********
	public List<Skill> getSkillById(Integer user_IdS)
	{
		return showDao.getSkillById(user_IdS);
	}
	
	//**********
	public List<Skill> getSkillByName(String inputInfo,Integer user_IdS)
	{
		return showDao.getSkillByName(inputInfo, user_IdS);
	}
	//**********
	public List<Skill> getSkillByType(String inputInfo,Integer user_IdS)
	{
		return showDao.getSkillByType(inputInfo, user_IdS);
	}
	//*********
	public List<Skill> getSkillAll()
	{
		return showDao.getAllSkill();
	}
	//basic
	public List<Basic> getAllBasic(Integer user_IdB)
	{
		return showDao.getAllBasic(user_IdB);
	}
	//skill
	public List<Skill> getSkillByIdAudit(Integer skill_Id)
	{
		return showDao.getSkillByIdAudit(skill_Id);
	}
	//********
	public Skill getSkill(Integer skill_Id)
	{
		return showDao.getSkill(skill_Id);
	}
	//*********
	public void saveOrUpdate(Skill skill)
	{
		showDao.saveOrUpdate(skill);
	}
	//*******
	public void delete(Integer skill_Id)
	{
		showDao.delete(skill_Id);
	}
	//**********
	public List<Skill> getSkillByHigh(String selectTypes[],String selectInputsType[],String includeOrNot[],
			String selectInputsInclude[],String exactOrNot[],String selectAnother[],Integer user_IdS )
	{
		return showDao.getSkillByHigh(selectTypes, selectInputsType, includeOrNot, selectInputsInclude, exactOrNot, selectAnother, user_IdS);
	}
}
