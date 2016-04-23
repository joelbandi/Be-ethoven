import java.io.IOException;

import com.leapmotion.leap.*;
public class Main {

	public static void main(String[] args) {
		
		/**
		 * Adding the controller object here. It serves as our connection to the Leap Motion service/daemon.
		 * also enable the circle gesture
		 */
		Controller controller = new Controller();
		controller.enableGesture(Gesture.Type.TYPE_CIRCLE);
		
		/**
		 * Adding a listener event instead of polling the controller for changes, 
		 * we can create a separate thread to listen to the controller 
		 */
		
		LeapListener listener = new LeapListener();
		
		/**
		 * register a listener to the controller here...
		 */
		controller.addListener(listener);
		
		
		/**
		 * 
		 * Adding the main 'Game loop' to this thing. Exits loop once eneter is pressed.. 
		 */
        System.out.println("Press Enter to quit...");
        try {
            System.in.read();
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        
        /**
         * Remove listener here 
         */
        
        controller.removeListener(listener);
        
		
	}

}
