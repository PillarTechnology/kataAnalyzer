package fileGatherer;

import org.junit.Test;

import java.io.File;
import java.util.Arrays;
import java.util.List;
import static org.junit.Assert.assertEquals;
import testUtils.TestConstants;

public class FileGathererTest{

    @Test
    @SuppressWarnings("ConstantConditions")
    public void testTakesAListOfFilesAndReturnsListOfJavaFiles() throws Exception{
        File file = new File(TestConstants.TEST_FILE_DIR);
        List<File> listOfJavaFiles = Arrays.asList(file.listFiles());

        final File aJavaFile1 = new File(TestConstants.TEST_FILE_DIR, "JavaTestThatIsProperlyWritten.java");
        final File aJavaFile2 = new File(TestConstants.TEST_FILE_DIR, "JavaTestWithAsserts.java");
        final File aJavaFile3 = new File(TestConstants.TEST_FILE_DIR, "JavaTestWithNoAsserts.java");
        final File aJavaFile4 = new File(TestConstants.TEST_FILE_DIR, "JavaTestWithTestAnnotation.java");
        final File aJavaFile5 = new File(TestConstants.TEST_FILE_DIR, "JavaTestWithTestImport.java");
        final File aJavaFile6 = new File(TestConstants.TEST_FILE_DIR, "NotAJavaTestClass.java");
        List<File> expectedFiles = Arrays.asList(
                aJavaFile1,
                aJavaFile2,
                aJavaFile3,
                aJavaFile4,
                aJavaFile5,
                aJavaFile6);
        FileGatherer gatherer = new FileGatherer();

        List<File> listOfFilesReturned = gatherer.filterJavaFiles(listOfJavaFiles);
        assertEquals(expectedFiles, listOfFilesReturned);
    }
}
