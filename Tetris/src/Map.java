import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;

public class Map extends Thread{

	public int[][] m;
	
	public Map(int[][] map) {
		this.m = map;
	}
	
	public void showMap(){
		System.out.println("\n\n\n\n\n\n\n\n\n");
		for(int i = 2; i < m.length;i++){
			for(int j = 0; j < m[i].length; j++){
//				if(i == 2){
//					if(j == 0){
//						System.out.print("┌");
//					} else if ( j == m[i].length -1){
//						System.out.print("┐");
//					} else {
//						System.out.print("─");
//					}
//				} else if( i == m.length-1){
//					if(j == 0){
//						System.out.print("└");
//					} else if ( j == m[i].length -1){
//						System.out.print("┘");
//					} else {
//						System.out.print("─");
//					}
//					
//				} else {
					if(j == 0 || j == m[i].length-1){
//						System.out.print("│");
					} else {
						if(m[i][j] == 0){
							System.out.print(" □ ");
						} else if(m[i][j] == 1 || m[i][j] == 5){
							System.out.print(" ■ ");
						}
					}
//				}
			}
			System.out.println();
		}
		System.out.println();
	}
	
	
	// 새로운 아이디어 각 block 들의 고유의 위치를 가지고 함
	
	
	

}













