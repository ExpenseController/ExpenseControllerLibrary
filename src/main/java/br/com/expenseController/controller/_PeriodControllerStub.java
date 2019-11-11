package br.com.expenseController.controller;

import br.com.expenseController.model.Period;
import br.com.expenseController.model.PeriodHelper;
import br.com.expenseController.model.PeriodsHelper;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;
import org.omg.CORBA.MARSHAL;
import org.omg.CORBA.ORB;
import org.omg.CORBA.portable.ApplicationException;
import org.omg.CORBA.portable.Delegate;
import org.omg.CORBA.portable.InputStream;
import org.omg.CORBA.portable.ObjectImpl;
import org.omg.CORBA.portable.OutputStream;
import org.omg.CORBA.portable.RemarshalException;

public class _PeriodControllerStub extends ObjectImpl implements PeriodController {

    private static String[] IDS = {
        "IDL:br/com/expenseController/controllers/PeriodController:1.0"
    };
    
    public boolean insert(Period period) {
        InputStream inputStream = null;
        
        try {
            OutputStream outputStream = _request("insert", true);
            PeriodHelper.write(outputStream, period);
            inputStream = _invoke(outputStream);
            boolean result = inputStream.read_boolean();
            return result;
        } catch (ApplicationException appException) {
            inputStream = appException.getInputStream();
            String _id = appException.getId();
            throw new org.omg.CORBA.MARSHAL(_id);
        } catch (RemarshalException remarshalException) {
            return insert(period);
        } finally {
            _releaseReply(inputStream);
        }
    }

    public boolean update(Period period) {
        InputStream inputStream = null;
        try {
            OutputStream outputStream = _request("update", true);
            PeriodHelper.write(outputStream, period);
            inputStream = _invoke(outputStream);
            boolean result = inputStream.read_boolean();
            return result;
        } catch (ApplicationException appException) {
            inputStream = appException.getInputStream();
            String _id = appException.getId();
            throw new MARSHAL(_id);
        } catch (RemarshalException remarshalException) {
            return update(period);
        } finally {
            _releaseReply(inputStream);
        }
    }

    public boolean remove(Period period) {
        InputStream inputStream = null;
        
        try {
            OutputStream outputStream = _request("remove", true);
            PeriodHelper.write(outputStream, period);
            inputStream = _invoke(outputStream);
            boolean result = inputStream.read_boolean();
            return result;
        } catch (ApplicationException appException) {
            inputStream = appException.getInputStream();
            String _id = appException.getId();
            throw new MARSHAL(_id);
        } catch (RemarshalException remarshalException) {
            return remove(period);
        } finally {
            _releaseReply(inputStream);
        }
    }

    public Period load(int code) {
        InputStream inputStream = null;
        
        try {
            OutputStream outputStream = _request("load", true);
            outputStream.write_long(code);
            inputStream = _invoke(outputStream);
            Period result = PeriodHelper.read(inputStream);
            return result;
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

    public List<Period> loadAll() {
        InputStream inputStream = null;

        try {
            OutputStream outputStream = _request("loadAll", true);
            inputStream = _invoke(outputStream);
            List<Period> result = PeriodsHelper.read(inputStream);
            return result;
        } catch (ApplicationException appException) {
            inputStream = appException.getInputStream();
            String _id = appException.getId();
            throw new MARSHAL(_id);
        } catch (RemarshalException remarshalException) {
            return loadAll();
        } finally {
            _releaseReply(inputStream);
        }
    }

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