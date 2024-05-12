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
 * 维修员
 *
 * @author 
 * @email
 */
@TableName("weixiuyuan")
public class WeixiuyuanEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public WeixiuyuanEntity() {

	}

	public WeixiuyuanEntity(T t) {
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
     * 账户
     */
    @ColumnInfo(comment="账户",type="varchar(200)")
    @TableField(value = "username")

    private String username;


    /**
     * 密码
     */
    @ColumnInfo(comment="密码",type="varchar(200)")
    @TableField(value = "password")

    private String password;


    /**
     * 维修员姓名
     */
    @ColumnInfo(comment="维修员姓名",type="varchar(200)")
    @TableField(value = "weixiuyuan_name")

    private String weixiuyuanName;


    /**
     * 维修员手机号
     */
    @ColumnInfo(comment="维修员手机号",type="varchar(200)")
    @TableField(value = "weixiuyuan_phone")

    private String weixiuyuanPhone;


    /**
     * 维修员身份证号
     */
    @ColumnInfo(comment="维修员身份证号",type="varchar(200)")
    @TableField(value = "weixiuyuan_id_number")

    private String weixiuyuanIdNumber;


    /**
     * 维修员头像
     */
    @ColumnInfo(comment="维修员头像",type="varchar(200)")
    @TableField(value = "weixiuyuan_photo")

    private String weixiuyuanPhoto;


    /**
     * 性别
     */
    @ColumnInfo(comment="性别",type="int(11)")
    @TableField(value = "sex_types")

    private Integer sexTypes;


    /**
     * 维修员邮箱
     */
    @ColumnInfo(comment="维修员邮箱",type="varchar(200)")
    @TableField(value = "weixiuyuan_email")

    private String weixiuyuanEmail;


    /**
     * 创建时间
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

    @Override
    public String toString() {
        return "Weixiuyuan{" +
            ", id=" + id +
            ", username=" + username +
            ", password=" + password +
            ", weixiuyuanName=" + weixiuyuanName +
            ", weixiuyuanPhone=" + weixiuyuanPhone +
            ", weixiuyuanIdNumber=" + weixiuyuanIdNumber +
            ", weixiuyuanPhoto=" + weixiuyuanPhoto +
            ", sexTypes=" + sexTypes +
            ", weixiuyuanEmail=" + weixiuyuanEmail +
            ", createTime=" + DateUtil.convertString(createTime,"yyyy-MM-dd") +
        "}";
    }
}
