package br.com.expenseController;

import org.omg.CORBA.portable.InputStream;
import org.omg.CORBA.portable.OutputStream;
import org.omg.CORBA.portable.Streamable;

public final class TransactionsHolder implements Streamable {

    private Transaction value[] = null;

    public TransactionsHolder() {
    }

    public TransactionsHolder(Transaction[] initialValue) {
        value = initialValue;
    }

    @Override
    public void _read(InputStream i) {
        value = TransactionsHelper.read(i);
    }

    @Override
    public void _write(OutputStream o) {
        TransactionsHelper.write(o, value);
    }

    @Override
    public org.omg.CORBA.TypeCode _type() {
        return TransactionsHelper.type();
    }
}