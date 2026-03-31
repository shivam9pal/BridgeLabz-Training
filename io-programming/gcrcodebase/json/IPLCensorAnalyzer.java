package week05.gcrcodebase.json;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.databind.*;

public class IPLCensorAnalyzer {
	public static void main(String[] args) throws Exception {
		ObjectMapper mapper = new ObjectMapper();
		
		Match[] matches = mapper.readValue(new File("ipl.json"), Match[].class);
		for(Match m : matches) {
			censorMatch(m);
		}
		mapper.writerWithDefaultPrettyPrinter()
		.writeValue(new File("ipl_censored.json"), matches);
		
		System.out.println("Censored Json Created");
		
		BufferedReader br = new BufferedReader(new FileReader("ipl.csv"));
        BufferedWriter bw = new BufferedWriter(new FileWriter("ipl_censored.csv"));

        String line = br.readLine();
        bw.write(line);
        bw.newLine();

        while ((line = br.readLine()) != null) {

            String[] data = line.split(",");

            data[1] = maskTeam(data[1]);
            data[2] = maskTeam(data[2]);
            data[5] = maskTeam(data[5]);
            data[6] = "REDACTED";

            bw.write(String.join(",", data));
            bw.newLine();
        }

        br.close();
        bw.close();

        System.out.println("Censored CSV created.");
	}
	
	static String maskTeam(String name) {
		String[] parts = name.split(" ");
		if(parts.length > 1) {
			return parts[0] + " ***";
		}
		return "***";
	}
	
	static void censorMatch(Match m) {
		m.team1 = maskTeam(m.team1);
		m.team2 = maskTeam(m.team2);
		m.winner = maskTeam(m.winner);
		m.player_of_match = "REDACTED";
		
		Map<String, Integer> newScore = new HashMap<>();
        for (String key : m.score.keySet()) {
            newScore.put(maskTeam(key), m.score.get(key));
        }
        m.score = newScore;
	}
}

class Match{
	public int match_id;
    public String team1;
    public String team2;
    public Map<String, Integer> score;
    public String winner;
    public String player_of_match;
}