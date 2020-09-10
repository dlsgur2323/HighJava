package vo;

import java.io.Serializable;

public class OmokVO implements Serializable{
	private int[][] map = new int[15][15];
	private int[] wxy = {7,7};
	private int[] bxy = {7,7};
	private boolean turn = true; // true 이면 백돌 false 면 흑돌 차례
	
	public int[][] getMap() {
		return map;
	}
	public void setMap(int[][] map) {
		this.map = map;
	}
	public int[] getWxy() {
		return wxy;
	}
	public void setWxy(int[] wxy) {
		this.wxy = wxy;
	}
	public int[] getBxy() {
		return bxy;
	}
	public void setBxy(int[] bxy) {
		this.bxy = bxy;
	}
	
	
}
