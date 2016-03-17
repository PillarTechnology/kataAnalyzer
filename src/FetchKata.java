import java.io.*;

/**
 * Created by stevenroderick on 3/17/16.
 */
public class FetchKata {

    final String workingDir = System.getProperty("user.dir") + "/CandidateKata";

    public String cloneRepository(String url) {
        cleanup();
        Runtime runtime = Runtime.getRuntime();
        try {
            String command = "git clone " + url + " " + workingDir;
            Process process = runtime.exec(command);
            process.waitFor();
        }
        catch(IOException ioe){
            return ioe.getMessage();
        }
        catch (InterruptedException ie) {
            return ie.getMessage();
        }
        return workingDir;
    }

    public void cleanup() {
        File file = new File(workingDir);
        deleteDirectory(file);
    }

    public boolean deleteDirectory(File directory) {
        if(directory.exists()){
            File[] files = directory.listFiles();
            if(null!=files){
                for(int i=0; i<files.length; i++) {
                    if(files[i].isDirectory()) {
                        deleteDirectory(files[i]);
                    }
                    else {
                        files[i].delete();
                    }
                }
            }
        }
        return(directory.delete());
    }
}
