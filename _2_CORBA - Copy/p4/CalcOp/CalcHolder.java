package CalcOp;

/**
* CalcOp/CalcHolder.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from CalcOp.idl
* Wednesday, 7 May, 2025 4:53:23 PM IST
*/

public final class CalcHolder implements org.omg.CORBA.portable.Streamable
{
  public CalcOp.Calc value = null;

  public CalcHolder ()
  {
  }

  public CalcHolder (CalcOp.Calc initialValue)
  {
    value = initialValue;
  }

  public void _read (org.omg.CORBA.portable.InputStream i)
  {
    value = CalcOp.CalcHelper.read (i);
  }

  public void _write (org.omg.CORBA.portable.OutputStream o)
  {
    CalcOp.CalcHelper.write (o, value);
  }

  public org.omg.CORBA.TypeCode _type ()
  {
    return CalcOp.CalcHelper.type ();
  }

}
