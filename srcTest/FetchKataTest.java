import org.junit.Test;

import java.io.File;

import static junit.framework.TestCase.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Created by stevenroderick on 3/17/16.
 */
public class FetchKataTest {

    @Test
    public void itSucceedsAtCloningARepoWhenGivenAURL() {
        FetchKata fetchKata = new FetchKata();
        boolean success = fetchKata.cloneRepository("https://github.com/PillarTechnology/kataAnalyzer");
        assertTrue(success == true);
    }

    @Test
    public void itCreatesLocalRepoWhenGivenAURL() {
        FetchKata fetchKata = new FetchKata();
        boolean success = fetchKata.cloneRepository("https://github.com/PillarTechnology/kataAnalyzer");
        File dir = new File(fetchKata.localDirectory);
        assertTrue(dir.exists());
    }

    @Test
    public void itFailsAtCreatingLocalRepoWhenGivenAnInvalidURL() {
        FetchKata fetchKata = new FetchKata();
        boolean success = fetchKata.cloneRepository("derp");
        assertFalse(success == false);
    }

    @Test
    public void itWillCleanUpLocalRepoWhenCalled() {
        FetchKata fetchKata = new FetchKata();
        fetchKata.cloneRepository("https://github.com/PillarTechnology/kataAnalyzer");
        fetchKata.cleanup();
        File newFile = new File(fetchKata.localDirectory);
        assertTrue(newFile.exists() == false);
    }

    @Test
    public void itWillDeleteLocalRepoWhenGivenADirectory() {
        FetchKata fetchKata = new FetchKata();
        String repo = System.getProperty("user.dir") + "/SHOULD_BE_DELETED";
        File newFile = new File(repo);
        newFile.mkdir();
        fetchKata.deleteDirectory(newFile);
        assertFalse(newFile.exists());
    }
}
