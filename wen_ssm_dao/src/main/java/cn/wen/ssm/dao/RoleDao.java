package cn.wen.ssm.dao;

import cn.wen.ssm.domain.Permission;
import cn.wen.ssm.domain.Role;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @author 张文军
 * @Description:
 * @Company:南京农业大学工学院
 * @version:1.0
 * @date 2019/3/212:00
 */
public interface RoleDao {

		@Select("select * from role where id in (select roleId from users_role where userId=#{userId})")
		@Results({
						@Result(id=true,property = "id",column = "id"),
						@Result(property = "roleName",column = "roleName"),
						@Result(property = "roleDesc",column = "roleDesc"),
						@Result(property = "permissions",column = "id",javaType = java.util.List.class,many = @Many(select="cn.wen.ssm.dao.PermissionsDao.fundPermissionsByRoleId")),
		})
		public List<Role> findRoleByUserId(String userId) throws Exception;

		@Select("select * from role")
		List<Role> findAll();

		@Insert("INSERT INTO ROLE (ROLENAME, ROLEDESC) VALUES ( #{roleName}, #{roleDesc})")
		void save(Role role);

		@Select("select * from role where id = #{roleId}")
		Role findById(String roleId);

		@Select("select * from permission where id not in (select PermissionId from role_permission where roleId = #{roleId})")
		List<Permission> findOtherPermissionsByRoleId(String roleId);

		@Insert("insert into role_permission(permissionId,roleId) values(#{permissionId},#{roleId})")
		void addPermissionToRole(@Param("roleId")String roleId,@Param("permissionId")String permissionId);
}
