package fr.projectGroup.appkana.core;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileUtils {
    public static void registerNewScore(PlayerScore newScore) {
        try {
            final PrintWriter writer = new PrintWriter(new FileWriter("ScoresFile.txt"));

            writer.println("");
            writer.println(newScore.getName() + " " + newScore.getScore());

            writer.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static List<PlayerScore> readAllScores() throws IOException {
        final List<PlayerScore> playersScore = new ArrayList<>();
        final BufferedReader reader = new BufferedReader(new FileReader("ScoresFile.txt"));
        String line;

        while ((line = reader.readLine()) != null) {
            final String name = line.split(" ")[0];
            final float points = Float.parseFloat(line.split(" ")[1]);

            playersScore.add(new PlayerScore(name, points));
        }

        reader.close();
        return playersScore;
    }
}
