package com.entity.model;

import com.entity.WeixiudingdanEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 物品维修订单
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class WeixiudingdanModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 维修员
     */
    private Integer weixiuyuanId;


    /**
     * 用户
     */
    private Integer yonghuId;


    /**
     * 维修编号
     */
    private String weixiudingdanUuidNumber;


    /**
     * 物品名称
     */
    private String weixiudingdanName;


    /**
     * 物品照片
     */
    private String weixiudingdanPhoto;


    /**
     * 维修类型
     */
    private Integer weixiuyuyueTypes;


    /**
     * 维修价格
     */
    private Double weixiudingdanBaojia;


    /**
     * 维修时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date yuyueTime;


    /**
     * 维修内容
     */
    private String weixiudingdanContent;


    /**
     * 维修状态
     */
    private Integer weixiudingdanTypes;


    /**
     * 录入时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date insertTime;


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
