package br.com.expenseController.model;

import java.util.List;
import org.omg.CORBA.portable.InputStream;
import org.omg.CORBA.portable.OutputStream;
import org.omg.CORBA.portable.Streamable;

public final class TagsHolder implements Streamable {

    private List<Tag> value = null;

    public TagsHolder() {
    }

    public TagsHolder(List<Tag> initialValue) {
        value = initialValue;
    }

    @Override
    public void _read(InputStream i) {
        value = TagsHelper.read(i);
    }

    @Override
    public void _write(OutputStream o) {
        TagsHelper.write(o, value);
    }

    @Override
    public org.omg.CORBA.TypeCode _type() {
        return TagsHelper.type();
    }

}
