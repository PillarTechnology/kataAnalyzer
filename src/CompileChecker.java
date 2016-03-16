/**
 * Created by stevenroderick on 3/16/16.
 */
import java.io.File;
import javax.tools.*;

public class CompileChecker {

    public boolean Compile(String[] fileNames) {
        JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
        DiagnosticCollector<JavaFileObject> diagnostics = new DiagnosticCollector<JavaFileObject>();
        StandardJavaFileManager fileManager = compiler.getStandardFileManager(diagnostics, null, null);
        Iterable<? extends JavaFileObject> compilationUnits = fileManager.getJavaFileObjectsFromStrings(java.util.Arrays.asList(fileNames));
        JavaCompiler.CompilationTask task = compiler.getTask(null, fileManager, diagnostics, null,
                null, compilationUnits);
        return task.call();
    }

    public boolean EnsureFileIsJava(File file) {
        return (file.getName().equals("sampleFilePath.java"));
    }
}
