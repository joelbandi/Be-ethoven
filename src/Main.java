import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import com.leapmotion.leap.*;
public class Main {

	public static void main(String[] args) {
		
		/**
		 * Adding the controller object here. It serves as our connection to the Leap Motion service/daemon.
		 * also enable the circle gesture
		 */
		Controller controller = new Controller();
		
		/**
		 * Adding a listener event instead of polling the controller for changes, 
		 * we can create a separate thread to listen to the controller 
		 */
		
		LeapListener listener = new LeapListener();
		
		/**
		 * register a listener to the controller here...
		 */
		controller.addListener(listener);
		controller.enableGesture(Gesture.Type.TYPE_KEY_TAP);
		controller.config().setFloat("Gesture.KeyTap.MinDownVelocity", 40.0f);
		controller.config().setFloat("Gesture.KeyTap.HistorySeconds", .2f);
		controller.config().setFloat("Gesture.KeyTap.MinDistance", 1.0f);
		controller.setPolicy(Controller.PolicyFlag.POLICY_BACKGROUND_FRAMES);
		controller.config().save();
		
		/**
		 * 
		 * Adding the main 'Game loop' to this thing. Exits loop once enter is pressed.. 
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


