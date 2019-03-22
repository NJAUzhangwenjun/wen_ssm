package cn.wen.ssm.domain;

/**
 * @author 张文军
 * @Description:
 * @Company:南京农业大学工学院
 * @version:1.0
 * @date 2019/3/198:55
 */
public class Traveller {

		/**
		 * 1 id varchar2(32) 无意义、主键uuid
		 * 2 name varchar2(20) 姓名
		 * 3 sex varchar2(20) 性别
		 * 4 phoneNum varchar2(20) 电话号码
		 * 5 credentialsType int 证件类型 0身份证 1护照 2军官证
		 * 6 credentialsNum varchar2(50) 证件号码
		 * 7 travellerType int 旅客类型(人群) 0 成人 1 儿童
		 */
		private String id;
		private String name;
		private String sex;
		private String phoneNum;
		private Integer credentialsType;
		private String credentialsTypeStr;
		private String credentialsNum;
		private Integer travellerType;
		private String travellerTypeStr;

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

		public String getSex() {
				return sex;
		}

		public void setSex(String sex) {
				this.sex = sex;
		}

		public String getPhoneNum() {
				return phoneNum;
		}

		public void setPhoneNum(String phoneNum) {
				this.phoneNum = phoneNum;
		}

		public Integer getCredentialsType() {
				return credentialsType;
		}

		public void setCredentialsType(Integer credentialsType) {
				this.credentialsType = credentialsType;
		}

		public String getCredentialsTypeStr() {
				//credentialsType int 证件类型 0身份证 1护照 2军官证
				if (credentialsType !=null){
						if (credentialsType == 0){
								credentialsTypeStr = "身份证";
						}else if (credentialsType == 1){
								credentialsTypeStr = "护照";
						} else if (credentialsType == 2){
								credentialsTypeStr = "军官证";
						}
				}
				return credentialsTypeStr;
		}

		public void setCredentialsTypeStr(String credentialsTypeStr) {
				this.credentialsTypeStr = credentialsTypeStr;
		}

		public String getCredentialsNum() {
				return credentialsNum;
		}

		public void setCredentialsNum(String credentialsNum) {
				this.credentialsNum = credentialsNum;
		}

		public Integer getTravellerType() {


				return travellerType;
		}

		public void setTravellerType(Integer travellerType) {
				this.travellerType = travellerType;
		}

		public String getTravellerTypeStr() {
				//travellerType int 旅客类型(人群) 0 成人 1 儿童
				if(travellerType!=null){
						if (travellerType ==0){
								travellerTypeStr = "成人";
						}else if (travellerType ==1){
								travellerTypeStr = "儿童";
						}
				}
				return travellerTypeStr;
		}

		public void setTravellerTypeStr(String travellerTypeStr) {
				this.travellerTypeStr = travellerTypeStr;
		}
}
