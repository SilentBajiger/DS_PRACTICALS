import java.rmi.*;

public interface ServerInterface extends Remote {
    public double add(double a, double b) throws RemoteException;
}
