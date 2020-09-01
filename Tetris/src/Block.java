import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Block extends Thread {
	private static Map map;
	public int[][] shape;
	public int temp;
	final int T = 0;
	final int L1 = 1;
	final int L2 = 2;
	final int I = 3;
	final int E = 4;

	public Block(int i, Map map) {
		this.map = map;
		temp = i;
		if (temp == T) {
			// this.shape = new int[][]{{0, 1, 0},
			// {1, 1, 1}};
		} else if (temp == L1) {
			// this.shape = new int[][]{{1, 0, 0},
			// {1, 1, 1}};
		} else if (temp == L2) {
			// this.shape = new int[][]{{0, 0, 1},
			// {1, 1, 1}};
		} else if (temp == I) {
			// this.shape = new int[][]{{0, 0, 0, 0},
			// {1, 1, 1, 1}};
		} else if (temp == E) {
			this.shape = new int[][] { { 0, 4 }, { 0, 5 }, { 1, 4 }, { 1, 5 } };
		}

	}

	private final Lock lock = new ReentrantLock();

	public void Move(int input) {
		if (input == 37) {
			if (!(map.m[shape[0][0]][shape[0][1] - 1] == 5 || shape[0][1] - 1 == 0)) {
				shape[0][1]--;
				shape[1][1]--;
				shape[2][1]--;
				shape[3][1]--;
				map.m[shape[0][0]][shape[0][1] - 1] = 0;
				map.m[shape[1][0]][shape[1][1] - 1] = 0;
				map.m[shape[2][0]][shape[2][1] - 1] = 0;
				map.m[shape[3][0]][shape[3][1] - 1] = 0;
				map.showMap();
			}
		}
	}

	public void Falling() {
		try {
			map.m[shape[0][0]][shape[0][1]] = 1;
			map.m[shape[1][0]][shape[1][1]] = 1;
			map.m[shape[2][0]][shape[2][1]] = 1;
			map.m[shape[3][0]][shape[3][1]] = 1;
			map.showMap();
			if (shape[2][0] == map.m.length - 1
					|| map.m[shape[2][0] + 1][shape[2][1]] == 5) {
				map.m[shape[0][0]][shape[0][1]] = 5;
				map.m[shape[1][0]][shape[1][1]] = 5;
				map.m[shape[2][0]][shape[2][1]] = 5;
				map.m[shape[3][0]][shape[3][1]] = 5;
				return;
			}
			Thread.sleep(500);
			shape[0][0]++;
			shape[1][0]++;
			shape[2][0]++;
			shape[3][0]++;
			map.m[shape[3][0] - 1][shape[3][1]] = 0;
			map.m[shape[0][0] - 1][shape[0][1]] = 0;
			map.m[shape[1][0] - 1][shape[1][1]] = 0;
			map.m[shape[2][0] - 1][shape[2][1]] = 0;

		} catch (InterruptedException e) {
			// TODO: handle exception
		}
	}

	@Override
	public void run() {
		while(true){
			Falling();
			if (shape[2][0] == map.m.length - 1
					|| map.m[shape[2][0] + 1][shape[2][1]] == 5) {
				map.m[shape[0][0]][shape[0][1]] = 5;
				map.m[shape[1][0]][shape[1][1]] = 5;
				map.m[shape[2][0]][shape[2][1]] = 5;
				map.m[shape[3][0]][shape[3][1]] = 5;
				return;
			}
		}
	}

}
// 우39 하40 좌37 상38