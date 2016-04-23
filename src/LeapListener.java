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
		

		
		
		
		
		
		
		Vector rightvector = righthand.palmPosition();
		Vector leftvector = lefthand.palmPosition();
		
		
		float rightx = rightvector.getX();
		float leftx =  leftvector.getX();
		
		
		
		
		System.out.println("Scanning this hand");
		
		boolean chk = righthand.isValid() && righthand.isValid();
		
		String r = "";
		String l = "";
		
		if(rightx>150.0 && chk){
			 r = "->";
		}else if(rightx<100.0 && chk){
			 r = "<-";
		}else if(chk){
			r = "--";
		}
		
		if(leftx<-150.0 && chk){
			l = "<-";
		}else if(leftx>-100.0 && chk){
			l = "->";
		}else if(chk){
			l = "--";
		}
		
		
		
		System.out.println(l+" and "+r);
		
		
		
        
        
    }
	
}
