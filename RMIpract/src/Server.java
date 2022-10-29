import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import java.rmi.*;
import java.rmi.registry.LocateRegistry;
import java.rmi.server.UnicastRemoteObject;

public class Server {

	public static void main(String[] args) throws NamingException, RemoteException {
    LocateRegistry.createRegistry(1099);
	Context context = new InitialContext();
	context.bind("rmi://localhost:1099/Cities", new CitiesImpl());
	System.out.print("Server started");
	}	
}

interface Cities extends Remote
{
	String output() throws RemoteException;
		
}
@SuppressWarnings("serial")
class CitiesImpl extends UnicastRemoteObject implements Cities
{
	protected CitiesImpl() throws RemoteException{
		
	}
	@Override
	public String output() {
		try {
			ExampleDB exampledb = new ExampleDB();
			String result = exampledb.check();
			return result;
		} catch (SQLException e) {
			e.printStackTrace();
			return e.toString();	
		}		
	}
}
