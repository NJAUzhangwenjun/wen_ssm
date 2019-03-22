package cn.wen.ssm.service.impl;

import cn.wen.ssm.dao.ProductDao;
import cn.wen.ssm.domain.Product;
import cn.wen.ssm.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author 张文军
 * @Description:
 * @Company:南京农业大学工学院
 * @version:1.0
 * @date 2019/3/1720:11
 */
@Service
@Transactional
public class ProductServiceImpl implements ProductService {

		@Autowired
		ProductDao productDao;

		@Override
		public List<Product> findAll() throws Exception {
				return productDao.findAll();
		}

		@Override
		public void save(Product product) {
				productDao.save(product);
		}
}
