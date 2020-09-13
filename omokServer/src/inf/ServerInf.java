package inf;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface ServerInf extends Remote{
	
	public void setClient(ClientInf client) throws RemoteException;
	
	public void ready() throws RemoteException;
	
	public void pMove(int[] xy, int i, int j) throws RemoteException;
	
	public void pSelect(int[] xy, int color) throws RemoteException;
	
}
