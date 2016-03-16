/**
 * Created by stevenroderick on 3/16/16.
 */
import java.io.File;
import javax.tools.*;

public class CompileChecker {

    public boolean Compile(String fileName) {
        JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
        int compilationResult = compiler.run(null, null, null, fileName);
        if(compilationResult == 0)
            return true;
        else
            return false;

    }

    public boolean EnsureFileIsJava(File file) {
        return (file.getName().contains(".java"));
    }
}
