package br.com.expenseController.controllers;

import org.omg.CORBA.Any;
import org.omg.CORBA.BAD_PARAM;
import org.omg.CORBA.ORB;
import org.omg.CORBA.TypeCode;
import org.omg.CORBA.portable.Delegate;
import org.omg.CORBA.portable.InputStream;
import org.omg.CORBA.portable.ObjectImpl;
import org.omg.CORBA.portable.OutputStream;

abstract public class TagControllerHelper {

    private static String ID = "IDL:br/com/expenseController/controllers/TagController:1.0";
    private static TypeCode TYPE_CODE = null;

    public static void insert(Any any, TagController that) {
        OutputStream out = any.create_output_stream();
        any.type(type());
        write(out, that);
        any.read_value(out.create_input_stream(), type());
    }

    public static TagController extract(Any a) {
        return read(a.create_input_stream());
    }


    synchronized public static TypeCode type() {
        if (TYPE_CODE == null) {
            TYPE_CODE = ORB.init().create_interface_tc(TagControllerHelper.id(), "TagController");
        }
        
        return TYPE_CODE;
    }

    public static String id() {
        return ID;
    }

    public static TagController read(InputStream istream) {
        return narrow(istream.read_Object(_TagControllerStub.class));
    }

    public static void write(OutputStream ostream, TagController value) {
        ostream.write_Object((org.omg.CORBA.Object) value);
    }

    public static TagController narrow(org.omg.CORBA.Object obj) {
        if (obj == null) {
            return null;
        } else if (obj instanceof TagController) {
            return (TagController) obj;
        } else if (!obj._is_a(id())) {
            throw new BAD_PARAM();
        } else {
            Delegate delegate = ((ObjectImpl) obj)._get_delegate();
            _TagControllerStub stub = new _TagControllerStub();
            stub._set_delegate(delegate);
            return stub;
        }
    }

    public static TagController unchecked_narrow(Object obj) {
        if (obj == null) {
            return null;
        } else if (obj instanceof TagController) {
            return (TagController) obj;
        } else {
            Delegate delegate = ((ObjectImpl) obj)._get_delegate();
            _TagControllerStub stub = new _TagControllerStub();
            stub._set_delegate(delegate);
            return stub;
        }
    }
}