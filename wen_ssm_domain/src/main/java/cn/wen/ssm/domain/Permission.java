package cn.wen.ssm.domain;

import java.util.List;

/**
 * @author 张文军
 * @Description:
 * @Company:南京农业大学工学院
 * @version:1.0
 * @date 2019/3/210:31
 */
public class Permission {
		/**
		 * 1 id varchar2 无意义，主键uuid
		 * 2 permissionName varchar2 权限名
		 * 3 url varchar2 资源路径
		 */
		private String id;
		private String permissionName;
		private String url;
		private List<Role> roles;

		public String getId() {
				return id;
		}

		public void setId(String id) {
				this.id = id;
		}

		public String getPermissionName() {
				return permissionName;
		}

		public void setPermissionName(String permissionName) {
				this.permissionName = permissionName;
		}

		public String getUrl() {
				return url;
		}

		public void setUrl(String url) {
				this.url = url;
		}

		public List<Role> getRoles() {
				return roles;
		}

		public void setRoles(List<Role> roles) {
				this.roles = roles;
		}
}
