package cn.wen.ssm.service.impl;

import cn.wen.ssm.dao.PermissionsDao;
import cn.wen.ssm.domain.Permission;
import cn.wen.ssm.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author 张文军
 * @Description:
 * @Company:南京农业大学工学院
 * @version:1.0
 * @date 2019/3/2115:32
 */
@Service
@Transactional
public class PermissionServiceImpl implements PermissionService {
		@Autowired
		PermissionsDao permissionsDao;
		@Override
		public List<Permission> findAll() {
				return permissionsDao.findAll();
		}

		@Override
		public void save(Permission permission) {
				permissionsDao.save(permission);
		}
}
