package br.com.expenseController.persistence;

import org.omg.CORBA.portable.ApplicationException;
import org.omg.CORBA.portable.Delegate;
import org.omg.CORBA.portable.InputStream;
import org.omg.CORBA.portable.ObjectImpl;
import org.omg.CORBA.portable.OutputStream;
import org.omg.CORBA.portable.RemarshalException;

public class _TagPersistenceStub extends ObjectImpl implements TagPersistence {

    public boolean insert(br.com.expenseController.Tag tag) {
        InputStream $in = null;
        
        try {
            OutputStream $out = _request("insert", true);
            br.com.expenseController.TagHelper.write($out, tag);
            $in = _invoke($out);
            boolean $result = $in.read_boolean();
            return $result;
        } catch (ApplicationException $ex) {
            $in = $ex.getInputStream();
            String _id = $ex.getId();
            throw new org.omg.CORBA.MARSHAL(_id);
        } catch (RemarshalException $rm) {
            return insert(tag);
        } finally {
            _releaseReply($in);
        }
    } // insert

    public boolean update(br.com.expenseController.Tag tag) {
        InputStream $in = null;
        try {
            OutputStream $out = _request("update", true);
            br.com.expenseController.TagHelper.write($out, tag);
            $in = _invoke($out);
            boolean $result = $in.read_boolean();
            return $result;
        } catch (ApplicationException $ex) {
            $in = $ex.getInputStream();
            String _id = $ex.getId();
            throw new org.omg.CORBA.MARSHAL(_id);
        } catch (RemarshalException $rm) {
            return update(tag);
        } finally {
            _releaseReply($in);
        }
    } // update

    public boolean remove(br.com.expenseController.Tag tag) {
        InputStream $in = null;
        try {
            OutputStream $out = _request("remove", true);
            br.com.expenseController.TagHelper.write($out, tag);
            $in = _invoke($out);
            boolean $result = $in.read_boolean();
            return $result;
        } catch (ApplicationException $ex) {
            $in = $ex.getInputStream();
            String _id = $ex.getId();
            throw new org.omg.CORBA.MARSHAL(_id);
        } catch (RemarshalException $rm) {
            return remove(tag);
        } finally {
            _releaseReply($in);
        }
    } // remove

    public br.com.expenseController.Tag load(int code) {
        InputStream $in = null;
        try {
            OutputStream $out = _request("load", true);
            $out.write_long(code);
            $in = _invoke($out);
            br.com.expenseController.Tag $result = br.com.expenseController.TagHelper.read($in);
            return $result;
        } catch (ApplicationException $ex) {
            $in = $ex.getInputStream();
            String _id = $ex.getId();
            throw new org.omg.CORBA.MARSHAL(_id);
        } catch (RemarshalException $rm) {
            return load(code);
        } finally {
            _releaseReply($in);
        }
    } // load

    public br.com.expenseController.Tag[] loadAll() {
        InputStream $in = null;
        try {
            OutputStream $out = _request("loadAll", true);
            $in = _invoke($out);
            br.com.expenseController.Tag $result[] = br.com.expenseController.TagsHelper.read($in);
            return $result;
        } catch (ApplicationException $ex) {
            $in = $ex.getInputStream();
            String _id = $ex.getId();
            throw new org.omg.CORBA.MARSHAL(_id);
        } catch (RemarshalException $rm) {
            return loadAll();
        } finally {
            _releaseReply($in);
        }
    } // loadAll

    // Type-specific CORBA::Object operations
    private static String[] __ids = {
        "IDL:br/com/expenseController/persistence/TagPersistence:1.0"};

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
            Delegate delegate = ((ObjectImpl) obj)._get_delegate();
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
} // class _TagPersistenceStub
