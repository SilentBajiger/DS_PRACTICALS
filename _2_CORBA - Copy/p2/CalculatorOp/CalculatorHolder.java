package CalculatorOp;

/**
* CalculatorOp/CalculatorHolder.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from CalculatorOp.idl
* Wednesday, 7 May, 2025 3:33:41 PM IST
*/

public final class CalculatorHolder implements org.omg.CORBA.portable.Streamable
{
  public CalculatorOp.Calculator value = null;

  public CalculatorHolder ()
  {
  }

  public CalculatorHolder (CalculatorOp.Calculator initialValue)
  {
    value = initialValue;
  }

  public void _read (org.omg.CORBA.portable.InputStream i)
  {
    value = CalculatorOp.CalculatorHelper.read (i);
  }

  public void _write (org.omg.CORBA.portable.OutputStream o)
  {
    CalculatorOp.CalculatorHelper.write (o, value);
  }

  public org.omg.CORBA.TypeCode _type ()
  {
    return CalculatorOp.CalculatorHelper.type ();
  }

}
