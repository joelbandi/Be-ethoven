/**
 * 
 */

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
public class Parse {

	static HashMap hm = new HashMap<String, String>();
	
	Parse() {
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
	}
	/**
	 * @param args
	 */
	public static void parseplay(String positions) {
		Pattern left = new Pattern();
		Pattern right = new Pattern();
		left.add("V0 I[Violin] ");
		right.add("V1 I[Violin] ");
		int i =0;
		//System.out.println(positions.split("\t")[0]);
		String leftInput = (String) hm.get(positions.split("\t")[0]);
		String rightInput = (String) hm.get(positions.split("\t")[1]);
		left = left.add(leftInput+" ");
		right = right.add(rightInput+" ");
		left.setTempo(100);
		right.setTempo(100);
		Pattern finalPattern = new Pattern();
		finalPattern.add(left);
		finalPattern.add(right);
		Player player = new Player();
		player.play(finalPattern);
	}

}
