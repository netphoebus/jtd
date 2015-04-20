package com.jlj.service;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.jlj.model.Client;

public interface IClientService {

	public abstract void add(Client client) throws Exception;

	public abstract void delete(Client client);

	public abstract void deleteById(int id);

	public abstract void update(Client client);

	public abstract List<Client> getClients();

	public abstract Client loadById(int id);

	public abstract int getPageCount(int con, String convalue, int status,
			String publicaccount, int size);

	public abstract int getTotalCount(int con, String convalue, int status,
			String publicaccount);

	public abstract List<Client> queryList(int con, String convalue,
			int status, String publicaccount, int page, int size);

	public abstract List<Client> getClientsByPublicAccount(String paccount);

	public abstract int getFrontPageCount(int catid, int size);

	public abstract int getFrontTotalCount(int catid);

	@GET
	@Path("/list/{catid}/{page}/{size}")
	@Produces( { MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public abstract List<Client> queryFrontList(@PathParam("catid")
	int catid, @PathParam("page")
	int page, @PathParam("size")
	int size);

	/**
	 * 用户登录
	 */
	@GET
	@Path("/userlogin/{username}/{password}")
	@Produces( { MediaType.APPLICATION_JSON })
	public abstract List<Client> userLogin(@PathParam("username")
	String username, @PathParam("password")
	String password);

	/**
	 * 修改密码
	 */
	@GET
	@Path("/updatepwd/{username}/{oldpwd}/{newpwd}")
	@Produces(MediaType.APPLICATION_JSON)
	public abstract int updatePwd(@PathParam("username")
	String username, @PathParam("oldpwd")
	String oldpwd, @PathParam("newpwd")
	String newpwd);

	/**
	 * 用户注册
	 */
	@GET
	@Path("/register/{username}/{password}/{limits}")
	@Produces(MediaType.APPLICATION_JSON)
	public abstract int addMember(@PathParam("username")
	String username, @PathParam("password")
	String password, @PathParam("limits")
	String limits);

	/**
	 * 获取apk版本号
	 * @return
	 */
	@GET
	@Path("/apkversion")
	@Produces(MediaType.APPLICATION_JSON)
	public abstract String getApkVersion();

	/**
	 * 检查是否有该卡号card_num
	 * 检查是否有该卡号card_num,返回0：不存在（提示他数据尚未同步或已与别的用户名绑定，请与管理员联系）
	 * 检查该用户uid的真实姓名,返回-1：该用户名不匹配
	 * 返回1：卡号存在，真实姓名匹配成功，卡号存入field5字段
	 */
	@GET
	@Path("/checkcardnum/{cardnum}/{realname}/{uid}")
	@Produces(MediaType.APPLICATION_JSON)
	public abstract int checkcardnum(@PathParam("cardnum")
	String cardnum, @PathParam("realname")
	String realname, @PathParam("uid")
	int uid);

}