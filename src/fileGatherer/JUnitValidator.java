package fileGatherer;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Scanner;


public class JUnitValidator implements ITestFileVaidator {

    public boolean validateFile(File file)
    {
        try {
            Scanner scan = new Scanner(file);
            while(scan.hasNextLine()){
                String line = scan.nextLine();
                if(line.contains("org.junit.Test;")){
                    return true;
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return false;
        }
        return false;
    }
}
