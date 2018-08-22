package com.dliberty.liberty.entity;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public class TbkCoupon {
    private Integer id;

    private String shopTitle;

    private Integer userType;

    private BigDecimal zkFinalPrice;

    private String title;

    private String nick;

    private Long sellerId;

    private Long volume;

    private String pictUrl;

    private String itemUrl;

    private Long couponTotalCount;

    private BigDecimal commissionRate;

    private String couponInfo;

    private BigDecimal couponMoney;

    private Long category;

    private Long numIid;

    private Long couponRemainCount;

    private Date couponStartTime;

    private Date couponEndTime;

    private String couponClickUrl;

    private String couponTpwd;

    private String itemDescription;

    private Date createTime;

    private Date updateTime;

    private String imgUrl;

    private String status;

    private List<SmallImages> smallImages;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getShopTitle() {
        return shopTitle;
    }

    public void setShopTitle(String shopTitle) {
        this.shopTitle = shopTitle;
    }

    public Integer getUserType() {
        return userType;
    }

    public void setUserType(Integer userType) {
        this.userType = userType;
    }

    public BigDecimal getZkFinalPrice() {
        return zkFinalPrice;
    }

    public void setZkFinalPrice(BigDecimal zkFinalPrice) {
        this.zkFinalPrice = zkFinalPrice;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }

    public Long getSellerId() {
        return sellerId;
    }

    public void setSellerId(Long sellerId) {
        this.sellerId = sellerId;
    }

    public Long getVolume() {
        return volume;
    }

    public void setVolume(Long volume) {
        this.volume = volume;
    }

    public String getPictUrl() {
        return pictUrl;
    }

    public void setPictUrl(String pictUrl) {
        this.pictUrl = pictUrl;
    }

    public String getItemUrl() {
        return itemUrl;
    }

    public void setItemUrl(String itemUrl) {
        this.itemUrl = itemUrl;
    }

    public Long getCouponTotalCount() {
        return couponTotalCount;
    }

    public void setCouponTotalCount(Long couponTotalCount) {
        this.couponTotalCount = couponTotalCount;
    }

    public BigDecimal getCommissionRate() {
        return commissionRate;
    }

    public void setCommissionRate(BigDecimal commissionRate) {
        this.commissionRate = commissionRate;
    }

    public String getCouponInfo() {
        return couponInfo;
    }

    public void setCouponInfo(String couponInfo) {
        this.couponInfo = couponInfo;
    }

    public Long getCategory() {
        return category;
    }

    public void setCategory(Long category) {
        this.category = category;
    }

    public Long getNumIid() {
        return numIid;
    }

    public void setNumIid(Long numIid) {
        this.numIid = numIid;
    }

    public Long getCouponRemainCount() {
        return couponRemainCount;
    }

    public void setCouponRemainCount(Long couponRemainCount) {
        this.couponRemainCount = couponRemainCount;
    }

    public Date getCouponStartTime() {
        return couponStartTime;
    }

    public void setCouponStartTime(Date couponStartTime) {
        this.couponStartTime = couponStartTime;
    }

    public Date getCouponEndTime() {
        return couponEndTime;
    }

    public void setCouponEndTime(Date couponEndTime) {
        this.couponEndTime = couponEndTime;
    }

    public String getCouponClickUrl() {
        return couponClickUrl;
    }

    public void setCouponClickUrl(String couponClickUrl) {
        this.couponClickUrl = couponClickUrl;
    }

    public String getCouponTpwd() {
        return couponTpwd;
    }

    public void setCouponTpwd(String couponTpwd) {
        this.couponTpwd = couponTpwd;
    }

    public String getItemDescription() {
        return itemDescription;
    }

    public void setItemDescription(String itemDescription) {
        this.itemDescription = itemDescription;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public List<SmallImages> getSmallImages() {
        return smallImages;
    }

    public void setSmallImages(List<SmallImages> smallImages) {
        this.smallImages = smallImages;
    }


    public BigDecimal getCouponMoney() {
        return couponMoney;
    }

    public void setCouponMoney(BigDecimal couponMoney) {
        this.couponMoney = couponMoney;
    }


    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public TbkCoupon(String shopTitle, Integer userType, BigDecimal zkFinalPrice, String title, String nick,
                     Long sellerId, Long volume, String pictUrl, String itemUrl, Long couponTotalCount,
                     BigDecimal commissionRate, String couponInfo, Long category, Long numIid, Long couponRemainCount,
                     Date couponStartTime, Date couponEndTime, String couponClickUrl, String itemDescription, String status) {
        super();
        this.shopTitle = shopTitle;
        this.userType = userType;
        this.zkFinalPrice = zkFinalPrice;
        this.title = title;
        this.nick = nick;
        this.sellerId = sellerId;
        this.volume = volume;
        this.pictUrl = pictUrl;
        this.itemUrl = itemUrl;
        this.couponTotalCount = couponTotalCount;
        this.commissionRate = commissionRate;
        this.couponInfo = couponInfo;
        this.category = category;
        this.numIid = numIid;
        this.couponRemainCount = couponRemainCount;
        this.couponStartTime = couponStartTime;
        this.couponEndTime = couponEndTime;
        this.couponClickUrl = couponClickUrl;
        this.itemDescription = itemDescription;
        this.status = status;
    }

    public TbkCoupon() {
    }
}