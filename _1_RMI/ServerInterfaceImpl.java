import java.rmi.RemoteException;
import java.util.*;
import java.rmi.server.UnicastRemoteObject;
public class ServerInterfaceImpl extends UnicastRemoteObject implements ServerInterface {


    public ServerInterfaceImpl  () throws RemoteException
    {

    }

    @Override
    public double add(double a, double b) {
        // TODO Auto-generated method stub
        return a + b;
        // throw new UnsupportedOperationException("Unimplemented method 'add'");
    }

    
}
