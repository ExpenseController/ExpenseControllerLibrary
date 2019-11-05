package br.com.expenseController;

import org.omg.CORBA.portable.IDLEntity;

public final class Tag implements IDLEntity {

    private int code;
    private String description;

    public Tag() {
    }

    public Tag(int code, String description) {
        this.code = code;
        this.description = description;
    }

    public int getCode() {
        return this.code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
