//import org.junit.Test;
//        import static org.junit.Assert.assertEquals;
//
//public class AnActualJavaTest {
//
//    @Test
//    public void testTakesAListOfFilesAndReturnsListOfJavaFiles() throws Exception{
//        String PATH_TO_TEST_FILES = "testResources";
//        File file = new File(PATH_TO_TEST_FILES);
//        List<File> listOfJavaFiles = Arrays.asList(file.listFiles());
//
//        final File aJavaFile1 = new File(PATH_TO_TEST_FILES,"JavaTestWithNoAsserts.java");
//        final File aJavaFile2 = new File(PATH_TO_TEST_FILES,"JavaTestWithTestImport.java");
//        final File aJavaFile3 = new File(PATH_TO_TEST_FILES,"NotAJavaTestClass.java");
//        List<File> expectedFiles = Arrays.asList(aJavaFile1, aJavaFile2, aJavaFile3);
//
//        FileGatherer gatherer = new FileGatherer();
//
//        List<File> listOfFilesReturned = gatherer.filterJavaFiles(listOfJavaFiles);
//        assertEquals(expectedFiles, listOfFilesReturned);
//    }
//}