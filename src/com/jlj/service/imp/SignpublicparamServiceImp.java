package com.jlj.service.imp;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.jlj.dao.ISignpublicparamDao;
import com.jlj.model.Signpublicparam;
import com.jlj.model.Sigsuntime;
import com.jlj.service.ISignpublicparamService;


@Component("signpublicparamService")
public class SignpublicparamServiceImp implements ISignpublicparamService  {
	private ISignpublicparamDao signpublicparamDao;
	public ISignpublicparamDao getSignpublicparamDao() {
		return signpublicparamDao;
	}
	@Resource
	public void setSignpublicparamDao(ISignpublicparamDao signpublicparamDao) {
		this.signpublicparamDao = signpublicparamDao;
	}
	//添加对象
	/* (non-Javadoc)
	 * @see com.jlj.service.imp.ISignpublicparamService#add(com.jlj.model.Signpublicparam)
	 */
	public void add(Signpublicparam signpublicparam) throws Exception {
		signpublicparamDao.save(signpublicparam);
	}
	//删除对象
	/* (non-Javadoc)
	 * @see com.jlj.service.imp.ISignpublicparamService#delete(com.jlj.model.Signpublicparam)
	 */
	public void delete(Signpublicparam signpublicparam) {
		signpublicparamDao.delete(signpublicparam);
	}
	//删除某个id的对象
	/* (non-Javadoc)
	 * @see com.jlj.service.imp.ISignpublicparamService#deleteById(int)
	 */
	public void deleteById(int id) {
		signpublicparamDao.deleteById(id);
	}
	//修改对象
	/* (non-Javadoc)
	 * @see com.jlj.service.imp.ISignpublicparamService#update(com.jlj.model.Signpublicparam)
	 */
	public void update(Signpublicparam signpublicparam) {
		signpublicparamDao.update(signpublicparam);
	}
	//获取所有对象
	/* (non-Javadoc)
	 * @see com.jlj.service.imp.ISignpublicparamService#getSignpublicparams()
	 */
	public List<Signpublicparam> getSignpublicparams() {
		return signpublicparamDao.getSignpublicparams();
	}
	//加载一个id的对象
	/* (non-Javadoc)
	 * @see com.jlj.service.imp.ISignpublicparamService#loadById(int)
	 */
	public Signpublicparam loadById(int id) {
		return signpublicparamDao.loadById(id);
	}
	//后台管理-页数获取
	/* (non-Javadoc)
	 * @see com.jlj.service.imp.ISignpublicparamService#getPageCount(int, java.lang.String, int)
	 */
	public int getPageCount(int con, String convalue,int size) {
		int totalCount=this.getTotalCount(con, convalue);
		return totalCount%size==0?totalCount/size:(totalCount/size+1);
	}
	//后台管理-获取总记录数
	/* (non-Javadoc)
	 * @see com.jlj.service.imp.ISignpublicparamService#getTotalCount(int, java.lang.String)
	 */
	public int getTotalCount(int con, String convalue) {
		String queryString = "select count(*) from Signpublicparam mo where 1=1 ";
		Object[] p = null;
		if(con!=0&&convalue!=null&&!convalue.equals("")){
			//线路名称
			if(con==1){
				queryString += "and mo.name like ? "; 
			}
			p = new Object[]{'%'+convalue+'%'};
		}
//		queryString += " order by mo.id desc ";
		return signpublicparamDao.getUniqueResult(queryString,p);
	}
	//后台管理-获取符合条件的记录
	/* (non-Javadoc)
	 * @see com.jlj.service.imp.ISignpublicparamService#queryList(int, java.lang.String, int, int)
	 */
	public List<Signpublicparam> queryList(int con, String convalue, int page, int size) {
		String queryString = "from Signpublicparam mo where 1=1 ";
		Object[] p = null;
		if(con!=0&&convalue!=null&&!convalue.equals("")){
			//线路名称
			if(con==1){
				queryString += "and mo.name like ? "; 
			}
			p = new Object[]{'%'+convalue+'%'};
		}
//		queryString += " order by mo.id desc ";
		return signpublicparamDao.pageList(queryString,p,page,size);
	}
	/* (non-Javadoc)
	 * @see com.jlj.service.imp.ISignpublicparamService#loadByMkid(long)
	 */
	public Signpublicparam loadByMkid(long mkid) {
		// TODO Auto-generated method stub
		
		String queryString = "from Signpublicparam mo where 1=1 and mo.mkid="+mkid;
		
		
		return signpublicparamDao.loadByMkid(queryString);
	}
	public Signpublicparam getPublicparamByIp(String clientIP) {
		String queryString = "from Signpublicparam mo where mo.ip = :ip";
		String[] paramNames = new String[] { "ip" };
		Object[] values = new Object[] { clientIP };
		return signpublicparamDao.queryByNamedParam(queryString, paramNames, values);
	}
	public void updateByPublicid(int red_Clearance_Time, int yellow_Flash_Time,
			String number, String comparam, int checkflow, int innermark,
			int workingset, int SigSunTime0, int SigSunTime1, int SigSunTime2,
			int SigSunTime3, int SigSunTime4, int SigSunTime5, int SigSunTime6,
			int gmintime, int gmaxtime, int zdbctime, int countdownmode,
			int xrfxtime, int cycle, int xyxr, int SigSpecialTime00,
			int SigSpecialTime01, int SigSpecialTime10, int SigSpecialTime11,
			int SigSpecialTime20, int SigSpecialTime21, int SigSpecialTime30,
			int SigSpecialTime31, int SigSpecialTime40, int SigSpecialTime41,
			int SigSpecialTime50, int SigSpecialTime51, int SigSpecialTime60,
			int SigSpecialTime61, int SigSpecialTime70, int SigSpecialTime71,
			int SigSpecialTime80, int SigSpecialTime81, int SigSpecialTime90,
			int SigSpecialTime91, int SigSpecialTime100, int SigSpecialTime101,
			int SigSpecialTime110, int SigSpecialTime111,
			int SigSpecialTime120, int SigSpecialTime121,
			int SigSpecialTime130, int SigSpecialTime131,
			int SigSpecialTime140, int SigSpecialTime141,
			int SigSpecialTime150, int SigSpecialTime151,
			int SigSpecialTime160, int SigSpecialTime161,
			int SigSpecialTime170, int SigSpecialTime171,
			int SigSpecialTime180, int SigSpecialTime181,
			int SigSpecialTime190, int SigSpecialTime191,
			int SigSpecialTime200, int SigSpecialTime201,
			int SigSpecialTime210, int SigSpecialTime211,
			int SigSpecialTime220, int SigSpecialTime221,
			int SigSpecialTime230, int SigSpecialTime231, Integer publicid) {
		String hql = "update Signpublicparam mo set mo.qchdtime =:red_Clearance_Time,mo.kjhstime=:yellow_Flash_Time,mo.number=:number," +
				"mo.comparam=:comparam,mo.checkflow=:checkflow,mo.innermark=:innermark,mo.workingset=:workingset," +
				"mo.mon=:SigSunTime0,mo.tue=:SigSunTime1,mo.wes=:SigSunTime2,mo.thir=:SigSunTime3,mo.fra=:SigSunTime4,mo.sata=:SigSunTime5,mo.sun=:SigSunTime6," +
				"mo.gmintime=:gmintime,mo.gmaxtime=:gmaxtime,mo.zdbctime=:zdbctime,mo.countdownmode=:countdownmode,mo.xrfxtime=:xrfxtime,mo.cycle=:cycle,mo.xyxr=:xyxr " +
				"mo.specialmonth0=:SigSpecialTime00,mo.specialday0=:SigSpecialTime01,mo.specialmonth1=:SigSpecialTime10,mo.specialday1=:SigSpecialTime11," +
				"mo.specialmonth2=:SigSpecialTime20,mo.specialday2=:SigSpecialTime21,mo.specialmonth3=:SigSpecialTime30,mo.specialday3=:SigSpecialTime31," +
				"mo.specialmonth4=:SigSpecialTime40,mo.specialday4=:SigSpecialTime41,mo.specialmonth5=:SigSpecialTime50,mo.specialday5=:SigSpecialTime51," +
				"mo.specialmonth6=:SigSpecialTime60,mo.specialday6=:SigSpecialTime61,mo.specialmonth7=:SigSpecialTime70,mo.specialday7=:SigSpecialTime71," +
				"mo.specialmonth8=:SigSpecialTime80,mo.specialday8=:SigSpecialTime81,mo.specialmonth9=:SigSpecialTime90,mo.specialday9=:SigSpecialTime91," +
				"mo.specialmonth10=:SigSpecialTime100,mo.specialday10=:SigSpecialTime101,mo.specialmonth11=:SigSpecialTime110,mo.specialday11=:SigSpecialTime111," +
				"mo.specialmonth12=:SigSpecialTime120,mo.specialday12=:SigSpecialTime121,mo.specialmonth13=:SigSpecialTime130,mo.specialday13=:SigSpecialTime131," +
				"mo.specialmonth14=:SigSpecialTime140,mo.specialday14=:SigSpecialTime141,mo.specialmonth15=:SigSpecialTime150,mo.specialday15=:SigSpecialTime151," +
				"mo.specialmonth16=:SigSpecialTime160,mo.specialday16=:SigSpecialTime161,mo.specialmonth17=:SigSpecialTime170,mo.specialday17=:SigSpecialTime171," +
				"mo.specialmonth18=:SigSpecialTime180,mo.specialday18=:SigSpecialTime181,mo.specialmonth19=:SigSpecialTime190,mo.specialday19=:SigSpecialTime191," +
				"mo.specialmonth20=:SigSpecialTime200,mo.specialday20=:SigSpecialTime201,mo.specialmonth21=:SigSpecialTime210,mo.specialday21=:SigSpecialTime211," +
				"mo.specialmonth22=:SigSpecialTime220,mo.specialday22=:SigSpecialTime221,mo.specialmonth23=:SigSpecialTime230,mo.specialday23=:SigSpecialTime231," +
				" where mo.id = :publicid";
		String[] paramNames = new String[] {"red_Clearance_Time","yellow_Flash_Time","number",
				"comparam","checkflow","innermark","workingset","SigSunTime0",
				"SigSunTime1","SigSunTime2","SigSunTime3","SigSunTime4","SigSunTime5","SigSunTime6",
				"gmintime","gmaxtime","zdbctime","countdownmode","xrfxtime","cycle","xyxr",
				"SigSpecialTime00","SigSpecialTime01","SigSpecialTime10","SigSpecialTime11",
				"SigSpecialTime20","SigSpecialTime21","SigSpecialTime30","SigSpecialTime31",
				"SigSpecialTime40","SigSpecialTime41","SigSpecialTime50","SigSpecialTime51",
				"SigSpecialTime60","SigSpecialTime61","SigSpecialTime70","SigSpecialTime71",
				"SigSpecialTime80","SigSpecialTime81","SigSpecialTime90","SigSpecialTime91",
				"SigSpecialTime100","SigSpecialTime101","SigSpecialTime110","SigSpecialTime111",
				"SigSpecialTime120","SigSpecialTime121","SigSpecialTime130","SigSpecialTime131",
				"SigSpecialTime140","SigSpecialTime141","SigSpecialTime150","SigSpecialTime151",
				"SigSpecialTime160","SigSpecialTime161","SigSpecialTime170","SigSpecialTime171",
				"SigSpecialTime180","SigSpecialTime181","SigSpecialTime190","SigSpecialTime191",
				"SigSpecialTime200","SigSpecialTime201","SigSpecialTime210","SigSpecialTime211",
				"SigSpecialTime220","SigSpecialTime221","SigSpecialTime230","SigSpecialTime231", 
				"publicid"};
		Object[] values = new Object[] { red_Clearance_Time,yellow_Flash_Time,number,
				comparam,checkflow,innermark,workingset,
				SigSunTime0,SigSunTime1,SigSunTime2,SigSunTime3,SigSunTime4,SigSunTime5,SigSunTime6,
				gmintime,gmaxtime,zdbctime,countdownmode,xrfxtime,cycle,xyxr,
				SigSpecialTime00,SigSpecialTime01,SigSpecialTime10,SigSpecialTime11,
				SigSpecialTime20,SigSpecialTime21,SigSpecialTime30,SigSpecialTime31,
				SigSpecialTime40,SigSpecialTime41,SigSpecialTime50,SigSpecialTime51,
				SigSpecialTime60,SigSpecialTime61,SigSpecialTime70,SigSpecialTime71,
				SigSpecialTime80,SigSpecialTime81,SigSpecialTime90,SigSpecialTime91,
				SigSpecialTime100,SigSpecialTime101,SigSpecialTime110,SigSpecialTime111,
				SigSpecialTime120,SigSpecialTime121,SigSpecialTime130,SigSpecialTime131,
				SigSpecialTime140,SigSpecialTime141,SigSpecialTime150,SigSpecialTime151,
				SigSpecialTime160,SigSpecialTime161,SigSpecialTime170,SigSpecialTime171,
				SigSpecialTime180,SigSpecialTime181,SigSpecialTime190,SigSpecialTime191,
				SigSpecialTime200,SigSpecialTime201,SigSpecialTime210,SigSpecialTime211,
				SigSpecialTime220,SigSpecialTime221,SigSpecialTime230,SigSpecialTime231,
				publicid };
		signpublicparamDao.updateByHql(hql, paramNames, values);
	}
	public Signpublicparam loadBySid(int sid) {
		
		String queryString = "from Signpublicparam mo where 1=1 and mo.sig.id="+sid;
		return signpublicparamDao.loadByMkid(queryString);	
	}
	public Signpublicparam loadBySigIp(String sigIp) {
		// TODO Auto-generated method stub
		String queryString = "from Signpublicparam mo where 1=1 and mo.ip='"+sigIp+"'";
		return signpublicparamDao.loadByMkid(queryString);
	}
}
