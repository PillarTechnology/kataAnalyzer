package kataAnalyzer.testUtils;


import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.Arrays.asList;

public class TestHelper {

    public final static String TEST_FILE_DIR = "../../testResources/";

    @SuppressWarnings("ConstantConditions")
    public static List<File> getAllJavaFilesFromTestDirectory() {
        File directory = new File(TestHelper.TEST_FILE_DIR);
        List<File> listOfJavaFiles = Arrays.asList(directory.listFiles());
        return listOfJavaFiles.
                stream().
                filter(file -> file.getName().endsWith(".java")).
                collect(Collectors.toCollection(ArrayList::new));
    }

    public static List<File> getAllTestJavaFilesFromTestDirectory() {
        final File aJavaFile1 = new File(TestHelper.TEST_FILE_DIR, "JavaTestThatIsProperlyWritten.java");
        return Collections.singletonList(aJavaFile1);
    }

    public static List<File> getAllNonTestJavaFilesFromTestDirectory() {
        final File aJavaFile1 = new File(TestHelper.TEST_FILE_DIR, "JavaTestWithAssertsButNoTestImport.java");
        final File aJavaFile2 = new File(TestHelper.TEST_FILE_DIR, "JavaTestWithNoAsserts.java");
        final File aJavaFile3 = new File(TestHelper.TEST_FILE_DIR, "JavaTestWithTestAnnotation.java");
        final File aJavaFile4 = new File(TestHelper.TEST_FILE_DIR, "JavaTestWithTestImport.java");
        final File aJavaFile5 = new File(TestHelper.TEST_FILE_DIR, "NotAJavaTestClass.java");
        return asList(
                aJavaFile1,
                aJavaFile2,
                aJavaFile3,
                aJavaFile4,
                aJavaFile5);
    }
}
