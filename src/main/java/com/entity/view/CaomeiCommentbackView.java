package com.entity.view;

import org.apache.tools.ant.util.DateUtils;
import com.annotation.ColumnInfo;
import com.entity.CaomeiCommentbackEntity;
import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;
import com.utils.DateUtil;

/**
* 草莓评价
* 后端返回视图实体辅助类
* （通常后端关联的表或者自定义的字段需要返回使用）
*/
@TableName("caomei_commentback")
public class CaomeiCommentbackView extends CaomeiCommentbackEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	//当前表

	//级联表 草莓
		/**
		* 草莓名称
		*/

		@ColumnInfo(comment="草莓名称",type="varchar(200)")
		private String caomeiName;
		/**
		* 草莓编号
		*/

		@ColumnInfo(comment="草莓编号",type="varchar(200)")
		private String caomeiUuidNumber;
		/**
		* 草莓照片
		*/

		@ColumnInfo(comment="草莓照片",type="varchar(200)")
		private String caomeiPhoto;
		/**
		* 草莓类型
		*/
		@ColumnInfo(comment="草莓类型",type="int(11)")
		private Integer caomeiTypes;
			/**
			* 草莓类型的值
			*/
			@ColumnInfo(comment="草莓类型的字典表值",type="varchar(200)")
			private String caomeiValue;
		/**
		* 草莓库存
		*/

		@ColumnInfo(comment="草莓库存",type="int(11)")
		private Integer caomeiKucunNumber;
		/**
		* 草莓原价
		*/
		@ColumnInfo(comment="草莓原价",type="decimal(10,2)")
		private Double caomeiOldMoney;
		/**
		* 现价/斤
		*/
		@ColumnInfo(comment="现价/斤",type="decimal(10,2)")
		private Double caomeiNewMoney;
		/**
		* 所属仓库
		*/

		@ColumnInfo(comment="所属仓库",type="varchar(200)")
		private String caomeiCangku;
		/**
		* 草莓热度
		*/

		@ColumnInfo(comment="草莓热度",type="int(11)")
		private Integer caomeiClicknum;
		/**
		* 草莓介绍
		*/

		@ColumnInfo(comment="草莓介绍",type="longtext")
		private String caomeiContent;
		/**
		* 是否上架
		*/
		@ColumnInfo(comment="是否上架",type="int(11)")
		private Integer shangxiaTypes;
			/**
			* 是否上架的值
			*/
			@ColumnInfo(comment="是否上架的字典表值",type="varchar(200)")
			private String shangxiaValue;
		/**
		* 逻辑删除
		*/

		@ColumnInfo(comment="逻辑删除",type="int(11)")
		private Integer caomeiDelete;
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
		* 用户邮箱
		*/

		@ColumnInfo(comment="用户邮箱",type="varchar(200)")
		private String yonghuEmail;
		/**
		* 余额
		*/
		@ColumnInfo(comment="余额",type="decimal(10,2)")
		private Double newMoney;
		/**
		* 账户状态
		*/
		@ColumnInfo(comment="账户状态",type="int(11)")
		private Integer jinyongTypes;
			/**
			* 账户状态的值
			*/
			@ColumnInfo(comment="账户状态的字典表值",type="varchar(200)")
			private String jinyongValue;



	public CaomeiCommentbackView() {

	}

	public CaomeiCommentbackView(CaomeiCommentbackEntity caomeiCommentbackEntity) {
		try {
			BeanUtils.copyProperties(this, caomeiCommentbackEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}





	//级联表的get和set 草莓

		/**
		* 获取： 草莓名称
		*/
		public String getCaomeiName() {
			return caomeiName;
		}
		/**
		* 设置： 草莓名称
		*/
		public void setCaomeiName(String caomeiName) {
			this.caomeiName = caomeiName;
		}

		/**
		* 获取： 草莓编号
		*/
		public String getCaomeiUuidNumber() {
			return caomeiUuidNumber;
		}
		/**
		* 设置： 草莓编号
		*/
		public void setCaomeiUuidNumber(String caomeiUuidNumber) {
			this.caomeiUuidNumber = caomeiUuidNumber;
		}

		/**
		* 获取： 草莓照片
		*/
		public String getCaomeiPhoto() {
			return caomeiPhoto;
		}
		/**
		* 设置： 草莓照片
		*/
		public void setCaomeiPhoto(String caomeiPhoto) {
			this.caomeiPhoto = caomeiPhoto;
		}
		/**
		* 获取： 草莓类型
		*/
		public Integer getCaomeiTypes() {
			return caomeiTypes;
		}
		/**
		* 设置： 草莓类型
		*/
		public void setCaomeiTypes(Integer caomeiTypes) {
			this.caomeiTypes = caomeiTypes;
		}


			/**
			* 获取： 草莓类型的值
			*/
			public String getCaomeiValue() {
				return caomeiValue;
			}
			/**
			* 设置： 草莓类型的值
			*/
			public void setCaomeiValue(String caomeiValue) {
				this.caomeiValue = caomeiValue;
			}

		/**
		* 获取： 草莓库存
		*/
		public Integer getCaomeiKucunNumber() {
			return caomeiKucunNumber;
		}
		/**
		* 设置： 草莓库存
		*/
		public void setCaomeiKucunNumber(Integer caomeiKucunNumber) {
			this.caomeiKucunNumber = caomeiKucunNumber;
		}

		/**
		* 获取： 草莓原价
		*/
		public Double getCaomeiOldMoney() {
			return caomeiOldMoney;
		}
		/**
		* 设置： 草莓原价
		*/
		public void setCaomeiOldMoney(Double caomeiOldMoney) {
			this.caomeiOldMoney = caomeiOldMoney;
		}

		/**
		* 获取： 现价/斤
		*/
		public Double getCaomeiNewMoney() {
			return caomeiNewMoney;
		}
		/**
		* 设置： 现价/斤
		*/
		public void setCaomeiNewMoney(Double caomeiNewMoney) {
			this.caomeiNewMoney = caomeiNewMoney;
		}

		/**
		* 获取： 所属仓库
		*/
		public String getCaomeiCangku() {
			return caomeiCangku;
		}
		/**
		* 设置： 所属仓库
		*/
		public void setCaomeiCangku(String caomeiCangku) {
			this.caomeiCangku = caomeiCangku;
		}

		/**
		* 获取： 草莓热度
		*/
		public Integer getCaomeiClicknum() {
			return caomeiClicknum;
		}
		/**
		* 设置： 草莓热度
		*/
		public void setCaomeiClicknum(Integer caomeiClicknum) {
			this.caomeiClicknum = caomeiClicknum;
		}

		/**
		* 获取： 草莓介绍
		*/
		public String getCaomeiContent() {
			return caomeiContent;
		}
		/**
		* 设置： 草莓介绍
		*/
		public void setCaomeiContent(String caomeiContent) {
			this.caomeiContent = caomeiContent;
		}
		/**
		* 获取： 是否上架
		*/
		public Integer getShangxiaTypes() {
			return shangxiaTypes;
		}
		/**
		* 设置： 是否上架
		*/
		public void setShangxiaTypes(Integer shangxiaTypes) {
			this.shangxiaTypes = shangxiaTypes;
		}


			/**
			* 获取： 是否上架的值
			*/
			public String getShangxiaValue() {
				return shangxiaValue;
			}
			/**
			* 设置： 是否上架的值
			*/
			public void setShangxiaValue(String shangxiaValue) {
				this.shangxiaValue = shangxiaValue;
			}

		/**
		* 获取： 逻辑删除
		*/
		public Integer getCaomeiDelete() {
			return caomeiDelete;
		}
		/**
		* 设置： 逻辑删除
		*/
		public void setCaomeiDelete(Integer caomeiDelete) {
			this.caomeiDelete = caomeiDelete;
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
		* 获取： 账户状态
		*/
		public Integer getJinyongTypes() {
			return jinyongTypes;
		}
		/**
		* 设置： 账户状态
		*/
		public void setJinyongTypes(Integer jinyongTypes) {
			this.jinyongTypes = jinyongTypes;
		}


			/**
			* 获取： 账户状态的值
			*/
			public String getJinyongValue() {
				return jinyongValue;
			}
			/**
			* 设置： 账户状态的值
			*/
			public void setJinyongValue(String jinyongValue) {
				this.jinyongValue = jinyongValue;
			}


	@Override
	public String toString() {
		return "CaomeiCommentbackView{" +
			", caomeiName=" + caomeiName +
			", caomeiUuidNumber=" + caomeiUuidNumber +
			", caomeiPhoto=" + caomeiPhoto +
			", caomeiKucunNumber=" + caomeiKucunNumber +
			", caomeiOldMoney=" + caomeiOldMoney +
			", caomeiNewMoney=" + caomeiNewMoney +
			", caomeiCangku=" + caomeiCangku +
			", caomeiClicknum=" + caomeiClicknum +
			", caomeiContent=" + caomeiContent +
			", caomeiDelete=" + caomeiDelete +
			", yonghuName=" + yonghuName +
			", yonghuPhone=" + yonghuPhone +
			", yonghuIdNumber=" + yonghuIdNumber +
			", yonghuPhoto=" + yonghuPhoto +
			", yonghuEmail=" + yonghuEmail +
			", newMoney=" + newMoney +
			"} " + super.toString();
	}
}
