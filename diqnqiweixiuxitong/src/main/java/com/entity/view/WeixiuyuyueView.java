package com.entity.view;

import org.apache.tools.ant.util.DateUtils;
import com.annotation.ColumnInfo;
import com.entity.WeixiuyuyueEntity;
import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;
import com.utils.DateUtil;

/**
* 物品维修预约
* 后端返回视图实体辅助类
* （通常后端关联的表或者自定义的字段需要返回使用）
*/
@TableName("weixiuyuyue")
public class WeixiuyuyueView extends WeixiuyuyueEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	//当前表
	/**
	* 物品维修类型的值
	*/
	@ColumnInfo(comment="物品维修类型的字典表值",type="varchar(200)")
	private String weixiuyuyueValue;
	/**
	* 预约状态的值
	*/
	@ColumnInfo(comment="预约状态的字典表值",type="varchar(200)")
	private String weixiuyuyueYesnoValue;

	//级联表 维修员
		/**
		* 维修员姓名
		*/

		@ColumnInfo(comment="维修员姓名",type="varchar(200)")
		private String weixiuyuanName;
		/**
		* 维修员手机号
		*/

		@ColumnInfo(comment="维修员手机号",type="varchar(200)")
		private String weixiuyuanPhone;
		/**
		* 维修员身份证号
		*/

		@ColumnInfo(comment="维修员身份证号",type="varchar(200)")
		private String weixiuyuanIdNumber;
		/**
		* 维修员头像
		*/

		@ColumnInfo(comment="维修员头像",type="varchar(200)")
		private String weixiuyuanPhoto;
		/**
		* 维修员邮箱
		*/

		@ColumnInfo(comment="维修员邮箱",type="varchar(200)")
		private String weixiuyuanEmail;
	//级联表 用户
		/**
		* 用户姓名
		*/

		@ColumnInfo(comment="用户姓名",type="varchar(200)")
		private String yonghuName;
		/**
		* 用户手机号
		*/

		@ColumnInfo(comment="用户手机号",type="varchar(200)")
		private String yonghuPhone;
		/**
		* 用户身份证号
		*/

		@ColumnInfo(comment="用户身份证号",type="varchar(200)")
		private String yonghuIdNumber;
		/**
		* 用户头像
		*/

		@ColumnInfo(comment="用户头像",type="varchar(200)")
		private String yonghuPhoto;
		/**
		* 余额
		*/
		@ColumnInfo(comment="余额",type="decimal(10,2)")
		private Double newMoney;
		/**
		* 用户邮箱
		*/

		@ColumnInfo(comment="用户邮箱",type="varchar(200)")
		private String yonghuEmail;

	//重复字段
			/**
			* 重复字段 的types
			*/
			@ColumnInfo(comment="重复字段 的types",type="Integer")
			private Integer sexTypes;
				@ColumnInfo(comment="重复字段 的值",type="varchar(200)")
				private String sexValue;


	public WeixiuyuyueView() {

	}

	public WeixiuyuyueView(WeixiuyuyueEntity weixiuyuyueEntity) {
		try {
			BeanUtils.copyProperties(this, weixiuyuyueEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



	//当前表的
	/**
	* 获取： 物品维修类型的值
	*/
	public String getWeixiuyuyueValue() {
		return weixiuyuyueValue;
	}
	/**
	* 设置： 物品维修类型的值
	*/
	public void setWeixiuyuyueValue(String weixiuyuyueValue) {
		this.weixiuyuyueValue = weixiuyuyueValue;
	}
	//当前表的
	/**
	* 获取： 预约状态的值
	*/
	public String getWeixiuyuyueYesnoValue() {
		return weixiuyuyueYesnoValue;
	}
	/**
	* 设置： 预约状态的值
	*/
	public void setWeixiuyuyueYesnoValue(String weixiuyuyueYesnoValue) {
		this.weixiuyuyueYesnoValue = weixiuyuyueYesnoValue;
	}


	//级联表的get和set 维修员

		/**
		* 获取： 维修员姓名
		*/
		public String getWeixiuyuanName() {
			return weixiuyuanName;
		}
		/**
		* 设置： 维修员姓名
		*/
		public void setWeixiuyuanName(String weixiuyuanName) {
			this.weixiuyuanName = weixiuyuanName;
		}

		/**
		* 获取： 维修员手机号
		*/
		public String getWeixiuyuanPhone() {
			return weixiuyuanPhone;
		}
		/**
		* 设置： 维修员手机号
		*/
		public void setWeixiuyuanPhone(String weixiuyuanPhone) {
			this.weixiuyuanPhone = weixiuyuanPhone;
		}

		/**
		* 获取： 维修员身份证号
		*/
		public String getWeixiuyuanIdNumber() {
			return weixiuyuanIdNumber;
		}
		/**
		* 设置： 维修员身份证号
		*/
		public void setWeixiuyuanIdNumber(String weixiuyuanIdNumber) {
			this.weixiuyuanIdNumber = weixiuyuanIdNumber;
		}

		/**
		* 获取： 维修员头像
		*/
		public String getWeixiuyuanPhoto() {
			return weixiuyuanPhoto;
		}
		/**
		* 设置： 维修员头像
		*/
		public void setWeixiuyuanPhoto(String weixiuyuanPhoto) {
			this.weixiuyuanPhoto = weixiuyuanPhoto;
		}

		/**
		* 获取： 维修员邮箱
		*/
		public String getWeixiuyuanEmail() {
			return weixiuyuanEmail;
		}
		/**
		* 设置： 维修员邮箱
		*/
		public void setWeixiuyuanEmail(String weixiuyuanEmail) {
			this.weixiuyuanEmail = weixiuyuanEmail;
		}
	//级联表的get和set 用户

		/**
		* 获取： 用户姓名
		*/
		public String getYonghuName() {
			return yonghuName;
		}
		/**
		* 设置： 用户姓名
		*/
		public void setYonghuName(String yonghuName) {
			this.yonghuName = yonghuName;
		}

		/**
		* 获取： 用户手机号
		*/
		public String getYonghuPhone() {
			return yonghuPhone;
		}
		/**
		* 设置： 用户手机号
		*/
		public void setYonghuPhone(String yonghuPhone) {
			this.yonghuPhone = yonghuPhone;
		}

		/**
		* 获取： 用户身份证号
		*/
		public String getYonghuIdNumber() {
			return yonghuIdNumber;
		}
		/**
		* 设置： 用户身份证号
		*/
		public void setYonghuIdNumber(String yonghuIdNumber) {
			this.yonghuIdNumber = yonghuIdNumber;
		}

		/**
		* 获取： 用户头像
		*/
		public String getYonghuPhoto() {
			return yonghuPhoto;
		}
		/**
		* 设置： 用户头像
		*/
		public void setYonghuPhoto(String yonghuPhoto) {
			this.yonghuPhoto = yonghuPhoto;
		}

		/**
		* 获取： 余额
		*/
		public Double getNewMoney() {
			return newMoney;
		}
		/**
		* 设置： 余额
		*/
		public void setNewMoney(Double newMoney) {
			this.newMoney = newMoney;
		}

		/**
		* 获取： 用户邮箱
		*/
		public String getYonghuEmail() {
			return yonghuEmail;
		}
		/**
		* 设置： 用户邮箱
		*/
		public void setYonghuEmail(String yonghuEmail) {
			this.yonghuEmail = yonghuEmail;
		}

	//重复字段
			/**
			* 获取： 重复字段 的types
			*/
			public Integer getSexTypes() {
			return sexTypes;
			}
			/**
			* 设置： 重复字段 的types
			*/
			public void setSexTypes(Integer sexTypes) {
			this.sexTypes = sexTypes;
			}
				public String getSexValue() {
				return sexValue;
				}
				public void setSexValue(String sexValue) {
				this.sexValue = sexValue;
				}

	@Override
	public String toString() {
		return "WeixiuyuyueView{" +
			", weixiuyuyueValue=" + weixiuyuyueValue +
			", weixiuyuyueYesnoValue=" + weixiuyuyueYesnoValue +
			", weixiuyuanName=" + weixiuyuanName +
			", weixiuyuanPhone=" + weixiuyuanPhone +
			", weixiuyuanIdNumber=" + weixiuyuanIdNumber +
			", weixiuyuanPhoto=" + weixiuyuanPhoto +
			", weixiuyuanEmail=" + weixiuyuanEmail +
			", yonghuName=" + yonghuName +
			", yonghuPhone=" + yonghuPhone +
			", yonghuIdNumber=" + yonghuIdNumber +
			", yonghuPhoto=" + yonghuPhoto +
			", newMoney=" + newMoney +
			", yonghuEmail=" + yonghuEmail +
			"} " + super.toString();
	}
}
