package br.com.expenseController;

import org.omg.CORBA.Any;
import org.omg.CORBA.ORB;
import org.omg.CORBA.StructMember;
import org.omg.CORBA.TCKind;
import org.omg.CORBA.TypeCode;
import org.omg.CORBA.portable.InputStream;
import org.omg.CORBA.portable.OutputStream;

abstract public class TagHelper {

    private static final String ID = "IDL:br/com/expenseController/Tag:1.0";
    private static TypeCode TYPE_CODE = null;
    private static boolean ACTIVE = false;

    public static void insert(Any a, Tag that) {
        OutputStream out = a.create_output_stream();
        a.type(type());
        write(out, that);
        a.read_value(out.create_input_stream(), type());
    }

    public static Tag extract(Any a) {
        return read(a.create_input_stream());
    }

    synchronized public static TypeCode type() {
        if (TYPE_CODE == null) {
            synchronized (TypeCode.class) {
                if (TYPE_CODE == null) {
                    if (ACTIVE) {
                        return ORB.init().create_recursive_tc(ID);
                    }
                    
                    ACTIVE = true;
                    StructMember[] members = new StructMember[2];
                    TypeCode membersTypeCode = null;
                    membersTypeCode = ORB.init().get_primitive_tc(TCKind.tk_long);
                    members[0] = new StructMember(
                            "code",
                            membersTypeCode,
                            null);
                    membersTypeCode = ORB.init().create_wstring_tc(0);
                    members[1] = new StructMember(
                            "description",
                            membersTypeCode,
                            null);
                    TYPE_CODE = ORB.init().create_struct_tc(TagHelper.id(), "Tag", members);
                    ACTIVE = false;
                }
            }
        }
        return TYPE_CODE;
    }

    public static String id() {
        return ID;
    }

    public static Tag read(InputStream istream) {
        Tag value = new Tag(istream.read_long(), istream.read_wstring());
        return value;
    }

    public static void write(OutputStream ostream, Tag tag) {
        ostream.write_long(tag.getCode());
        ostream.write_wstring(tag.getDescription());
    }

}
