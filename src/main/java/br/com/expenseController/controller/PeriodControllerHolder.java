package br.com.expenseController.controller;

import org.omg.CORBA.portable.InputStream;
import org.omg.CORBA.portable.OutputStream;
import org.omg.CORBA.portable.Streamable;

public final class PeriodControllerHolder implements Streamable {

    private PeriodController value;

    public PeriodControllerHolder() {
    }

    public PeriodControllerHolder(PeriodController initialValue) {
        this.value = initialValue;
    }

    @Override
    public void _read(InputStream i) {
        this.value = PeriodControllerHelper.read(i);
    }

    @Override
    public void _write(OutputStream o) {
        PeriodControllerHelper.write(o, value);
    }

    @Override
    public org.omg.CORBA.TypeCode _type() {
        return PeriodControllerHelper.type();
    }

}
