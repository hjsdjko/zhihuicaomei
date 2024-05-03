package com.entity.model;

import com.entity.ShidujiankongEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 湿度监控
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class ShidujiankongModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 湿度监控编号
     */
    private String shidujiankongUuidNumber;


    /**
     * 湿度监控地点
     */
    private String shidujiankongAddress;


    /**
     * 湿度监控类型
     */
    private Integer shidujiankongTypes;


    /**
     * 附件
     */
    private String shidujiankongFile;


    /**
     * 湿度
     */
    private Double shidujiankongShuzi;


    /**
     * 监控时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date shidujiankongTime;


    /**
     * 监控备注
     */
    private String shidujiankongContent;


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

    }
