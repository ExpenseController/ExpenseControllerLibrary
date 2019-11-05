package br.com.expenseController.persistence;

import br.com.expenseController.model.Period;
import br.com.expenseController.model.PeriodHelper;
import br.com.expenseController.model.PeriodsHelper;

public class _PeriodPersistenceStub extends org.omg.CORBA.portable.ObjectImpl implements br.com.expenseController.persistence.PeriodPersistence {

    public boolean insert(Period period) {
        org.omg.CORBA.portable.InputStream $in = null;
        try {
            org.omg.CORBA.portable.OutputStream $out = _request("insert", true);
            PeriodHelper.write($out, period);
            $in = _invoke($out);
            boolean $result = $in.read_boolean();
            return $result;
        } catch (org.omg.CORBA.portable.ApplicationException $ex) {
            $in = $ex.getInputStream();
            String _id = $ex.getId();
            throw new org.omg.CORBA.MARSHAL(_id);
        } catch (org.omg.CORBA.portable.RemarshalException $rm) {
            return insert(period);
        } finally {
            _releaseReply($in);
        }
    } // insert

    public boolean update(Period period) {
        org.omg.CORBA.portable.InputStream $in = null;
        try {
            org.omg.CORBA.portable.OutputStream $out = _request("update", true);
            PeriodHelper.write($out, period);
            $in = _invoke($out);
            boolean $result = $in.read_boolean();
            return $result;
        } catch (org.omg.CORBA.portable.ApplicationException $ex) {
            $in = $ex.getInputStream();
            String _id = $ex.getId();
            throw new org.omg.CORBA.MARSHAL(_id);
        } catch (org.omg.CORBA.portable.RemarshalException $rm) {
            return update(period);
        } finally {
            _releaseReply($in);
        }
    } // update

    public boolean remove(Period period) {
        org.omg.CORBA.portable.InputStream $in = null;
        try {
            org.omg.CORBA.portable.OutputStream $out = _request("remove", true);
            PeriodHelper.write($out, period);
            $in = _invoke($out);
            boolean $result = $in.read_boolean();
            return $result;
        } catch (org.omg.CORBA.portable.ApplicationException $ex) {
            $in = $ex.getInputStream();
            String _id = $ex.getId();
            throw new org.omg.CORBA.MARSHAL(_id);
        } catch (org.omg.CORBA.portable.RemarshalException $rm) {
            return remove(period);
        } finally {
            _releaseReply($in);
        }
    } // remove

    public Period load(int code) {
        org.omg.CORBA.portable.InputStream $in = null;
        try {
            org.omg.CORBA.portable.OutputStream $out = _request("load", true);
            $out.write_long(code);
            $in = _invoke($out);
            Period $result = PeriodHelper.read($in);
            return $result;
        } catch (org.omg.CORBA.portable.ApplicationException $ex) {
            $in = $ex.getInputStream();
            String _id = $ex.getId();
            throw new org.omg.CORBA.MARSHAL(_id);
        } catch (org.omg.CORBA.portable.RemarshalException $rm) {
            return load(code);
        } finally {
            _releaseReply($in);
        }
    } // load

    public Period[] loadAll() {
        org.omg.CORBA.portable.InputStream $in = null;
        try {
            org.omg.CORBA.portable.OutputStream $out = _request("loadAll", true);
            $in = _invoke($out);
            Period $result[] = PeriodsHelper.read($in);
            return $result;
        } catch (org.omg.CORBA.portable.ApplicationException $ex) {
            $in = $ex.getInputStream();
            String _id = $ex.getId();
            throw new org.omg.CORBA.MARSHAL(_id);
        } catch (org.omg.CORBA.portable.RemarshalException $rm) {
            return loadAll();
        } finally {
            _releaseReply($in);
        }
    } // loadAll

    // Type-specific CORBA::Object operations
    private static String[] __ids = {
        "IDL:br/com/expenseController/persistence/PeriodPersistence:1.0"};

    public String[] _ids() {
        return (String[]) __ids.clone();
    }

    private void readObject(java.io.ObjectInputStream s) throws java.io.IOException {
        String str = s.readUTF();
        String[] args = null;
        java.util.Properties props = null;
        org.omg.CORBA.ORB orb = org.omg.CORBA.ORB.init(args, props);
        try {
            org.omg.CORBA.Object obj = orb.string_to_object(str);
            org.omg.CORBA.portable.Delegate delegate = ((org.omg.CORBA.portable.ObjectImpl) obj)._get_delegate();
            _set_delegate(delegate);
        } finally {
            orb.destroy();
        }
    }

    private void writeObject(java.io.ObjectOutputStream s) throws java.io.IOException {
        String[] args = null;
        java.util.Properties props = null;
        org.omg.CORBA.ORB orb = org.omg.CORBA.ORB.init(args, props);
        try {
            String str = orb.object_to_string(this);
            s.writeUTF(str);
        } finally {
            orb.destroy();
        }
    }
} // class _PeriodPersistenceStub
