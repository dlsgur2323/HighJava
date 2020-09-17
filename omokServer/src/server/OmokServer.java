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
			e.printStackTrace();
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

	private void start() throws RemoteException{
		List<Boolean> setTurn = new ArrayList<>(); 
		setTurn.add(true);
		setTurn.add(false);
		Collections.shuffle(setTurn);
		
		clientList.get(0).setMyTurn(setTurn.get(0));
		clientList.get(1).setMyTurn(setTurn.get(1));
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("게임을 시작합니다.");
		clientList.get(0).start();
		clientList.get(1).start();
	}

	@Override
	public void ready() throws RemoteException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void pMove(int color, int i, int j) throws RemoteException {
		for(ClientInf client : clientList){
			client.pMove(color, i, j);
		}
		
	}
	
	public void pSelect(int[] xy, int color) throws RemoteException {
		for(ClientInf client : clientList){
			client.pSelect(xy, color);
		}
	}

}
