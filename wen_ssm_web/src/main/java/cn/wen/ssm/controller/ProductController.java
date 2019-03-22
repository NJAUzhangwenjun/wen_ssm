package cn.wen.ssm.controller;

import cn.wen.ssm.domain.Product;
import cn.wen.ssm.service.ProductService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.security.RolesAllowed;
import java.util.List;

/**
 * @author 张文军
 * @Description:
 * @Company:南京农业大学工学院
 * @version:1.0
 * @date 2019/3/1721:37
 */
@Controller
@RequestMapping("/product")
public class ProductController {

		@Autowired
		ProductService productService;
		/**
		 * 查询所有
		 * @return
		 */


		@RequestMapping("/findAll.do")
		@RolesAllowed("ADMIN")
		public ModelAndView findAll(@RequestParam(name = "page",required = true,defaultValue = "1")int page, @RequestParam(name = "size",required = true,defaultValue = "4") int size) throws Exception {
				ModelAndView modelAndView = new ModelAndView();
				PageHelper.startPage(page, size);
				List<Product> productList = productService.findAll();
				PageInfo pageInfo = new PageInfo(productList);
				modelAndView.addObject("pageInfo", pageInfo);
				modelAndView.setViewName("product-list");
				return modelAndView;
		}


		@RequestMapping("/save.do")
		public String save(Product product){
				productService.save(product);
				return "redirect:findAll.do";
		}

}
