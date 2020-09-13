package client;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;

public class OmokClient2 {

	private int[][] map = new int[15][15];
	private int[] wxy = {7,7};
	private int[] bxy = {7,7};
	private Key key = new Key(wxy, bxy);
	private boolean turn = true; // true 이면 백돌 false 면 흑돌 차례
	
	public static void main(String[] args) {
		JFrame f = new JFrame();
	    f.setSize(300,200);     
	    f.setLayout( null );
	    f.setVisible(true);
	    
	    OmokClient2 o = new OmokClient2();
		o.start();
		f.addKeyListener(o.key);
	}
	
	private void start() {
		printmap();
		
	}

	
	private void printmap() {
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
	
	
	class Key implements KeyListener{
		private int[] wxy;
		private int[] bxy;
		
		public Key(int[] wxy, int[] bxy) {
			this.wxy = wxy;
			this.bxy = bxy;
		}
		public void keyTyped(KeyEvent e) {
			// TODO Auto-generated method stub
			
		}
		public void keyPressed(KeyEvent e) {
			if(e.getKeyCode() == 37){ // 좌
				if(turn){
					if(wxy[0] > 0){
						wxy[0]--;
						printmap();
					}
				} else {
					if(bxy[0] > 0){
						bxy[0]--;
						printmap();
					}
				}
			} else if(e.getKeyCode() == 39){ // 우
				if(turn){
					if(wxy[0] < 14){
						wxy[0]++;
						printmap();
					}
				} else {
					if(bxy[0] < 14){
						bxy[0]++;
						printmap();
					}
				}
			} else if(e.getKeyCode() == 40){ // 하
				if(turn){
					if(wxy[1] < 14){
						wxy[1]++;
						printmap();
					}
				}else {
					if(bxy[1] < 14){
						bxy[1]++;
						printmap();
					}
				}
			} else if(e.getKeyCode() == 38){ // 상
				if(turn){
					if(wxy[1] > 0){
						wxy[1]--;
						printmap();
					}
				}else {
					if(bxy[1] > 0){
						bxy[1]--;
						printmap();
					}
				}
			} else if(e.getKeyCode() == 10){ // 엔터
				if(turn){
					if(map[wxy[1]][wxy[0]] == 0){
						map[wxy[1]][wxy[0]] = 1;
						printmap();
						turn = false;
						checkWin(wxy, 1, 0, 1);// 좌우
						checkWin(wxy, 0, 1, 1);// 상하
						checkWin(wxy, 1, -1, 1);// /대각선
						checkWin(wxy, 1, 1, 1);// \대각선
					}
				}else {
					if(map[bxy[1]][bxy[0]] == 0){
						map[bxy[1]][bxy[0]] = 2;
						printmap();
						turn = true;
						checkWin(bxy, 1, 0, 2);// 좌우
						checkWin(bxy, 0, 1, 2);// 상하
						checkWin(bxy, 1, -1, 2);// /대각선
						checkWin(bxy, 1, 1, 2);// \대각선
					}
				}
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
}
