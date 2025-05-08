import java.rmi.*;
import java.rmi.server.*;

public class RMI_Interface_Impl extends UnicastRemoteObject implements RMI_Interface {

    public RMI_Interface_Impl() throws RemoteException{
        super();
    }
    public double add(double a,double b) throws RemoteException{
        return a + b;
    }
    public double sub(double a,double b) throws RemoteException{
        return a - b;
    }
    
}
