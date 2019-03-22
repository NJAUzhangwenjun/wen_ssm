package cn.wen.ssm.domain;

import java.util.List;

/**
 * @author 张文军
 * @Description:
 * @Company:南京农业大学工学院
 * @version:1.0
 * @date 2019/3/210:29
 */
public class Role {
		/**
		 * 1 id varchar2 无意义，主键uuid
		 * 2 roleName varchar2 角色名
		 * 3 roleDesc varchar2 角色描述
		 */
		private String id;
		private String roleName;
		private String roleDesc;
		private List<Permission> permissions;
		private List<UserInfo> users;

		public String getId() {
				return id;
		}

		public void setId(String id) {
				this.id = id;
		}

		public String getRoleName() {
				return roleName;
		}

		public void setRoleName(String roleName) {
				this.roleName = roleName;
		}

		public String getRoleDesc() {
				return roleDesc;
		}

		public void setRoleDesc(String roleDesc) {
				this.roleDesc = roleDesc;
		}

		public List<Permission> getPermissions() {
				return permissions;
		}

		public void setPermissions(List<Permission> permissions) {
				this.permissions = permissions;
		}

		public List<UserInfo> getUsers() {
				return users;
		}

		public void setUsers(List<UserInfo> users) {
				this.users = users;
		}
}
