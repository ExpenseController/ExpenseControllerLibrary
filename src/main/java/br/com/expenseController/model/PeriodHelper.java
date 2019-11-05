package br.com.expenseController.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.omg.CORBA.Any;
import org.omg.CORBA.ORB;
import org.omg.CORBA.StructMember;
import org.omg.CORBA.TCKind;
import org.omg.CORBA.TypeCode;
import org.omg.CORBA.portable.InputStream;
import org.omg.CORBA.portable.OutputStream;

abstract public class PeriodHelper {

    private static final String ID = "IDL:br/com/expenseController/Period:1.0";
    private static TypeCode TYPE_CODE = null;
    private static boolean ACTIVE = false;

    public static void insert(Any any, Period period) {
        OutputStream out = any.create_output_stream();
        any.type(type());
        write(out, period);
        any.read_value(out.create_input_stream(), type());
    }

    public static Period extract(Any a) {
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
                    StructMember[] members = new StructMember[4];
                    TypeCode membersTypeCode = null;
                    membersTypeCode = ORB.init().get_primitive_tc(TCKind.tk_long);
                    members[0] = new StructMember(
                            "codigo",
                            membersTypeCode,
                            null);
                    membersTypeCode = ORB.init().create_wstring_tc(0);
                    members[1] = new StructMember(
                            "description",
                            membersTypeCode,
                            null);
                    membersTypeCode = TransactionHelper.type();
                    membersTypeCode = ORB.init().create_sequence_tc(0, membersTypeCode);
                    membersTypeCode = ORB.init().create_alias_tc(TransactionsHelper.id(), "Transactions", membersTypeCode);
                    members[2] = new StructMember(
                            "outlay",
                            membersTypeCode,
                            null);
                    membersTypeCode = TransactionHelper.type();
                    membersTypeCode = ORB.init().create_sequence_tc(0, membersTypeCode);
                    membersTypeCode = ORB.init().create_alias_tc(TransactionsHelper.id(), "Transactions", membersTypeCode);
                    members[3] = new StructMember(
                            "earnings",
                            membersTypeCode,
                            null);
                    TYPE_CODE = ORB.init().create_struct_tc(PeriodHelper.id(), "Period", members);
                    ACTIVE = false;
                }
            }
        }
        return TYPE_CODE;
    }

    public static String id() {
        return ID;
    }

    public static Period read(InputStream istream) {
        int code = istream.read_long();
        String description = istream.read_wstring();
        List<Transaction> outlay = new ArrayList<>(Arrays.asList(TransactionsHelper.read(istream)));
        List<Transaction> earnings = new ArrayList<>(Arrays.asList(TransactionsHelper.read(istream)));
        Period value = new Period(code, description, outlay, earnings);
        return value;
    }

    public static void write(OutputStream ostream, Period period) {
        ostream.write_long(period.getCode());
        ostream.write_wstring(period.getDescription());
        TransactionsHelper.write(ostream, (Transaction[]) period.getOutlay().toArray());
        TransactionsHelper.write(ostream, (Transaction[]) period.getEarnings().toArray());
    }

}
