package br.com.expenseController.controllers;

import org.omg.CORBA.Any;
import org.omg.CORBA.BAD_PARAM;
import org.omg.CORBA.ORB;
import org.omg.CORBA.TypeCode;
import org.omg.CORBA.portable.Delegate;
import org.omg.CORBA.portable.InputStream;
import org.omg.CORBA.portable.ObjectImpl;
import org.omg.CORBA.portable.OutputStream;

abstract public class PeriodControllerHelper {

    private static final String ID = "IDL:br/com/expenseController/controllers/PeriodController:1.0";
    private static TypeCode TYPE_CODE = null;

    public static void insert(Any any, PeriodController that) {
        OutputStream out = any.create_output_stream();
        any.type(type());
        write(out, that);
        any.read_value(out.create_input_stream(), type());
    }

    public static PeriodController extract(Any any) {
        return read(any.create_input_stream());
    }

    synchronized public static TypeCode type() {
        if (TYPE_CODE == null) {
            TYPE_CODE = ORB.init().create_interface_tc(PeriodControllerHelper.id(), "PeriodController");
        }
        
        return TYPE_CODE;
    }

    public static String id() {
        return ID;
    }

    public static PeriodController read(InputStream istream) {
        return narrow(istream.read_Object(_PeriodControllerStub.class));
    }

    public static void write(OutputStream ostream, PeriodController value) {
        ostream.write_Object((org.omg.CORBA.Object) value);
    }

    public static PeriodController narrow(org.omg.CORBA.Object obj) {
        if (obj == null) {
            return null;
        } else if (obj instanceof PeriodController) {
            return (PeriodController) obj;
        } else if (!obj._is_a(id())) {
            throw new BAD_PARAM();
        } else {
            Delegate delegate = ((ObjectImpl) obj)._get_delegate();
            _PeriodControllerStub stub = new _PeriodControllerStub();
            stub._set_delegate(delegate);
            return stub;
        }
    }

    public static PeriodController unchecked_narrow(org.omg.CORBA.Object obj) {
        if (obj == null) {
            return null;
        } else if (obj instanceof PeriodController) {
            return (PeriodController) obj;
        } else {
            Delegate delegate = ((ObjectImpl) obj)._get_delegate();
            _PeriodControllerStub stub = new _PeriodControllerStub();
            stub._set_delegate(delegate);
            return stub;
        }
    }

}