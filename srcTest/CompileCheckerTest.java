import java.io.File;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
/**
 * Created by stevenroderick on 3/16/16.
 */
public class CompileCheckerTest {

    @Test
    public void ensureFileIsAJavaFile() {
        CompileChecker compileChecker = new CompileChecker();
        String filePath = "Users/User/Desktop/sampleFilePath.java/";
        File file = new File(filePath);
        assertTrue(compileChecker.ensureFileIsJava(file));
    }

    @Test
    public void ensureFileIsAJavaFile2() {
        CompileChecker compileChecker = new CompileChecker();
        String filePath = System.getProperty("user.dir") + "/srcTest/CompileCheckerTest.java";
        File file = new File(filePath);
        assertTrue(compileChecker.ensureFileIsJava(file));
    }

    @Test
    public void canUseJavac() {
        CompileChecker compileChecker = new CompileChecker();
        List<String> arguments = new ArrayList<>();
        String directory = System.getProperty("user.dir") + "/src";
        File folder = new File(directory);
        File[] listOfFiles = folder.listFiles();
        for(int i = 0; i < listOfFiles.length; i++) {
            if(listOfFiles[i].getName().contains(".java"))
                arguments.add(listOfFiles[i].getPath());
        }
        boolean canCompile = compileChecker.createClassFiles(arguments.toArray(new String[arguments.size()]));
        assertTrue(canCompile);
    }

    @Test
    public void getAllFilesShouldReturnZero() {
        CompileChecker compileChecker = new CompileChecker();
        List<String> classes = compileChecker.getClassFiles();
        for(int i = 0; i < classes.size(); i++) {
            File file = new File(classes.get(i));
            file.delete();
        }
        classes = compileChecker.getClassFiles();
        assertTrue(classes.size() == 0);
    }

    @Test
    public void ensureClassFilesAreGenerated() {
        CompileChecker compileChecker = new CompileChecker();
        List<String> classes = compileChecker.getClassFiles();
        for(int i = 0; i < classes.size(); i++) {
            File file = new File(classes.get(i));
            file.delete();
        }
        List<String> arguments = new ArrayList<>();
        String directory = System.getProperty("user.dir") + "/src";
        File folder = new File(directory);
        File[] listOfFiles = folder.listFiles();
        for(int i = 0; i < listOfFiles.length; i++) {
            if(listOfFiles[i].getName().contains(".java"))
                arguments.add(listOfFiles[i].getPath());
        }
        compileChecker.createClassFiles(arguments.toArray(new String[arguments.size()]));
        classes = compileChecker.getClassFiles();
        assertTrue(classes.size() != 0);
    }

    @Test
    public void buildJavaJarFile() {
        CompileChecker compileChecker = new CompileChecker();
        List<String> arguments = new ArrayList<>();
        String directory = System.getProperty("user.dir") + "/src";
        File folder = new File(directory);
        File[] listOfFiles = folder.listFiles();
        for(int i = 0; i < listOfFiles.length; i++) {
            if(listOfFiles[i].getName().contains(".java"))
                arguments.add(listOfFiles[i].getPath());
        }
        boolean canBuildJar = false;
        boolean canCompile = compileChecker.createClassFiles(arguments.toArray(new String[arguments.size()]));
        if(canCompile == true) {
            canBuildJar = compileChecker.createJARFile(compileChecker.getClassFiles());
        }
        assertTrue(canBuildJar);
    }
}
