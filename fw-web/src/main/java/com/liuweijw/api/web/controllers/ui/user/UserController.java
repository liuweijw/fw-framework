package com.liuweijw.api.web.controllers.ui.user;

import io.swagger.annotations.ApiOperation;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.liuweijw.api.core.http.AjaxResult;
import com.liuweijw.api.security.auth.JwtAuthenticationToken;

@RestController
@RequestMapping("/api/user")
public class UserController {

	@RequestMapping(value = "/me", method = { RequestMethod.GET, RequestMethod.POST })
	@ApiOperation(value = "获取用户受保护资源", notes = "根据token获取用户受保护资源")
	@PreAuthorize("hasRole('AUTH')")
	public @ResponseBody AjaxResult get(JwtAuthenticationToken token) {
		return new AjaxResult().success().data(token.getPrincipal());
	}

}
