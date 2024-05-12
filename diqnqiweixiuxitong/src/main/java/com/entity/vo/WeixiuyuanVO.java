package com.entity.vo;

import com.entity.WeixiuyuanEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 维修员
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("weixiuyuan")
public class WeixiuyuanVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

    @TableField(value = "id")
    private Integer id;


    /**
     * 账户
     */

    @TableField(value = "username")
    private String username;


    /**
     * 密码
     */

    @TableField(value = "password")
    private String password;


    /**
     * 维修员姓名
     */

    @TableField(value = "weixiuyuan_name")
    private String weixiuyuanName;


    /**
     * 维修员手机号
     */

    @TableField(value = "weixiuyuan_phone")
    private String weixiuyuanPhone;


    /**
     * 维修员身份证号
     */

    @TableField(value = "weixiuyuan_id_number")
    private String weixiuyuanIdNumber;


    /**
     * 维修员头像
     */

    @TableField(value = "weixiuyuan_photo")
    private String weixiuyuanPhoto;


    /**
     * 性别
     */

    @TableField(value = "sex_types")
    private Integer sexTypes;


    /**
     * 维修员邮箱
     */

    @TableField(value = "weixiuyuan_email")
    private String weixiuyuanEmail;


    /**
     * 创建时间
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
	 * 设置：账户
	 */
    public String getUsername() {
        return username;
    }


    /**
	 * 获取：账户
	 */

    public void setUsername(String username) {
        this.username = username;
    }
    /**
	 * 设置：密码
	 */
    public String getPassword() {
        return password;
    }


    /**
	 * 获取：密码
	 */

    public void setPassword(String password) {
        this.password = password;
    }
    /**
	 * 设置：维修员姓名
	 */
    public String getWeixiuyuanName() {
        return weixiuyuanName;
    }


    /**
	 * 获取：维修员姓名
	 */

    public void setWeixiuyuanName(String weixiuyuanName) {
        this.weixiuyuanName = weixiuyuanName;
    }
    /**
	 * 设置：维修员手机号
	 */
    public String getWeixiuyuanPhone() {
        return weixiuyuanPhone;
    }


    /**
	 * 获取：维修员手机号
	 */

    public void setWeixiuyuanPhone(String weixiuyuanPhone) {
        this.weixiuyuanPhone = weixiuyuanPhone;
    }
    /**
	 * 设置：维修员身份证号
	 */
    public String getWeixiuyuanIdNumber() {
        return weixiuyuanIdNumber;
    }


    /**
	 * 获取：维修员身份证号
	 */

    public void setWeixiuyuanIdNumber(String weixiuyuanIdNumber) {
        this.weixiuyuanIdNumber = weixiuyuanIdNumber;
    }
    /**
	 * 设置：维修员头像
	 */
    public String getWeixiuyuanPhoto() {
        return weixiuyuanPhoto;
    }


    /**
	 * 获取：维修员头像
	 */

    public void setWeixiuyuanPhoto(String weixiuyuanPhoto) {
        this.weixiuyuanPhoto = weixiuyuanPhoto;
    }
    /**
	 * 设置：性别
	 */
    public Integer getSexTypes() {
        return sexTypes;
    }


    /**
	 * 获取：性别
	 */

    public void setSexTypes(Integer sexTypes) {
        this.sexTypes = sexTypes;
    }
    /**
	 * 设置：维修员邮箱
	 */
    public String getWeixiuyuanEmail() {
        return weixiuyuanEmail;
    }


    /**
	 * 获取：维修员邮箱
	 */

    public void setWeixiuyuanEmail(String weixiuyuanEmail) {
        this.weixiuyuanEmail = weixiuyuanEmail;
    }
    /**
	 * 设置：创建时间
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 获取：创建时间
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

}
