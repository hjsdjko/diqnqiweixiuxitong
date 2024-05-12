package com.entity.model;

import com.entity.WeixiuyuanEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 维修员
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class WeixiuyuanModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 账户
     */
    private String username;


    /**
     * 密码
     */
    private String password;


    /**
     * 维修员姓名
     */
    private String weixiuyuanName;


    /**
     * 维修员手机号
     */
    private String weixiuyuanPhone;


    /**
     * 维修员身份证号
     */
    private String weixiuyuanIdNumber;


    /**
     * 维修员头像
     */
    private String weixiuyuanPhoto;


    /**
     * 性别
     */
    private Integer sexTypes;


    /**
     * 维修员邮箱
     */
    private String weixiuyuanEmail;


    /**
     * 创建时间
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
	 * 获取：账户
	 */
    public String getUsername() {
        return username;
    }


    /**
	 * 设置：账户
	 */
    public void setUsername(String username) {
        this.username = username;
    }
    /**
	 * 获取：密码
	 */
    public String getPassword() {
        return password;
    }


    /**
	 * 设置：密码
	 */
    public void setPassword(String password) {
        this.password = password;
    }
    /**
	 * 获取：维修员姓名
	 */
    public String getWeixiuyuanName() {
        return weixiuyuanName;
    }


    /**
	 * 设置：维修员姓名
	 */
    public void setWeixiuyuanName(String weixiuyuanName) {
        this.weixiuyuanName = weixiuyuanName;
    }
    /**
	 * 获取：维修员手机号
	 */
    public String getWeixiuyuanPhone() {
        return weixiuyuanPhone;
    }


    /**
	 * 设置：维修员手机号
	 */
    public void setWeixiuyuanPhone(String weixiuyuanPhone) {
        this.weixiuyuanPhone = weixiuyuanPhone;
    }
    /**
	 * 获取：维修员身份证号
	 */
    public String getWeixiuyuanIdNumber() {
        return weixiuyuanIdNumber;
    }


    /**
	 * 设置：维修员身份证号
	 */
    public void setWeixiuyuanIdNumber(String weixiuyuanIdNumber) {
        this.weixiuyuanIdNumber = weixiuyuanIdNumber;
    }
    /**
	 * 获取：维修员头像
	 */
    public String getWeixiuyuanPhoto() {
        return weixiuyuanPhoto;
    }


    /**
	 * 设置：维修员头像
	 */
    public void setWeixiuyuanPhoto(String weixiuyuanPhoto) {
        this.weixiuyuanPhoto = weixiuyuanPhoto;
    }
    /**
	 * 获取：性别
	 */
    public Integer getSexTypes() {
        return sexTypes;
    }


    /**
	 * 设置：性别
	 */
    public void setSexTypes(Integer sexTypes) {
        this.sexTypes = sexTypes;
    }
    /**
	 * 获取：维修员邮箱
	 */
    public String getWeixiuyuanEmail() {
        return weixiuyuanEmail;
    }


    /**
	 * 设置：维修员邮箱
	 */
    public void setWeixiuyuanEmail(String weixiuyuanEmail) {
        this.weixiuyuanEmail = weixiuyuanEmail;
    }
    /**
	 * 获取：创建时间
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 设置：创建时间
	 */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    }
