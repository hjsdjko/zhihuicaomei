package com.entity.view;

import org.apache.tools.ant.util.DateUtils;
import com.annotation.ColumnInfo;
import com.entity.ShidujiankongEntity;
import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;
import com.utils.DateUtil;

/**
* 湿度监控
* 后端返回视图实体辅助类
* （通常后端关联的表或者自定义的字段需要返回使用）
*/
@TableName("shidujiankong")
public class ShidujiankongView extends ShidujiankongEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	//当前表
	/**
	* 湿度监控类型的值
	*/
	@ColumnInfo(comment="湿度监控类型的字典表值",type="varchar(200)")
	private String shidujiankongValue;




	public ShidujiankongView() {

	}

	public ShidujiankongView(ShidujiankongEntity shidujiankongEntity) {
		try {
			BeanUtils.copyProperties(this, shidujiankongEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



	//当前表的
	/**
	* 获取： 湿度监控类型的值
	*/
	public String getShidujiankongValue() {
		return shidujiankongValue;
	}
	/**
	* 设置： 湿度监控类型的值
	*/
	public void setShidujiankongValue(String shidujiankongValue) {
		this.shidujiankongValue = shidujiankongValue;
	}




	@Override
	public String toString() {
		return "ShidujiankongView{" +
			", shidujiankongValue=" + shidujiankongValue +
			"} " + super.toString();
	}
}
