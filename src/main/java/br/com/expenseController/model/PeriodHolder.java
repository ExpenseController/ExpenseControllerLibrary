package br.com.expenseController.model;

import org.omg.CORBA.portable.InputStream;
import org.omg.CORBA.portable.OutputStream;
import org.omg.CORBA.portable.Streamable;

public final class PeriodHolder implements Streamable {

    private Period value = null;

    public PeriodHolder() {
    }

    public PeriodHolder(Period initialValue) {
        value = initialValue;
    }

    @Override
    public void _read(InputStream i) {
        value = PeriodHelper.read(i);
    }

    @Override
    public void _write(OutputStream o) {
        PeriodHelper.write(o, value);
    }

    @Override
    public org.omg.CORBA.TypeCode _type() {
        return PeriodHelper.type();
    }

}
