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
        List<File> expectedTestFiles = TestHelper.getAllTestJavaFilesFromTestDirectory();
        List<File> expectedNonTestFiles = TestHelper.getAllNonTestJavaFilesFromTestDirectory();

        MockTestFileValidator mockValidator = new MockTestFileValidator();
        for (File file: expectedTestFiles) {
            mockValidator.setValueToReturnFromValidate(file, true);
        }
        for (File file: expectedNonTestFiles) {
            mockValidator.setValueToReturnFromValidate(file, false);
        }

        JavaSourceSorter javaSourceSorter = new JavaSourceSorter(mockValidator);

        HashMap<SourceType, List<File>> actualMap = javaSourceSorter.sortIntoSourceTypes(allJavaFilesFromTestDirectory);

        assertEquals(expectedNonTestFiles, actualMap.get(SourceType.NOT_TEST_CODE));
        assertEquals(expectedTestFiles, actualMap.get(SourceType.TEST_CODE));

    }

}
