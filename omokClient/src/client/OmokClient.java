package client;

import inf.ClientInf;
import inf.ServerInf;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

import javax.swing.JFrame;

import vo.OmokVO;



public class OmokClient extends UnicastRemoteObject implements ClientInf{
	private boolean ready;
	private boolean myTurn;
	private boolean nowTurn;
	protected OmokClient() throws RemoteException {
		ready = false;
	}
	
	public static void main(String[] args) {
		JFrame f = new JFrame();
	    f.setSize(100,100);     
	    f.setLayout( null );
	    f.setVisible(true);
	    
	    
	    try {
			ClientInf client = new OmokClient();
			
			Registry reg = LocateRegistry.getRegistry("192.168.43.40", 1099);
			ServerInf server = (ServerInf)reg.lookup("omok");
			
			server.setClient(client);
			System.out.println("오목 게임에 접속하셨습니다.");
			
		} catch (RemoteException e) {
			// TODO: handle exception
		} catch (NotBoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    
	}

	@Override
	public void printMap(OmokVO omokpan) throws RemoteException { // 현재 서버의 데이터로 화면 출력
		int[][]map = omokpan.getMap();
		int[] wxy = omokpan.getWxy();
		int[] bxy = omokpan.getBxy();
		System.out.println("\n\n\n\n\n");
		System.out.println("┌─────────────────────────────────────────────┐");
		for(int i=0; i<map.length;i++){
			for(int j=0; j<map[i].length;j++){
				if(j==0){
					System.out.print("│");
				}
				if(map[i][j] == 1){
					if(i==wxy[1] && j==wxy[0] || i==bxy[1] && j==bxy[0]){
							System.out.print(">○<");
					} else {
						System.out.print(" ○ ");
					}
				} else if(map[i][j] == 2){
					if(i==wxy[1] && j==wxy[0] || i==bxy[1] && j==bxy[0]){
							System.out.print(">●<");
					} else {
						System.out.print(" ● ");
					}
				} else if (map[i][j] == 0) {
					if(nowTurn){
						if(i==wxy[1] && j==wxy[0]){
							System.out.print("> <");
						} else {
							System.out.print("   ");
						}
					} else {
						if (i==bxy[1] && j==bxy[0]){
							System.out.print("> <");
						} else {
							System.out.print("   ");
						}
					}
				}
				if(j==14){
					System.out.print("│");
				}
			}
			System.out.println();
		}
		System.out.println("└─────────────────────────────────────────────┘");
		
	}
	
	@Override
	public void setNowTurn(boolean torf) throws RemoteException {
		nowTurn = torf;
		
	}

	@Override
	public void setMyTurn(boolean torf) throws RemoteException { // 게임시작하면 나의 턴(돌)을 정해주는 메소드 
		myTurn = torf;
		
	}

	class OmoKey implements KeyListener{
		
		public OmoKey(int[] wxy, int[] bxy) {
		}
		public void keyTyped(KeyEvent e) {
			// TODO Auto-generated method stub
			
		}
		public void keyPressed(KeyEvent e) {
			
		}
		@Override
		public void keyReleased(KeyEvent e) {
			// TODO Auto-generated method stub
			
		}
	}

	
	
}
