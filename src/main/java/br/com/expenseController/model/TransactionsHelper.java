package br.com.expenseController;

import org.omg.CORBA.Any;
import org.omg.CORBA.ORB;
import org.omg.CORBA.TypeCode;
import org.omg.CORBA.portable.InputStream;
import org.omg.CORBA.portable.OutputStream;

abstract public class TransactionsHelper {

    private static final String ID = "IDL:br/com/expenseController/Transactions:1.0";
    private static TypeCode TYPE_CODE = null;

    public static void insert(Any a, Transaction[] that) {
        OutputStream out = a.create_output_stream();
        a.type(type());
        write(out, that);
        a.read_value(out.create_input_stream(), type());
    }

    public static Transaction[] extract(Any a) {
        return read(a.create_input_stream());
    }


    synchronized public static TypeCode type() {
        if (TYPE_CODE == null) {
            TYPE_CODE = TransactionHelper.type();
            TYPE_CODE = ORB.init().create_sequence_tc(0, TYPE_CODE);
            TYPE_CODE = ORB.init().create_alias_tc(TransactionsHelper.id(), "Transactions", TYPE_CODE);
        }
        return TYPE_CODE;
    }

    public static String id() {
        return ID;
    }

    public static Transaction[] read(InputStream istream) {
        Transaction value[] = null;
        int lenght = istream.read_long();
        value = new Transaction[lenght];
        
        for (int i = 0; i < value.length; ++i) {
            value[i] = TransactionHelper.read(istream);
        }
        
        return value;
    }

    public static void write(OutputStream ostream, Transaction[] value) {
        ostream.write_long(value.length);
        
        for (int i = 0; i < value.length; ++i) {
            TransactionHelper.write(ostream, value[i]);
        }
    }
}