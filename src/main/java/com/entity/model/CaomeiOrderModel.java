package com.entity.model;

import com.entity.CaomeiOrderEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 草莓订单
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class CaomeiOrderModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 订单编号
     */
    private String caomeiOrderUuidNumber;


    /**
     * 收货地址
     */
    private Integer addressId;


    /**
     * 草莓
     */
    private Integer caomeiId;


    /**
     * 用户
     */
    private Integer yonghuId;


    /**
     * 购买斤数
     */
    private Integer buyNumber;


    /**
     * 实付价格
     */
    private Double caomeiOrderTruePrice;


    /**
     * 快递公司
     */
    private String caomeiOrderCourierName;


    /**
     * 快递单号
     */
    private String caomeiOrderCourierNumber;


    /**
     * 订单类型
     */
    private Integer caomeiOrderTypes;


    /**
     * 支付类型
     */
    private Integer caomeiOrderPaymentTypes;


    /**
     * 订单创建时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date insertTime;


    /**
     * 创建时间 show3 listShow
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
	 * 获取：订单编号
	 */
    public String getCaomeiOrderUuidNumber() {
        return caomeiOrderUuidNumber;
    }


    /**
	 * 设置：订单编号
	 */
    public void setCaomeiOrderUuidNumber(String caomeiOrderUuidNumber) {
        this.caomeiOrderUuidNumber = caomeiOrderUuidNumber;
    }
    /**
	 * 获取：收货地址
	 */
    public Integer getAddressId() {
        return addressId;
    }


    /**
	 * 设置：收货地址
	 */
    public void setAddressId(Integer addressId) {
        this.addressId = addressId;
    }
    /**
	 * 获取：草莓
	 */
    public Integer getCaomeiId() {
        return caomeiId;
    }


    /**
	 * 设置：草莓
	 */
    public void setCaomeiId(Integer caomeiId) {
        this.caomeiId = caomeiId;
    }
    /**
	 * 获取：用户
	 */
    public Integer getYonghuId() {
        return yonghuId;
    }


    /**
	 * 设置：用户
	 */
    public void setYonghuId(Integer yonghuId) {
        this.yonghuId = yonghuId;
    }
    /**
	 * 获取：购买斤数
	 */
    public Integer getBuyNumber() {
        return buyNumber;
    }


    /**
	 * 设置：购买斤数
	 */
    public void setBuyNumber(Integer buyNumber) {
        this.buyNumber = buyNumber;
    }
    /**
	 * 获取：实付价格
	 */
    public Double getCaomeiOrderTruePrice() {
        return caomeiOrderTruePrice;
    }


    /**
	 * 设置：实付价格
	 */
    public void setCaomeiOrderTruePrice(Double caomeiOrderTruePrice) {
        this.caomeiOrderTruePrice = caomeiOrderTruePrice;
    }
    /**
	 * 获取：快递公司
	 */
    public String getCaomeiOrderCourierName() {
        return caomeiOrderCourierName;
    }


    /**
	 * 设置：快递公司
	 */
    public void setCaomeiOrderCourierName(String caomeiOrderCourierName) {
        this.caomeiOrderCourierName = caomeiOrderCourierName;
    }
    /**
	 * 获取：快递单号
	 */
    public String getCaomeiOrderCourierNumber() {
        return caomeiOrderCourierNumber;
    }


    /**
	 * 设置：快递单号
	 */
    public void setCaomeiOrderCourierNumber(String caomeiOrderCourierNumber) {
        this.caomeiOrderCourierNumber = caomeiOrderCourierNumber;
    }
    /**
	 * 获取：订单类型
	 */
    public Integer getCaomeiOrderTypes() {
        return caomeiOrderTypes;
    }


    /**
	 * 设置：订单类型
	 */
    public void setCaomeiOrderTypes(Integer caomeiOrderTypes) {
        this.caomeiOrderTypes = caomeiOrderTypes;
    }
    /**
	 * 获取：支付类型
	 */
    public Integer getCaomeiOrderPaymentTypes() {
        return caomeiOrderPaymentTypes;
    }


    /**
	 * 设置：支付类型
	 */
    public void setCaomeiOrderPaymentTypes(Integer caomeiOrderPaymentTypes) {
        this.caomeiOrderPaymentTypes = caomeiOrderPaymentTypes;
    }
    /**
	 * 获取：订单创建时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }


    /**
	 * 设置：订单创建时间
	 */
    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }
    /**
	 * 获取：创建时间 show3 listShow
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 设置：创建时间 show3 listShow
	 */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    }
