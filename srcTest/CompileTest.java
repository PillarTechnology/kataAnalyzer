import java.io.File;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
/**
 * Created by stevenroderick on 3/16/16.
 */
public class CompileTest {

    @Test
    public void EnsureFileIsAJavaFile() {
        CompileChecker compileChecker = new CompileChecker();
        String filePath = "Users/User/Desktop/sampleFilePath.java/";
        File file = new File(filePath);
        assertTrue(compileChecker.EnsureFileIsJava(file));
    }

    @Test
    public void EnsureFileIsAJavaFile2() {
        CompileChecker compileChecker = new CompileChecker();
        String filePath = System.getProperty("user.dir") + "/srcTest/CompileTest.java";
        File file = new File(filePath);
        assertTrue(compileChecker.EnsureFileIsJava(file));
    }

    @Test
    public void TestRunJavacInApp() {
        CompileChecker compileChecker = new CompileChecker();
        List<String> arguments = new ArrayList<>();
        String directory = System.getProperty("user.dir") + "/src";
        File folder = new File(directory);
        File[] listOfFiles = folder.listFiles();
        for(int i = 0; i < listOfFiles.length; i++) {
            if(listOfFiles[i].getName().contains(".java"))
                arguments.add(listOfFiles[i].getPath());
        }
        boolean canCompile = compileChecker.CreateClassFiles(arguments.toArray(new String[arguments.size()]));
        assertTrue(canCompile);
    }
}
