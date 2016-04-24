/**
 * 
 */
package musicApp;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;

import org.jfugue.pattern.Pattern;
import org.jfugue.pattern.PatternProducer;
import org.jfugue.player.Player;

/**
 * @author Shaf
 *
 */
public class parseTextAndPlay {

	static HashMap hm = new HashMap<String, String>();
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		hm.put("1", "C3q");
		hm.put("1#", "D3q");
		hm.put("2", "E3q");
		hm.put("2#", "F3q");
		hm.put("3", "G3q");
		hm.put("3#", "A3q");
		hm.put("4", "C4q");
		hm.put("4#", "D4q");
		hm.put("5", "E4q");
		hm.put("5#", "F4q");
		hm.put("6", "G4q");
		hm.put("6#", "A4q");
		// TODO Auto-generated method stub
		File f = new File("C:\\Users\\Shaf\\Downloads\\positions.txt");
		Charset charset = Charset.forName("US-ASCII");
		Pattern left = new Pattern();
		Pattern right = new Pattern();
		left.add("V0 I[Piano] ");
		right.add("V1 I[Piano] ");
		int i =0;
		try {
			FileInputStream fStream = new FileInputStream(f);
			BufferedReader in = new BufferedReader(new InputStreamReader(fStream));
			while(in.ready()) {
				String input = in.readLine();
				System.out.println(input.split("\t")[0]);
				String leftInput = (String) hm.get(input.split("\t")[0]);
				String rightInput = (String) hm.get(input.split("\t")[0]);
				left = left.add(leftInput+" ");
				right = right.add(rightInput+" ");
				left.setTempo(450);
				right.setTempo(450);
				
			}
			Pattern finalPattern = new Pattern();
			finalPattern.add(left);
			finalPattern.add(right);
			in.close();
			Player player = new Player();
			player.play(finalPattern);
		} catch(IOException e) {
			System.out.println("File input error");
		}
	}

}
