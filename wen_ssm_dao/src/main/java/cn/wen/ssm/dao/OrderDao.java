package cn.wen.ssm.dao;

import cn.wen.ssm.domain.Orders;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @author 张文军
 * @Description:
 * @Company:南京农业大学工学院
 * @version:1.0
 * @date 2019/3/1919:34
 */

public interface OrderDao {


		@Select("select * from orders")
		@Results({
						@Result(id=true,column = "id",property = "id"),
						@Result(column = "orderNum",property = "orderNum"),
						@Result(column = "orderTime",property = "orderTime"),
						@Result(column = "orderStatus",property = "orderStatus"),
						@Result(column = "peopleCount",property = "peopleCount"),
						@Result(column = "payType",property = "payType"),
						@Result(column = "orderDesc",property = "orderDesc"),
						@Result(column = "productId",property = "product",one = @One(select = "cn.wen.ssm.dao.ProductDao.findById"))
		})
		List<Orders> findAll();


		@Select("select * from orders where id=#{id}")
		@Results({
						@Result(id=true,column = "id",property = "id"),
						@Result(column = "orderNum",property = "orderNum"),
						@Result(column = "orderTime",property = "orderTime"),
						@Result(column = "orderStatus",property = "orderStatus"),
						@Result(column = "peopleCount",property = "peopleCount"),
						@Result(column = "payType",property = "payType"),
						@Result(column = "orderDesc",property = "orderDesc"),
						@Result(column = "productId",property = "product",one = @One(select =
										"cn.wen.ssm.dao.ProductDao.findById")),
						@Result(column = "id",property = "travellers",many = @Many(select =
										"cn.wen.ssm.dao.TravellerDao.findByOrdersId")),
						@Result(column = "memberId",property = "member",one = @One(select =
										"cn.wen.ssm.dao.MemberDao.findById")),
		})
		public Orders findById(String id);
}
