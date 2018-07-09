/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.sys.dao;

import com.jeesite.common.dao.CrudDao;
import com.jeesite.common.mybatis.annotation.MyBatisDao;
import com.jeesite.modules.sys.entity.GeneralInfo;

import java.util.List;
import java.util.Map;

/**
 * 资讯DAO接口
 * @author yuegang
 * @version 2018-07-07
 */
@MyBatisDao
public interface GeneralInfoDao extends CrudDao<GeneralInfo> {

    public List<GeneralInfo> findInfoList(Map paramMap);

}