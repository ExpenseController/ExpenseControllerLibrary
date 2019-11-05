package br.com.expenseController.controller;

import br.com.expenseController.model.Tag;
import br.com.expenseController.model.TagHelper;
import java.util.Properties;
import org.omg.CORBA.MARSHAL;
import org.omg.CORBA.ORB;
import org.omg.CORBA.portable.ApplicationException;
import org.omg.CORBA.portable.Delegate;
import org.omg.CORBA.portable.InputStream;
import org.omg.CORBA.portable.ObjectImpl;
import org.omg.CORBA.portable.OutputStream;
import org.omg.CORBA.portable.RemarshalException;

public class _TagControllerStub extends ObjectImpl implements TagController {

    private static String[] IDS = {
        "IDL:br/com/expenseController/controllers/TagController:1.0"
    };
    
    public boolean insert(Tag tag) {
        InputStream inputStream = null;
        
        try {
            OutputStream outputStream = _request("insert", true);
            TagHelper.write(outputStream, tag);
            inputStream = _invoke(outputStream);
            boolean result = inputStream.read_boolean();
            return result;
        } catch (ApplicationException appException) {
            inputStream = appException.getInputStream();
            String _id = appException.getId();
            throw new MARSHAL(_id);
        } catch (RemarshalException remarshalException) {
            return insert(tag);
        } finally {
            _releaseReply(inputStream);
        }
    }

    public boolean update(Tag tag) {
        InputStream inputStream = null;
        try {
            OutputStream outputStream = _request("update", true);
            TagHelper.write(outputStream, tag);
            inputStream = _invoke(outputStream);
            boolean result = inputStream.read_boolean();
            return result;
        } catch (ApplicationException appException) {
            inputStream = appException.getInputStream();
            String _id = appException.getId();
            throw new MARSHAL(_id);
        } catch (RemarshalException rm) {
            return update(tag);
        } finally {
            _releaseReply(inputStream);
        }
    }

    public boolean remove(Tag tag) {
        InputStream inputStream = null;
        
        try {
            OutputStream outputStream = _request("remove", true);
            TagHelper.write(outputStream, tag);
            inputStream = _invoke(outputStream);
            boolean $result = inputStream.read_boolean();
            return $result;
        } catch (ApplicationException appException) {
            inputStream = appException.getInputStream();
            String _id = appException.getId();
            throw new MARSHAL(_id);
        } catch (RemarshalException remarshalException) {
            return remove(tag);
        } finally {
            _releaseReply(inputStream);
        }
    }

    public Tag load(int code) {
        InputStream inputStream = null;
        
        try {
            OutputStream outputStream = _request("load", true);
            outputStream.write_long(code);
            inputStream = _invoke(outputStream);
            Tag $result = TagHelper.read(inputStream);
            return $result;
        } catch (ApplicationException appException) {
            inputStream = appException.getInputStream();
            String _id = appException.getId();
            throw new MARSHAL(_id);
        } catch (RemarshalException remarshalException) {
            return load(code);
        } finally {
            _releaseReply(inputStream);
        }
    }

    public String[] _ids() {
        return (String[]) IDS.clone();
    }

    private void readObject(java.io.ObjectInputStream s) throws java.io.IOException {
        String str = s.readUTF();
        String[] args = null;
        Properties props = null;
        ORB orb = ORB.init(args, props);
        
        try {
            Object obj = orb.string_to_object(str);
            Delegate delegate = ((ObjectImpl) obj)._get_delegate();
            _set_delegate(delegate);
        } finally {
            orb.destroy();
        }
    }

    private void writeObject(java.io.ObjectOutputStream s) throws java.io.IOException {
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