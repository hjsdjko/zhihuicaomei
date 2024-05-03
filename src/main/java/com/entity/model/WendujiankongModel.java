package com.entity.model;

import com.entity.WendujiankongEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 温度监控
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class WendujiankongModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 温度监控编号
     */
    private String wendujiankongUuidNumber;


    /**
     * 温度监控地点
     */
    private String wendujiankongAddress;


    /**
     * 温度监控类型
     */
    private Integer wendujiankongTypes;


    /**
     * 附件
     */
    private String wendujiankongFile;


    /**
     * 温度
     */
    private Double wendujiankongShuzi;


    /**
     * 监控时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date wendujiankongTime;


    /**
     * 监控备注
     */
    private String wendujiankongContent;


    /**
     * 上传时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date insertTime;


    /**
     * 创建时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
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

    }
