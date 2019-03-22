package cn.wen.ssm.service;

import cn.wen.ssm.domain.Product;

import java.util.List;

/**
 * @author 张文军
 * @Description:
 * @Company:南京农业大学工学院
 * @version:1.0
 * @date 2019/3/1720:00
 */
public interface ProductService {

		/**
		 * 查询商品信息
		 * @return
		 * @throws Exception
		 */
		List<Product> findAll() throws Exception;

		/**
		 * 保存
		 * @param product
		 */
		void save(Product product);
}
