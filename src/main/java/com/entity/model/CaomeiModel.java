package com.entity.model;

import com.entity.CaomeiEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 草莓
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class CaomeiModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 草莓名称
     */
    private String caomeiName;


    /**
     * 草莓编号
     */
    private String caomeiUuidNumber;


    /**
     * 草莓照片
     */
    private String caomeiPhoto;


    /**
     * 草莓类型
     */
    private Integer caomeiTypes;


    /**
     * 草莓库存
     */
    private Integer caomeiKucunNumber;


    /**
     * 草莓原价
     */
    private Double caomeiOldMoney;


    /**
     * 现价/斤
     */
    private Double caomeiNewMoney;


    /**
     * 所属仓库
     */
    private String caomeiCangku;


    /**
     * 草莓热度
     */
    private Integer caomeiClicknum;


    /**
     * 草莓介绍
     */
    private String caomeiContent;


    /**
     * 是否上架
     */
    private Integer shangxiaTypes;


    /**
     * 逻辑删除
     */
    private Integer caomeiDelete;


    /**
     * 录入时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date insertTime;


    /**
     * 创建时间  show1 show2 photoShow
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
	 * 获取：创建时间  show1 show2 photoShow
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 设置：创建时间  show1 show2 photoShow
	 */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    }
