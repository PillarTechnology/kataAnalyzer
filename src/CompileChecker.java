/**
 * Created by stevenroderick on 3/16/16.
 */
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.tools.*;

public class CompileChecker {


    public boolean EnsureFileIsJava(File file) {
        return (file.getName().contains(".java"));
    }

    public boolean CreateClassFiles(String[] commands) {
        String writtenCommands = "";
        for(int i = 0; i < commands.length; i++) {
            writtenCommands += commands[i];
            if(i < commands.length)
                writtenCommands += " ";
        }
        System.out.println(writtenCommands);
        try {
            Process proc =  Runtime.getRuntime().exec("javac " + writtenCommands);
            int exitVal = proc.waitFor();
            System.out.println("Exit Val: " + exitVal);
            if(exitVal == 0) {
                return CreateJARFile(GetClassFiles());
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

    private List<String> GetClassFiles() {
        List<String> classes = new ArrayList<>();
        String directory = System.getProperty("user.dir");
        ArrayList<File> listOfFiles = new ArrayList<>();
        SearchFoldersRecursively(directory, listOfFiles);
        for(int i = 0; i < listOfFiles.size(); i++) {
            if(listOfFiles.get(i).getName().contains(".class"))
                classes.add(listOfFiles.get(i).getPath());
        }
        return classes;
    }

    private void SearchFoldersRecursively(String directoryName, ArrayList<File> files) {
        File directory = new File(directoryName);
        File[] newFoundFiles = directory.listFiles();
        for(int i = 0; i < newFoundFiles.length; i++) {
            if(newFoundFiles[i].isFile())
                files.add(newFoundFiles[i]);
            else if (newFoundFiles[i].isDirectory())
                SearchFoldersRecursively(newFoundFiles[i].getAbsolutePath(), files);
        }
    }

    private boolean CreateJARFile(List<String> classFiles) {
        String writtenCommands = "";
        for(int i = 0; i < classFiles.size(); i++) {
            writtenCommands += classFiles.get(i);
            if(i < classFiles.size())
                writtenCommands += " ";
        }
        System.out.println(writtenCommands);
        try {
            Process proc = Runtime.getRuntime().exec("jar cf main.jar " + writtenCommands);
            int exitVal = proc.waitFor();
            System.out.println("Exit Val: " + exitVal);
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
