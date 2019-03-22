package cn.wen.ssm.domain;

import java.util.List;

/**
 * @author 张文军
 * @Description:
 * @Company:南京农业大学工学院
 * @version:1.0
 * @date 2019/3/210:28
 */
public class UserInfo {

		/**
		 * 1 id varchar2 无意义，主键uuid
		 * 2 email varchar2 非空，唯一
		 * 3 username varchar2 用户名
		 * 5 password varchar2 密码（加密）
		 * 6 phoneNum varchar2 电话
		 * 7 status int 状态0 未开启 1 开启
		 */
		private String id;
		private String username;
		private String email;
		private String password;
		private String phoneNum;
		private int status;
		private String statusStr;
		private List<Role> roles;

		public String getId() {
				return id;
		}

		public void setId(String id) {
				this.id = id;
		}

		public String getUsername() {
				return username;
		}

		public void setUsername(String username) {
				this.username = username;
		}

		public String getEmail() {
				return email;
		}

		public void setEmail(String email) {
				this.email = email;
		}

		public String getPassword() {
				return password;
		}

		public void setPassword(String password) {
				this.password = password;
		}

		public String getPhoneNum() {
				return phoneNum;
		}

		public void setPhoneNum(String phoneNum) {
				this.phoneNum = phoneNum;
		}

		public int getStatus() {
				return status;
		}

		public void setStatus(int status) {
				this.status = status;
		}

		public String getStatusStr() {
				//status int 状态0 未开启 1 开启
				if (status == 0){
						statusStr = "未开启";
				}else if(status == 1){
						statusStr = "开启";
				}
				return statusStr;
		}

		public void setStatusStr(String statusStr) {
				this.statusStr = statusStr;
		}

		public List<Role> getRoles() {
				return roles;
		}

		public void setRoles(List<Role> roles) {
				this.roles = roles;
		}
}
