package br.com.expenseController.persistence;

import org.omg.CORBA.Any;
import org.omg.CORBA.BAD_PARAM;
import org.omg.CORBA.ORB;
import org.omg.CORBA.TypeCode;
import org.omg.CORBA.portable.Delegate;
import org.omg.CORBA.portable.InputStream;
import org.omg.CORBA.portable.ObjectImpl;
import org.omg.CORBA.portable.OutputStream;

abstract public class PeriodPersistenceHelper {

    private static String ID = "IDL:br/com/expenseController/persistence/PeriodPersistence:1.0";

    public static void insert(Any any, PeriodPersistence that) {
        OutputStream out = any.create_output_stream();
        any.type(type());
        write(out, that);
        any.read_value(out.create_input_stream(), type());
    }

    public static PeriodPersistence extract(Any any) {
        return read(any.create_input_stream());
    }

    private static TypeCode __typeCode = null;

    synchronized public static TypeCode type() {
        if (__typeCode == null) {
            __typeCode = ORB.init().create_interface_tc(br.com.expenseController.persistence.PeriodPersistenceHelper.id(), "PeriodPersistence");
        }
        return __typeCode;
    }

    public static String id() {
        return ID;
    }

    public static PeriodPersistence read(InputStream istream) {
        return narrow(istream.read_Object(_PeriodPersistenceStub.class));
    }

    public static void write(OutputStream ostream, PeriodPersistence value) {
        ostream.write_Object((org.omg.CORBA.Object) value);
    }

    public static PeriodPersistence narrow(org.omg.CORBA.Object obj) {
        if (obj == null) {
            return null;
        } else if (obj instanceof PeriodPersistence) {
            return (PeriodPersistence) obj;
        } else if (!obj._is_a(id())) {
            throw new BAD_PARAM();
        } else {
            Delegate delegate = ((ObjectImpl) obj)._get_delegate();
           _PeriodPersistenceStub stub = new _PeriodPersistenceStub();
            stub._set_delegate(delegate);
            return stub;
        }
    }

    public static PeriodPersistence unchecked_narrow(org.omg.CORBA.Object obj) {
        if (obj == null) {
            return null;
        } else if (obj instanceof PeriodPersistence) {
            return (PeriodPersistence) obj;
        } else {
            Delegate delegate = ((ObjectImpl) obj)._get_delegate();
           _PeriodPersistenceStub stub = new _PeriodPersistenceStub();
            stub._set_delegate(delegate);
            return stub;
        }
    }

}
