package fileGatherer;

import org.junit.Test;

import java.io.File;
import java.util.Arrays;
import java.util.List;
import static org.junit.Assert.assertEquals;
import testUtils.TestHelper;

public class JavaFileFilterTest {

    @Test
    @SuppressWarnings("ConstantConditions")
    public void testTakesAListOfFilesAndReturnsListOfJavaFiles() throws Exception{
        File file = new File(TestHelper.TEST_FILE_DIR);
        List<File> listOfJavaFiles = Arrays.asList(file.listFiles());

        final File aJavaFile1 = new File(TestHelper.TEST_FILE_DIR, "JavaTestThatIsProperlyWritten.java");
        final File aJavaFile2 = new File(TestHelper.TEST_FILE_DIR, "JavaTestWithAssertsButNoTestImport.java");
        final File aJavaFile3 = new File(TestHelper.TEST_FILE_DIR, "JavaTestWithNoAsserts.java");
        final File aJavaFile4 = new File(TestHelper.TEST_FILE_DIR, "JavaTestWithTestAnnotation.java");
        final File aJavaFile5 = new File(TestHelper.TEST_FILE_DIR, "JavaTestWithTestImport.java");
        final File aJavaFile6 = new File(TestHelper.TEST_FILE_DIR, "NotAJavaTestClass.java");
        List<File> expectedFiles = Arrays.asList(
                aJavaFile1,
                aJavaFile2,
                aJavaFile3,
                aJavaFile4,
                aJavaFile5,
                aJavaFile6);
        JavaFileFilter gatherer = new JavaFileFilter();

        List<File> listOfFilesReturned = gatherer.filterFiles(listOfJavaFiles);
        assertEquals(expectedFiles, listOfFilesReturned);
    }
}
