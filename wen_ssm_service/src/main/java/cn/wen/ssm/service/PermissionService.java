package cn.wen.ssm.service;

import cn.wen.ssm.domain.Permission;

import java.util.List;

/**
 * @author 张文军
 * @Description:
 * @Company:南京农业大学工学院
 * @version:1.0
 * @date 2019/3/2115:31
 */
public interface PermissionService {
		List<Permission> findAll();

		void save(Permission permission);
}
