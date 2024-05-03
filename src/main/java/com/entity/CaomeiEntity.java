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
 * 草莓
 *
 * @author 
 * @email
 */
@TableName("caomei")
public class CaomeiEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public CaomeiEntity() {

	}

	public CaomeiEntity(T t) {
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
     * 草莓名称
     */
    @ColumnInfo(comment="草莓名称",type="varchar(200)")
    @TableField(value = "caomei_name")

    private String caomeiName;


    /**
     * 草莓编号
     */
    @ColumnInfo(comment="草莓编号",type="varchar(200)")
    @TableField(value = "caomei_uuid_number")

    private String caomeiUuidNumber;


    /**
     * 草莓照片
     */
    @ColumnInfo(comment="草莓照片",type="varchar(200)")
    @TableField(value = "caomei_photo")

    private String caomeiPhoto;


    /**
     * 草莓类型
     */
    @ColumnInfo(comment="草莓类型",type="int(11)")
    @TableField(value = "caomei_types")

    private Integer caomeiTypes;


    /**
     * 草莓库存
     */
    @ColumnInfo(comment="草莓库存",type="int(11)")
    @TableField(value = "caomei_kucun_number")

    private Integer caomeiKucunNumber;


    /**
     * 草莓原价
     */
    @ColumnInfo(comment="草莓原价",type="decimal(10,2)")
    @TableField(value = "caomei_old_money")

    private Double caomeiOldMoney;


    /**
     * 现价/斤
     */
    @ColumnInfo(comment="现价/斤",type="decimal(10,2)")
    @TableField(value = "caomei_new_money")

    private Double caomeiNewMoney;


    /**
     * 所属仓库
     */
    @ColumnInfo(comment="所属仓库",type="varchar(200)")
    @TableField(value = "caomei_cangku")

    private String caomeiCangku;


    /**
     * 草莓热度
     */
    @ColumnInfo(comment="草莓热度",type="int(11)")
    @TableField(value = "caomei_clicknum")

    private Integer caomeiClicknum;


    /**
     * 草莓介绍
     */
    @ColumnInfo(comment="草莓介绍",type="longtext")
    @TableField(value = "caomei_content")

    private String caomeiContent;


    /**
     * 是否上架
     */
    @ColumnInfo(comment="是否上架",type="int(11)")
    @TableField(value = "shangxia_types")

    private Integer shangxiaTypes;


    /**
     * 逻辑删除
     */
    @ColumnInfo(comment="逻辑删除",type="int(11)")
    @TableField(value = "caomei_delete")

    private Integer caomeiDelete;


    /**
     * 录入时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @ColumnInfo(comment="录入时间",type="timestamp")
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
	 * 获取：草莓名称
	 */
    public String getCaomeiName() {
        return caomeiName;
    }
    /**
	 * 设置：草莓名称
	 */

    public void setCaomeiName(String caomeiName) {
        this.caomeiName = caomeiName;
    }
    /**
	 * 获取：草莓编号
	 */
    public String getCaomeiUuidNumber() {
        return caomeiUuidNumber;
    }
    /**
	 * 设置：草莓编号
	 */

    public void setCaomeiUuidNumber(String caomeiUuidNumber) {
        this.caomeiUuidNumber = caomeiUuidNumber;
    }
    /**
	 * 获取：草莓照片
	 */
    public String getCaomeiPhoto() {
        return caomeiPhoto;
    }
    /**
	 * 设置：草莓照片
	 */

    public void setCaomeiPhoto(String caomeiPhoto) {
        this.caomeiPhoto = caomeiPhoto;
    }
    /**
	 * 获取：草莓类型
	 */
    public Integer getCaomeiTypes() {
        return caomeiTypes;
    }
    /**
	 * 设置：草莓类型
	 */

    public void setCaomeiTypes(Integer caomeiTypes) {
        this.caomeiTypes = caomeiTypes;
    }
    /**
	 * 获取：草莓库存
	 */
    public Integer getCaomeiKucunNumber() {
        return caomeiKucunNumber;
    }
    /**
	 * 设置：草莓库存
	 */

    public void setCaomeiKucunNumber(Integer caomeiKucunNumber) {
        this.caomeiKucunNumber = caomeiKucunNumber;
    }
    /**
	 * 获取：草莓原价
	 */
    public Double getCaomeiOldMoney() {
        return caomeiOldMoney;
    }
    /**
	 * 设置：草莓原价
	 */

    public void setCaomeiOldMoney(Double caomeiOldMoney) {
        this.caomeiOldMoney = caomeiOldMoney;
    }
    /**
	 * 获取：现价/斤
	 */
    public Double getCaomeiNewMoney() {
        return caomeiNewMoney;
    }
    /**
	 * 设置：现价/斤
	 */

    public void setCaomeiNewMoney(Double caomeiNewMoney) {
        this.caomeiNewMoney = caomeiNewMoney;
    }
    /**
	 * 获取：所属仓库
	 */
    public String getCaomeiCangku() {
        return caomeiCangku;
    }
    /**
	 * 设置：所属仓库
	 */

    public void setCaomeiCangku(String caomeiCangku) {
        this.caomeiCangku = caomeiCangku;
    }
    /**
	 * 获取：草莓热度
	 */
    public Integer getCaomeiClicknum() {
        return caomeiClicknum;
    }
    /**
	 * 设置：草莓热度
	 */

    public void setCaomeiClicknum(Integer caomeiClicknum) {
        this.caomeiClicknum = caomeiClicknum;
    }
    /**
	 * 获取：草莓介绍
	 */
    public String getCaomeiContent() {
        return caomeiContent;
    }
    /**
	 * 设置：草莓介绍
	 */

    public void setCaomeiContent(String caomeiContent) {
        this.caomeiContent = caomeiContent;
    }
    /**
	 * 获取：是否上架
	 */
    public Integer getShangxiaTypes() {
        return shangxiaTypes;
    }
    /**
	 * 设置：是否上架
	 */

    public void setShangxiaTypes(Integer shangxiaTypes) {
        this.shangxiaTypes = shangxiaTypes;
    }
    /**
	 * 获取：逻辑删除
	 */
    public Integer getCaomeiDelete() {
        return caomeiDelete;
    }
    /**
	 * 设置：逻辑删除
	 */

    public void setCaomeiDelete(Integer caomeiDelete) {
        this.caomeiDelete = caomeiDelete;
    }
    /**
	 * 获取：录入时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }
    /**
	 * 设置：录入时间
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
        return "Caomei{" +
            ", id=" + id +
            ", caomeiName=" + caomeiName +
            ", caomeiUuidNumber=" + caomeiUuidNumber +
            ", caomeiPhoto=" + caomeiPhoto +
            ", caomeiTypes=" + caomeiTypes +
            ", caomeiKucunNumber=" + caomeiKucunNumber +
            ", caomeiOldMoney=" + caomeiOldMoney +
            ", caomeiNewMoney=" + caomeiNewMoney +
            ", caomeiCangku=" + caomeiCangku +
            ", caomeiClicknum=" + caomeiClicknum +
            ", caomeiContent=" + caomeiContent +
            ", shangxiaTypes=" + shangxiaTypes +
            ", caomeiDelete=" + caomeiDelete +
            ", insertTime=" + DateUtil.convertString(insertTime,"yyyy-MM-dd") +
            ", createTime=" + DateUtil.convertString(createTime,"yyyy-MM-dd") +
        "}";
    }
}
