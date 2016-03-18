package kataAnalyzer.sourceCompiler;

import java.io.File;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/**
 * Created by stevenroderick on 3/16/16.
 */
public class CompileCheckerTest {

    private final String SOURCE_DIRECTORY = "../../src/kataAnalyzer/sourceCompiler/";
    private final String SOURCE_TEST_DIRECTORY = "../../srcTest/kataAnalyzer/sourceCompiler/";

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
        String filePath = SOURCE_TEST_DIRECTORY + "CompileCheckerTest.java";
        File file = new File(filePath);
        assertTrue(compileChecker.ensureFileIsJava(file));
    }

    @Test
    public void canUseJavac() {
        CompileChecker compileChecker = new CompileChecker();
        List<String> arguments = new ArrayList<>();
        String directory = SOURCE_DIRECTORY;
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
        String directory = SOURCE_DIRECTORY;
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
        String directory = SOURCE_DIRECTORY;
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

    @Test
    public void itShouldReturnTrueAfterCompileSourceIsCalledWithADirectory() {
        CompileChecker compileChecker = new CompileChecker();
        boolean compiled = compileChecker.compileSource(SOURCE_DIRECTORY);
        assertTrue(compiled == true);
    }

    @Test
    public void itShouldFailAtCompileWhenGivenAnInvalidDirectory() {
        CompileChecker compileChecker = new CompileChecker();
        boolean compiled = compileChecker.compileSource("invalid");
        assertTrue(compiled == false);
    }

    @Test
    public void itShouldReturnJarPath() {
        CompileChecker compileChecker = new CompileChecker();
        boolean compiled = compileChecker.compileSource(SOURCE_DIRECTORY);
        assertEquals(System.getProperty("user.dir") + "/main.jar", compileChecker.pathForJarFile);
    }

    @Test
    public void itShouldReturnTrueAfterCompileSourceIsCalledWithAListOfFiles() {
        CompileChecker compileChecker = new CompileChecker();
        File folder = new File(SOURCE_DIRECTORY);
        boolean compiled = compileChecker.compileSource(Arrays.asList(folder.listFiles()));
        assertTrue(compiled == true);
    }
}
