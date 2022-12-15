package fr.projectGroup.appkana.test;

import fr.projectGroup.appkana.Core.PlayerScore;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PlayerScoreTest {
    @Test
    public void testInstantiation() {
        Assertions.assertDoesNotThrow(() -> new PlayerScore("", 0));
        Assertions.assertDoesNotThrow(() -> new PlayerScore("random", 22.47));
    }

    @Test
    public void testGetters() {
        final PlayerScore playerScore = new PlayerScore("random", 84.54);

        Assertions.assertEquals(playerScore.getName(), "random");
        Assertions.assertEquals(playerScore.getScore(), 84.54);
    }

    @Test
    public void testToStringAndEquals() {
        final PlayerScore playerScore = new PlayerScore("random", 82.6);

        Assertions.assertEquals(playerScore.toString(), "PlayerScore[name=random, score=82.6]");
        Assertions.assertEquals(playerScore, new PlayerScore("random", 82.6));
    }

    @Test
    public void testSortWithBubbleSort() {
        final List<PlayerScore> playerScoreList = new ArrayList<>();

        playerScoreList.add(new PlayerScore("random", 12.4));
        playerScoreList.add(new PlayerScore("random2", 73));
        playerScoreList.add(new PlayerScore("random3", 39.11));
        playerScoreList.add(new PlayerScore("random4", 0.04));

        PlayerScore.BubbleSort(playerScoreList);

        for (int i = 1; i < playerScoreList.size(); ++i) {
            Assertions.assertTrue(playerScoreList.get(i - 1).getScore() <= playerScoreList.get(i).getScore());
        }
    }

    @Test
    public void testSortComparableInterface() {
        final List<PlayerScore> playerScoreList = new ArrayList<>();

        playerScoreList.add(new PlayerScore("random", 12.4));
        playerScoreList.add(new PlayerScore("random2", 73));
        playerScoreList.add(new PlayerScore("random3", 39.11));
        playerScoreList.add(new PlayerScore("random4", 0.04));

        Collections.sort(playerScoreList);

        for (int i = 1; i < playerScoreList.size(); ++i) {
            Assertions.assertTrue(playerScoreList.get(i - 1).getScore() <= playerScoreList.get(i).getScore());
        }
    }
}
