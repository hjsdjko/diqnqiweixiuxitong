package com.entity.vo;

import com.entity.WeixiuyuyueEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 物品维修预约
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("weixiuyuyue")
public class WeixiuyuyueVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

    @TableField(value = "id")
    private Integer id;


    /**
     * 用户
     */

    @TableField(value = "yonghu_id")
    private Integer yonghuId;


    /**
     * 维修员
     */

    @TableField(value = "weixiuyuan_id")
    private Integer weixiuyuanId;


    /**
     * 物品名称
     */

    @TableField(value = "weixiuyuyue_name")
    private String weixiuyuyueName;


    /**
     * 预约编号
     */

    @TableField(value = "weixiuyuyue_uuid_number")
    private String weixiuyuyueUuidNumber;


    /**
     * 物品照片
     */

    @TableField(value = "weixiuyuyue_photo")
    private String weixiuyuyuePhoto;


    /**
     * 物品维修类型
     */

    @TableField(value = "weixiuyuyue_types")
    private Integer weixiuyuyueTypes;


    /**
     * 预约维修时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "yuyue_time")
    private Date yuyueTime;


    /**
     * 物品损坏详情
     */

    @TableField(value = "weixiuyuyue_content")
    private String weixiuyuyueContent;


    /**
     * 申请时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "insert_time")
    private Date insertTime;


    /**
     * 预约状态
     */

    @TableField(value = "weixiuyuyue_yesno_types")
    private Integer weixiuyuyueYesnoTypes;


    /**
     * 审核意见
     */

    @TableField(value = "weixiuyuyue_yesno_text")
    private String weixiuyuyueYesnoText;


    /**
     * 审核时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "weixiuyuyue_shenhe_time")
    private Date weixiuyuyueShenheTime;


    /**
     * 创建时间  show3 listShow
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "create_time")
    private Date createTime;


    /**
	 * 设置：主键
	 */
    public Integer getId() {
        return id;
    }


    /**
	 * 获取：主键
	 */

    public void setId(Integer id) {
        this.id = id;
    }
    /**
	 * 设置：用户
	 */
    public Integer getYonghuId() {
        return yonghuId;
    }


    /**
	 * 获取：用户
	 */

    public void setYonghuId(Integer yonghuId) {
        this.yonghuId = yonghuId;
    }
    /**
	 * 设置：维修员
	 */
    public Integer getWeixiuyuanId() {
        return weixiuyuanId;
    }


    /**
	 * 获取：维修员
	 */

    public void setWeixiuyuanId(Integer weixiuyuanId) {
        this.weixiuyuanId = weixiuyuanId;
    }
    /**
	 * 设置：物品名称
	 */
    public String getWeixiuyuyueName() {
        return weixiuyuyueName;
    }


    /**
	 * 获取：物品名称
	 */

    public void setWeixiuyuyueName(String weixiuyuyueName) {
        this.weixiuyuyueName = weixiuyuyueName;
    }
    /**
	 * 设置：预约编号
	 */
    public String getWeixiuyuyueUuidNumber() {
        return weixiuyuyueUuidNumber;
    }


    /**
	 * 获取：预约编号
	 */

    public void setWeixiuyuyueUuidNumber(String weixiuyuyueUuidNumber) {
        this.weixiuyuyueUuidNumber = weixiuyuyueUuidNumber;
    }
    /**
	 * 设置：物品照片
	 */
    public String getWeixiuyuyuePhoto() {
        return weixiuyuyuePhoto;
    }


    /**
	 * 获取：物品照片
	 */

    public void setWeixiuyuyuePhoto(String weixiuyuyuePhoto) {
        this.weixiuyuyuePhoto = weixiuyuyuePhoto;
    }
    /**
	 * 设置：物品维修类型
	 */
    public Integer getWeixiuyuyueTypes() {
        return weixiuyuyueTypes;
    }


    /**
	 * 获取：物品维修类型
	 */

    public void setWeixiuyuyueTypes(Integer weixiuyuyueTypes) {
        this.weixiuyuyueTypes = weixiuyuyueTypes;
    }
    /**
	 * 设置：预约维修时间
	 */
    public Date getYuyueTime() {
        return yuyueTime;
    }


    /**
	 * 获取：预约维修时间
	 */

    public void setYuyueTime(Date yuyueTime) {
        this.yuyueTime = yuyueTime;
    }
    /**
	 * 设置：物品损坏详情
	 */
    public String getWeixiuyuyueContent() {
        return weixiuyuyueContent;
    }


    /**
	 * 获取：物品损坏详情
	 */

    public void setWeixiuyuyueContent(String weixiuyuyueContent) {
        this.weixiuyuyueContent = weixiuyuyueContent;
    }
    /**
	 * 设置：申请时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }


    /**
	 * 获取：申请时间
	 */

    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }
    /**
	 * 设置：预约状态
	 */
    public Integer getWeixiuyuyueYesnoTypes() {
        return weixiuyuyueYesnoTypes;
    }


    /**
	 * 获取：预约状态
	 */

    public void setWeixiuyuyueYesnoTypes(Integer weixiuyuyueYesnoTypes) {
        this.weixiuyuyueYesnoTypes = weixiuyuyueYesnoTypes;
    }
    /**
	 * 设置：审核意见
	 */
    public String getWeixiuyuyueYesnoText() {
        return weixiuyuyueYesnoText;
    }


    /**
	 * 获取：审核意见
	 */

    public void setWeixiuyuyueYesnoText(String weixiuyuyueYesnoText) {
        this.weixiuyuyueYesnoText = weixiuyuyueYesnoText;
    }
    /**
	 * 设置：审核时间
	 */
    public Date getWeixiuyuyueShenheTime() {
        return weixiuyuyueShenheTime;
    }


    /**
	 * 获取：审核时间
	 */

    public void setWeixiuyuyueShenheTime(Date weixiuyuyueShenheTime) {
        this.weixiuyuyueShenheTime = weixiuyuyueShenheTime;
    }
    /**
	 * 设置：创建时间  show3 listShow
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 获取：创建时间  show3 listShow
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

}
