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
 * 种植计划
 *
 * @author 
 * @email
 */
@TableName("zhongzhijihua")
public class ZhongzhijihuaEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public ZhongzhijihuaEntity() {

	}

	public ZhongzhijihuaEntity(T t) {
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
     * 种植计划编号
     */
    @ColumnInfo(comment="种植计划编号",type="varchar(200)")
    @TableField(value = "zhongzhijihua_uuid_number")

    private String zhongzhijihuaUuidNumber;


    /**
     * 计划标题
     */
    @ColumnInfo(comment="计划标题",type="varchar(200)")
    @TableField(value = "zhongzhijihua_name")

    private String zhongzhijihuaName;


    /**
     * 计划地点
     */
    @ColumnInfo(comment="计划地点",type="varchar(200)")
    @TableField(value = "zhongzhijihua_address")

    private String zhongzhijihuaAddress;


    /**
     * 附件
     */
    @ColumnInfo(comment="附件",type="varchar(200)")
    @TableField(value = "zhongzhijihua_file")

    private String zhongzhijihuaFile;


    /**
     * 种植计划类型
     */
    @ColumnInfo(comment="种植计划类型",type="int(11)")
    @TableField(value = "zhongzhijihua_types")

    private Integer zhongzhijihuaTypes;


    /**
     * 计划开始时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @ColumnInfo(comment="计划开始时间",type="timestamp")
    @TableField(value = "zhongzhijihua_kaishi_time")

    private Date zhongzhijihuaKaishiTime;


    /**
     * 计划内容
     */
    @ColumnInfo(comment="计划内容",type="longtext")
    @TableField(value = "zhongzhijihua_content")

    private String zhongzhijihuaContent;


    /**
     * 上传时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @ColumnInfo(comment="上传时间",type="timestamp")
    @TableField(value = "insert_time",fill = FieldFill.INSERT)

    private Date insertTime;


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
	 * 获取：种植计划编号
	 */
    public String getZhongzhijihuaUuidNumber() {
        return zhongzhijihuaUuidNumber;
    }
    /**
	 * 设置：种植计划编号
	 */

    public void setZhongzhijihuaUuidNumber(String zhongzhijihuaUuidNumber) {
        this.zhongzhijihuaUuidNumber = zhongzhijihuaUuidNumber;
    }
    /**
	 * 获取：计划标题
	 */
    public String getZhongzhijihuaName() {
        return zhongzhijihuaName;
    }
    /**
	 * 设置：计划标题
	 */

    public void setZhongzhijihuaName(String zhongzhijihuaName) {
        this.zhongzhijihuaName = zhongzhijihuaName;
    }
    /**
	 * 获取：计划地点
	 */
    public String getZhongzhijihuaAddress() {
        return zhongzhijihuaAddress;
    }
    /**
	 * 设置：计划地点
	 */

    public void setZhongzhijihuaAddress(String zhongzhijihuaAddress) {
        this.zhongzhijihuaAddress = zhongzhijihuaAddress;
    }
    /**
	 * 获取：附件
	 */
    public String getZhongzhijihuaFile() {
        return zhongzhijihuaFile;
    }
    /**
	 * 设置：附件
	 */

    public void setZhongzhijihuaFile(String zhongzhijihuaFile) {
        this.zhongzhijihuaFile = zhongzhijihuaFile;
    }
    /**
	 * 获取：种植计划类型
	 */
    public Integer getZhongzhijihuaTypes() {
        return zhongzhijihuaTypes;
    }
    /**
	 * 设置：种植计划类型
	 */

    public void setZhongzhijihuaTypes(Integer zhongzhijihuaTypes) {
        this.zhongzhijihuaTypes = zhongzhijihuaTypes;
    }
    /**
	 * 获取：计划开始时间
	 */
    public Date getZhongzhijihuaKaishiTime() {
        return zhongzhijihuaKaishiTime;
    }
    /**
	 * 设置：计划开始时间
	 */

    public void setZhongzhijihuaKaishiTime(Date zhongzhijihuaKaishiTime) {
        this.zhongzhijihuaKaishiTime = zhongzhijihuaKaishiTime;
    }
    /**
	 * 获取：计划内容
	 */
    public String getZhongzhijihuaContent() {
        return zhongzhijihuaContent;
    }
    /**
	 * 设置：计划内容
	 */

    public void setZhongzhijihuaContent(String zhongzhijihuaContent) {
        this.zhongzhijihuaContent = zhongzhijihuaContent;
    }
    /**
	 * 获取：上传时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }
    /**
	 * 设置：上传时间
	 */

    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
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
        return "Zhongzhijihua{" +
            ", id=" + id +
            ", zhongzhijihuaUuidNumber=" + zhongzhijihuaUuidNumber +
            ", zhongzhijihuaName=" + zhongzhijihuaName +
            ", zhongzhijihuaAddress=" + zhongzhijihuaAddress +
            ", zhongzhijihuaFile=" + zhongzhijihuaFile +
            ", zhongzhijihuaTypes=" + zhongzhijihuaTypes +
            ", zhongzhijihuaKaishiTime=" + DateUtil.convertString(zhongzhijihuaKaishiTime,"yyyy-MM-dd") +
            ", zhongzhijihuaContent=" + zhongzhijihuaContent +
            ", insertTime=" + DateUtil.convertString(insertTime,"yyyy-MM-dd") +
            ", createTime=" + DateUtil.convertString(createTime,"yyyy-MM-dd") +
        "}";
    }
}
