package br.com.expenseController.controller;

import org.omg.CORBA.TypeCode;
import org.omg.CORBA.portable.InputStream;
import org.omg.CORBA.portable.OutputStream;
import org.omg.CORBA.portable.Streamable;

public final class TransactionControllerHolder implements Streamable {

    public TransactionController value = null;

    public TransactionControllerHolder() {
    }

    public TransactionControllerHolder(TransactionController initialValue) {
        this.value = initialValue;
    }

    @Override
    public void _read(InputStream i) {
        this.value = TransactionControllerHelper.read(i);
    }

    @Override
    public void _write(OutputStream o) {
        TransactionControllerHelper.write(o, value);
    }

    @Override
    public TypeCode _type() {
        return TransactionControllerHelper.type();
    }
}