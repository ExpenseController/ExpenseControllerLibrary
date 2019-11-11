package br.com.expenseController.model;

import java.util.ArrayList;
import java.util.List;
import org.omg.CORBA.Any;
import org.omg.CORBA.ORB;
import org.omg.CORBA.TypeCode;
import org.omg.CORBA.portable.InputStream;
import org.omg.CORBA.portable.OutputStream;

abstract public class TagsHelper {

    private static final String ID = "IDL:br/com/expenseController/Tags:1.0";
    private static TypeCode TYPE_CODE = null;

    public static void insert(Any any, List<Tag> tags) {
        OutputStream out = any.create_output_stream();
        any.type(type());
        write(out, tags);
        any.read_value(out.create_input_stream(), type());
    }

    public static List<Tag> extract(Any any) {
        return read(any.create_input_stream());
    }

    synchronized public static TypeCode type() {
        if (TYPE_CODE == null) {
            TYPE_CODE = TagHelper.type();
            TYPE_CODE = ORB.init().create_sequence_tc(0, TYPE_CODE);
            TYPE_CODE = ORB.init().create_alias_tc(TagsHelper.id(), "Tags", TYPE_CODE);
        }
        return TYPE_CODE;
    }

    public static String id() {
        return ID;
    }

    public static List<Tag> read(InputStream istream) {
        List<Tag> value = null;
        int lenght = istream.read_long();
        value = new ArrayList<>(lenght);

        for (int i = 0; i < value.size(); ++i) {
            value.add(TagHelper.read(istream));
        }

        return value;
    }

    public static void write(OutputStream ostream, List<Tag> value) {
        ostream.write_long(value.size());
        
        for (int i = 0; i < value.size(); ++i) {
            TagHelper.write(ostream, value.get(i));
        }
    }

}
