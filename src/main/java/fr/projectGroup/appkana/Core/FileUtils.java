package fr.projectGroup.appkana.Core;

import java.io.*;
import java.util.ArrayList;
import java.util.List;


/**
 * This class contains some static methods to manipulate text file that contains the score.
 */
public class FileUtils {

    /**
     * This static method append the new score on the text file.
     *
     * @param newScore The PlayerScore object that we want to add.
     */
    public static void registerNewScore(PlayerScore newScore) {
        final List<String> oldContent = readLines();

        try {
            final BufferedWriter BuffWriter = new BufferedWriter(new FileWriter("ScoresFile.txt"));

            for (String currentLine : oldContent) {
                BuffWriter.write(currentLine + "\n");
            }

            BuffWriter.write(newScore.getName() + " " + newScore.getScore());

            BuffWriter.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * This static method read the text file and parse the lines to get all scores.
     *
     * @return A List which contains all score registered.
     */
    public static List<PlayerScore> readAllScores() {
        final List<PlayerScore> playersScore = new ArrayList<>();

        try {
            final BufferedReader reader = new BufferedReader(new FileReader("ScoresFile.txt"));
            String line;

            while ((line = reader.readLine()) != null) {
                final String[] splitLine = line.split(" ");

                playersScore.add(new PlayerScore(splitLine[0], Double.parseDouble(splitLine[1])));
            }

            reader.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return playersScore;
    }

    /**
     * This static private method read all lines of the file. It uses of the readAllScores method.
     *
     * @return A List of String where each line corresponds of a String.
     */
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
