import com.leapmotion.leap.*;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;


public class LeapListener extends Listener {

	String r = "";
	String l = "";

	public void onConnect(Controller controller) {
		System.out.println("Controller connected");
	}

	public void onFrame(Controller controller) {

		Frame frame = controller.frame();
		HandList handlist = frame.hands();
		
		if (handlist.count() < 2) {
			System.out.println("Put both your hands in range");
			return;
		}

		Hand righthand = handlist.rightmost();
		Hand lefthand = handlist.leftmost();

		Vector rightvector = righthand.palmPosition();
		Vector leftvector = lefthand.palmPosition();

		float rightx = rightvector.getX();
		float leftx = leftvector.getX();

		float righty = rightvector.getY();
		float lefty = leftvector.getY();

		
		Frame frame1 = controller.frame(1);
		GestureList gl = frame1.gestures();
		if (!gl.isEmpty()) {
			keytap(gl);
		}

		
		boolean chk = righthand.isValid() && righthand.isValid();
		rightcheck(righty, rightx, chk);
		leftcheck(lefty, leftx, chk);
		System.out.println(l + " and " + r);
	}

	public void keytap(GestureList gl) {

		Gesture gesture = gl.get(0);
		KeyTapGesture keytapgesture = null;

		if (gesture.type() == KeyTapGesture.classType()) {
			keytapgesture = new KeyTapGesture(gesture);
		}

		Pointable pointable = keytapgesture.pointable();
		Hand h = pointable.hand();
		System.out.println(h.id()+"----->>"+pointable.id());

	}

	public void rightcheck(float righty, float rightx, boolean chk) {
		if (righty <= 150.0) {
			if (rightx > 150.0 && chk) {
				r = "6";
			} else if (rightx < 100.0 && chk) {
				r = "4";
			} else if (chk) {
				r = "5";
			}
		} else {
			if (rightx > 150.0 && chk) {
				r = "6#";
			} else if (rightx < 100.0 && chk) {
				r = "4#";
			} else if (chk) {
				r = "5#";
			}
		}
	}

	public void leftcheck(float lefty, float leftx, boolean chk) {
		if (lefty <= 150.0) {
			if (leftx < -150.0 && chk) {
				l = "1";
				play();
			} else if (leftx > -100.0 && chk) {
				l = "3";
				play();
			} else if (chk) {
				l = "2";
				play();
			}
		} else {
			if (leftx < -150.0 && chk) {
				l = "1#";
				play();
			} else if (leftx > -100.0 && chk) {
				l = "3#";
				play();
			} else if (chk) {
				l = "2#";
				play();
			}
		}
		
		
		printfile(l,r);	
		
	}
	
	
	
	public void printfile(String l, String r){
		String content = l+"	-	"+r;
		try(FileWriter fw = new FileWriter("/home/joel/Devspace/Be-ethoven/src/positions.txt", true);
			    BufferedWriter bw = new BufferedWriter(fw);
			    PrintWriter out = new PrintWriter(bw))
			{
			    out.println(content);
			} catch (IOException e) {
				return;
			}
		
	}
	
	
	public void play(){
//		Choir choir = new Choir("1");
//		choir.run();
	}

}
