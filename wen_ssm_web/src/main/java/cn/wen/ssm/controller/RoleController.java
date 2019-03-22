package cn.wen.ssm.controller;

import cn.wen.ssm.domain.Permission;
import cn.wen.ssm.domain.Role;
import cn.wen.ssm.service.RoleService;
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
 * @date 2019/3/2114:58
 */
@Controller
@RequestMapping("/role")
public class RoleController {

		@Autowired
		RoleService roleService;

		@RequestMapping("/findAll.do")
		public ModelAndView findAll(){

				ModelAndView modelAndView = new ModelAndView();
				List<Role> roleList = roleService.findAll();
				modelAndView.addObject("roleList", roleList);
				modelAndView.setViewName("role-list");
				return modelAndView;
		}

		@RequestMapping("/save.do")
		public String save(Role role){
				roleService.save(role);
				return "redirect:findAll.do";
		}

		@RequestMapping("/findRoleByIdAndAllPermission.do")
		public ModelAndView findRoleByIdAndAllPermission(@RequestParam(name = "id") String roleId){
				ModelAndView modelAndView = new ModelAndView();
				Role role = roleService.findById(roleId);
				List<Permission> permissionList = roleService.findOtherPermissionsByRoleId(roleId);
				modelAndView.addObject("role", role);
				modelAndView.addObject("permissionList", permissionList);
				modelAndView.setViewName("role-permission-add");
				return modelAndView;
		}

		@RequestMapping("/addPermissionToRole.do")
		public String addPermissionToRole(@RequestParam(name = "roleId") String roleId,@RequestParam(name = "ids")String [] permissionIds){
				roleService.addPermissionToRole(roleId, permissionIds);
				return "redirect:findAll.do";
		}

}
