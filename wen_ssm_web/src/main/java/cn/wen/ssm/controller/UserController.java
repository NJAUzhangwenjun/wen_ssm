package cn.wen.ssm.controller;

import cn.wen.ssm.domain.Role;
import cn.wen.ssm.domain.UserInfo;
import cn.wen.ssm.service.UserService;
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
 * @date 2019/3/2111:52
 */
@Controller
@RequestMapping("/user")
public class UserController {
		@Autowired
		UserService userService;

		@RequestMapping("/findAll.do")
		public ModelAndView findAll(){

				ModelAndView modelAndView = new ModelAndView();
				List<UserInfo> userList = userService.findAll();
				modelAndView.addObject("userList", userList);
				modelAndView.setViewName("user-list");
				return modelAndView;
		}


		@RequestMapping("/findById.do")
		public ModelAndView findById(String id){

				ModelAndView modelAndView = new ModelAndView();
				UserInfo  userInfo= userService.findById(id);
				modelAndView.addObject("user", userInfo);
				modelAndView.setViewName("user-show");
				return modelAndView;
		}



		@RequestMapping("/save.do")
		public String save(UserInfo userInfo){
				userService.save(userInfo);
				return "redirect:findAll.do";
		}

		@RequestMapping("/findUserByIdAndAllRole.do")
		public ModelAndView findUserByIdAndAllRole(@RequestParam(name = "id",required = true) String userId){
				ModelAndView modelAndView = new ModelAndView();
				UserInfo byId = userService.findById(userId);
				List<Role> roleList = userService.findOtherRole(userId);
				modelAndView.addObject("user", byId);
				modelAndView.addObject("roleList", roleList);
				modelAndView.setViewName("user-role-add");
				return modelAndView;
		}


		@RequestMapping("/addRoleToUser.do")
		public String addRoleToUser(@RequestParam(name = "userId",required = true) String userId,@RequestParam(name = "ids",required = true) String[] roleIds){
				userService.addRoleToUser(userId, roleIds);
				return "redirect:findAll.do";
		}

}
