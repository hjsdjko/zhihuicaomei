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
 * 湿度监控
 *
 * @author 
 * @email
 */
@TableName("shidujiankong")
public class ShidujiankongEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public ShidujiankongEntity() {

	}

	public ShidujiankongEntity(T t) {
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
     * 湿度监控编号
     */
    @ColumnInfo(comment="湿度监控编号",type="varchar(200)")
    @TableField(value = "shidujiankong_uuid_number")

    private String shidujiankongUuidNumber;


    /**
     * 湿度监控地点
     */
    @ColumnInfo(comment="湿度监控地点",type="varchar(200)")
    @TableField(value = "shidujiankong_address")

    private String shidujiankongAddress;


    /**
     * 湿度监控类型
     */
    @ColumnInfo(comment="湿度监控类型",type="int(11)")
    @TableField(value = "shidujiankong_types")

    private Integer shidujiankongTypes;


    /**
     * 附件
     */
    @ColumnInfo(comment="附件",type="varchar(200)")
    @TableField(value = "shidujiankong_file")

    private String shidujiankongFile;


    /**
     * 湿度
     */
    @ColumnInfo(comment="湿度",type="decimal(10,2)")
    @TableField(value = "shidujiankong_shuzi")

    private Double shidujiankongShuzi;


    /**
     * 监控时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @ColumnInfo(comment="监控时间",type="timestamp")
    @TableField(value = "shidujiankong_time")

    private Date shidujiankongTime;


    /**
     * 监控备注
     */
    @ColumnInfo(comment="监控备注",type="longtext")
    @TableField(value = "shidujiankong_content")

    private String shidujiankongContent;


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
	 * 获取：湿度监控编号
	 */
    public String getShidujiankongUuidNumber() {
        return shidujiankongUuidNumber;
    }
    /**
	 * 设置：湿度监控编号
	 */

    public void setShidujiankongUuidNumber(String shidujiankongUuidNumber) {
        this.shidujiankongUuidNumber = shidujiankongUuidNumber;
    }
    /**
	 * 获取：湿度监控地点
	 */
    public String getShidujiankongAddress() {
        return shidujiankongAddress;
    }
    /**
	 * 设置：湿度监控地点
	 */

    public void setShidujiankongAddress(String shidujiankongAddress) {
        this.shidujiankongAddress = shidujiankongAddress;
    }
    /**
	 * 获取：湿度监控类型
	 */
    public Integer getShidujiankongTypes() {
        return shidujiankongTypes;
    }
    /**
	 * 设置：湿度监控类型
	 */

    public void setShidujiankongTypes(Integer shidujiankongTypes) {
        this.shidujiankongTypes = shidujiankongTypes;
    }
    /**
	 * 获取：附件
	 */
    public String getShidujiankongFile() {
        return shidujiankongFile;
    }
    /**
	 * 设置：附件
	 */

    public void setShidujiankongFile(String shidujiankongFile) {
        this.shidujiankongFile = shidujiankongFile;
    }
    /**
	 * 获取：湿度
	 */
    public Double getShidujiankongShuzi() {
        return shidujiankongShuzi;
    }
    /**
	 * 设置：湿度
	 */

    public void setShidujiankongShuzi(Double shidujiankongShuzi) {
        this.shidujiankongShuzi = shidujiankongShuzi;
    }
    /**
	 * 获取：监控时间
	 */
    public Date getShidujiankongTime() {
        return shidujiankongTime;
    }
    /**
	 * 设置：监控时间
	 */

    public void setShidujiankongTime(Date shidujiankongTime) {
        this.shidujiankongTime = shidujiankongTime;
    }
    /**
	 * 获取：监控备注
	 */
    public String getShidujiankongContent() {
        return shidujiankongContent;
    }
    /**
	 * 设置：监控备注
	 */

    public void setShidujiankongContent(String shidujiankongContent) {
        this.shidujiankongContent = shidujiankongContent;
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
        return "Shidujiankong{" +
            ", id=" + id +
            ", shidujiankongUuidNumber=" + shidujiankongUuidNumber +
            ", shidujiankongAddress=" + shidujiankongAddress +
            ", shidujiankongTypes=" + shidujiankongTypes +
            ", shidujiankongFile=" + shidujiankongFile +
            ", shidujiankongShuzi=" + shidujiankongShuzi +
            ", shidujiankongTime=" + DateUtil.convertString(shidujiankongTime,"yyyy-MM-dd") +
            ", shidujiankongContent=" + shidujiankongContent +
            ", insertTime=" + DateUtil.convertString(insertTime,"yyyy-MM-dd") +
            ", createTime=" + DateUtil.convertString(createTime,"yyyy-MM-dd") +
        "}";
    }
}
