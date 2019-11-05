package br.com.expenseController.controllers;

import org.omg.CORBA.Any;
import org.omg.CORBA.BAD_PARAM;
import org.omg.CORBA.ORB;
import org.omg.CORBA.TypeCode;
import org.omg.CORBA.portable.Delegate;
import org.omg.CORBA.portable.InputStream;
import org.omg.CORBA.portable.ObjectImpl;
import org.omg.CORBA.portable.OutputStream;

abstract public class TransactionControllerHelper {

    private static final String ID = "IDL:br/com/expenseController/controllers/TransactionController:1.0";
    private static TypeCode TYPE_CODE = null;

    public static void insert(Any any, TransactionController that) {
        OutputStream out = any.create_output_stream();
        any.type(type());
        write(out, that);
        any.read_value(out.create_input_stream(), type());
    }

    public static TransactionController extract(Any any) {
        return read(any.create_input_stream());
    }

    synchronized public static TypeCode type() {
        if (TYPE_CODE == null) {
            TYPE_CODE = ORB.init().create_interface_tc(br.com.expenseController.controllers.TransactionControllerHelper.id(), "TransactionController");
        }

        return TYPE_CODE;
    }

    public static String id() {
        return ID;
    }

    public static TransactionController read(InputStream istream) {
        return narrow(istream.read_Object(_TransactionControllerStub.class));
    }

    public static void write(OutputStream ostream, TransactionController value) {
        ostream.write_Object((org.omg.CORBA.Object) value);
    }

    public static TransactionController narrow(org.omg.CORBA.Object obj) {
        if (obj == null) {
            return null;
        } else if (obj instanceof TransactionController) {
            return (TransactionController) obj;
        } else if (!obj._is_a(id())) {
            throw new BAD_PARAM();
        } else {
            Delegate delegate = ((ObjectImpl) obj)._get_delegate();
            _TransactionControllerStub stub = new _TransactionControllerStub();
            stub._set_delegate(delegate);
            return stub;
        }
    }

    public static TransactionController unchecked_narrow(Object obj) {
        if (obj == null) {
            return null;
        } else if (obj instanceof TransactionController) {
            return (TransactionController) obj;
        } else {
            Delegate delegate = ((ObjectImpl) obj)._get_delegate();
            _TransactionControllerStub stub = new _TransactionControllerStub();
            stub._set_delegate(delegate);
            return stub;
        }
    }
}