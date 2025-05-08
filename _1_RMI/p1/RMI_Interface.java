import java.rmi.*;

public interface RMI_Interface extends Remote {
    public double add(double a,double b) throws RemoteException;
    public double sub(double a,double b) throws RemoteException;
}