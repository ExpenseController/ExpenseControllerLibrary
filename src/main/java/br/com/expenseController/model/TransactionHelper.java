package br.com.expenseController;

import java.math.BigDecimal;
import org.omg.CORBA.Any;
import org.omg.CORBA.ORB;
import org.omg.CORBA.StructMember;
import org.omg.CORBA.TCKind;
import org.omg.CORBA.TypeCode;
import org.omg.CORBA.portable.InputStream;
import org.omg.CORBA.portable.OutputStream;

abstract public class TransactionHelper {

    private static String ID = "IDL:br/com/expenseController/Transaction:1.0";
    private static TypeCode TYPE_CODE = null;
    private static boolean ACTIVE = false;

    public static void insert(Any any, Transaction that) {
        OutputStream out = any.create_output_stream();
        any.type(type());
        write(out, that);
        any.read_value(out.create_input_stream(), type());
    }

    public static Transaction extract(Any a) {
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
                    StructMember[] members = new StructMember[5];
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
                    membersTypeCode = ORB.init().get_primitive_tc(TCKind.tk_longlong);
                    members[2] = new StructMember(
                            "date",
                            membersTypeCode,
                            null);
                    membersTypeCode = ORB.init().get_primitive_tc(TCKind.tk_double);
                    members[3] = new StructMember(
                            "value",
                            membersTypeCode,
                            null);
                    membersTypeCode = TagHelper.type();
                    members[4] = new StructMember(
                            "tag",
                            membersTypeCode,
                            null);
                    TYPE_CODE = ORB.init().create_struct_tc(TransactionHelper.id(), "Transaction", members);
                    ACTIVE = false;
                }
            }
        }
        return TYPE_CODE;
    }

    public static String id() {
        return ID;
    }

    public static Transaction read(InputStream istream) {
        int code = istream.read_long();
        String description = istream.read_wstring();
        long date = istream.read_longlong();
        BigDecimal value = BigDecimal.valueOf(istream.read_double());
        Tag tag = TagHelper.read(istream);
        return new Transaction(code, description, date, value, tag);
    }

    public static void write(OutputStream ostream, Transaction value) {
        ostream.write_long(value.getCode());
        ostream.write_wstring(value.getDescription());
        ostream.write_longlong(value.getDate());
        ostream.write_double(value.getValue().doubleValue());
        TagHelper.write(ostream, value.getTag());
    }

}
