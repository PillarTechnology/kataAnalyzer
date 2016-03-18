package kataAnalyzer.sourceCompiler; /**
 * Created by stevenroderick on 3/16/16.
 */
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CompileChecker {

    public boolean ensureFileIsJava(File file) {
        return (file.getName().contains(".java"));
    }

    public boolean createClassFiles(String[] commands) {
        String writtenCommands = "";
        for(int i = 0; i < commands.length; i++) {
            writtenCommands += commands[i];
            if(i < commands.length)
                writtenCommands += " ";
        }
        try {
            File runtimeDir = new File(System.getProperty("user.dir") + "/RuntimeCompile");
            boolean newDir = runtimeDir.mkdir();
            Process proc =  Runtime.getRuntime().exec("javac -d " + runtimeDir.getAbsolutePath() + " " + writtenCommands);
            int exitVal = proc.waitFor();
            if(exitVal == 0) {
                return true;
            }
            else
                return false;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        } catch (InterruptedException e) {
            e.printStackTrace();
            return false;
        }
    }

    public List<String> getClassFiles() {
        List<String> classes = new ArrayList<>();
        File runtimeDir = new File(System.getProperty("user.dir") + "/RuntimeCompile");
        String directory = runtimeDir.getAbsolutePath();
        ArrayList<File> listOfFiles = new ArrayList<>();
        searchFoldersRecursively(directory, listOfFiles);
        for(int i = 0; i < listOfFiles.size(); i++) {
            if(listOfFiles.get(i).getName().endsWith(".class"))
                classes.add(listOfFiles.get(i).getPath());
        }
        return classes;
    }

    private void searchFoldersRecursively(String directoryName, ArrayList<File> files) {
        File directory = new File(directoryName);
        File[] newFoundFiles = directory.listFiles();
        for(int i = 0; i < newFoundFiles.length; i++) {
            if(newFoundFiles[i].isFile())
                files.add(newFoundFiles[i]);
            else if (newFoundFiles[i].isDirectory())
                searchFoldersRecursively(newFoundFiles[i].getAbsolutePath(), files);
        }
    }

    public boolean createJARFile(List<String> classFiles) {
        String writtenCommands = "";
        for(int i = 0; i < classFiles.size(); i++) {
            writtenCommands += classFiles.get(i);
            if(i < classFiles.size())
                writtenCommands += " ";
        }
        try {
            Process proc = Runtime.getRuntime().exec("jar cf main.jar " + writtenCommands);
            int exitVal = proc.waitFor();
            if(exitVal == 0)
                return true;
            else
                return false;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        } catch (InterruptedException e) {
            e.printStackTrace();
            return false;
        }
    }
}
