package com.entity.model;

import com.entity.WeixiuyuyueEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 物品维修预约
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class WeixiuyuyueModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 用户
     */
    private Integer yonghuId;


    /**
     * 维修员
     */
    private Integer weixiuyuanId;


    /**
     * 物品名称
     */
    private String weixiuyuyueName;


    /**
     * 预约编号
     */
    private String weixiuyuyueUuidNumber;


    /**
     * 物品照片
     */
    private String weixiuyuyuePhoto;


    /**
     * 物品维修类型
     */
    private Integer weixiuyuyueTypes;


    /**
     * 预约维修时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date yuyueTime;


    /**
     * 物品损坏详情
     */
    private String weixiuyuyueContent;


    /**
     * 申请时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date insertTime;


    /**
     * 预约状态
     */
    private Integer weixiuyuyueYesnoTypes;


    /**
     * 审核意见
     */
    private String weixiuyuyueYesnoText;


    /**
     * 审核时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date weixiuyuyueShenheTime;


    /**
     * 创建时间  show3 listShow
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
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
	 * 获取：创建时间  show3 listShow
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 设置：创建时间  show3 listShow
	 */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    }
