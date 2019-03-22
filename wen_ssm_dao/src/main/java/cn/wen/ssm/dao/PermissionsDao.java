package cn.wen.ssm.dao;

import cn.wen.ssm.domain.Permission;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @author 张文军
 * @Description:
 * @Company:南京农业大学工学院
 * @version:1.0
 * @date 2019/3/2114:09
 */
public interface PermissionsDao {
		@Select("select * from permission where id in (select permissionId from role_permission where roleId=#{roleId})")
		public List<Permission> fundPermissionsByRoleId(@Param("roleId") String roleId);

		@Select("select * from permission")
		List<Permission> findAll();

		@Insert("insert into permission(permissionName,url) values(#{permissionName},#{url}) ")
		void save(Permission permission);
}
