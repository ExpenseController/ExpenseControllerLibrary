package br.com.expenseController.persistence;

/**
* br/com/expenseController/persistence/TagPersistenceHolder.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from expenseController.idl
* Quarta-feira, 23 de Outubro de 2019 14h06min58s BRST
*/

public final class TagPersistenceHolder implements org.omg.CORBA.portable.Streamable
{
  public br.com.expenseController.persistence.TagPersistence value = null;

  public TagPersistenceHolder ()
  {
  }

  public TagPersistenceHolder (br.com.expenseController.persistence.TagPersistence initialValue)
  {
    value = initialValue;
  }

  public void _read (org.omg.CORBA.portable.InputStream i)
  {
    value = br.com.expenseController.persistence.TagPersistenceHelper.read (i);
  }

  public void _write (org.omg.CORBA.portable.OutputStream o)
  {
    br.com.expenseController.persistence.TagPersistenceHelper.write (o, value);
  }

  public org.omg.CORBA.TypeCode _type ()
  {
    return br.com.expenseController.persistence.TagPersistenceHelper.type ();
  }

}
