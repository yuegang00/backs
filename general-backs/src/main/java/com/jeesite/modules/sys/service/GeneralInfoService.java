/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.sys.service;

import com.jeesite.common.entity.Page;
import com.jeesite.common.service.CrudService;
import com.jeesite.modules.file.utils.FileUploadUtils;
import com.jeesite.modules.sys.dao.GeneralInfoDao;
import com.jeesite.modules.sys.entity.GeneralInfo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * 资讯Service
 * @author yuegang
 * @version 2018-07-07
 */
@Service
@Transactional(readOnly=true)
public class GeneralInfoService extends CrudService<GeneralInfoDao, GeneralInfo> {

	private GeneralInfoDao generalInfoDao;

	/**
	 * 获取资讯信息列表
	 * @param paramMap
	 * @return infoList
	 */
	public List findInfoList(Map paramMap) {
		List infoList = generalInfoDao.findInfoList(paramMap);
		return infoList;
	}
	
	/**
	 * 获取单条数据
	 * @param generalInfo
	 * @return
	 */
	@Override
	public GeneralInfo get(GeneralInfo generalInfo) {
		return super.get(generalInfo);
	}
	
	/**
	 * 查询分页数据
	 * @param page 分页对象
	 * @param generalInfo
	 * @return
	 */
	@Override
	public Page<GeneralInfo> findPage(Page<GeneralInfo> page, GeneralInfo generalInfo) {
		return super.findPage(page, generalInfo);
	}


	/**
	 * 查询分页数据
	 * @param
	 * @param
	 * @return
	 */

	public List<GeneralInfo> quereyInfoByMap(Map paramMap) {
		List infoList = new ArrayList();
		return infoList;
	}
	
	/**
	 * 保存数据（插入或更新）
	 * @param generalInfo
	 */
	@Override
	@Transactional(readOnly=false)
	public void save(GeneralInfo generalInfo) {
		super.save(generalInfo);
		// 保存上传图片
		FileUploadUtils.saveFileUpload(generalInfo.getId(), "generalInfo_image");
		// 保存上传附件
		FileUploadUtils.saveFileUpload(generalInfo.getId(), "generalInfo_file");
	}
	
	/**
	 * 更新状态
	 * @param generalInfo
	 */
	@Override
	@Transactional(readOnly=false)
	public void updateStatus(GeneralInfo generalInfo) {
		super.updateStatus(generalInfo);
	}
	
	/**
	 * 删除数据
	 * @param generalInfo
	 */
	@Override
	@Transactional(readOnly=false)
	public void delete(GeneralInfo generalInfo) {
		super.delete(generalInfo);
	}
	
}