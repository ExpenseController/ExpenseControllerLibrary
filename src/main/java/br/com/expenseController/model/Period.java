package br.com.expenseController;

import java.util.ArrayList;
import java.util.List;
import org.omg.CORBA.portable.IDLEntity;

public final class Period implements IDLEntity {

    private int code;
    private String description;
    private List<Transaction> outlay;
    private List<Transaction> earnings;

    public Period() {
        this.outlay = new ArrayList<>();
        this.earnings = new ArrayList<>();
    }

    public Period(int code, String description, List<Transaction> outlay, List<Transaction> earnings) {
        this.code = code;
        this.description = description;
        this.outlay = outlay;
        this.earnings = earnings;
    }

    public int getCode() {
        return this.code;
    }

    public String getDescription() {
        return this.description;
    }

    public List<Transaction> getOutlay() {
        return this.outlay;
    }

    public List<Transaction> getEarnings() {
        return this.earnings;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
