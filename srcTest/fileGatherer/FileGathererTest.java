package fileGatherer;

import junit.framework.TestCase;
import org.junit.Test;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

public class FileGathererTest extends TestCase {

    @Test
    public void testGatherTakesAListOfFilesAndReturnsListOfJavaFiles() throws Exception{
        Path path = Paths.get("/testResources/");

        final File notAJavaFile = new File(path.toString(),"readme.txt");
        final File notAJavaFile2 = new File(path.toString(),"readme2.txt");
        final File aJavaFile1 = new File(path.toString(),"readme.java");
        final File aJavaFile2 = new File(path.toString(),"readmeagain.java");
        final File aJavaFile3 = new File(path.toString(),"dontreadme.java");

        List<File> filesPassedIn = Arrays.asList(notAJavaFile, notAJavaFile2, aJavaFile1, aJavaFile2, aJavaFile3);
        List<File> expectedFiles = Arrays.asList(aJavaFile1, aJavaFile2, aJavaFile3);

        FileGatherer gatherer = new FileGatherer();

        List<File> listOfFilesReturned = gatherer.filterJavaFiles(filesPassedIn);
        assertEquals(expectedFiles, listOfFilesReturned);
    }


}
