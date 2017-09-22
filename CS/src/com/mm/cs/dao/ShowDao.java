package com.mm.cs.dao;

import java.util.List;

import com.mm.cs.entities.Basic;
import com.mm.cs.entities.Skill;

public class ShowDao extends BaseDao
{
	//***
	public List<Skill> getSkillId(Integer user_IdS,Integer skill_Id)
	{
		String hql = "from Skill s" +
				" left outer join fetch s.listFirst" +
				" left outer join fetch s.listSecond" +
				" left outer join fetch s.listThird" +
				" left outer join fetch s.tradeFirst" +
				" left outer join fetch s.tradeSecond" +
				" left outer join fetch s.tradeThird" +
				" where s.user_IdS = ? and s.skill_Id = ?";
		return getSession().createQuery(hql).setInteger(0, user_IdS).setInteger(1, skill_Id).list();
	}
	//***
	public List<Skill> getSkillById(Integer user_IdS)
	{
		String hql="from Skill s" +
				" left outer join fetch s.listFirst" +
				" left outer join fetch s.listSecond" +
				" left outer join fetch s.listThird" +
				" left outer join fetch s.tradeFirst" +
				" left outer join fetch s.tradeSecond" +
				" left outer join fetch s.tradeThird" +
				" where s.user_IdS = ?";
		return getSession().createQuery(hql).setInteger(0, user_IdS).list();
	}
	
	//*******
	public List<Skill> getSkillByName(String inputInfo,Integer user_IdS)
	{
		String hql = "from Skill s " +
				" left outer join fetch s.listFirst" +
				" left outer join fetch s.listSecond" +
				" left outer join fetch s.listThird" +
				" left outer join fetch s.tradeFirst" +
				" left outer join fetch s.tradeSecond" +
				" left outer join fetch s.tradeThird" +
				" where s.t_Name = ? and s.user_IdS = ?";
		return getSession().createQuery(hql).setString(0, inputInfo).setInteger(1, user_IdS).list();
	}
	
	//********
	public List<Skill> getSkillByType(String inputInfo,Integer user_IdS)
	{
		
		String hql = "from Skill s" +
						" left outer join fetch s.listFirst" +
						" left outer join fetch s.listSecond" +
						" left outer join fetch s.listThird" +
						" left outer join fetch s.tradeFirst" +
						" left outer join fetch s.tradeSecond" +
						" left outer join fetch s.tradeThird" +
						" where s.t_Type = ? and s.user_IdS = ?";
		return getSession().createQuery(hql).setString(0, inputInfo).setInteger(1, user_IdS).list();
	}
	
	//********
	public List<Skill> getAllSkill()
	{
		
		String hql = "from Skill";
		return getSession().createQuery(hql).list();
	}
	
	//basic
	public List<Basic> getAllBasic(Integer user_IdB)
	{
		String hql = "from Basic b " +
				" left outer join fetch b.department " +
				" left outer join fetch b.area " +
				" where b.id = ? ";
		return getSession().createQuery(hql).setInteger(0, user_IdB).list();
	}
	
	//skill
	public List<Skill> getSkillByIdAudit(Integer skill_Id)
	{
		String hql = "from Skill s" +
				" left outer join fetch s.listFirst" +
				" left outer join fetch s.listSecond" +
				" left outer join fetch s.listThird" +
				" left outer join fetch s.tradeFirst" +
				" left outer join fetch s.tradeSecond" +
				" left outer join fetch s.tradeThird" +
				" where s.skill_Id = ?";
		return getSession().createQuery(hql).setInteger(0, skill_Id).list();
	}
	//********
	public Skill getSkill(Integer skill_Id)
	{
		return (Skill) getSession().get(Skill.class, skill_Id);
	}
	
