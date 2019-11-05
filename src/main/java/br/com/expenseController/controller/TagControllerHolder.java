package br.com.expenseController.controller;

import org.omg.CORBA.TypeCode;
import org.omg.CORBA.portable.InputStream;
import org.omg.CORBA.portable.OutputStream;
import org.omg.CORBA.portable.Streamable;

public final class TagControllerHolder implements Streamable {

    public TagController value = null;

    public TagControllerHolder() {
    }

    public TagControllerHolder(TagController initialValue) {
        this.value = initialValue;
    }

    @Override
    public void _read(InputStream i) {
        this.value = TagControllerHelper.read(i);
    }

    @Override
    public void _write(OutputStream o) {
        TagControllerHelper.write(o, value);
    }

    @Override
    public TypeCode _type() {
        return TagControllerHelper.type();
    }
}