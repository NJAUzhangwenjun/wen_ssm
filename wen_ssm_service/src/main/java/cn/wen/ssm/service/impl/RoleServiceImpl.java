package cn.wen.ssm.service.impl;

import cn.wen.ssm.dao.RoleDao;
import cn.wen.ssm.domain.Permission;
import cn.wen.ssm.domain.Role;
import cn.wen.ssm.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author 张文军
 * @Description:
 * @Company:南京农业大学工学院
 * @version:1.0
 * @date 2019/3/2115:00
 */
@Service
@Transactional
public class RoleServiceImpl implements RoleService {
		@Autowired
		RoleDao roleDao;

		@Override
		public List<Role> findAll() {
				return roleDao.findAll();
		}

		@Override
		public void save(Role role) {
				roleDao.save(role);
		}

		@Override
		public Role findById(String roleId) {
						return roleDao.findById(roleId);
		}

		@Override
		public List<Permission> findOtherPermissionsByRoleId(String roleId) {
				return roleDao.findOtherPermissionsByRoleId(roleId);
		}

		@Override
		public void addPermissionToRole(String roleId, String[] permissionIds) {
				for (String permissionId : permissionIds) {
						roleDao.addPermissionToRole(roleId, permissionId);
				}
		}
}
