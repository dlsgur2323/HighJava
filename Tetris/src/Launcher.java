import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;




public class Launcher {
	static Map map = new Map(new int[25][10]);
	static Key keyb;
	public static void main(String[] args) {
		JFrame f = new JFrame();
	    f.setSize(300,200);     
	    f.setLayout( null );
	    f.setVisible(true);
	    map.showMap();
	    Block b1 = new Block(4, map);
	    b1.start();
	    f.addKeyListener(keyb=new Key(b1));
	    try {
			b1.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    f.removeKeyListener(keyb);
	    Block b2 = new Block(4, map);
	    b2.start();
	    f.addKeyListener(keyb=new Key(b2));
	    try {
	    	b2.join();
	    } catch (InterruptedException e) {
	    	// TODO Auto-generated catch block
	    	e.printStackTrace();
	    }
	    f.removeKeyListener(keyb);
	}

}
//우39 하40 좌37 상38
class Key implements KeyListener{
	Block block;
	

	public Key(Block block) {
		super();
		this.block = block;
	}
	public Key() {
	}
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode() == 37){
			block.Move(37);
		}
	}
	
	
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	
}












