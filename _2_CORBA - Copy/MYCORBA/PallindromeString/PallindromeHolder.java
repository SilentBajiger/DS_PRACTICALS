package PallindromeString;

/**
* PallindromeString/PallindromeHolder.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from PallindromeString.idl
* Monday, 10 February, 2025 11:00:27 PM IST
*/

public final class PallindromeHolder implements org.omg.CORBA.portable.Streamable
{
  public PallindromeString.Pallindrome value = null;

  public PallindromeHolder ()
  {
  }

  public PallindromeHolder (PallindromeString.Pallindrome initialValue)
  {
    value = initialValue;
  }

  public void _read (org.omg.CORBA.portable.InputStream i)
  {
    value = PallindromeString.PallindromeHelper.read (i);
  }

  public void _write (org.omg.CORBA.portable.OutputStream o)
  {
    PallindromeString.PallindromeHelper.write (o, value);
  }

  public org.omg.CORBA.TypeCode _type ()
  {
    return PallindromeString.PallindromeHelper.type ();
  }

}
