package com.entity;

import com.annotation.ColumnInfo;
import javax.validation.constraints.*;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.lang.reflect.InvocationTargetException;
import java.io.Serializable;
import java.util.*;
import org.apache.tools.ant.util.DateUtils;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.beanutils.BeanUtils;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import com.baomidou.mybatisplus.enums.FieldFill;
import com.utils.DateUtil;


/**
 * 物品维修预约
 *
 * @author 
 * @email
 */
@TableName("weixiuyuyue")
public class WeixiuyuyueEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public WeixiuyuyueEntity() {

	}

	public WeixiuyuyueEntity(T t) {
		try {
			BeanUtils.copyProperties(this, t);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


    /**
     * 主键
     */
    @TableId(type = IdType.AUTO)
    @ColumnInfo(comment="主键",type="int(11)")
    @TableField(value = "id")

    private Integer id;


    /**
     * 用户
     */
    @ColumnInfo(comment="用户",type="int(11)")
    @TableField(value = "yonghu_id")

    private Integer yonghuId;


    /**
     * 维修员
     */
    @ColumnInfo(comment="维修员",type="int(11)")
    @TableField(value = "weixiuyuan_id")

    private Integer weixiuyuanId;


    /**
     * 物品名称
     */
    @ColumnInfo(comment="物品名称",type="varchar(200)")
    @TableField(value = "weixiuyuyue_name")

    private String weixiuyuyueName;


    /**
     * 预约编号
     */
    @ColumnInfo(comment="预约编号",type="varchar(200)")
    @TableField(value = "weixiuyuyue_uuid_number")

    private String weixiuyuyueUuidNumber;


    /**
     * 物品照片
     */
    @ColumnInfo(comment="物品照片",type="varchar(200)")
    @TableField(value = "weixiuyuyue_photo")

    private String weixiuyuyuePhoto;


    /**
     * 物品维修类型
     */
    @ColumnInfo(comment="物品维修类型",type="int(11)")
    @TableField(value = "weixiuyuyue_types")

    private Integer weixiuyuyueTypes;


    /**
     * 预约维修时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @ColumnInfo(comment="预约维修时间",type="timestamp")
    @TableField(value = "yuyue_time")

    private Date yuyueTime;


    /**
     * 物品损坏详情
     */
    @ColumnInfo(comment="物品损坏详情",type="text")
    @TableField(value = "weixiuyuyue_content")

    private String weixiuyuyueContent;


    /**
     * 申请时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @ColumnInfo(comment="申请时间",type="timestamp")
    @TableField(value = "insert_time",fill = FieldFill.INSERT)

    private Date insertTime;


    /**
     * 预约状态
     */
    @ColumnInfo(comment="预约状态",type="int(11)")
    @TableField(value = "weixiuyuyue_yesno_types")

    private Integer weixiuyuyueYesnoTypes;


    /**
     * 审核意见
     */
    @ColumnInfo(comment="审核意见",type="text")
    @TableField(value = "weixiuyuyue_yesno_text")

    private String weixiuyuyueYesnoText;


    /**
     * 审核时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @ColumnInfo(comment="审核时间",type="timestamp")
    @TableField(value = "weixiuyuyue_shenhe_time")

    private Date weixiuyuyueShenheTime;


    /**
     * 创建时间   listShow
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @ColumnInfo(comment="创建时间",type="timestamp")
    @TableField(value = "create_time",fill = FieldFill.INSERT)

    private Date createTime;


    /**
	 * 获取：主键
	 */
    public Integer getId() {
        return id;
    }
    /**
	 * 设置：主键
	 */

    public void setId(Integer id) {
        this.id = id;
    }
    /**
	 * 获取：用户
	 */
    public Integer getYonghuId() {
        return yonghuId;
    }
    /**
	 * 设置：用户
	 */

    public void setYonghuId(Integer yonghuId) {
        this.yonghuId = yonghuId;
    }
    /**
	 * 获取：维修员
	 */
    public Integer getWeixiuyuanId() {
        return weixiuyuanId;
    }
    /**
	 * 设置：维修员
	 */

    public void setWeixiuyuanId(Integer weixiuyuanId) {
        this.weixiuyuanId = weixiuyuanId;
    }
    /**
	 * 获取：物品名称
	 */
    public String getWeixiuyuyueName() {
        return weixiuyuyueName;
    }
    /**
	 * 设置：物品名称
	 */

    public void setWeixiuyuyueName(String weixiuyuyueName) {
        this.weixiuyuyueName = weixiuyuyueName;
    }
    /**
	 * 获取：预约编号
	 */
    public String getWeixiuyuyueUuidNumber() {
        return weixiuyuyueUuidNumber;
    }
    /**
	 * 设置：预约编号
	 */

    public void setWeixiuyuyueUuidNumber(String weixiuyuyueUuidNumber) {
        this.weixiuyuyueUuidNumber = weixiuyuyueUuidNumber;
    }
    /**
	 * 获取：物品照片
	 */
    public String getWeixiuyuyuePhoto() {
        return weixiuyuyuePhoto;
    }
    /**
	 * 设置：物品照片
	 */

    public void setWeixiuyuyuePhoto(String weixiuyuyuePhoto) {
        this.weixiuyuyuePhoto = weixiuyuyuePhoto;
    }
    /**
	 * 获取：物品维修类型
	 */
    public Integer getWeixiuyuyueTypes() {
        return weixiuyuyueTypes;
    }
    /**
	 * 设置：物品维修类型
	 */

    public void setWeixiuyuyueTypes(Integer weixiuyuyueTypes) {
        this.weixiuyuyueTypes = weixiuyuyueTypes;
    }
    /**
	 * 获取：预约维修时间
	 */
    public Date getYuyueTime() {
        return yuyueTime;
    }
    /**
	 * 设置：预约维修时间
	 */

    public void setYuyueTime(Date yuyueTime) {
        this.yuyueTime = yuyueTime;
    }
    /**
	 * 获取：物品损坏详情
	 */
    public String getWeixiuyuyueContent() {
        return weixiuyuyueContent;
    }
    /**
	 * 设置：物品损坏详情
	 */

    public void setWeixiuyuyueContent(String weixiuyuyueContent) {
        this.weixiuyuyueContent = weixiuyuyueContent;
    }
    /**
	 * 获取：申请时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }
    /**
	 * 设置：申请时间
	 */

    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }
    /**
	 * 获取：预约状态
	 */
    public Integer getWeixiuyuyueYesnoTypes() {
        return weixiuyuyueYesnoTypes;
    }
    /**
	 * 设置：预约状态
	 */

    public void setWeixiuyuyueYesnoTypes(Integer weixiuyuyueYesnoTypes) {
        this.weixiuyuyueYesnoTypes = weixiuyuyueYesnoTypes;
    }
    /**
	 * 获取：审核意见
	 */
    public String getWeixiuyuyueYesnoText() {
        return weixiuyuyueYesnoText;
    }
    /**
	 * 设置：审核意见
	 */

    public void setWeixiuyuyueYesnoText(String weixiuyuyueYesnoText) {
        this.weixiuyuyueYesnoText = weixiuyuyueYesnoText;
    }
    /**
	 * 获取：审核时间
	 */
    public Date getWeixiuyuyueShenheTime() {
        return weixiuyuyueShenheTime;
    }
    /**
	 * 设置：审核时间
	 */

    public void setWeixiuyuyueShenheTime(Date weixiuyuyueShenheTime) {
        this.weixiuyuyueShenheTime = weixiuyuyueShenheTime;
    }
    /**
	 * 获取：创建时间   listShow
	 */
    public Date getCreateTime() {
        return createTime;
    }
    /**
	 * 设置：创建时间   listShow
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "Weixiuyuyue{" +
            ", id=" + id +
            ", yonghuId=" + yonghuId +
            ", weixiuyuanId=" + weixiuyuanId +
            ", weixiuyuyueName=" + weixiuyuyueName +
            ", weixiuyuyueUuidNumber=" + weixiuyuyueUuidNumber +
            ", weixiuyuyuePhoto=" + weixiuyuyuePhoto +
            ", weixiuyuyueTypes=" + weixiuyuyueTypes +
            ", yuyueTime=" + DateUtil.convertString(yuyueTime,"yyyy-MM-dd") +
            ", weixiuyuyueContent=" + weixiuyuyueContent +
            ", insertTime=" + DateUtil.convertString(insertTime,"yyyy-MM-dd") +
            ", weixiuyuyueYesnoTypes=" + weixiuyuyueYesnoTypes +
            ", weixiuyuyueYesnoText=" + weixiuyuyueYesnoText +
            ", weixiuyuyueShenheTime=" + DateUtil.convertString(weixiuyuyueShenheTime,"yyyy-MM-dd") +
            ", createTime=" + DateUtil.convertString(createTime,"yyyy-MM-dd") +
        "}";
    }
}
