import junit.framework.Assert;

import java.io.File;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import org.junit.Test;
/**
 * Created by stevenroderick on 3/16/16.
 */
public class CompileTest {

    @Test
    public void ProveFileNameCanBeGrabbedFromFilePath() {
        String filePath = "Users/User/Desktop/sampleFilePath.java/";
        File file = new File(filePath);
        System.out.print(file.getName());
        assertTrue((file.getName().equals("sampleFilePath.java")));
    }

    @Test
    public void EnsureFileIsAJavaFile() {
        CompileChecker compileChecker = new CompileChecker();
        String filePath = "Users/User/Desktop/sampleFilePath.java/";
        File file = new File(filePath);
        assertTrue(compileChecker.EnsureFileIsJava(file));
    }

    @Test
    public void JavaFileCanCompileInRuntime() {
        CompileChecker compileChecker = new CompileChecker();
        System.out.print(System.getProperty("user.dir"));
        String[] stringArray = new String[] {System.getProperty("user.dir") + "/srcTest/CompileTest.java"};
        assertTrue(compileChecker.Compile(stringArray));
    }
}
