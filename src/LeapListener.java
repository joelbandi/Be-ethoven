import com.leapmotion.leap.*;


public class LeapListener extends Listener {
	
	public void onConnect(Controller controller){
		System.out.println("Controller connected");
	}
	
	
	
	public  void onFrame(Controller controller) {
 
		Frame frame = controller.frame();
		
		
		HandList handlist = frame.hands();
		
		if(handlist.count()<2){
			System.out.println("Put both your hands in range");
			return;
		}
		Hand righthand  = handlist.rightmost();
		Hand lefthand = handlist.leftmost();
		Hand hand = righthand;
		Vector rightvector = righthand.palmPosition();
		Vector leftvector = lefthand.palmPosition();
		float rightx = rightvector.getX();
		float leftx =  leftvector.getX();
		
		float righty = rightvector.getY();
		float lefty = leftvector.getY();
		
		System.out.println("Scanning this hand");
		boolean chk = righthand.isValid() && righthand.isValid();
		String r = "";
		String l = "";
		
		if(righty<=150.0){
			if(rightx>150.0 && chk){
				 r = "6";
			}else if(rightx<100.0 && chk){
				 r = "4";
			}else if(chk){
				r = "5";
			}
		}else{
			if(rightx>150.0 && chk){
				 r = "6#";
			}else if(rightx<100.0 && chk){
				 r = "4#";
			}else if(chk){
				r = "5#";
			}
		}
		
		
		if(lefty<=150.0){
			if(leftx<-150.0 && chk){
				l = "1";
			}else if(leftx>-100.0 && chk){
				l = "3";
			}else if(chk){
				l = "2";
			}
		}else{
			if(leftx<-150.0 && chk){
				l = "1#";
			}else if(leftx>-100.0 && chk){
				l = "3#";
			}else if(chk){
				l = "2#";
			}
		}
		
		
	
		

		System.out.println(l+" and "+r);
    }
	
	
	
	
}
