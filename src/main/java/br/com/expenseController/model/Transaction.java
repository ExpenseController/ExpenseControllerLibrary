package br.com.expenseController;

import java.math.BigDecimal;
import org.omg.CORBA.portable.IDLEntity;

public final class Transaction implements IDLEntity {

    private int code;
    private String description;
    private long date;
    private BigDecimal value;
    private Tag tag;

    public Transaction() {
    }

    public Transaction(int code, String description, long date, BigDecimal value, Tag tag) {
        this.code = code;
        this.description = description;
        this.date = date;
        this.value = value;
        this.tag = tag;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public long getDate() {
        return date;
    }

    public void setDate(long date) {
        this.date = date;
    }

    public BigDecimal getValue() {
        return value;
    }

    public void setValue(BigDecimal value) {
        this.value = value;
    }

    public Tag getTag() {
        return tag;
    }

    public void setTag(Tag tag) {
        this.tag = tag;
    }
}
