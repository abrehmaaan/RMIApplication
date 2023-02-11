import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.server.UnicastRemoteObject;
import java.util.Date;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.io.*;

public class Server extends UnicastRemoteObject implements ServerInterface {
	public Server() throws RemoteException {
	}
	public String getFile(String filePath) {
		String content = "";
		try {
			BufferedReader br = new BufferedReader(new FileReader(filePath));
			String line = "";
			while ((line = br.readLine()) != null) {
				content += line + "\n";
			}
			br.close();
			return content;
		} catch (IOException e) {
			return "Error reading file";
		}
	}

	public static void main(String[] args) {
		try {
			Server server = new Server();
			LocateRegistry.createRegistry(1099);
			Naming.rebind("rmi://localhost:1099/Server", server);
			System.out.println("Server is running...");
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}
