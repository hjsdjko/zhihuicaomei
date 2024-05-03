package com.entity.view;

import org.apache.tools.ant.util.DateUtils;
import com.annotation.ColumnInfo;
import com.entity.WendujiankongEntity;
import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;
import com.utils.DateUtil;

/**
* 温度监控
* 后端返回视图实体辅助类
* （通常后端关联的表或者自定义的字段需要返回使用）
*/
@TableName("wendujiankong")
public class WendujiankongView extends WendujiankongEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	//当前表
	/**
	* 温度监控类型的值
	*/
	@ColumnInfo(comment="温度监控类型的字典表值",type="varchar(200)")
	private String wendujiankongValue;




	public WendujiankongView() {

	}

	public WendujiankongView(WendujiankongEntity wendujiankongEntity) {
		try {
			BeanUtils.copyProperties(this, wendujiankongEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



	//当前表的
	/**
	* 获取： 温度监控类型的值
	*/
	public String getWendujiankongValue() {
		return wendujiankongValue;
	}
	/**
	* 设置： 温度监控类型的值
	*/
	public void setWendujiankongValue(String wendujiankongValue) {
		this.wendujiankongValue = wendujiankongValue;
	}




	@Override
	public String toString() {
		return "WendujiankongView{" +
			", wendujiankongValue=" + wendujiankongValue +
			"} " + super.toString();
	}
}
