package com.taiacloud.team.service;

import com.taiacloud.team.domain.Architect;
import com.taiacloud.team.domain.Designer;
import com.taiacloud.team.domain.Employee;
import com.taiacloud.team.domain.Programmer;

/*功能：关于开发团队成员的管理：添加、删除等。
 * 说明：
 * counter为静态变量，用来为开发团队新增成员自动生成团队中的唯一ID，即memberId。
 * 	（提示：应使用增1的方式）
 * MAX_MEMBER：表示开发团队最大成员数
 * team数组：用来保存当前团队中的各成员对象 
 * total：记录团队成员的实际人数
 * getTeam()方法：返回当前团队的所有对象
 * 		返回：包含所有成员对象的数组，数组大小与成员人数一致
 * addMember(e: Employee)方法：向团队中添加成员
 * 		参数：待添加成员的对象
 * 		异常：添加失败， TeamException中包含了失败原因
 * removeMember(memberId: int)方法：从团队中删除成员
 * 		参数：待删除成员的memberId
 * 		异常：找不到指定memberId的员工，删除失败
 * 另外，可根据需要自行添加其他方法或重载构造器
 * 
 * */
public class TeamService {
	private static int counter = 1;//用来为开发团队新增成员自动生成团队中的唯一ID，即memberId。
	private final int MAX_MEMBER = 5;//表示开发团队最大成员数
	private Programmer[] team = new Programmer[MAX_MEMBER];//保存当前团队中的各成员对象 
	private int total = 0;//记录团队成员的实际人数
	public TeamService() {
		super();
	}
	
	/**
	 * 
	 * @Description 获取开发团队中的所有成员
	 * @author taia
	 * @version 
	 * @date 2021年10月11日下午12:52:51
	 * @return
	 */
	public Programmer[] getTeam() {
		Programmer[] team = new Programmer[total];
		for(int i = 0;i < team.length;i++) {
			team[i] = this.team[i];
		}
		return team;
	}
	/**
	 * 
	 * @Description 向团队中添加成员
	 * @author taia
	 * @version 
	 * @date 2021年10月11日下午12:57:15
	 * @param e
	 * @throws TeamException 
	 */
	public void addMember(Employee e) throws TeamException {
//		成员已满，无法添加
		if(total >= MAX_MEMBER) {
			throw new TeamException("成员已满，无法添加");
		}
//		该成员不是开发人员，无法添加
		if(!(e instanceof Programmer)) {
			throw new TeamException("该成员不是开发人员，无法添加");
		}
//		该员工已在本开发团队中
		if(isExist(e)) {
			throw new TeamException("该员工已在本开发团队中");
		}
//		该员工已是某团队成员 
//		该员正在休假，无法添加
		Programmer p =(Programmer)e;//一定不会出现类型转换异常
//		if("BUSY".equalsIgnoreCase(p.getStatus().getNAME())){//if(p.getStatus().getNAME().equals("BUSY")) {
//			throw new TeamException("该员工已是某团队成员");
//		}else if("VOCATION".equalsIgnoreCase(p.getStatus().getNAME())) {
//			throw new TeamException("该员正在休假，无法添加");
//		}

		switch (p.getStatus()){//byte\short\char\int\String\enum对象

			case BUSY:
				throw new TeamException("该员工已是某团队成员");
			case VOCATION:
				throw new TeamException("该员正在休假，无法添加");
		}






//		团队中至多只能有一名架构师
		
//		团队中至多只能有两名设计师
//		团队中至多只能有三名程序员
		
		//获取team中已有成员中的架构师、设计师、程序员人数
		int numOfArch = 0,numOfDes = 0,numOfPro = 0;
		for(int i = 0;i < total;i++) {
			if(team[i] instanceof Architect) {
				numOfArch++;
				
			}else if(team[i] instanceof Designer) {
				numOfDes++;
			}else {
				numOfPro++;
			}
		}
		
		if(p instanceof Architect) {
			if(numOfArch >= 1) {
				throw new TeamException("团队中至多只能有一名架构师");
			}
		}else if(p instanceof Designer) {
			if(numOfDes >= 2) {
				throw new TeamException("团队中至多只能有两名设计师");
			}
		}else {
			if(numOfPro >= 3) {
				throw new TeamException("团队中至多只能有三名程序员");
			}
		}
		
		
		//将p（e）添加到现有成员中
		team[total++] = p;
		//p的属性赋值
		p.setStatus(Status.BUSY);
		p.setMemberId(counter++);

	}
	/**
	 * 
	 * @Description 判断指定员工是否已经存在现有的团队
	 * @author taia
	 * @version 
	 * @date 2021年10月11日下午1:08:34
	 * @param e
	 * @return
	 */
	private boolean isExist(Employee e) {
		for(int i = 0;i < total;i++) {
			if(team[i].getId() == e.getId()) {
				return true;
			}
		}
		return false;	
	}
	/**
	 * 
	 * @Description 移除成员
	 * @author taia
	 * @version 
	 * @date 2021年10月11日下午4:58:51
	 * @param memberId
	 */
	public void removeMember(int memberId) throws TeamException{
		int i = 0;
		for(;i < total;i++){
			if(team[i].getMemberId() == memberId){
				team[i].setStatus(Status.FREE);
				break;
			}
		}
		
		//未找到指定memberId的情况
		if(i == total){
			throw new TeamException("找不到指定memberId的员工，删除失败");
		}
		
		
		//后一个元素覆盖前一个元素，实现删除操作
		for(int j = i + 1;j < total;j++){
			team[j - 1] = team[j];
		}
		
		//写法一：
//		team[total-1] = null;
//		total--;
		//写法二：
		team[--total] = null;
		
		
	}
}
