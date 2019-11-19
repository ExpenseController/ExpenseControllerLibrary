package br.com.expenseController.model;

import java.math.BigDecimal;
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
    
    public BigDecimal outlayTotalValue() {
        BigDecimal total = BigDecimal.ZERO;
        
        this.outlay.forEach((transaction) -> {
            total.add(transaction.getValue());
        });
        
        return total;
    }
    
    public BigDecimal earningsTotalValue() {
        BigDecimal total = BigDecimal.ZERO;
        
        this.earnings.forEach((transaction) -> {
            total.add(transaction.getValue());
        });
        
        return total;
    }
    
    public BigDecimal wallet() {
        return earningsTotalValue().subtract(outlayTotalValue());
    }
}
