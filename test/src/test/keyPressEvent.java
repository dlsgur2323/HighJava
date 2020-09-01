package test;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;

public class keyPressEvent {

	public static void main(String[] args) {
		Charactor ch = new Charactor();
		Map map = new Map(new int[25][50], ch);
		 JFrame f = new JFrame();
	     f.setSize(300,200);     
	     f.setLayout( null );
	     f.setVisible(true);
	     
	     map.showMap();
	}
	

}
class Charactor {
	int[] location = {5,5};
	
}

class Map {
	private int[][] map;
	Charactor ch;

	public Map(int[][] map, Charactor ch) {
		this.map = map;
		this.ch = ch;
	}
	
	public void showMap(){
		System.out.println("\n\n\n\n\n\n\n\n\n");
		for(int i = 0; i < map.length;i++){
			for(int j = 0; j < map[i].length; j++){
				if(i == ch.location[1] && j == ch.location[0]){
					System.out.print("c");
				} else if(i == 0){
					if(j == 0){
						System.out.print("┌");
					} else if ( j == map[i].length -1){
						System.out.print("┐");
					} else {
						System.out.print("─");
					}
				} else if( i == map.length-1){
					if(j == 0){
						System.out.print("└");
					} else if ( j == map[i].length -1){
						System.out.print("┘");
					} else {
						System.out.print("─");
					}
					
				} else {
					if(j == 0 || j == map[i].length-1){
						System.out.print("│");
					} else {
						System.out.print(" ");
					}
				}
			}
			System.out.println();
		}
		System.out.println();
	}
	
	
}
//우39 하40 좌37 상38
