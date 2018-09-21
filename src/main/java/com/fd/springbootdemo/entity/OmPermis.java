package com.fd.springbootdemo.entity;

import java.util.Date;

public class OmPermis {
    private Integer permisId;

    private Integer parentPermisId;

    private String permisName;

    private Byte menuPermisFlag;

    private String permisCode;

    private String remark;

    private Integer permisOrder;

    private Date createTime;

    private Date updateTime;

    public Integer getPermisId() {
        return permisId;
    }

    public void setPermisId(Integer permisId) {
        this.permisId = permisId;
    }

    public Integer getParentPermisId() {
        return parentPermisId;
    }

    public void setParentPermisId(Integer parentPermisId) {
        this.parentPermisId = parentPermisId;
    }

    public String getPermisName() {
        return permisName;
    }

    public void setPermisName(String permisName) {
        this.permisName = permisName == null ? null : permisName.trim();
    }

    public Byte getMenuPermisFlag() {
        return menuPermisFlag;
    }

    public void setMenuPermisFlag(Byte menuPermisFlag) {
        this.menuPermisFlag = menuPermisFlag;
    }

    public String getPermisCode() {
        return permisCode;
    }

    public void setPermisCode(String permisCode) {
        this.permisCode = permisCode == null ? null : permisCode.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public Integer getPermisOrder() {
        return permisOrder;
    }

    public void setPermisOrder(Integer permisOrder) {
        this.permisOrder = permisOrder;
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
}