package cn.wen.ssm.dao;

import cn.wen.ssm.domain.Product;
import org.apache.ibatis.annotations.*;
import java.util.List;

/**
 * @author 张文军
 * @Description:
 * @Company:南京农业大学工学院
 * @version:1.0
 * @date 2019/3/1720:01
 */
public interface ProductDao {
		/**
		 * 查询商品信息
		 * @return
		 * @throws Exception
		 */
		@Select("select * from product")
		public List<Product> findAll() throws Exception;

		/**
		 * 保存
		 * @param product
		 */
		@Insert("insert into product(productNum,productName,cityName,departureTime,productPrice,productDesc,productStatus) values(#{productNum},#{productName},#{cityName},#{departureTime},#{productPrice},#{productDesc},#{productStatus})")
		void save(Product product);

		@Select("select * from product where id =#{id}")
		Product findById(String id);
}
