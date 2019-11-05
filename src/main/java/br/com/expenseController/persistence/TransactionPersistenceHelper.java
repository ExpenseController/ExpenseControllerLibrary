package br.com.expenseController.persistence;


/**
* br/com/expenseController/persistence/TransactionPersistenceHelper.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from expenseController.idl
* Quarta-feira, 23 de Outubro de 2019 14h06min58s BRST
*/

abstract public class TransactionPersistenceHelper
{
  private static String  _id = "IDL:br/com/expenseController/persistence/TransactionPersistence:1.0";

  public static void insert (org.omg.CORBA.Any a, br.com.expenseController.persistence.TransactionPersistence that)
  {
    org.omg.CORBA.portable.OutputStream out = a.create_output_stream ();
    a.type (type ());
    write (out, that);
    a.read_value (out.create_input_stream (), type ());
  }

  public static br.com.expenseController.persistence.TransactionPersistence extract (org.omg.CORBA.Any a)
  {
    return read (a.create_input_stream ());
  }

  private static org.omg.CORBA.TypeCode __typeCode = null;
  synchronized public static org.omg.CORBA.TypeCode type ()
  {
    if (__typeCode == null)
    {
      __typeCode = org.omg.CORBA.ORB.init ().create_interface_tc (br.com.expenseController.persistence.TransactionPersistenceHelper.id (), "TransactionPersistence");
    }
    return __typeCode;
  }

  public static String id ()
  {
    return _id;
  }

  public static br.com.expenseController.persistence.TransactionPersistence read (org.omg.CORBA.portable.InputStream istream)
  {
    return narrow (istream.read_Object (_TransactionPersistenceStub.class));
  }

  public static void write (org.omg.CORBA.portable.OutputStream ostream, br.com.expenseController.persistence.TransactionPersistence value)
  {
    ostream.write_Object ((org.omg.CORBA.Object) value);
  }

  public static br.com.expenseController.persistence.TransactionPersistence narrow (org.omg.CORBA.Object obj)
  {
    if (obj == null)
      return null;
    else if (obj instanceof br.com.expenseController.persistence.TransactionPersistence)
      return (br.com.expenseController.persistence.TransactionPersistence)obj;
    else if (!obj._is_a (id ()))
      throw new org.omg.CORBA.BAD_PARAM ();
    else
    {
      org.omg.CORBA.portable.Delegate delegate = ((org.omg.CORBA.portable.ObjectImpl)obj)._get_delegate ();
      br.com.expenseController.persistence._TransactionPersistenceStub stub = new br.com.expenseController.persistence._TransactionPersistenceStub ();
      stub._set_delegate(delegate);
      return stub;
    }
  }

  public static br.com.expenseController.persistence.TransactionPersistence unchecked_narrow (org.omg.CORBA.Object obj)
  {
    if (obj == null)
      return null;
    else if (obj instanceof br.com.expenseController.persistence.TransactionPersistence)
      return (br.com.expenseController.persistence.TransactionPersistence)obj;
    else
    {
      org.omg.CORBA.portable.Delegate delegate = ((org.omg.CORBA.portable.ObjectImpl)obj)._get_delegate ();
      br.com.expenseController.persistence._TransactionPersistenceStub stub = new br.com.expenseController.persistence._TransactionPersistenceStub ();
      stub._set_delegate(delegate);
      return stub;
    }
  }

}