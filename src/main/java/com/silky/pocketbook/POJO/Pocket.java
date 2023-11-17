package com.silky.pocketbook.POJO;

import java.io.Serializable;
import java.util.Date;

public class Pocket implements Serializable {
    private Integer id;

    private Date recordDay;

    private Integer kind;

    private Double value;

    private Integer userId;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getRecordDay() {
        return recordDay;
    }

    public void setRecordDay(Date recordDay) {
        this.recordDay = recordDay;
    }

    public Integer getKind() {
        return kind;
    }

    public void setKind(Integer kind) {
        this.kind = kind;
    }

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "Pocket{" +
                "id=" + id +
                ", recordDay=" + recordDay +
                ", kind=" + kind +
                ", value=" + value +
                ", userId=" + userId +
                '}';
    }
}