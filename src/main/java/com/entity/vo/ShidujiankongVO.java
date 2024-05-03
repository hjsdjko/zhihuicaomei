package com.entity.vo;

import com.entity.ShidujiankongEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 湿度监控
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("shidujiankong")
public class ShidujiankongVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

    @TableField(value = "id")
    private Integer id;


    /**
     * 湿度监控编号
     */

    @TableField(value = "shidujiankong_uuid_number")
    private String shidujiankongUuidNumber;


    /**
     * 湿度监控地点
     */

    @TableField(value = "shidujiankong_address")
    private String shidujiankongAddress;


    /**
     * 湿度监控类型
     */

    @TableField(value = "shidujiankong_types")
    private Integer shidujiankongTypes;


    /**
     * 附件
     */

    @TableField(value = "shidujiankong_file")
    private String shidujiankongFile;


    /**
     * 湿度
     */

    @TableField(value = "shidujiankong_shuzi")
    private Double shidujiankongShuzi;


    /**
     * 监控时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "shidujiankong_time")
    private Date shidujiankongTime;


    /**
     * 监控备注
     */

    @TableField(value = "shidujiankong_content")
    private String shidujiankongContent;


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
	 * 设置：湿度监控编号
	 */
    public String getShidujiankongUuidNumber() {
        return shidujiankongUuidNumber;
    }


    /**
	 * 获取：湿度监控编号
	 */

    public void setShidujiankongUuidNumber(String shidujiankongUuidNumber) {
        this.shidujiankongUuidNumber = shidujiankongUuidNumber;
    }
    /**
	 * 设置：湿度监控地点
	 */
    public String getShidujiankongAddress() {
        return shidujiankongAddress;
    }


    /**
	 * 获取：湿度监控地点
	 */

    public void setShidujiankongAddress(String shidujiankongAddress) {
        this.shidujiankongAddress = shidujiankongAddress;
    }
    /**
	 * 设置：湿度监控类型
	 */
    public Integer getShidujiankongTypes() {
        return shidujiankongTypes;
    }


    /**
	 * 获取：湿度监控类型
	 */

    public void setShidujiankongTypes(Integer shidujiankongTypes) {
        this.shidujiankongTypes = shidujiankongTypes;
    }
    /**
	 * 设置：附件
	 */
    public String getShidujiankongFile() {
        return shidujiankongFile;
    }


    /**
	 * 获取：附件
	 */

    public void setShidujiankongFile(String shidujiankongFile) {
        this.shidujiankongFile = shidujiankongFile;
    }
    /**
	 * 设置：湿度
	 */
    public Double getShidujiankongShuzi() {
        return shidujiankongShuzi;
    }


    /**
	 * 获取：湿度
	 */

    public void setShidujiankongShuzi(Double shidujiankongShuzi) {
        this.shidujiankongShuzi = shidujiankongShuzi;
    }
    /**
	 * 设置：监控时间
	 */
    public Date getShidujiankongTime() {
        return shidujiankongTime;
    }


    /**
	 * 获取：监控时间
	 */

    public void setShidujiankongTime(Date shidujiankongTime) {
        this.shidujiankongTime = shidujiankongTime;
    }
    /**
	 * 设置：监控备注
	 */
    public String getShidujiankongContent() {
        return shidujiankongContent;
    }


    /**
	 * 获取：监控备注
	 */

    public void setShidujiankongContent(String shidujiankongContent) {
        this.shidujiankongContent = shidujiankongContent;
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
