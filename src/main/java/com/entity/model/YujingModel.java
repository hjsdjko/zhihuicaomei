package com.entity.model;

import com.entity.YujingEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 病虫害预警
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class YujingModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 预警编号
     */
    private String yujingUuidNumber;


    /**
     * 预警标题
     */
    private String yujingName;


    /**
     * 预警地点
     */
    private String yujingAddress;


    /**
     * 附件
     */
    private String yujingFile;


    /**
     * 预警类型
     */
    private Integer yujingTypes;


    /**
     * 预警时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date yujingTime;


    /**
     * 预警内容
     */
    private String yujingContent;


    /**
     * 发布时间
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

    }
