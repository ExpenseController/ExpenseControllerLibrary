package br.com.expenseController.controller;

import br.com.expenseController.model.Period;
import br.com.expenseController.model.PeriodHelper;
import br.com.expenseController.model.Transaction;
import br.com.expenseController.model.TransactionHelper;
import br.com.expenseController.model.TransactionsHelper;
import org.omg.CORBA.MARSHAL;
import org.omg.CORBA.ORB;
import org.omg.CORBA.portable.ApplicationException;
import org.omg.CORBA.portable.Delegate;
import org.omg.CORBA.portable.InputStream;
import org.omg.CORBA.portable.ObjectImpl;
import org.omg.CORBA.portable.OutputStream;
import org.omg.CORBA.portable.RemarshalException;

public class _TransactionControllerStub extends ObjectImpl implements TransactionController {

    private static String[] IDS = {
        "IDL:br/com/expenseController/controllers/TransactionController:1.0"
    };

    public boolean insert(Transaction transaction) {
        InputStream inputStream = null;
        
        try {
            OutputStream outputStream = _request("insert", true);
            TransactionHelper.write(outputStream, transaction);
            inputStream = _invoke(outputStream);
            boolean result = inputStream.read_boolean();
            return result;
        } catch (ApplicationException appException) {
            inputStream = appException.getInputStream();
            String _id = appException.getId();
            throw new MARSHAL(_id);
        } catch (RemarshalException remarshalException) {
            return insert(transaction);
        } finally {
            _releaseReply(inputStream);
        }
    }

    public boolean update(Transaction transaction) {
        InputStream inputStream = null;
        
        try {
            OutputStream outputStream = _request("update", true);
            TransactionHelper.write(outputStream, transaction);
            inputStream = _invoke(outputStream);
            boolean result = inputStream.read_boolean();
            return result;
        } catch (ApplicationException appException) {
            inputStream = appException.getInputStream();
            String _id = appException.getId();
            throw new MARSHAL(_id);
        } catch (RemarshalException remarshalException) {
            return update(transaction);
        } finally {
            _releaseReply(inputStream);
        }
    }

    public boolean remove(Transaction transaction) {
        InputStream inputStream = null;
        
        try {
            OutputStream outputStream = _request("remove", true);
            TransactionHelper.write(outputStream, transaction);
            inputStream = _invoke(outputStream);
            boolean result = inputStream.read_boolean();
            return result;
        } catch (ApplicationException appException) {
            inputStream = appException.getInputStream();
            String _id = appException.getId();
            throw new MARSHAL(_id);
        } catch (RemarshalException remarshalException) {
            return remove(transaction);
        } finally {
            _releaseReply(inputStream);
        }
    }

    public Transaction load(int code) {
        InputStream inputStream = null;
        
        try {
            OutputStream outputStream = _request("load", true);
            outputStream.write_long(code);
            inputStream = _invoke(outputStream);
            Transaction result = TransactionHelper.read(inputStream);
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

    public Transaction[] loadAll() {
        InputStream inputStream = null;
        
        try {
            OutputStream outputStream = _request("loadAll", true);
            inputStream = _invoke(outputStream);
            Transaction result[] = TransactionsHelper.read(inputStream);
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

    public Transaction[] loadPeriod(Period Period) {
        InputStream inputStream = null;
        
        try {
            OutputStream outputStream = _request("loadPeriod", true);
            PeriodHelper.write(outputStream, Period);
            inputStream = _invoke(outputStream);
            Transaction result[] = TransactionsHelper.read(inputStream);
            return result;
        } catch (ApplicationException appException) {
            inputStream = appException.getInputStream();
            String _id = appException.getId();
            throw new MARSHAL(_id);
        } catch (RemarshalException remarshalException) {
            return loadPeriod(Period);
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