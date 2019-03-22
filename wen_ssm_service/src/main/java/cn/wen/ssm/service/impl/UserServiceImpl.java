package cn.wen.ssm.service.impl;

import cn.wen.ssm.dao.UserDao;
import cn.wen.ssm.domain.Role;
import cn.wen.ssm.domain.UserInfo;
import cn.wen.ssm.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 张文军
 * @Description:
 * @Company:南京农业大学工学院
 * @version:1.0
 * @date 2019/3/211:30
 */
@Service("userService")
@Transactional
public class UserServiceImpl implements UserService {
		@Autowired
		UserDao userDao;

		@Override
		public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
				UserInfo userInfo = null;
				try {
						userInfo = userDao.findByUsername(username);
				} catch (Exception e) {
						e.printStackTrace();
				}
				//处理自己的用户对象封装成UserDetails
				//  User user=new User(userInfo.getUsername(),"{noop}"+userInfo.getPassword(),getAuthority(userInfo.getRoles()));
				User user = new User(userInfo.getUsername(), userInfo.getPassword(), userInfo.getStatus() == 0 ? false : true, true, true, true, getAuthority(userInfo.getRoles()));
				return user;
		}

		//作用就是返回一个List集合，集合中装入的是角色描述
		public List<SimpleGrantedAuthority> getAuthority(List<Role> roles) {

				List<SimpleGrantedAuthority> list = new ArrayList<>();
				for (Role role : roles) {
						list.add(new SimpleGrantedAuthority("ROLE_" + role.getRoleName()));
				}
				return list;
		}

		@Override
		public List<UserInfo> findAll() {
				return userDao.findAll();
		}

		@Autowired
		private BCryptPasswordEncoder bCryptPasswordEncoder;


		@Override
		public void save(UserInfo userInfo) {
				//密码加密
				userInfo.setPassword(bCryptPasswordEncoder.encode(userInfo.getPassword()));
				userDao.save(userInfo);
		}

		@Override
		public UserInfo findById(String id) {

				return userDao.findById(id);
		}

		@Override
		public List<Role> findOtherRole(String userId) {
				return userDao.findOtherRole(userId);
		}

		@Override
		public void addRoleToUser(String userId, String[] roleIds) {
				for (String roleId : roleIds) {
						userDao.addRoleToUser(userId, roleId);
				}
		}
}
