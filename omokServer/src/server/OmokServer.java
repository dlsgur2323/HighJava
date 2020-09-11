package server;

import inf.ClientInf;
import inf.ServerInf;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import vo.OmokVO;


public class OmokServer extends UnicastRemoteObject implements ServerInf{
	private List<ClientInf> clientList;
	int ready;
	OmokVO omokpan;
	boolean nowTurn;
	public OmokServer() throws RemoteException {
		clientList = new ArrayList<>();
		omokpan = new OmokVO();
	}

	public static void main(String[] args) {
		try {
			ServerInf server = new OmokServer();
			
			Registry reg = LocateRegistry.createRegistry(1099);
			reg.rebind("omok", server);
			
			System.out.println("서버 준비 완료");
			System.out.println("사용자를 기다립니다.");
			
			
		} catch (RemoteException e) {
			// TODO: handle exception
		}

	}

	@Override
	public void doDisplay() throws RemoteException {
		for(ClientInf client : clientList){
			client.printMap(omokpan);
		}
		
	}

	@Override
	public void setClient(ClientInf client) throws RemoteException {
		clientList.add(client);
		System.out.println("새로운 사용자가 접속했습니다.");
		if(clientList.size() == 2){
			start();
		}
		
	}

	List<Boolean> setTurn = new ArrayList<>(); 
	private void start() throws RemoteException{
		setTurn.add(true);
		setTurn.add(false);
		Collections.shuffle(setTurn);
		
		clientList.get(0).setMyTurn(setTurn.get(0));
		clientList.get(1).setMyTurn(setTurn.get(1));
		nowTurn = true;
		clientList.get(0).setNowTurn(true);
		clientList.get(1).setNowTurn(true);
		doDisplay();
	}

	@Override
	public void ready() throws RemoteException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void nowTurn() throws RemoteException {
		nowTurn = !nowTurn;
		clientList.get(0).setNowTurn(nowTurn);
		clientList.get(1).setNowTurn(nowTurn);
		
	}

}