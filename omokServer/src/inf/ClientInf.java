package inf;

import java.rmi.Remote;
import java.rmi.RemoteException;

import vo.OmokVO;

public interface ClientInf extends Remote{
	
	public void printMap(OmokVO omokpan) throws RemoteException;
	
	public void setMyTurn(boolean torf)	throws RemoteException;

	public void setNowTurn(boolean torf) throws RemoteException;
	
}
