package com.fw.api.web.controllers.ui.version;

import io.swagger.annotations.ApiOperation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.fw.api.bean.version.VersionBean;
import com.fw.api.core.http.AjaxResult;
import com.fw.api.web.controllers.BaseController;
import com.fw.api.web.domain.Version;
import com.fw.api.web.repository.VersionRepository;

@RestController
@RequestMapping(value = "/api/version")
public class VersionController extends BaseController {

	@Autowired
	private VersionRepository versionRepository;

	@RequestMapping(value = "/init", method = { RequestMethod.GET, RequestMethod.POST })
	@ApiOperation(value = "获取版本号", notes = "根据type获取版本号信息")
	@PreAuthorize("hasRole('ADMIN')")
	@ResponseBody
	public AjaxResult versionInit(Integer type) {
		type = null == type ? 1 : type;
		Version version = versionRepository.findByType(type);
		VersionBean vBean = null;
		if (null != version) {
			vBean = new VersionBean();
			vBean.setDescription(version.getDescription());
			vBean.setDownload_url(version.getDownload_url());
			vBean.setMin_version(version.getMin_version());
			vBean.setNew_version(version.getNew_version());
			vBean.setStatus(version.getStatus());
			vBean.setType(version.getType());

			return new AjaxResult().success().data(vBean);
		}
		return new AjaxResult().failure().data(vBean);
	}

}
