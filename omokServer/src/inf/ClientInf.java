package inf;

import java.rmi.Remote;
import java.rmi.RemoteException;

import vo.OmokVO;

public interface ClientInf extends Remote{
	
	public void start() throws RemoteException;
	
	public void printMap() throws RemoteException;
	
	public void setMyTurn(boolean torf)	throws RemoteException;

	public void pMove(int[] xy, int i, int j) throws RemoteException;
	
}
