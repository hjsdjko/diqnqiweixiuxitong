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
 * 物品维修订单
 *
 * @author 
 * @email
 */
@TableName("weixiudingdan")
public class WeixiudingdanEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public WeixiudingdanEntity() {

	}

	public WeixiudingdanEntity(T t) {
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
     * 维修员
     */
    @ColumnInfo(comment="维修员",type="int(11)")
    @TableField(value = "weixiuyuan_id")

    private Integer weixiuyuanId;


    /**
     * 用户
     */
    @ColumnInfo(comment="用户",type="int(11)")
    @TableField(value = "yonghu_id")

    private Integer yonghuId;


    /**
     * 维修编号
     */
    @ColumnInfo(comment="维修编号",type="varchar(200)")
    @TableField(value = "weixiudingdan_uuid_number")

    private String weixiudingdanUuidNumber;


    /**
     * 物品名称
     */
    @ColumnInfo(comment="物品名称",type="varchar(200)")
    @TableField(value = "weixiudingdan_name")

    private String weixiudingdanName;


    /**
     * 物品照片
     */
    @ColumnInfo(comment="物品照片",type="varchar(200)")
    @TableField(value = "weixiudingdan_photo")

    private String weixiudingdanPhoto;


    /**
     * 维修类型
     */
    @ColumnInfo(comment="维修类型",type="int(11)")
    @TableField(value = "weixiuyuyue_types")

    private Integer weixiuyuyueTypes;


    /**
     * 维修价格
     */
    @ColumnInfo(comment="维修价格",type="decimal(10,2)")
    @TableField(value = "weixiudingdan_baojia")

    private Double weixiudingdanBaojia;


    /**
     * 维修时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @ColumnInfo(comment="维修时间",type="timestamp")
    @TableField(value = "yuyue_time")

    private Date yuyueTime;


    /**
     * 维修内容
     */
    @ColumnInfo(comment="维修内容",type="text")
    @TableField(value = "weixiudingdan_content")

    private String weixiudingdanContent;


    /**
     * 维修状态
     */
    @ColumnInfo(comment="维修状态",type="int(11)")
    @TableField(value = "weixiudingdan_types")

    private Integer weixiudingdanTypes;


    /**
     * 录入时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @ColumnInfo(comment="录入时间",type="timestamp")
    @TableField(value = "insert_time",fill = FieldFill.INSERT)

    private Date insertTime;


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
	 * 获取：维修编号
	 */
    public String getWeixiudingdanUuidNumber() {
        return weixiudingdanUuidNumber;
    }
    /**
	 * 设置：维修编号
	 */

    public void setWeixiudingdanUuidNumber(String weixiudingdanUuidNumber) {
        this.weixiudingdanUuidNumber = weixiudingdanUuidNumber;
    }
    /**
	 * 获取：物品名称
	 */
    public String getWeixiudingdanName() {
        return weixiudingdanName;
    }
    /**
	 * 设置：物品名称
	 */

    public void setWeixiudingdanName(String weixiudingdanName) {
        this.weixiudingdanName = weixiudingdanName;
    }
    /**
	 * 获取：物品照片
	 */
    public String getWeixiudingdanPhoto() {
        return weixiudingdanPhoto;
    }
    /**
	 * 设置：物品照片
	 */

    public void setWeixiudingdanPhoto(String weixiudingdanPhoto) {
        this.weixiudingdanPhoto = weixiudingdanPhoto;
    }
    /**
	 * 获取：维修类型
	 */
    public Integer getWeixiuyuyueTypes() {
        return weixiuyuyueTypes;
    }
    /**
	 * 设置：维修类型
	 */

    public void setWeixiuyuyueTypes(Integer weixiuyuyueTypes) {
        this.weixiuyuyueTypes = weixiuyuyueTypes;
    }
    /**
	 * 获取：维修价格
	 */
    public Double getWeixiudingdanBaojia() {
        return weixiudingdanBaojia;
    }
    /**
	 * 设置：维修价格
	 */

    public void setWeixiudingdanBaojia(Double weixiudingdanBaojia) {
        this.weixiudingdanBaojia = weixiudingdanBaojia;
    }
    /**
	 * 获取：维修时间
	 */
    public Date getYuyueTime() {
        return yuyueTime;
    }
    /**
	 * 设置：维修时间
	 */

    public void setYuyueTime(Date yuyueTime) {
        this.yuyueTime = yuyueTime;
    }
    /**
	 * 获取：维修内容
	 */
    public String getWeixiudingdanContent() {
        return weixiudingdanContent;
    }
    /**
	 * 设置：维修内容
	 */

    public void setWeixiudingdanContent(String weixiudingdanContent) {
        this.weixiudingdanContent = weixiudingdanContent;
    }
    /**
	 * 获取：维修状态
	 */
    public Integer getWeixiudingdanTypes() {
        return weixiudingdanTypes;
    }
    /**
	 * 设置：维修状态
	 */

    public void setWeixiudingdanTypes(Integer weixiudingdanTypes) {
        this.weixiudingdanTypes = weixiudingdanTypes;
    }
    /**
	 * 获取：录入时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }
    /**
	 * 设置：录入时间
	 */

    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
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
        return "Weixiudingdan{" +
            ", id=" + id +
            ", weixiuyuanId=" + weixiuyuanId +
            ", yonghuId=" + yonghuId +
            ", weixiudingdanUuidNumber=" + weixiudingdanUuidNumber +
            ", weixiudingdanName=" + weixiudingdanName +
            ", weixiudingdanPhoto=" + weixiudingdanPhoto +
            ", weixiuyuyueTypes=" + weixiuyuyueTypes +
            ", weixiudingdanBaojia=" + weixiudingdanBaojia +
            ", yuyueTime=" + DateUtil.convertString(yuyueTime,"yyyy-MM-dd") +
            ", weixiudingdanContent=" + weixiudingdanContent +
            ", weixiudingdanTypes=" + weixiudingdanTypes +
            ", insertTime=" + DateUtil.convertString(insertTime,"yyyy-MM-dd") +
            ", createTime=" + DateUtil.convertString(createTime,"yyyy-MM-dd") +
        "}";
    }
}
