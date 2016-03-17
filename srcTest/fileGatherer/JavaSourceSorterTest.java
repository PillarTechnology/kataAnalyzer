package fileGatherer;

import static java.util.Arrays.asList;
import static junit.framework.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import testUtils.TestHelper;

import java.io.File;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;


public class JavaSourceSorterTest {


    @Before
    public void setup(){
    }

    @Test
    public void shouldReturnSortedTestFiles() {
        List<File> allJavaFilesFromTestDirectory = TestHelper.getAllJavaFilesFromTestDirectory();

        final File aJavaFile1 = new File(TestHelper.TEST_FILE_DIR, "JavaTestThatIsProperlyWritten.java");
        final File aJavaFile2 = new File(TestHelper.TEST_FILE_DIR, "JavaTestWithAssertsButNoTestImport.java");
        final File aJavaFile3 = new File(TestHelper.TEST_FILE_DIR, "JavaTestWithNoAsserts.java");
        final File aJavaFile4 = new File(TestHelper.TEST_FILE_DIR, "JavaTestWithTestAnnotation.java");
        final File aJavaFile5 = new File(TestHelper.TEST_FILE_DIR, "JavaTestWithTestImport.java");
        final File aJavaFile6 = new File(TestHelper.TEST_FILE_DIR, "NotAJavaTestClass.java");
        List<File> expectedTestFiles = Collections.singletonList(aJavaFile1);
        List<File> expectedNonTestFiles = asList(
                aJavaFile2,
                aJavaFile3,
                aJavaFile4,
                aJavaFile5,
                aJavaFile6);

        MockTestFileValidator mockValidator = new MockTestFileValidator();
        mockValidator.setValueToReturnFromValidate(aJavaFile1, true);
        mockValidator.setValueToReturnFromValidate(aJavaFile2, false);
        mockValidator.setValueToReturnFromValidate(aJavaFile3, false);
        mockValidator.setValueToReturnFromValidate(aJavaFile4, false);
        mockValidator.setValueToReturnFromValidate(aJavaFile5, false);
        mockValidator.setValueToReturnFromValidate(aJavaFile6, false);

        JavaSourceSorter javaSourceSorter = new JavaSourceSorter(mockValidator);

        HashMap<SourceType, List<File>> actualMap = javaSourceSorter.sortIntoSourceTypes(allJavaFilesFromTestDirectory);

        assertEquals(expectedNonTestFiles, actualMap.get(SourceType.NOT_TEST_CODE));
        assertEquals(expectedTestFiles, actualMap.get(SourceType.TEST_CODE));

    }

}
