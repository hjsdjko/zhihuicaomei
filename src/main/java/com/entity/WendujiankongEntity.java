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
 * 温度监控
 *
 * @author 
 * @email
 */
@TableName("wendujiankong")
public class WendujiankongEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public WendujiankongEntity() {

	}

	public WendujiankongEntity(T t) {
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
     * 温度监控编号
     */
    @ColumnInfo(comment="温度监控编号",type="varchar(200)")
    @TableField(value = "wendujiankong_uuid_number")

    private String wendujiankongUuidNumber;


    /**
     * 温度监控地点
     */
    @ColumnInfo(comment="温度监控地点",type="varchar(200)")
    @TableField(value = "wendujiankong_address")

    private String wendujiankongAddress;


    /**
     * 温度监控类型
     */
    @ColumnInfo(comment="温度监控类型",type="int(11)")
    @TableField(value = "wendujiankong_types")

    private Integer wendujiankongTypes;


    /**
     * 附件
     */
    @ColumnInfo(comment="附件",type="varchar(200)")
    @TableField(value = "wendujiankong_file")

    private String wendujiankongFile;


    /**
     * 温度
     */
    @ColumnInfo(comment="温度",type="decimal(10,2)")
    @TableField(value = "wendujiankong_shuzi")

    private Double wendujiankongShuzi;


    /**
     * 监控时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @ColumnInfo(comment="监控时间",type="timestamp")
    @TableField(value = "wendujiankong_time")

    private Date wendujiankongTime;


    /**
     * 监控备注
     */
    @ColumnInfo(comment="监控备注",type="longtext")
    @TableField(value = "wendujiankong_content")

    private String wendujiankongContent;


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
	 * 获取：温度监控编号
	 */
    public String getWendujiankongUuidNumber() {
        return wendujiankongUuidNumber;
    }
    /**
	 * 设置：温度监控编号
	 */

    public void setWendujiankongUuidNumber(String wendujiankongUuidNumber) {
        this.wendujiankongUuidNumber = wendujiankongUuidNumber;
    }
    /**
	 * 获取：温度监控地点
	 */
    public String getWendujiankongAddress() {
        return wendujiankongAddress;
    }
    /**
	 * 设置：温度监控地点
	 */

    public void setWendujiankongAddress(String wendujiankongAddress) {
        this.wendujiankongAddress = wendujiankongAddress;
    }
    /**
	 * 获取：温度监控类型
	 */
    public Integer getWendujiankongTypes() {
        return wendujiankongTypes;
    }
    /**
	 * 设置：温度监控类型
	 */

    public void setWendujiankongTypes(Integer wendujiankongTypes) {
        this.wendujiankongTypes = wendujiankongTypes;
    }
    /**
	 * 获取：附件
	 */
    public String getWendujiankongFile() {
        return wendujiankongFile;
    }
    /**
	 * 设置：附件
	 */

    public void setWendujiankongFile(String wendujiankongFile) {
        this.wendujiankongFile = wendujiankongFile;
    }
    /**
	 * 获取：温度
	 */
    public Double getWendujiankongShuzi() {
        return wendujiankongShuzi;
    }
    /**
	 * 设置：温度
	 */

    public void setWendujiankongShuzi(Double wendujiankongShuzi) {
        this.wendujiankongShuzi = wendujiankongShuzi;
    }
    /**
	 * 获取：监控时间
	 */
    public Date getWendujiankongTime() {
        return wendujiankongTime;
    }
    /**
	 * 设置：监控时间
	 */

    public void setWendujiankongTime(Date wendujiankongTime) {
        this.wendujiankongTime = wendujiankongTime;
    }
    /**
	 * 获取：监控备注
	 */
    public String getWendujiankongContent() {
        return wendujiankongContent;
    }
    /**
	 * 设置：监控备注
	 */

    public void setWendujiankongContent(String wendujiankongContent) {
        this.wendujiankongContent = wendujiankongContent;
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
        return "Wendujiankong{" +
            ", id=" + id +
            ", wendujiankongUuidNumber=" + wendujiankongUuidNumber +
            ", wendujiankongAddress=" + wendujiankongAddress +
            ", wendujiankongTypes=" + wendujiankongTypes +
            ", wendujiankongFile=" + wendujiankongFile +
            ", wendujiankongShuzi=" + wendujiankongShuzi +
            ", wendujiankongTime=" + DateUtil.convertString(wendujiankongTime,"yyyy-MM-dd") +
            ", wendujiankongContent=" + wendujiankongContent +
            ", insertTime=" + DateUtil.convertString(insertTime,"yyyy-MM-dd") +
            ", createTime=" + DateUtil.convertString(createTime,"yyyy-MM-dd") +
        "}";
    }
}
