import java.rmi.Remote;
import java.rmi.RemoteException;

public interface ServerInterface extends Remote {
    public String getFile(String filePath) throws RemoteException;
}