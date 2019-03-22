package cn.wen.ssm.service;

import cn.wen.ssm.domain.Role;
import cn.wen.ssm.domain.UserInfo;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

/**
 * @author 张文军
 * @Description:
 * @Company:南京农业大学工学院
 * @version:1.0
 * @date 2019/3/211:29
 */
public interface UserService extends UserDetailsService {
		List<UserInfo> findAll();

		void save(UserInfo userInfo);

		UserInfo  findById(String id);

		List<Role> findOtherRole(String userId);

		void addRoleToUser(String userId, String[] roleIds);
}
