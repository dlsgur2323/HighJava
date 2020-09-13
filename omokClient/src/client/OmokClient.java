package client;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

import javax.swing.JFrame;

import inf.ClientInf;
import inf.ServerInf;

public class OmokClient extends UnicastRemoteObject implements ClientInf{
	
	protected OmokClient() throws RemoteException {
		
	}

	private int[][] map = new int[15][15];
	private int[] wxy = {7,7};
	private int[] bxy = {7,7};
	private Key key;
	private boolean turn = true; // true 이면 백돌 false 면 흑돌 차례
	private boolean myTurn; // 내 돌색
	public static ServerInf server;
	
	public static void main(String[] args) {
		try {
			ClientInf client = new OmokClient();
			
			Registry reg = LocateRegistry.getRegistry("192.168.43.40", 1099);
			server = (ServerInf)reg.lookup("omok");
			
			server.setClient(client);
			System.out.println("오목 게임에 접속하셨습니다.");
			
			
			
		} catch (RemoteException e) {
			// TODO: handle exception
		} catch (NotBoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void start() throws RemoteException{
		JFrame f = new JFrame();
	    f.setSize(100,100);     
	    f.setLayout( null );
	    f.setVisible(true);
	    if(myTurn) {
	    	key = new Key(wxy);
	    } else {
	    	key = new Key(bxy);
	    }
		f.addKeyListener(key);
		
	}
	
	class Key implements KeyListener{
		private int[] wxy;
		private int[] bxy;
		
		public Key(int[] xy) {
			this.wxy = wxy;
			this.bxy = bxy;
		}
		public void keyTyped(KeyEvent e) {
			// TODO Auto-generated method stub
			
		}
		public void keyPressed(KeyEvent e){
			try {
				if(turn == myTurn) {
					if(e.getKeyCode() == 37){ // 좌
						if(myTurn){
							if(wxy[0] > 0){
								wxy[0]--;
								server.pMove(wxy, 0, -1);
							}
						} else {
							if(bxy[0] > 0){
								bxy[0]--;
								server.pMove(bxy, 0, -1);
							}
						}
					} else if(e.getKeyCode() == 39){ // 우
						if(myTurn){
							if(wxy[0] < 14){
								wxy[0]++;
								server.pMove(wxy, 0, 1);
							}
						} else {
							if(bxy[0] < 14){
								bxy[0]++;
								server.pMove(bxy, 0, 1);
							}
						}
					} else if(e.getKeyCode() == 40){ // 하
						if(myTurn){
							if(wxy[1] < 14){
								wxy[1]++;
								server.pMove(wxy, 1, 1);
							}
						}else {
							if(bxy[1] < 14){
								bxy[1]++;
								server.pMove(bxy, 1, 1);
							}
						}
					} else if(e.getKeyCode() == 38){ // 상
						if(myTurn){
							if(wxy[1] > 0){
								wxy[1]--;
								server.pMove(wxy, 1, -1);
							}
						}else {
							if(bxy[1] > 0){
								bxy[1]--;
								server.pMove(bxy, 1, -1);
							}
						}
					} else if(e.getKeyCode() == 10){ // 엔터
						if(myTurn){
							if(map[wxy[1]][wxy[0]] == 0){
								map[wxy[1]][wxy[0]] = 1;
								printMap();
								turn = false;
								checkWin(wxy, 1, 0, 1);// 좌우
								checkWin(wxy, 0, 1, 1);// 상하
								checkWin(wxy, 1, -1, 1);// /대각선
								checkWin(wxy, 1, 1, 1);// \대각선
							}
						}else {
							if(map[bxy[1]][bxy[0]] == 0){
								map[bxy[1]][bxy[0]] = 2;
								printMap();
								turn = true;
								checkWin(bxy, 1, 0, 2);// 좌우
								checkWin(bxy, 0, 1, 2);// 상하
								checkWin(bxy, 1, -1, 2);// /대각선
								checkWin(bxy, 1, 1, 2);// \대각선
							}
						}
					}
				}
			} catch (Exception e2) {
				// TODO: handle exception
			}
			
		}
		
		public void keyReleased(KeyEvent e) {
			// TODO Auto-generated method stub
			
		}
		
	}
	
	private void checkWin(int[] xy, int x, int y, int color) {
		int cnt = 0;
		int cx = xy[0];
		int cy = xy[1];
		while(true){ // 좌측 확인
			cx += x;
			cy += y;
			if(cx >= 0){
				if(map[cy][cx] == color){
					cnt++;
				} else {
					break;
				}
			} else {
				break;
			}
			if(cnt==4){
				if(color == 1) {
					System.out.println("백돌이 이겼습니다.");
				} else {
					System.out.println("흑돌이 이겼습니다.");
				}
				return;
			}
		}
		cx = xy[0];
		cy = xy[1];
		while(true){ // 우측 확인
			cx -= x;
			cy -= y;
			if(cx <= 14){
				if(map[cy][cx] == color){
					cnt++;
				} else {
					break;
				}
			} else {
				break;
			}
			if(cnt==4){
				if(color == 1) {
					System.out.println("백돌이 이겼습니다.");
				} else {
					System.out.println("흑돌이 이겼습니다.");
				}
				return;
			}
		}
	}

	@Override
	public void printMap() throws RemoteException {
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
					if(turn){
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
	public void setMyTurn(boolean torf) throws RemoteException {
		myTurn = torf;
		
	}

	@Override
	public void pMove(int[] xy, int i, int j) throws RemoteException {
		xy[i] += j;
		printMap();
	}

	
	
}
