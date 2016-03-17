/**
 * Created by stevenroderick on 3/16/16.
 */
import java.io.File;
import java.io.IOException;
import javax.tools.*;

public class CompileChecker {


    public boolean EnsureFileIsJava(File file) {
        return (file.getName().contains(".java"));
    }

    public boolean JavaCCompiled(String[] commands) {
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
