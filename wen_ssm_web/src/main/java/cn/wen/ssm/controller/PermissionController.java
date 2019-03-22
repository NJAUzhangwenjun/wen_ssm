package cn.wen.ssm.controller;

import cn.wen.ssm.domain.Permission;
import cn.wen.ssm.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * @author 张文军
 * @Description:
 * @Company:南京农业大学工学院
 * @version:1.0
 * @date 2019/3/2115:29
 */
@Controller
@RequestMapping("/permission")
public class PermissionController {
		@Autowired
		PermissionService permissionService;

		@RequestMapping("save.do")
		public String save(Permission permission){
				permissionService.save(permission);
				return "redirect:findAll.do";
		}

		@RequestMapping("/findAll.do")
		public ModelAndView findAll(){
				ModelAndView modelAndView = new ModelAndView();
				List<Permission> permissionList= permissionService.findAll();
				modelAndView.setViewName("permission-list");
				modelAndView.addObject("permissionList", permissionList);
				return modelAndView;
		}
}
