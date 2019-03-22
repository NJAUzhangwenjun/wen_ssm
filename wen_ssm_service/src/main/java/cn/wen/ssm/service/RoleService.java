package cn.wen.ssm.service;

import cn.wen.ssm.domain.Permission;
import cn.wen.ssm.domain.Role;

import java.util.List;

/**
 * @author 张文军
 * @Description:
 * @Company:南京农业大学工学院
 * @version:1.0
 * @date 2019/3/2115:00
 */
public interface RoleService {
		List<Role> findAll();

		void save(Role role);

		Role findById(String roleId);

		List<Permission> findOtherPermissionsByRoleId(String roleId);

		void addPermissionToRole(String roleId, String[] permissionIds);
}
