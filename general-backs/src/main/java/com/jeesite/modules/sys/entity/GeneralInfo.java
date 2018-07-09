/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.sys.entity;

import com.jeesite.common.entity.DataEntity;
import com.jeesite.common.mybatis.annotation.Column;
import com.jeesite.common.mybatis.annotation.Table;
import com.jeesite.common.mybatis.mapper.query.QueryType;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

import java.util.Date;

/**
 * 资讯Entity
 * @author yuegang
 * @version 2018-07-07
 */
@Table(name="g_app_information", alias="a", columns={
		@Column(name="id", attrName="id", label="id", isPK=true),
		@Column(name="cate_id", attrName="cateId", label="频道ID"),
		@Column(name="title", attrName="title", label="资讯标题", queryType=QueryType.LIKE),
		@Column(name="cate_name", attrName="cateName", label="频道"),
		@Column(name="theme", attrName="theme", label="题材"),
		@Column(name="news_source", attrName="newsSource", label="来源"),
		@Column(name="data_source", attrName="dataSource", label="数据来源"),
		@Column(name="img_path", attrName="imgPath", label="资讯图标路径"),
		@Column(includeEntity=DataEntity.class),
		@Column(name="data_status", attrName="dataStatus", label="数据状态", comment="数据状态(如 -1 是草稿 0 可以发表文章  )"),
		@Column(name="top_status", attrName="topStatus", label="置顶或者热点，置顶2，热点1，常正0"),
		@Column(name="author", attrName="author", label="作者", queryType=QueryType.LIKE),
	}, orderBy="a.update_date DESC"
)
public class GeneralInfo extends DataEntity<GeneralInfo> {
	
	private static final long serialVersionUID = 1L;
	private Long cateId;		// 频道ID
	private String title;		// 资讯标题
	private String cateName;		// 频道
	private String theme;		// 题材
	private String newsSource;		// 来源
	private String dataSource;		// 数据来源
	private String imgPath;		// 资讯图标路径
	private Long dataStatus;		// 数据状态(如 -1 是草稿 0 可以发表文章  )
	private Integer topStatus;		// 置顶或者热点，置顶2，热点1，常正0
	private String author;		// 作者
	private String name;         //频道名称
	private String infor_id;     //资讯主表ID
	private int browse_number;    //浏览量
	private int comment_number;   //评论量
	private int parise_number;     //点赞量

	
	public GeneralInfo() {
		this(null);
	}

	public GeneralInfo(String id){
		super(id);
	}
	
	public Long getCateId() {
		return cateId;
	}

	public void setCateId(Long cateId) {
		this.cateId = cateId;
	}
	
	@NotBlank(message="资讯标题不能为空")
	@Length(min=0, max=128, message="资讯标题长度不能超过 128 个字符")
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
	
	@Length(min=0, max=64, message="频道长度不能超过 64 个字符")
	public String getCateName() {
		return cateName;
	}

	public void setCateName(String cateName) {
		this.cateName = cateName;
	}
	
	@Length(min=0, max=24, message="题材长度不能超过 24 个字符")
	public String getTheme() {
		return theme;
	}

	public void setTheme(String theme) {
		this.theme = theme;
	}
	
	@Length(min=0, max=64, message="来源长度不能超过 64 个字符")
	public String getNewsSource() {
		return newsSource;
	}

	public void setNewsSource(String newsSource) {
		this.newsSource = newsSource;
	}
	
	@Length(min=0, max=64, message="数据来源长度不能超过 64 个字符")
	public String getDataSource() {
		return dataSource;
	}

	public void setDataSource(String dataSource) {
		this.dataSource = dataSource;
	}
	
	@Length(min=0, max=255, message="资讯图标路径长度不能超过 255 个字符")
	public String getImgPath() {
		return imgPath;
	}

	public void setImgPath(String imgPath) {
		this.imgPath = imgPath;
	}

	public Long getDataStatus() {
		return dataStatus;
	}

	public void setDataStatus(Long dataStatus) {
		this.dataStatus = dataStatus;
	}
	
	public Integer getTopStatus() {
		return topStatus;
	}

	public void setTopStatus(Integer topStatus) {
		this.topStatus = topStatus;
	}
	
	@Length(min=0, max=24, message="作者长度不能超过 24 个字符")
	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getInfor_id() {
		return infor_id;
	}

	public void setInfor_id(String infor_id) {
		this.infor_id = infor_id;
	}

	public int getBrowse_number() {
		return browse_number;
	}

	public void setBrowse_number(int browse_number) {
		this.browse_number = browse_number;
	}

	public int getComment_number() {
		return comment_number;
	}

	public void setComment_number(int comment_number) {
		this.comment_number = comment_number;
	}

	public int getParise_number() {
		return parise_number;
	}

	public void setParise_number(int parise_number) {
		this.parise_number = parise_number;
	}

	public Date getCreateDate_gte() {
		return sqlMap.getWhere().getValue("create_date", QueryType.GTE);
	}

	public void setCreateDate_gte(Date createDate) {
		sqlMap.getWhere().and("create_date", QueryType.GTE, createDate);
	}
	
	public Date getCreateDate_lte() {
		return sqlMap.getWhere().getValue("create_date", QueryType.LTE);
	}

	public void setCreateDate_lte(Date createDate) {
		sqlMap.getWhere().and("create_date", QueryType.LTE, createDate);
	}
	
}