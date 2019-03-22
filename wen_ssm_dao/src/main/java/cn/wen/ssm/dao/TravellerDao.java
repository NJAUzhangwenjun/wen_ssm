package cn.wen.ssm.dao;

import org.apache.ibatis.annotations.*;
import cn.wen.ssm.domain.Traveller;

import java.util.List;

/**
 * @author 张文军
 * @Description:
 * @Company:南京农业大学工学院
 * @version:1.0
 * @date 2019/3/2019:38
 */
public interface TravellerDao {

		@Select("select * from traveller where id in (select travellerId from order_traveller where orderId=#{ordersId})")
		List<Traveller> findByOrdersId(String ordersId) throws Exception;
}
