package br.com.expenseController.model;

import java.util.ArrayList;
import java.util.List;
import org.omg.CORBA.Any;
import org.omg.CORBA.ORB;
import org.omg.CORBA.TypeCode;
import org.omg.CORBA.portable.InputStream;
import org.omg.CORBA.portable.OutputStream;

abstract public class PeriodsHelper {

    private static String ID = "IDL:br/com/expenseController/Periods:1.0";
    private static TypeCode TYPE_CODE = null;

    public static void insert(Any any, List<Period> that) {
        OutputStream out = any.create_output_stream();
        any.type(type());
        write(out, that);
        any.read_value(out.create_input_stream(), type());
    }

    public static List<Period> extract(Any any) {
        return read(any.create_input_stream());
    }

    synchronized public static TypeCode type() {
        if (TYPE_CODE == null) {
            TYPE_CODE = PeriodHelper.type();
            TYPE_CODE = ORB.init().create_sequence_tc(0, TYPE_CODE);
            TYPE_CODE = ORB.init().create_alias_tc(PeriodsHelper.id(), "Periods", TYPE_CODE);
        }

        return TYPE_CODE;
    }

    public static String id() {
        return ID;
    }

    public static List<Period> read(InputStream istream) {
        List<Period> value = new ArrayList<>();
        int lenght = istream.read_long();

        for (int i = 0; i < lenght; ++i) {
            value.add(PeriodHelper.read(istream));
        }
        
        return value;
    }

    public static void write(OutputStream ostream, List<Period> value) {
        ostream.write_long(value.size());
        value.forEach((period) -> PeriodHelper.write(ostream, period));
    }
}