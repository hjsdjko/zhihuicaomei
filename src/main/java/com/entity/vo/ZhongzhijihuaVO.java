package com.entity.vo;

import com.entity.ZhongzhijihuaEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 种植计划
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("zhongzhijihua")
public class ZhongzhijihuaVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

    @TableField(value = "id")
    private Integer id;


    /**
     * 种植计划编号
     */

    @TableField(value = "zhongzhijihua_uuid_number")
    private String zhongzhijihuaUuidNumber;


    /**
     * 计划标题
     */

    @TableField(value = "zhongzhijihua_name")
    private String zhongzhijihuaName;


    /**
     * 计划地点
     */

    @TableField(value = "zhongzhijihua_address")
    private String zhongzhijihuaAddress;


    /**
     * 附件
     */

    @TableField(value = "zhongzhijihua_file")
    private String zhongzhijihuaFile;


    /**
     * 种植计划类型
     */

    @TableField(value = "zhongzhijihua_types")
    private Integer zhongzhijihuaTypes;


    /**
     * 计划开始时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "zhongzhijihua_kaishi_time")
    private Date zhongzhijihuaKaishiTime;


    /**
     * 计划内容
     */

    @TableField(value = "zhongzhijihua_content")
    private String zhongzhijihuaContent;


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
	 * 设置：种植计划编号
	 */
    public String getZhongzhijihuaUuidNumber() {
        return zhongzhijihuaUuidNumber;
    }


    /**
	 * 获取：种植计划编号
	 */

    public void setZhongzhijihuaUuidNumber(String zhongzhijihuaUuidNumber) {
        this.zhongzhijihuaUuidNumber = zhongzhijihuaUuidNumber;
    }
    /**
	 * 设置：计划标题
	 */
    public String getZhongzhijihuaName() {
        return zhongzhijihuaName;
    }


    /**
	 * 获取：计划标题
	 */

    public void setZhongzhijihuaName(String zhongzhijihuaName) {
        this.zhongzhijihuaName = zhongzhijihuaName;
    }
    /**
	 * 设置：计划地点
	 */
    public String getZhongzhijihuaAddress() {
        return zhongzhijihuaAddress;
    }


    /**
	 * 获取：计划地点
	 */

    public void setZhongzhijihuaAddress(String zhongzhijihuaAddress) {
        this.zhongzhijihuaAddress = zhongzhijihuaAddress;
    }
    /**
	 * 设置：附件
	 */
    public String getZhongzhijihuaFile() {
        return zhongzhijihuaFile;
    }


    /**
	 * 获取：附件
	 */

    public void setZhongzhijihuaFile(String zhongzhijihuaFile) {
        this.zhongzhijihuaFile = zhongzhijihuaFile;
    }
    /**
	 * 设置：种植计划类型
	 */
    public Integer getZhongzhijihuaTypes() {
        return zhongzhijihuaTypes;
    }


    /**
	 * 获取：种植计划类型
	 */

    public void setZhongzhijihuaTypes(Integer zhongzhijihuaTypes) {
        this.zhongzhijihuaTypes = zhongzhijihuaTypes;
    }
    /**
	 * 设置：计划开始时间
	 */
    public Date getZhongzhijihuaKaishiTime() {
        return zhongzhijihuaKaishiTime;
    }


    /**
	 * 获取：计划开始时间
	 */

    public void setZhongzhijihuaKaishiTime(Date zhongzhijihuaKaishiTime) {
        this.zhongzhijihuaKaishiTime = zhongzhijihuaKaishiTime;
    }
    /**
	 * 设置：计划内容
	 */
    public String getZhongzhijihuaContent() {
        return zhongzhijihuaContent;
    }


    /**
	 * 获取：计划内容
	 */

    public void setZhongzhijihuaContent(String zhongzhijihuaContent) {
        this.zhongzhijihuaContent = zhongzhijihuaContent;
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
