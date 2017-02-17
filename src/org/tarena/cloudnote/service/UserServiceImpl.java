package org.tarena.cloudnote.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.tarena.cloudnote.dao.UserDao;
import org.tarena.cloudnote.entity.User;
import org.tarena.cloudnote.util.NoteResult;
import org.tarena.cloudnote.util.NoteUtil;
/**
 * 实现UserService接口，统一处理User方面逻辑
 * @author Hello.Ju
 *
 */
@Service//扫描，对应context:component-scan，这儿扫描的是UserServiceImpl，默认的bean名为userServiceImpl
@Transactional
public class UserServiceImpl implements UserService {
	@Resource
	private UserDao userDao;
	
	public UserDao getDao() {
		return userDao;
	}
	
	public void setDao(UserDao dao) {
		this.userDao = dao;
	}

	/**
	 * 登入验证
	 */
	@Override
	public NoteResult checkLogin(String name, String password) {
		NoteResult result = new NoteResult();
		//检查用户名
		User user = userDao.findByName(name);
		if (user == null) {
			result.setStatus(1);
			result.setMsg("用户名不存在");
			return result;
		}
		//检查密码
		String md5_password = NoteUtil.md5(password);
		if (!user.getCn_user_password().equals(md5_password)) {
			result.setStatus(2);
			result.setMsg("密码错误");
			return result;
		}
		//全部正确
		result.setStatus(0);
		result.setMsg("用户名和密码正确");
		result.setData(user.getCn_user_id());//返回用户ID
		return result;
	}

	/**
	 * 注册
	 */
	@Override
	public NoteResult regist(String name, String password, String nick) {
		NoteResult result = new NoteResult();
		//必要的检查
		User has_user = userDao.findByName(name);
		if (has_user != null) {
			result.setStatus(1);
			result.setMsg("用户名被占用！");
			return result;
		}
		//添加处理
		User user = new User();
		user.setCn_user_id(NoteUtil.createId());
		user.setCn_user_name(name);
		user.setCn_user_password(NoteUtil.md5(password));
		user.setCn_user_nick(nick);
		user.setCn_user_token(null);
		userDao.save(user);
		//注册成功
		//模拟失败
		String s = null;s.length();
		result.setStatus(0);
		result.setMsg("注册成功！");
		return result;
	}

}
