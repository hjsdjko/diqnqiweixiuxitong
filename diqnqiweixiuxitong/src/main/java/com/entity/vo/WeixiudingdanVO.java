package com.entity.vo;

import com.entity.WeixiudingdanEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 物品维修订单
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("weixiudingdan")
public class WeixiudingdanVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

    @TableField(value = "id")
    private Integer id;


    /**
     * 维修员
     */

    @TableField(value = "weixiuyuan_id")
    private Integer weixiuyuanId;


    /**
     * 用户
     */

    @TableField(value = "yonghu_id")
    private Integer yonghuId;


    /**
     * 维修编号
     */

    @TableField(value = "weixiudingdan_uuid_number")
    private String weixiudingdanUuidNumber;


    /**
     * 物品名称
     */

    @TableField(value = "weixiudingdan_name")
    private String weixiudingdanName;


    /**
     * 物品照片
     */

    @TableField(value = "weixiudingdan_photo")
    private String weixiudingdanPhoto;


    /**
     * 维修类型
     */

    @TableField(value = "weixiuyuyue_types")
    private Integer weixiuyuyueTypes;


    /**
     * 维修价格
     */

    @TableField(value = "weixiudingdan_baojia")
    private Double weixiudingdanBaojia;


    /**
     * 维修时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "yuyue_time")
    private Date yuyueTime;


    /**
     * 维修内容
     */

    @TableField(value = "weixiudingdan_content")
    private String weixiudingdanContent;


    /**
     * 维修状态
     */

    @TableField(value = "weixiudingdan_types")
    private Integer weixiudingdanTypes;


    /**
     * 录入时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "insert_time")
    private Date insertTime;


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
	 * 设置：维修编号
	 */
    public String getWeixiudingdanUuidNumber() {
        return weixiudingdanUuidNumber;
    }


    /**
	 * 获取：维修编号
	 */

    public void setWeixiudingdanUuidNumber(String weixiudingdanUuidNumber) {
        this.weixiudingdanUuidNumber = weixiudingdanUuidNumber;
    }
    /**
	 * 设置：物品名称
	 */
    public String getWeixiudingdanName() {
        return weixiudingdanName;
    }


    /**
	 * 获取：物品名称
	 */

    public void setWeixiudingdanName(String weixiudingdanName) {
        this.weixiudingdanName = weixiudingdanName;
    }
    /**
	 * 设置：物品照片
	 */
    public String getWeixiudingdanPhoto() {
        return weixiudingdanPhoto;
    }


    /**
	 * 获取：物品照片
	 */

    public void setWeixiudingdanPhoto(String weixiudingdanPhoto) {
        this.weixiudingdanPhoto = weixiudingdanPhoto;
    }
    /**
	 * 设置：维修类型
	 */
    public Integer getWeixiuyuyueTypes() {
        return weixiuyuyueTypes;
    }


    /**
	 * 获取：维修类型
	 */

    public void setWeixiuyuyueTypes(Integer weixiuyuyueTypes) {
        this.weixiuyuyueTypes = weixiuyuyueTypes;
    }
    /**
	 * 设置：维修价格
	 */
    public Double getWeixiudingdanBaojia() {
        return weixiudingdanBaojia;
    }


    /**
	 * 获取：维修价格
	 */

    public void setWeixiudingdanBaojia(Double weixiudingdanBaojia) {
        this.weixiudingdanBaojia = weixiudingdanBaojia;
    }
    /**
	 * 设置：维修时间
	 */
    public Date getYuyueTime() {
        return yuyueTime;
    }


    /**
	 * 获取：维修时间
	 */

    public void setYuyueTime(Date yuyueTime) {
        this.yuyueTime = yuyueTime;
    }
    /**
	 * 设置：维修内容
	 */
    public String getWeixiudingdanContent() {
        return weixiudingdanContent;
    }


    /**
	 * 获取：维修内容
	 */

    public void setWeixiudingdanContent(String weixiudingdanContent) {
        this.weixiudingdanContent = weixiudingdanContent;
    }
    /**
	 * 设置：维修状态
	 */
    public Integer getWeixiudingdanTypes() {
        return weixiudingdanTypes;
    }


    /**
	 * 获取：维修状态
	 */

    public void setWeixiudingdanTypes(Integer weixiudingdanTypes) {
        this.weixiudingdanTypes = weixiudingdanTypes;
    }
    /**
	 * 设置：录入时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }


    /**
	 * 获取：录入时间
	 */

    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
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
