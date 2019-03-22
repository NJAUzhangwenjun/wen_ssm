package cn.wen.ssm.dao;
import cn.wen.ssm.domain.Role;
import cn.wen.ssm.domain.UserInfo;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @author 张文军
 * @Description:
 * @Company:南京农业大学工学院
 * @version:1.0
 * @date 2019/3/211:36
 */
public interface UserDao {
		@Select("select * from users where username=#{username}")
		@Results({
						@Result(id = true, property = "id", column = "id"),
						@Result(column = "username", property = "username"),
						@Result(column = "email", property = "email"),
						@Result(column = "password", property = "password"),
						@Result(column = "phoneNum", property = "phoneNum"),
						@Result(column = "status", property = "status"),
						@Result(column = "id", property = "roles", javaType = java.util.List.class, many =
						@Many(select = "cn.wen.ssm.dao.RoleDao.findRoleByUserId")) })
		public UserInfo findByUsername(String username);

		@Select("select * from users")
		List<UserInfo> findAll();

		@Insert("insert into users(email,username,password,phoneNum,status) values(#{email},#{username},#{password},#{phoneNum},#{status})")
		void save(UserInfo userInfo);

		@Select("select * from users where id = #{id}")
		@Results({
						@Result(id = true, property = "id", column = "id"),
						@Result(column = "username", property = "username"),
						@Result(column = "email", property = "email"),
						@Result(column = "password", property = "password"),
						@Result(column = "phoneNum", property = "phoneNum"),
						@Result(column = "status", property = "status"),
						@Result(column = "id", property = "roles", javaType = java.util.List.class, many =
						@Many(select = "cn.wen.ssm.dao.RoleDao.findRoleByUserId")) })
		UserInfo findById(String id);


		@Select("select * from role where id not in (select roleId from users_role where userId = #{userId})")
		List<Role> findOtherRole(String userId);

		@Insert("INSERT INTO USERS_ROLE (USERID, ROLEID) VALUES (#{userId}, #{roleId})")
		void addRoleToUser(@Param("userId")String userId,@Param("roleId") String roleId);
}
