package br.com.expenseController.model;

import org.omg.CORBA.portable.InputStream;
import org.omg.CORBA.portable.OutputStream;
import org.omg.CORBA.portable.Streamable;

public final class TagHolder implements Streamable {

    private Tag value = null;

    public TagHolder() {
    }

    public TagHolder(Tag initialValue) {
        value = initialValue;
    }

    @Override
    public void _read(InputStream i) {
        value = TagHelper.read(i);
    }

    @Override
    public void _write(OutputStream o) {
        TagHelper.write(o, value);
    }

    @Override
    public org.omg.CORBA.TypeCode _type() {
        return TagHelper.type();
    }
}