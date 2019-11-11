package br.com.expenseController.model;

import java.util.List;
import org.omg.CORBA.portable.InputStream;
import org.omg.CORBA.portable.OutputStream;
import org.omg.CORBA.portable.Streamable;

public final class PeriodsHolder implements Streamable {

    public List<Period> value = null;

    public PeriodsHolder() {
    }

    public PeriodsHolder(List<Period> initialValue) {
        value = initialValue;
    }

    @Override
    public void _read(InputStream i) {
        value = PeriodsHelper.read(i);
    }

    @Override
    public void _write(OutputStream o) {
        PeriodsHelper.write(o, value);
    }

    @Override
    public org.omg.CORBA.TypeCode _type() {
        return PeriodsHelper.type();
    }

}
