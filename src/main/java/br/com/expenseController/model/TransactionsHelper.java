package br.com.expenseController.model;

import java.util.ArrayList;
import java.util.List;
import org.omg.CORBA.Any;
import org.omg.CORBA.ORB;
import org.omg.CORBA.TypeCode;
import org.omg.CORBA.portable.InputStream;
import org.omg.CORBA.portable.OutputStream;

abstract public class TransactionsHelper {

    private static final String ID = "IDL:br/com/expenseController/Transactions:1.0";
    private static TypeCode TYPE_CODE = null;

    public static void insert(Any a, List<Transaction> that) {
        OutputStream out = a.create_output_stream();
        a.type(type());
        write(out, that);
        a.read_value(out.create_input_stream(), type());
    }

    public static List<Transaction> extract(Any a) {
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

    public static List<Transaction> read(InputStream istream) {
        List<Transaction> value = null;
        int lenght = istream.read_long();
        value = new ArrayList<>(lenght);
        
        for (int i = 0; i < value.size(); ++i) {
            value.add(TransactionHelper.read(istream));
        }
        
        return value;
    }

    public static void write(OutputStream ostream, List<Transaction> value) {
        ostream.write_long(value.size());
        
        value.forEach((transaction) -> {
            TransactionHelper.write(ostream, transaction);
        });
    }
}