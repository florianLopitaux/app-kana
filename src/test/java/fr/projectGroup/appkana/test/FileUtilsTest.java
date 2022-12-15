package fr.projectGroup.appkana.test;

import fr.projectGroup.appkana.Core.FileUtils;
import fr.projectGroup.appkana.Core.PlayerScore;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import java.util.List;

public class FileUtilsTest {
    @Test
    public void testReadAllScores() {
        Assertions.assertDoesNotThrow(FileUtils::readAllScores);

        final List<PlayerScore> playerScoreList = FileUtils.readAllScores();

        for (PlayerScore playerScore : playerScoreList) {
            Assertions.assertDoesNotThrow(playerScore::getName);
            Assertions.assertDoesNotThrow(playerScore::getScore);
        }
    }

    @Test
    public void testRegisterNewScoreMethod() {
        final List<PlayerScore> beforeUpdatePlayerScoreList = FileUtils.readAllScores();
        Assertions.assertDoesNotThrow(() -> FileUtils.registerNewScore(new PlayerScore("JulesLeGolem", 13.96)));

        final List<PlayerScore> afterUpdatePlayerScoreList = FileUtils.readAllScores();

        Assertions.assertNotEquals(beforeUpdatePlayerScoreList, afterUpdatePlayerScoreList);
        Assertions.assertEquals(afterUpdatePlayerScoreList.size(), beforeUpdatePlayerScoreList.size() + 1);
        Assertions.assertEquals(afterUpdatePlayerScoreList.get(afterUpdatePlayerScoreList.size() -1).getName(), "JulesLeGolem");
        Assertions.assertEquals(afterUpdatePlayerScoreList.get(afterUpdatePlayerScoreList.size() - 1).getScore(), 13.96);
    }
}
