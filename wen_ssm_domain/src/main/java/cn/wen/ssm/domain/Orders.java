package cn.wen.ssm.domain;

import cn.wen.ssm.utils.DateUtils;

import java.util.Date;
import java.util.List;

/**
 * @author 张文军
 * @Description:
 * @Company:南京农业大学工学院
 * @version:1.0
 * @date 2019/3/198:54
 */
public class Orders {

		/**
		 * 1 id varchar2(32) 无意义、主键uuid
		 * 2 orderNum varchar2(50) 订单编号 不为空 唯一
		 * 3 orderTime timestamp 下单时间
		 * 4 peopleCount int 出行人数
		 * 5 orderDesc varchar2(500) 订单描述(其它信息)
		 * 6 payType int 支付方式(0 支付宝 1 微信 2其它)
		 * 7 orderStatus int 订单状态(0 未支付 1 已支付)
		 * 8 productId int 产品id 外键
		 * 9 memberid int 会员(联系人）id 外键
		 */
		private String id;
		private String orderNum;
		private Date orderTime;
		private String orderTimeStr;

		private int orderStatus;
		private String orderStatusStr;
		private int peopleCount;
		private Product product;
		private List<Traveller> travellers;
		private Member member;
		private Integer payType;
		private String payTypeStr;
		private String orderDesc;



		public String getId() {
				return id;
		}

		public void setId(String id) {
				this.id = id;
		}

		public String getOrderNum() {
				return orderNum;
		}

		public void setOrderNum(String orderNum) {
				this.orderNum = orderNum;
		}

		public Date getOrderTime() {
				return orderTime;
		}

		public void setOrderTime(Date orderTime) {
				this.orderTime = orderTime;
		}

		public String getOrderTimeStr() {
				if(orderTime!= null){
						 orderTimeStr = DateUtils.data2String(orderTime, "yyyy-MM-dd hh:mm");
				}
				return orderTimeStr;
		}

		public void setOrderTimeStr(String orderTimeStr) {
				this.orderTimeStr = orderTimeStr;
		}

		public int getOrderStatus() {
				return orderStatus;
		}

		public void setOrderStatus(int orderStatus) {
				this.orderStatus = orderStatus;
		}
		public String getOrderStatusStr() {
				if (orderStatus==1){
						orderStatusStr = "已支付";
				}else if (orderStatus==0){
						orderStatusStr = "未支付";
				}
				return orderStatusStr;
		}

		public void setOrderStatusStr(String orderStatusStr) {
				this.orderStatusStr = orderStatusStr;
		}

		public int getPeopleCount() {
				return peopleCount;
		}

		public void setPeopleCount(int peopleCount) {
				this.peopleCount = peopleCount;
		}

		public Product getProduct() {
				return product;
		}

		public void setProduct(Product product) {
				this.product = product;
		}

		public List<Traveller> getTravellers() {
				return travellers;
		}

		public void setTravellers(List<Traveller> travellers) {
				this.travellers = travellers;
		}

		public Member getMember() {
				return member;
		}

		public void setMember(Member member) {
				this.member = member;
		}

		public Integer getPayType() {

				return payType;
		}

		public void setPayType(Integer payType) {
				this.payType = payType;
		}

		public String getPayTypeStr() {
				//支付方式(0 支付宝 1 微信 2其它)
				if(payType==0){
						payTypeStr = "支付宝";
				}else if(payType==1){
						payTypeStr = "微信";
				}else if(payType==2){
						payTypeStr = "其他";
				}
				return payTypeStr;
		}

		public void setPayTypeStr(String payTypeStr) {
				this.payTypeStr = payTypeStr;
		}

		public String getOrderDesc() {
				return orderDesc;
		}

		public void setOrderDesc(String orderDesc) {
				this.orderDesc = orderDesc;
		}
}
