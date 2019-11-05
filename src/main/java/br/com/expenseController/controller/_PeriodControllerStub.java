package br.com.expenseController.controllers;

import br.com.expenseController.Period;
import br.com.expenseController.PeriodHelper;
import br.com.expenseController.PeriodsHelper;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import org.omg.CORBA.MARSHAL;
import org.omg.CORBA.ORB;
import org.omg.CORBA.portable.ApplicationException;
import org.omg.CORBA.portable.Delegate;
import org.omg.CORBA.portable.InputStream;
import org.omg.CORBA.portable.ObjectImpl;
import org.omg.CORBA.portable.OutputStream;
import org.omg.CORBA.portable.RemarshalException;

public class _PeriodControllerStub extends ObjectImpl implements PeriodController {

    public boolean insert(Period period) {
        InputStream $in = null;
        
        try {
            OutputStream $out = _request("insert", true);
            br.com.expenseController.PeriodHelper.write($out, period);
            $in = _invoke($out);
            boolean $result = $in.read_boolean();
            return $result;
        } catch (ApplicationException $ex) {
            $in = $ex.getInputStream();
            String _id = $ex.getId();
            throw new org.omg.CORBA.MARSHAL(_id);
        } catch (RemarshalException $rm) {
            return insert(period);
        } finally {
            _releaseReply($in);
        }
    }

    public boolean update(Period period) {
        InputStream $in = null;
        try {
            OutputStream $out = _request("update", true);
            PeriodHelper.write($out, period);
            $in = _invoke($out);
            boolean $result = $in.read_boolean();
            return $result;
        } catch (ApplicationException $ex) {
            $in = $ex.getInputStream();
            String _id = $ex.getId();
            throw new MARSHAL(_id);
        } catch (RemarshalException $rm) {
            return update(period);
        } finally {
            _releaseReply($in);
        }
    }

    public boolean remove(Period period) {
        InputStream $in = null;
        
        try {
            OutputStream $out = _request("remove", true);
            PeriodHelper.write($out, period);
            $in = _invoke($out);
            boolean $result = $in.read_boolean();
            return $result;
        } catch (ApplicationException $ex) {
            $in = $ex.getInputStream();
            String _id = $ex.getId();
            throw new MARSHAL(_id);
        } catch (RemarshalException $rm) {
            return remove(period);
        } finally {
            _releaseReply($in);
        }
    }

    public Period load(int code) {
        InputStream $in = null;
        
        try {
            OutputStream $out = _request("load", true);
            $out.write_long(code);
            $in = _invoke($out);
            Period $result = PeriodHelper.read($in);
            return $result;
        } catch (ApplicationException $ex) {
            $in = $ex.getInputStream();
            String _id = $ex.getId();
            throw new MARSHAL(_id);
        } catch (RemarshalException $rm) {
            return load(code);
        } finally {
            _releaseReply($in);
        }
    }

    public Period[] loadAll() {
        InputStream $in = null;

        try {
            OutputStream $out = _request("loadAll", true);
            $in = _invoke($out);
            Period $result[] = PeriodsHelper.read($in);
            return $result;
        } catch (ApplicationException $ex) {
            $in = $ex.getInputStream();
            String _id = $ex.getId();
            throw new MARSHAL(_id);
        } catch (RemarshalException $rm) {
            return loadAll();
        } finally {
            _releaseReply($in);
        }
    }

    private static String[] IDS = {
        "IDL:br/com/expenseController/controllers/PeriodController:1.0"};

    public String[] _ids() {
        return (String[]) IDS.clone();
    }

    private void readObject(ObjectInputStream s) throws IOException {
        String str = s.readUTF();
        String[] args = null;
        java.util.Properties props = null;
        ORB orb = ORB.init(args, props);
        
        try {
            Object obj = orb.string_to_object(str);
            Delegate delegate = ((ObjectImpl) obj)._get_delegate();
            _set_delegate(delegate);
        } finally {
            orb.destroy();
        }
    }

    private void writeObject(ObjectOutputStream s) throws IOException {
        String[] args = null;
        java.util.Properties props = null;
        ORB orb = ORB.init(args, props);
        
        try {
            String str = orb.object_to_string(this);
            s.writeUTF(str);
        } finally {
            orb.destroy();
        }
    }
}