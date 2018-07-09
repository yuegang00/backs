/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.sys.web;

import com.jeesite.common.config.Global;
import com.jeesite.common.entity.Page;
import com.jeesite.common.web.BaseController;
import com.jeesite.modules.sys.entity.GeneralInfo;
import com.jeesite.modules.sys.service.GeneralInfoService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


/**
 * 资讯Controller
 * @author yuegang
 * @version 2018-07-07
 */
@Controller
@RequestMapping(value = "${adminPath}/sys/generalInfo")
public class GeneralInfoController extends BaseController {

	@Autowired
	private GeneralInfoService generalInfoService;
	
	/**
	 *
	 */
	@ModelAttribute
	public GeneralInfo get(Long id, boolean isNewRecord) {
		return generalInfoService.get(String.valueOf(id), isNewRecord);
	}

	/**
	 * 查询列表
	 */
	@RequiresPermissions("sys:generalInfo:view")
	@RequestMapping(value = {"list", ""})
	public String queryInfoList(GeneralInfo generalInfo, Model model) {


		model.addAttribute("generalInfo", generalInfo);
		return "modules/sys/generalInfoList";
	}

	/**
	 * 查询列表
	 */
	@RequiresPermissions("sys:generalInfo:view")
	@RequestMapping(value = {"unIssueList", ""})
	public String queryUnissueInfo( HttpServletRequest request, Model model) {
		String title = request.getParameter("title");
		String cateNameId = request.getParameter("cateName");
		String newsSourceId = request.getParameter("newsSource");
		String author = request.getParameter("author");
		String createDate_gte = request.getParameter("createDate_gte");
		String createDate_lte = request.getParameter("createDate_lte");
		Map paramMap = new ConcurrentHashMap();
		paramMap.put("titel",title);
		paramMap.put("cateNameId",cateNameId);
		paramMap.put("newsSourceId",newsSourceId);
		paramMap.put("author",author);
		paramMap.put("createDate_gte",createDate_gte);
		paramMap.put("createDate_lte",createDate_lte);

		List<GeneralInfo> infoList =  generalInfoService.quereyInfoByMap(paramMap);
		model.addAttribute("generalInfo", infoList);
		return "modules/sys/unIssueInfoList";
	}


	/**
	 * 分页信息查询
	 */
	@RequiresPermissions("sys:generalInfo:view")
	@RequestMapping(value = "listData")
	@ResponseBody
	public Page<GeneralInfo> listData(GeneralInfo generalInfo, HttpServletRequest request, HttpServletResponse response) {
		Page<GeneralInfo> page = generalInfoService.findPage(new Page<GeneralInfo>(request, response), generalInfo); 
		return page;
	}

	/**
	 * 查看编辑表单
	 */
	@RequiresPermissions("sys:generalInfo:view")
	@RequestMapping(value = "form")
	public String form(GeneralInfo generalInfo, Model model) {
		model.addAttribute("generalInfo", generalInfo);
		return "modules/sys/generalInfoForm";
	}

	/**
	 * 保存添加的资讯信息
	 */
	@RequiresPermissions("sys:generalInfo:edit")
	@PostMapping(value = "save")
	@ResponseBody
	public String save(@Validated GeneralInfo generalInfo) {
		generalInfoService.save(generalInfo);
		return renderResult(Global.TRUE, text("保存资讯成功！"));
	}
	
	/**
	 * 停用资讯
	 */
	@RequiresPermissions("sys:generalInfo:edit")
	@RequestMapping(value = "disable")
	@ResponseBody
	public String disable(GeneralInfo generalInfo) {
		generalInfo.setStatus(GeneralInfo.STATUS_DISABLE);
		generalInfoService.updateStatus(generalInfo);
		return renderResult(Global.TRUE, text("停用资讯成功"));
	}
	
	/**
	 * 启用资讯
	 */
	@RequiresPermissions("sys:generalInfo:edit")
	@RequestMapping(value = "enable")
	@ResponseBody
	public String enable(GeneralInfo generalInfo) {
		generalInfo.setStatus(GeneralInfo.STATUS_NORMAL);
		generalInfoService.updateStatus(generalInfo);
		return renderResult(Global.TRUE, text("启用资讯成功"));
	}
	
	/**
	 * 删除资讯
	 */
	@RequiresPermissions("sys:generalInfo:edit")
	@RequestMapping(value = "delete")
	@ResponseBody
	public String delete(GeneralInfo generalInfo) {
		generalInfoService.delete(generalInfo);
		return renderResult(Global.TRUE, text("删除资讯成功！"));
	}
	
}