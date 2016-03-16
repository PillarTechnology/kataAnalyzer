package fileGatherer;

import org.junit.Test;

import java.io.File;
import java.util.Arrays;
import java.util.List;
import static org.junit.Assert.assertEquals;

public class FileGathererTest{

    @Test
    @SuppressWarnings("ConstantConditions")
    public void testTakesAListOfFilesAndReturnsListOfJavaFiles() throws Exception{
        String PATH_TO_TEST_FILES = "testResources";
        File file = new File(PATH_TO_TEST_FILES);
        List<File> listOfJavaFiles = Arrays.asList(file.listFiles());

        final File aJavaFile1 = new File(PATH_TO_TEST_FILES,"AnActualJavaTest.java");
        final File aJavaFile2 = new File(PATH_TO_TEST_FILES,"AnotherActualJavaTest.java");
        final File aJavaFile3 = new File(PATH_TO_TEST_FILES,"NotAJavaTestClass.java");
        List<File> expectedFiles = Arrays.asList(aJavaFile1, aJavaFile2, aJavaFile3);

        FileGatherer gatherer = new FileGatherer();

        List<File> listOfFilesReturned = gatherer.filterJavaFiles(listOfJavaFiles);
        assertEquals(expectedFiles, listOfFilesReturned);
    }
}
