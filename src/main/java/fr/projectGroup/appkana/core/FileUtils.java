package fr.projectGroup.appkana.core;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileUtils {
    public static void registerNewScore(PlayerScore newScore) {
        final List<String> oldContent = readLines();

        try {
            final BufferedWriter BuffWriter = new BufferedWriter(new FileWriter("ScoresFile.txt"));

            for (String currentLine : oldContent) {
                BuffWriter.write(currentLine + "\n");
            }

            BuffWriter.write(newScore.name() + " " + newScore.score());

            BuffWriter.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static List<PlayerScore> readAllScores() {
        final List<PlayerScore> playersScore = new ArrayList<>();

        try {
            final BufferedReader reader = new BufferedReader(new FileReader("ScoresFile.txt"));
            String line;

            while ((line = reader.readLine()) != null) {
                final String[] splitLine = line.split(" ");
                System.out.println(splitLine.length);

                playersScore.add(new PlayerScore(splitLine[0], Double.parseDouble(splitLine[1])));
            }

            reader.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return playersScore;
    }

    private static List<String> readLines() {
        List<String> lines = new ArrayList<>();

        try {
            final BufferedReader reader = new BufferedReader(new FileReader("ScoresFile.txt"));
            String currentLine;

            while ((currentLine = reader.readLine()) != null) {
                lines.add(currentLine);
            }

            reader.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return lines;
    }
}
