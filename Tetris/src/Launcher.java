//import java.awt.event.KeyEvent;
//import java.awt.event.KeyListener;
//
//import javax.swing.JFrame;
//
//
//
//
//public class Launcher {
//	static Map map = new Map(new int[25][10]);
//	static Key keyb;
//	public static void main(String[] args) {
//		JFrame f = new JFrame();
//	    f.setSize(300,200);     
//	    f.setLayout( null );
//	    f.setVisible(true);
//	    map.showMap();
//	    
//	    while(true){
//	    	Block b = new Block(4,map);
//	    	b.start();
//	    	f.addKeyListener(keyb=new Key(b));
//	    	try {
//	    		b.join();
//	    	} catch (InterruptedException e) {
//	    		// TODO Auto-generated catch block
//	    		e.printStackTrace();
//	    	}
//	    	f.removeKeyListener(keyb);
//	    }
//	}
//
//}
//
//
//
//
//
//
//
//
//
//
//
//
//
