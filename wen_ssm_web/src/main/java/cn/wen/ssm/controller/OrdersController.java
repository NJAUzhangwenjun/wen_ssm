package cn.wen.ssm.controller;

import cn.wen.ssm.domain.Orders;
import cn.wen.ssm.service.OrdersService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * @author 张文军
 * @Description:
 * @Company:南京农业大学工学院
 * @version:1.0
 * @date 2019/3/1919:30
 */
@Controller
@RequestMapping("/orders")
public class OrdersController {

		@Autowired
		OrdersService ordersService;

		@RequestMapping("/findAll.do")
		public ModelAndView findAll(@RequestParam(name = "page",required = true,defaultValue = "1")int page,@RequestParam(name = "size",required = true,defaultValue = "4") int size){
				ModelAndView modelAndView = new ModelAndView();
				PageHelper.startPage(page, size);
				List<Orders> ordersList = ordersService.findAll();
				PageInfo pageInfo = new PageInfo(ordersList);
				modelAndView.addObject("pageInfo", pageInfo);
				modelAndView.setViewName("orders-page-list");
				return modelAndView;
		}


		@RequestMapping("/findById.do")
		public ModelAndView findById(String id){
				ModelAndView modelAndView = new ModelAndView();
				Orders orders = ordersService.findById(id);
				modelAndView.addObject("orders", orders);
				modelAndView.setViewName("orders-show");
				return modelAndView;
		}

}
