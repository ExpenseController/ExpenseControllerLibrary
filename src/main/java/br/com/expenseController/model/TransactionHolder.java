package br.com.expenseController.model;

import org.omg.CORBA.portable.InputStream;
import org.omg.CORBA.portable.OutputStream;
import org.omg.CORBA.portable.Streamable;

public final class TransactionHolder implements Streamable {

    private Transaction value = null;

    public TransactionHolder() {
    }

    public TransactionHolder(Transaction initialValue) {
        value = initialValue;
    }

    @Override
    public void _read(InputStream i) {
        value = TransactionHelper.read(i);
    }

    @Override
    public void _write(OutputStream o) {
        TransactionHelper.write(o, value);
    }

    @Override
    public org.omg.CORBA.TypeCode _type() {
        return TransactionHelper.type();
    }
}