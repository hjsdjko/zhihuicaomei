package com.entity.vo;

import com.entity.WendujiankongEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 温度监控
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("wendujiankong")
public class WendujiankongVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

    @TableField(value = "id")
    private Integer id;


    /**
     * 温度监控编号
     */

    @TableField(value = "wendujiankong_uuid_number")
    private String wendujiankongUuidNumber;


    /**
     * 温度监控地点
     */

    @TableField(value = "wendujiankong_address")
    private String wendujiankongAddress;


    /**
     * 温度监控类型
     */

    @TableField(value = "wendujiankong_types")
    private Integer wendujiankongTypes;


    /**
     * 附件
     */

    @TableField(value = "wendujiankong_file")
    private String wendujiankongFile;


    /**
     * 温度
     */

    @TableField(value = "wendujiankong_shuzi")
    private Double wendujiankongShuzi;


    /**
     * 监控时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "wendujiankong_time")
    private Date wendujiankongTime;


    /**
     * 监控备注
     */

    @TableField(value = "wendujiankong_content")
    private String wendujiankongContent;


    /**
     * 上传时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "insert_time")
    private Date insertTime;


    /**
     * 创建时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "create_time")
    private Date createTime;


    /**
	 * 设置：主键
	 */
    public Integer getId() {
        return id;
    }


    /**
	 * 获取：主键
	 */

    public void setId(Integer id) {
        this.id = id;
    }
    /**
	 * 设置：温度监控编号
	 */
    public String getWendujiankongUuidNumber() {
        return wendujiankongUuidNumber;
    }


    /**
	 * 获取：温度监控编号
	 */

    public void setWendujiankongUuidNumber(String wendujiankongUuidNumber) {
        this.wendujiankongUuidNumber = wendujiankongUuidNumber;
    }
    /**
	 * 设置：温度监控地点
	 */
    public String getWendujiankongAddress() {
        return wendujiankongAddress;
    }


    /**
	 * 获取：温度监控地点
	 */

    public void setWendujiankongAddress(String wendujiankongAddress) {
        this.wendujiankongAddress = wendujiankongAddress;
    }
    /**
	 * 设置：温度监控类型
	 */
    public Integer getWendujiankongTypes() {
        return wendujiankongTypes;
    }


    /**
	 * 获取：温度监控类型
	 */

    public void setWendujiankongTypes(Integer wendujiankongTypes) {
        this.wendujiankongTypes = wendujiankongTypes;
    }
    /**
	 * 设置：附件
	 */
    public String getWendujiankongFile() {
        return wendujiankongFile;
    }


    /**
	 * 获取：附件
	 */

    public void setWendujiankongFile(String wendujiankongFile) {
        this.wendujiankongFile = wendujiankongFile;
    }
    /**
	 * 设置：温度
	 */
    public Double getWendujiankongShuzi() {
        return wendujiankongShuzi;
    }


    /**
	 * 获取：温度
	 */

    public void setWendujiankongShuzi(Double wendujiankongShuzi) {
        this.wendujiankongShuzi = wendujiankongShuzi;
    }
    /**
	 * 设置：监控时间
	 */
    public Date getWendujiankongTime() {
        return wendujiankongTime;
    }


    /**
	 * 获取：监控时间
	 */

    public void setWendujiankongTime(Date wendujiankongTime) {
        this.wendujiankongTime = wendujiankongTime;
    }
    /**
	 * 设置：监控备注
	 */
    public String getWendujiankongContent() {
        return wendujiankongContent;
    }


    /**
	 * 获取：监控备注
	 */

    public void setWendujiankongContent(String wendujiankongContent) {
        this.wendujiankongContent = wendujiankongContent;
    }
    /**
	 * 设置：上传时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }


    /**
	 * 获取：上传时间
	 */

    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }
    /**
	 * 设置：创建时间
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 获取：创建时间
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

}
