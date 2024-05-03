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
 * 病虫害预警
 *
 * @author 
 * @email
 */
@TableName("yujing")
public class YujingEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public YujingEntity() {

	}

	public YujingEntity(T t) {
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
     * 预警编号
     */
    @ColumnInfo(comment="预警编号",type="varchar(200)")
    @TableField(value = "yujing_uuid_number")

    private String yujingUuidNumber;


    /**
     * 预警标题
     */
    @ColumnInfo(comment="预警标题",type="varchar(200)")
    @TableField(value = "yujing_name")

    private String yujingName;


    /**
     * 预警地点
     */
    @ColumnInfo(comment="预警地点",type="varchar(200)")
    @TableField(value = "yujing_address")

    private String yujingAddress;


    /**
     * 附件
     */
    @ColumnInfo(comment="附件",type="varchar(200)")
    @TableField(value = "yujing_file")

    private String yujingFile;


    /**
     * 预警类型
     */
    @ColumnInfo(comment="预警类型",type="int(11)")
    @TableField(value = "yujing_types")

    private Integer yujingTypes;


    /**
     * 预警时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @ColumnInfo(comment="预警时间",type="timestamp")
    @TableField(value = "yujing_time")

    private Date yujingTime;


    /**
     * 预警内容
     */
    @ColumnInfo(comment="预警内容",type="longtext")
    @TableField(value = "yujing_content")

    private String yujingContent;


    /**
     * 发布时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @ColumnInfo(comment="发布时间",type="timestamp")
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
	 * 获取：预警编号
	 */
    public String getYujingUuidNumber() {
        return yujingUuidNumber;
    }
    /**
	 * 设置：预警编号
	 */

    public void setYujingUuidNumber(String yujingUuidNumber) {
        this.yujingUuidNumber = yujingUuidNumber;
    }
    /**
	 * 获取：预警标题
	 */
    public String getYujingName() {
        return yujingName;
    }
    /**
	 * 设置：预警标题
	 */

    public void setYujingName(String yujingName) {
        this.yujingName = yujingName;
    }
    /**
	 * 获取：预警地点
	 */
    public String getYujingAddress() {
        return yujingAddress;
    }
    /**
	 * 设置：预警地点
	 */

    public void setYujingAddress(String yujingAddress) {
        this.yujingAddress = yujingAddress;
    }
    /**
	 * 获取：附件
	 */
    public String getYujingFile() {
        return yujingFile;
    }
    /**
	 * 设置：附件
	 */

    public void setYujingFile(String yujingFile) {
        this.yujingFile = yujingFile;
    }
    /**
	 * 获取：预警类型
	 */
    public Integer getYujingTypes() {
        return yujingTypes;
    }
    /**
	 * 设置：预警类型
	 */

    public void setYujingTypes(Integer yujingTypes) {
        this.yujingTypes = yujingTypes;
    }
    /**
	 * 获取：预警时间
	 */
    public Date getYujingTime() {
        return yujingTime;
    }
    /**
	 * 设置：预警时间
	 */

    public void setYujingTime(Date yujingTime) {
        this.yujingTime = yujingTime;
    }
    /**
	 * 获取：预警内容
	 */
    public String getYujingContent() {
        return yujingContent;
    }
    /**
	 * 设置：预警内容
	 */

    public void setYujingContent(String yujingContent) {
        this.yujingContent = yujingContent;
    }
    /**
	 * 获取：发布时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }
    /**
	 * 设置：发布时间
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
        return "Yujing{" +
            ", id=" + id +
            ", yujingUuidNumber=" + yujingUuidNumber +
            ", yujingName=" + yujingName +
            ", yujingAddress=" + yujingAddress +
            ", yujingFile=" + yujingFile +
            ", yujingTypes=" + yujingTypes +
            ", yujingTime=" + DateUtil.convertString(yujingTime,"yyyy-MM-dd") +
            ", yujingContent=" + yujingContent +
            ", insertTime=" + DateUtil.convertString(insertTime,"yyyy-MM-dd") +
            ", createTime=" + DateUtil.convertString(createTime,"yyyy-MM-dd") +
        "}";
    }
}
