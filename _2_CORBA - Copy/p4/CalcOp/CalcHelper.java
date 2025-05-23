package CalcOp;


/**
* CalcOp/CalcHelper.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from CalcOp.idl
* Wednesday, 7 May, 2025 4:53:23 PM IST
*/

abstract public class CalcHelper
{
  private static String  _id = "IDL:CalcOp/Calc:1.0";

  public static void insert (org.omg.CORBA.Any a, CalcOp.Calc that)
  {
    org.omg.CORBA.portable.OutputStream out = a.create_output_stream ();
    a.type (type ());
    write (out, that);
    a.read_value (out.create_input_stream (), type ());
  }

  public static CalcOp.Calc extract (org.omg.CORBA.Any a)
  {
    return read (a.create_input_stream ());
  }

  private static org.omg.CORBA.TypeCode __typeCode = null;
  synchronized public static org.omg.CORBA.TypeCode type ()
  {
    if (__typeCode == null)
    {
      __typeCode = org.omg.CORBA.ORB.init ().create_interface_tc (CalcOp.CalcHelper.id (), "Calc");
    }
    return __typeCode;
  }

  public static String id ()
  {
    return _id;
  }

  public static CalcOp.Calc read (org.omg.CORBA.portable.InputStream istream)
  {
    return narrow (istream.read_Object (_CalcStub.class));
  }

  public static void write (org.omg.CORBA.portable.OutputStream ostream, CalcOp.Calc value)
  {
    ostream.write_Object ((org.omg.CORBA.Object) value);
  }

  public static CalcOp.Calc narrow (org.omg.CORBA.Object obj)
  {
    if (obj == null)
      return null;
    else if (obj instanceof CalcOp.Calc)
      return (CalcOp.Calc)obj;
    else if (!obj._is_a (id ()))
      throw new org.omg.CORBA.BAD_PARAM ();
    else
    {
      org.omg.CORBA.portable.Delegate delegate = ((org.omg.CORBA.portable.ObjectImpl)obj)._get_delegate ();
      CalcOp._CalcStub stub = new CalcOp._CalcStub ();
      stub._set_delegate(delegate);
      return stub;
    }
  }

  public static CalcOp.Calc unchecked_narrow (org.omg.CORBA.Object obj)
  {
    if (obj == null)
      return null;
    else if (obj instanceof CalcOp.Calc)
      return (CalcOp.Calc)obj;
    else
    {
      org.omg.CORBA.portable.Delegate delegate = ((org.omg.CORBA.portable.ObjectImpl)obj)._get_delegate ();
      CalcOp._CalcStub stub = new CalcOp._CalcStub ();
      stub._set_delegate(delegate);
      return stub;
    }
  }

}
