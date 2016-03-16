import java.io.File;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import org.junit.Test;
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
    public void JavaFileCanCompileInRuntime() {
        CompileChecker compileChecker = new CompileChecker();
        System.out.print(System.getProperty("user.dir"));
        String[] stringArray = new String[] {};
        assertTrue(compileChecker.Compile(System.getProperty("user.dir") + "/srcTest/CompileTest.java"));
    }

    @Test
    public void JavaFileIsBad() {
        CompileChecker compileChecker = new CompileChecker();
        assertFalse(compileChecker.Compile(System.getProperty("user.dir") + "/srcTest/README.md2"));
    }
}