	//**********
	public void saveOrUpdate(Skill skill)
	{
		getSession().saveOrUpdate(skill);
	}
	//
	public void delete(Integer skill_Id)
	{
		String hql="delete from Skill s where s.skill_Id = ?";
		getSession().createQuery(hql).setInteger(0, skill_Id).executeUpdate();
	}
	//**********
	public List<Skill> getSkillByHigh(String selectTypes[],String selectInputsType[],String includeOrNot[],
			String selectInputsInclude[],String exactOrNot[],String selectAnother[],Integer user_IdS )
			{
				String hql = "from Skill s"+
				" left outer join fetch s.listFirst" +
				" left outer join fetch s.listSecond" +
				" left outer join fetch s.listThird" +
				" left outer join fetch s.tradeFirst" +
				" left outer join fetch s.tradeSecond" +
				" left outer join fetch s.tradeThird" +
				" where s.user_IdS = '"+user_IdS+"' ";
				
				// System.out.println(selectTypes.length+"q1");
				for (int i = 0; i < selectAnother.length; i++) {
					// 判断新添加的条件 并且 或者 不含
					if (selectAnother[i].equals("1"))// 并且*******************************
					{
						// 判断模糊查找还是精确查找
						if (exactOrNot[i].equals("1"))// 精确查找
						{
							if (selectTypes[i].equals("技术需求名称")) {
								if (!selectInputsType[i].equals("")
										&& selectInputsType[i] != null) {
									hql += " and s.t_Name = '" + selectInputsType[i]
											+ "' ";
								}
		
								// 含有 不含 或含
								if (includeOrNot[i].equals("1")
										&& !selectInputsInclude[i].equals("")) {
		
									hql += " and s.t_Name like '%"
											+ selectInputsInclude[i] + "%' ";
								}
		
								if (includeOrNot[i].equals("-1")
										&& !selectInputsInclude[i].equals("")) {
		
									hql += " and s.t_Name not in ('"
											+ selectInputsInclude[i] + "') ";
								}
		
								if (includeOrNot[i].equals("0")
										&& !selectInputsInclude[i].equals("")) {
		
									hql += " or s.t_Name = '" + selectInputsInclude[i]
											+ "' ";
								}
							} else if (selectTypes[i].equals("科技活动类型")) {
								if (!selectInputsType[i].equals("")
										&& selectInputsType[i] != null) {
		
									hql += " and s.t_Type = '" + selectInputsType[i]
											+ "'";
								}
		
								// 含有 不含 或含
								if (includeOrNot[i].equals("1")
										&& !selectInputsInclude[i].equals("")) {
		
									hql += " and s.t_Type like '%"
											+ selectInputsInclude[i] + "%' ";
								}
		
								if (includeOrNot[i].equals("-1")
										&& !selectInputsInclude[i].equals("")) {
		
									hql += " and s.t_Type not in ('"
											+ selectInputsInclude[i] + "') ";
								}
		
								if (includeOrNot[i].equals("0")
										&& !selectInputsInclude[i].equals("")) {
		
									hql += " or s.t_Type = '" + selectInputsInclude[i]
											+ "' ";
								}
							} else if (selectTypes[i].equals("技术需求解决方式")) {
								if (!selectInputsType[i].equals("")
										&& selectInputsType[i] != null) {
									hql += " and s.t_Cooperate = '"
											+ selectInputsType[i] + "'";
								}
								// 含有 不含 或含
								if (includeOrNot[i].equals("1")
										&& !selectInputsInclude[i].equals("")) {
		
									hql += " and s.t_Cooperate like '%"
											+ selectInputsInclude[i] + "%' ";
								}
		
								if (includeOrNot[i].equals("-1")
										&& !selectInputsInclude[i].equals("")) {
		
									hql += " and s.t_Cooperate not in ('"
											+ selectInputsInclude[i] + "') ";
								}
		
								if (includeOrNot[i].equals("0")
										&& !selectInputsInclude[i].equals("")) {
		
									hql += " or s.t_Cooperate = '"
											+ selectInputsInclude[i] + "' ";
								}
							} else if (selectTypes[i].equals("关键字")) {
								hql += " and s.t_Key1 = '" + selectInputsType[i] + "'";
							}
		
						} else if (exactOrNot[i].equals("0"))// 模糊查找
						{
							if (selectTypes[i].equals("技术需求名称")) {
								if (!selectInputsType[i].equals("")
										&& selectInputsType[i] != null) {
									hql += " and s.t_Name like '%"
											+ selectInputsType[i] + "%' ";
								}
		
								// 含有 不含 或含
								if (includeOrNot[i].equals("1")
										&& !selectInputsInclude[i].equals("")) {
		
									hql += " and s.t_Name like '%"
											+ selectInputsInclude[i] + "%' ";
								}
		
								if (includeOrNot[i].equals("-1")
										&& !selectInputsInclude[i].equals("")) {
		
									hql += " and s.t_Name not in ('"
											+ selectInputsInclude[i] + "') ";
								}
		
								if (includeOrNot[i].equals("0")
										&& !selectInputsInclude[i].equals("")) {
		
									hql += " or s.t_Name like '%"
											+ selectInputsInclude[i] + "%' ";
								}
							} else if (selectTypes[i].equals("科技活动类型")) {
								if (!selectInputsType[i].equals("")
										&& selectInputsType[i] != null) {
		
									hql += " and s.t_Type like '%"
											+ selectInputsType[i] + "%' ";
								}
		
								// 含有 不含 或含
								if (includeOrNot[i].equals("1")
										&& !selectInputsInclude[i].equals("")) {
		
									hql += " and s.t_Type like '%"
											+ selectInputsInclude[i] + "%' ";
								}
		
								if (includeOrNot[i].equals("-1")
										&& !selectInputsInclude[i].equals("")) {
		
									hql += " and s.t_Type not in ('"
											+ selectInputsInclude[i] + "') ";
								}
		
								if (includeOrNot[i].equals("0")
										&& !selectInputsInclude[i].equals("")) {
		
									hql += " or s.t_Type like '%"
											+ selectInputsInclude[i] + "%' ";
								}
							} else if (selectTypes[i].equals("技术需求解决方式")) {
								if (!selectInputsType[i].equals("")
										&& selectInputsType[i] != null) {
									hql += " and s.t_Cooperate like '%"
											+ selectInputsType[i] + "%' ";
								}
								// 含有 不含 或含
								if (includeOrNot[i].equals("1")
										&& !selectInputsInclude[i].equals("")) {
		
									hql += " and s.t_Cooperate like '%"
											+ selectInputsInclude[i] + "%' ";
								}
		
								if (includeOrNot[i].equals("-1")
										&& !selectInputsInclude[i].equals("")) {
		
									hql += " and s.t_Cooperate not in ('"
											+ selectInputsInclude[i] + "') ";
								}
		
								if (includeOrNot[i].equals("0")
										&& !selectInputsInclude[i].equals("")) {
		
									hql += " or s.t_Cooperate like '%"
											+ selectInputsInclude[i] + "%' ";
								}
							} else if (selectTypes[i].equals("关键字")) {
								hql += " and s.t_Key1 like '%" + selectInputsType[i]
										+ "%' ";
							}
		
						}
					} else if (selectAnother[i].equals("0"))// 或者**************************
					{
						// 判断模糊查找还是精确查找
						if (exactOrNot[i].equals("1"))// 精确查找
						{
							if (selectTypes[i].equals("技术需求名称")) {
								if (!selectInputsType[i].equals("")
										&& selectInputsType[i] != null) {
									hql += " or s.t_Name = '" + selectInputsType[i]
											+ "' ";
								}
		
								// 含有 不含 或含
								if (includeOrNot[i].equals("1")
										&& !selectInputsInclude[i].equals("")) {
		
									hql += " and s.t_Name like '%"
											+ selectInputsInclude[i] + "%' ";
								}
		
								if (includeOrNot[i].equals("-1")
										&& !selectInputsInclude[i].equals("")) {
		
									hql += " and s.t_Name not in ('"
											+ selectInputsInclude[i] + "') ";
								}
		
								if (includeOrNot[i].equals("0")
										&& !selectInputsInclude[i].equals("")) {
		
									hql += " or s.t_Name = '" + selectInputsInclude[i]
											+ "' ";
								}
							} else if (selectTypes[i].equals("科技活动类型")) {
								if (!selectInputsType[i].equals("")
										&& selectInputsType[i] != null) {
		
									hql += " or s.t_Type = '" + selectInputsType[i]
											+ "'";
								}
		
								// 含有 不含 或含
								if (includeOrNot[i].equals("1")
										&& !selectInputsInclude[i].equals("")) {
		
									hql += " and s.t_Type like '%"
											+ selectInputsInclude[i] + "%' ";
								}
		
								if (includeOrNot[i].equals("-1")
										&& !selectInputsInclude[i].equals("")) {
		
									hql += " and s.t_Type not in ('"
											+ selectInputsInclude[i] + "') ";
								}
		
								if (includeOrNot[i].equals("0")
										&& !selectInputsInclude[i].equals("")) {
		
									hql += " or s.t_Type = '" + selectInputsInclude[i]
											+ "' ";
								}
							} else if (selectTypes[i].equals("技术需求解决方式")) {
								if (!selectInputsType[i].equals("")
										&& selectInputsType[i] != null) {
									hql += " or s.t_Cooperate = '"
											+ selectInputsType[i] + "'";
								}
								// 含有 不含 或含
								if (includeOrNot[i].equals("1")
										&& !selectInputsInclude[i].equals("")) {
		
									hql += " and s.t_Cooperate like '%"
											+ selectInputsInclude[i] + "%' ";
								}
		
								if (includeOrNot[i].equals("-1")
										&& !selectInputsInclude[i].equals("")) {
		
									hql += " and s.t_Cooperate not in ('"
											+ selectInputsInclude[i] + "') ";
								}
		
								if (includeOrNot[i].equals("0")
										&& !selectInputsInclude[i].equals("")) {
		
									hql += " or s.t_Cooperate = '"
											+ selectInputsInclude[i] + "' ";
								}
							} else if (selectTypes[i].equals("关键字")) {
								hql += " or s.t_Key1 = '" + selectInputsType[i] + "'";
							}
		
						} else if (exactOrNot[i].equals("0"))// 模糊查找
						{
							if (selectTypes[i].equals("技术需求名称")) {
								if (!selectInputsType[i].equals("")
										&& selectInputsType[i] != null) {
									hql += " or s.t_Name like '%" + selectInputsType[i]
											+ "%' ";
								}
		
								// 含有 不含 或含
								if (includeOrNot[i].equals("1")
										&& !selectInputsInclude[i].equals("")) {
		
									hql += " and s.t_Name like '%"
											+ selectInputsInclude[i] + "%' ";
								}
		
								if (includeOrNot[i].equals("-1")
										&& !selectInputsInclude[i].equals("")) {
		
									hql += " and s.t_Name not in ('"
											+ selectInputsInclude[i] + "') ";
								}
		
								if (includeOrNot[i].equals("0")
										&& !selectInputsInclude[i].equals("")) {
		
									hql += " or s.t_Name like '%"
											+ selectInputsInclude[i] + "%' ";
								}
							} else if (selectTypes[i].equals("科技活动类型")) {
								if (!selectInputsType[i].equals("")
										&& selectInputsType[i] != null) {
		
									hql += " or s.t_Type like '%" + selectInputsType[i]
											+ "%' ";
								}
		
								// 含有 不含 或含
								if (includeOrNot[i].equals("1")
										&& !selectInputsInclude[i].equals("")) {
		
									hql += " and s.t_Type like '%"
											+ selectInputsInclude[i] + "%' ";
								}
		
								if (includeOrNot[i].equals("-1")
										&& !selectInputsInclude[i].equals("")) {
		
									hql += " and s.t_Type not in ('"
											+ selectInputsInclude[i] + "') ";
								}
		
								if (includeOrNot[i].equals("0")
										&& !selectInputsInclude[i].equals("")) {
		
									hql += " or s.t_Type like '%"
											+ selectInputsInclude[i] + "%' ";
								}
							} else if (selectTypes[i].equals("技术需求解决方式")) {
								if (!selectInputsType[i].equals("")
										&& selectInputsType[i] != null) {
									hql += " or s.t_Cooperate like '%"
											+ selectInputsType[i] + "%' ";
								}
								// 含有 不含 或含
								if (includeOrNot[i].equals("1")
										&& !selectInputsInclude[i].equals("")) {
		
									hql += " and s.t_Cooperate like '%"
											+ selectInputsInclude[i] + "%' ";
								}
		
								if (includeOrNot[i].equals("-1")
										&& !selectInputsInclude[i].equals("")) {
		
									hql += " and s.t_Cooperate not in ('"
											+ selectInputsInclude[i] + "') ";
								}
		
								if (includeOrNot[i].equals("0")
										&& !selectInputsInclude[i].equals("")) {
		
									hql += " or s.t_Cooperate like '%"
											+ selectInputsInclude[i] + "%' ";
								}
							} else if (selectTypes[i].equals("关键字")) {
								hql += " or s.t_Key1 like '%" + selectInputsType[i]
										+ "%' ";
							}
						}
		
					} else if (selectAnother[i].equals("-1"))// 不含************************
					{
						// 判断模糊查找还是精确查找
						if (exactOrNot[i].equals("1"))// 精确查找
						{
							if (selectTypes[i].equals("技术需求名称")) {
								if (!selectInputsType[i].equals("")
										&& selectInputsType[i] != null) {
									hql += " and s.t_Name not in ('"
											+ selectInputsType[i] + "')  ";
								}
		
								// 含有 不含 或含
								if (includeOrNot[i].equals("1")
										&& !selectInputsInclude[i].equals("")) {
		
									hql += " and s.t_Name like '%"
											+ selectInputsInclude[i] + "%' ";
								}
		
								if (includeOrNot[i].equals("-1")
										&& !selectInputsInclude[i].equals("")) {
		
									hql += " and s.t_Name not in ('"
											+ selectInputsInclude[i] + "') ";
								}
		
								if (includeOrNot[i].equals("0")
										&& !selectInputsInclude[i].equals("")) {
		
									hql += " or s.t_Name = '" + selectInputsInclude[i]
											+ "' ";
								}
							} else if (selectTypes[i].equals("科技活动类型")) {
								if (!selectInputsType[i].equals("")
										&& selectInputsType[i] != null) {
		
									hql += " and s.t_Type not in ('"
											+ selectInputsType[i] + "') ";
								}
		
								// 含有 不含 或含
								if (includeOrNot[i].equals("1")
										&& !selectInputsInclude[i].equals("")) {
		
									hql += " and s.t_Type like '%"
											+ selectInputsInclude[i] + "%' ";
								}
		
								if (includeOrNot[i].equals("-1")
										&& !selectInputsInclude[i].equals("")) {
		
									hql += " and s.t_Type not in ('"
											+ selectInputsInclude[i] + "') ";
								}
		
								if (includeOrNot[i].equals("0")
										&& !selectInputsInclude[i].equals("")) {
		
									hql += " or s.t_Type = '" + selectInputsInclude[i]
											+ "' ";
								}
							} else if (selectTypes[i].equals("技术需求解决方式")) {
								if (!selectInputsType[i].equals("")
										&& selectInputsType[i] != null) {
									hql += " and s.t_Cooperate not in ('"
											+ selectInputsType[i] + "') ";
								}
								// 含有 不含 或含
								if (includeOrNot[i].equals("1")
										&& !selectInputsInclude[i].equals("")) {
		
									hql += " and s.t_Cooperate like '%"
											+ selectInputsInclude[i] + "%' ";
								}
		
								if (includeOrNot[i].equals("-1")
										&& !selectInputsInclude[i].equals("")) {
		
									hql += " and s.t_Cooperate not in ('"
											+ selectInputsInclude[i] + "') ";
								}
		
								if (includeOrNot[i].equals("0")
										&& !selectInputsInclude[i].equals("")) {
		
									hql += " or s.t_Cooperate = '"
											+ selectInputsInclude[i] + "' ";
								}
							} else if (selectTypes[i].equals("关键字")) {
								hql += " and s.t_Key1 not in ('" + selectInputsType[i]
										+ "') ";
							}
		
						} else if (exactOrNot[i].equals("0"))// 模糊查找
						{
							if (selectTypes[i].equals("技术需求名称")) {
								if (!selectInputsType[i].equals("")
										&& selectInputsType[i] != null) {
									hql += " and s.t_Name not like '%"
											+ selectInputsType[i] + "%' ";
								}
		
								// 含有 不含 或含
								if (includeOrNot[i].equals("1")
										&& !selectInputsInclude[i].equals("")) {
		
									hql += " and s.t_Name like '%"
											+ selectInputsInclude[i] + "%' ";
								}
		
								if (includeOrNot[i].equals("-1")
										&& !selectInputsInclude[i].equals("")) {
		
									hql += " and s.t_Name not in ('"
											+ selectInputsInclude[i] + "') ";
								}
		
								if (includeOrNot[i].equals("0")
										&& !selectInputsInclude[i].equals("")) {
		
									hql += " or s.t_Name like '%"
											+ selectInputsInclude[i] + "%' ";
								}
							} else if (selectTypes[i].equals("科技活动类型")) {
								if (!selectInputsType[i].equals("")
										&& selectInputsType[i] != null) {
		
									hql += " or s.t_Type not  like '%"
											+ selectInputsType[i] + "%' ";
								}
		
								// 含有 不含 或含
								if (includeOrNot[i].equals("1")
										&& !selectInputsInclude[i].equals("")) {
		
									hql += " and s.t_Type like '%"
											+ selectInputsInclude[i] + "%' ";
								}
		
								if (includeOrNot[i].equals("-1")
										&& !selectInputsInclude[i].equals("")) {
		
									hql += " and s.t_Type not in ('"
											+ selectInputsInclude[i] + "') ";
								}
		
								if (includeOrNot[i].equals("0")
										&& !selectInputsInclude[i].equals("")) {
		
									hql += " or s.t_Type like '%"
											+ selectInputsInclude[i] + "%' ";
								}
							} else if (selectTypes[i].equals("技术需求解决方式")) {
								if (!selectInputsType[i].equals("")
										&& selectInputsType[i] != null) {
									hql += " or s.t_Cooperate not like '%"
											+ selectInputsType[i] + "%' ";
								}
								// 含有 不含 或含
								if (includeOrNot[i].equals("1")
										&& !selectInputsInclude[i].equals("")) {
		
									hql += " and s.t_Cooperate like '%"
											+ selectInputsInclude[i] + "%' ";
								}
		
								if (includeOrNot[i].equals("-1")
										&& !selectInputsInclude[i].equals("")) {
		
									hql += " and s.t_Cooperate not in ('"
											+ selectInputsInclude[i] + "') ";
								}
		
								if (includeOrNot[i].equals("0")
										&& !selectInputsInclude[i].equals("")) {
		
									hql += " or s.t_Cooperate like '%"
											+ selectInputsInclude[i] + "%' ";
								}
							} else if (selectTypes[i].equals("关键字")) {
								hql += " or s.t_Key1 not like '%" + selectInputsType[i]
										+ "%' ";
							}
						}
					}
		
				}
				return getSession().createQuery(hql).list();				
		}
}
