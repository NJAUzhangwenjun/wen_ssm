package cn.wen.ssm.domain;

/**
 * @author 张文军
 * @Description:
 * @Company:南京农业大学工学院
 * @version:1.0
 * @date 2019/3/198:55
 */
public class Member {

		/**
		 * 1 id varchar2(32) 无意义、主键uuid
		 * 2 name varchar2(20) 姓名
		 * 3 nickName varchar2(20) 昵称
		 * 4 phoneNum varchar2(20) 电话号码
		 * 5 email varchar2(50) 邮箱
		 * 1.2 会员表信息描述member
		 */
		private String id;
		private String name;
		private String nickname;
		private String phoneNum;
		private String email;

		public String getId() {
				return id;
		}

		public void setId(String id) {
				this.id = id;
		}

		public String getName() {
				return name;
		}

		public void setName(String name) {
				this.name = name;
		}

		public String getNickname() {
				return nickname;
		}

		public void setNickname(String nickname) {
				this.nickname = nickname;
		}

		public String getPhoneNum() {
				return phoneNum;
		}

		public void setPhoneNum(String phoneNum) {
				this.phoneNum = phoneNum;
		}

		public String getEmail() {
				return email;
		}

		public void setEmail(String email) {
				this.email = email;
		}
}
