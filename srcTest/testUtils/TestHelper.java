package testUtils;


import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class TestHelper {

    public final static String TEST_FILE_DIR = "testResources/";

    @SuppressWarnings("ConstantConditions")
    public static List<File> getAllJavaFilesFromTestDirectory(){
        File directory = new File(TestHelper.TEST_FILE_DIR);
        List<File> listOfJavaFiles = Arrays.asList(directory.listFiles());
        return listOfJavaFiles.
                stream().
                filter(file -> file.getName().endsWith(".java")).
                collect(Collectors.toCollection(ArrayList::new));
    }

}
