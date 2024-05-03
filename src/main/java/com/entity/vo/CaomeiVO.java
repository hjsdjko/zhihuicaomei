package com.entity.vo;

import com.entity.CaomeiEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 草莓
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("caomei")
public class CaomeiVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

    @TableField(value = "id")
    private Integer id;


    /**
     * 草莓名称
     */

    @TableField(value = "caomei_name")
    private String caomeiName;


    /**
     * 草莓编号
     */

    @TableField(value = "caomei_uuid_number")
    private String caomeiUuidNumber;


    /**
     * 草莓照片
     */

    @TableField(value = "caomei_photo")
    private String caomeiPhoto;


    /**
     * 草莓类型
     */

    @TableField(value = "caomei_types")
    private Integer caomeiTypes;


    /**
     * 草莓库存
     */

    @TableField(value = "caomei_kucun_number")
    private Integer caomeiKucunNumber;


    /**
     * 草莓原价
     */

    @TableField(value = "caomei_old_money")
    private Double caomeiOldMoney;


    /**
     * 现价/斤
     */

    @TableField(value = "caomei_new_money")
    private Double caomeiNewMoney;


    /**
     * 所属仓库
     */

    @TableField(value = "caomei_cangku")
    private String caomeiCangku;


    /**
     * 草莓热度
     */

    @TableField(value = "caomei_clicknum")
    private Integer caomeiClicknum;


    /**
     * 草莓介绍
     */

    @TableField(value = "caomei_content")
    private String caomeiContent;


    /**
     * 是否上架
     */

    @TableField(value = "shangxia_types")
    private Integer shangxiaTypes;


    /**
     * 逻辑删除
     */

    @TableField(value = "caomei_delete")
    private Integer caomeiDelete;


    /**
     * 录入时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "insert_time")
    private Date insertTime;


    /**
     * 创建时间  show1 show2 photoShow
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
	 * 设置：草莓名称
	 */
    public String getCaomeiName() {
        return caomeiName;
    }


    /**
	 * 获取：草莓名称
	 */

    public void setCaomeiName(String caomeiName) {
        this.caomeiName = caomeiName;
    }
    /**
	 * 设置：草莓编号
	 */
    public String getCaomeiUuidNumber() {
        return caomeiUuidNumber;
    }


    /**
	 * 获取：草莓编号
	 */

    public void setCaomeiUuidNumber(String caomeiUuidNumber) {
        this.caomeiUuidNumber = caomeiUuidNumber;
    }
    /**
	 * 设置：草莓照片
	 */
    public String getCaomeiPhoto() {
        return caomeiPhoto;
    }


    /**
	 * 获取：草莓照片
	 */

    public void setCaomeiPhoto(String caomeiPhoto) {
        this.caomeiPhoto = caomeiPhoto;
    }
    /**
	 * 设置：草莓类型
	 */
    public Integer getCaomeiTypes() {
        return caomeiTypes;
    }


    /**
	 * 获取：草莓类型
	 */

    public void setCaomeiTypes(Integer caomeiTypes) {
        this.caomeiTypes = caomeiTypes;
    }
    /**
	 * 设置：草莓库存
	 */
    public Integer getCaomeiKucunNumber() {
        return caomeiKucunNumber;
    }


    /**
	 * 获取：草莓库存
	 */

    public void setCaomeiKucunNumber(Integer caomeiKucunNumber) {
        this.caomeiKucunNumber = caomeiKucunNumber;
    }
    /**
	 * 设置：草莓原价
	 */
    public Double getCaomeiOldMoney() {
        return caomeiOldMoney;
    }


    /**
	 * 获取：草莓原价
	 */

    public void setCaomeiOldMoney(Double caomeiOldMoney) {
        this.caomeiOldMoney = caomeiOldMoney;
    }
    /**
	 * 设置：现价/斤
	 */
    public Double getCaomeiNewMoney() {
        return caomeiNewMoney;
    }


    /**
	 * 获取：现价/斤
	 */

    public void setCaomeiNewMoney(Double caomeiNewMoney) {
        this.caomeiNewMoney = caomeiNewMoney;
    }
    /**
	 * 设置：所属仓库
	 */
    public String getCaomeiCangku() {
        return caomeiCangku;
    }


    /**
	 * 获取：所属仓库
	 */

    public void setCaomeiCangku(String caomeiCangku) {
        this.caomeiCangku = caomeiCangku;
    }
    /**
	 * 设置：草莓热度
	 */
    public Integer getCaomeiClicknum() {
        return caomeiClicknum;
    }


    /**
	 * 获取：草莓热度
	 */

    public void setCaomeiClicknum(Integer caomeiClicknum) {
        this.caomeiClicknum = caomeiClicknum;
    }
    /**
	 * 设置：草莓介绍
	 */
    public String getCaomeiContent() {
        return caomeiContent;
    }


    /**
	 * 获取：草莓介绍
	 */

    public void setCaomeiContent(String caomeiContent) {
        this.caomeiContent = caomeiContent;
    }
    /**
	 * 设置：是否上架
	 */
    public Integer getShangxiaTypes() {
        return shangxiaTypes;
    }


    /**
	 * 获取：是否上架
	 */

    public void setShangxiaTypes(Integer shangxiaTypes) {
        this.shangxiaTypes = shangxiaTypes;
    }
    /**
	 * 设置：逻辑删除
	 */
    public Integer getCaomeiDelete() {
        return caomeiDelete;
    }


    /**
	 * 获取：逻辑删除
	 */

    public void setCaomeiDelete(Integer caomeiDelete) {
        this.caomeiDelete = caomeiDelete;
    }
    /**
	 * 设置：录入时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }


    /**
	 * 获取：录入时间
	 */

    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }
    /**
	 * 设置：创建时间  show1 show2 photoShow
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 获取：创建时间  show1 show2 photoShow
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

}
