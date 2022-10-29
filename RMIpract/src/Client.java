import java.rmi.RemoteException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

public class Client {

	public static void main(String[] args) throws NamingException, RemoteException {
		
		Context context = new InitialContext();
		Cities Cities = (Cities)context.lookup("rmi://localhost/Cities");
		String dataOutput = Cities.output();
		System.out.print(dataOutput);
	}

}
