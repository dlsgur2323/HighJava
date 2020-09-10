package inf;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface ServerInf extends Remote{
	
	public void setClient(ClientInf client) throws RemoteException;
	
	public void doDisplay() throws RemoteException;
	
	public void ready() throws RemoteException;
	
	public void nowTurn() throws RemoteException;
}
