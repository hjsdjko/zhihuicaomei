package com.entity.vo;

import com.entity.CaomeiOrderEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 草莓订单
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("caomei_order")
public class CaomeiOrderVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

    @TableField(value = "id")
    private Integer id;


    /**
     * 订单编号
     */

    @TableField(value = "caomei_order_uuid_number")
    private String caomeiOrderUuidNumber;


    /**
     * 收货地址
     */

    @TableField(value = "address_id")
    private Integer addressId;


    /**
     * 草莓
     */

    @TableField(value = "caomei_id")
    private Integer caomeiId;


    /**
     * 用户
     */

    @TableField(value = "yonghu_id")
    private Integer yonghuId;


    /**
     * 购买斤数
     */

    @TableField(value = "buy_number")
    private Integer buyNumber;


    /**
     * 实付价格
     */

    @TableField(value = "caomei_order_true_price")
    private Double caomeiOrderTruePrice;


    /**
     * 快递公司
     */

    @TableField(value = "caomei_order_courier_name")
    private String caomeiOrderCourierName;


    /**
     * 快递单号
     */

    @TableField(value = "caomei_order_courier_number")
    private String caomeiOrderCourierNumber;


    /**
     * 订单类型
     */

    @TableField(value = "caomei_order_types")
    private Integer caomeiOrderTypes;


    /**
     * 支付类型
     */

    @TableField(value = "caomei_order_payment_types")
    private Integer caomeiOrderPaymentTypes;


    /**
     * 订单创建时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "insert_time")
    private Date insertTime;


    /**
     * 创建时间 show3 listShow
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
	 * 设置：订单编号
	 */
    public String getCaomeiOrderUuidNumber() {
        return caomeiOrderUuidNumber;
    }


    /**
	 * 获取：订单编号
	 */

    public void setCaomeiOrderUuidNumber(String caomeiOrderUuidNumber) {
        this.caomeiOrderUuidNumber = caomeiOrderUuidNumber;
    }
    /**
	 * 设置：收货地址
	 */
    public Integer getAddressId() {
        return addressId;
    }


    /**
	 * 获取：收货地址
	 */

    public void setAddressId(Integer addressId) {
        this.addressId = addressId;
    }
    /**
	 * 设置：草莓
	 */
    public Integer getCaomeiId() {
        return caomeiId;
    }


    /**
	 * 获取：草莓
	 */

    public void setCaomeiId(Integer caomeiId) {
        this.caomeiId = caomeiId;
    }
    /**
	 * 设置：用户
	 */
    public Integer getYonghuId() {
        return yonghuId;
    }


    /**
	 * 获取：用户
	 */

    public void setYonghuId(Integer yonghuId) {
        this.yonghuId = yonghuId;
    }
    /**
	 * 设置：购买斤数
	 */
    public Integer getBuyNumber() {
        return buyNumber;
    }


    /**
	 * 获取：购买斤数
	 */

    public void setBuyNumber(Integer buyNumber) {
        this.buyNumber = buyNumber;
    }
    /**
	 * 设置：实付价格
	 */
    public Double getCaomeiOrderTruePrice() {
        return caomeiOrderTruePrice;
    }


    /**
	 * 获取：实付价格
	 */

    public void setCaomeiOrderTruePrice(Double caomeiOrderTruePrice) {
        this.caomeiOrderTruePrice = caomeiOrderTruePrice;
    }
    /**
	 * 设置：快递公司
	 */
    public String getCaomeiOrderCourierName() {
        return caomeiOrderCourierName;
    }


    /**
	 * 获取：快递公司
	 */

    public void setCaomeiOrderCourierName(String caomeiOrderCourierName) {
        this.caomeiOrderCourierName = caomeiOrderCourierName;
    }
    /**
	 * 设置：快递单号
	 */
    public String getCaomeiOrderCourierNumber() {
        return caomeiOrderCourierNumber;
    }


    /**
	 * 获取：快递单号
	 */

    public void setCaomeiOrderCourierNumber(String caomeiOrderCourierNumber) {
        this.caomeiOrderCourierNumber = caomeiOrderCourierNumber;
    }
    /**
	 * 设置：订单类型
	 */
    public Integer getCaomeiOrderTypes() {
        return caomeiOrderTypes;
    }


    /**
	 * 获取：订单类型
	 */

    public void setCaomeiOrderTypes(Integer caomeiOrderTypes) {
        this.caomeiOrderTypes = caomeiOrderTypes;
    }
    /**
	 * 设置：支付类型
	 */
    public Integer getCaomeiOrderPaymentTypes() {
        return caomeiOrderPaymentTypes;
    }


    /**
	 * 获取：支付类型
	 */

    public void setCaomeiOrderPaymentTypes(Integer caomeiOrderPaymentTypes) {
        this.caomeiOrderPaymentTypes = caomeiOrderPaymentTypes;
    }
    /**
	 * 设置：订单创建时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }


    /**
	 * 获取：订单创建时间
	 */

    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }
    /**
	 * 设置：创建时间 show3 listShow
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 获取：创建时间 show3 listShow
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

}
