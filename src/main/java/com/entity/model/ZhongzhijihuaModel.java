package com.entity.model;

import com.entity.ZhongzhijihuaEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 种植计划
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class ZhongzhijihuaModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 种植计划编号
     */
    private String zhongzhijihuaUuidNumber;


    /**
     * 计划标题
     */
    private String zhongzhijihuaName;


    /**
     * 计划地点
     */
    private String zhongzhijihuaAddress;


    /**
     * 附件
     */
    private String zhongzhijihuaFile;


    /**
     * 种植计划类型
     */
    private Integer zhongzhijihuaTypes;


    /**
     * 计划开始时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date zhongzhijihuaKaishiTime;


    /**
     * 计划内容
     */
    private String zhongzhijihuaContent;


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

    }
