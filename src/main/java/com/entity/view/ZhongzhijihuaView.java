package com.entity.view;

import org.apache.tools.ant.util.DateUtils;
import com.annotation.ColumnInfo;
import com.entity.ZhongzhijihuaEntity;
import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;
import com.utils.DateUtil;

/**
* 种植计划
* 后端返回视图实体辅助类
* （通常后端关联的表或者自定义的字段需要返回使用）
*/
@TableName("zhongzhijihua")
public class ZhongzhijihuaView extends ZhongzhijihuaEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	//当前表
	/**
	* 种植计划类型的值
	*/
	@ColumnInfo(comment="种植计划类型的字典表值",type="varchar(200)")
	private String zhongzhijihuaValue;




	public ZhongzhijihuaView() {

	}

	public ZhongzhijihuaView(ZhongzhijihuaEntity zhongzhijihuaEntity) {
		try {
			BeanUtils.copyProperties(this, zhongzhijihuaEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



	//当前表的
	/**
	* 获取： 种植计划类型的值
	*/
	public String getZhongzhijihuaValue() {
		return zhongzhijihuaValue;
	}
	/**
	* 设置： 种植计划类型的值
	*/
	public void setZhongzhijihuaValue(String zhongzhijihuaValue) {
		this.zhongzhijihuaValue = zhongzhijihuaValue;
	}




	@Override
	public String toString() {
		return "ZhongzhijihuaView{" +
			", zhongzhijihuaValue=" + zhongzhijihuaValue +
			"} " + super.toString();
	}
}
