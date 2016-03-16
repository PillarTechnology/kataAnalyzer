package fileGatherer;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


public class JUnitValidator implements ITestFileVaidator {

    public boolean validateFile(File file)
    {
        boolean hasTestImport = false;
        boolean hasTestAnnotation = false;
        boolean hasAssertImport = false;
        boolean hasAssertStatements = false;
        try {
            Scanner scan = new Scanner(file);
            while(scan.hasNextLine()){
                String line = scan.nextLine();
                if(line.contains("org.junit.Test;")){
                    System.out.println(line);
                    hasTestImport = true;
                }
                if(line.contains("@Test")){
                    System.out.println(line);
                    hasTestAnnotation = true;
                }
                if(line.contains("org.junit.Assert.")){
                    System.out.println(line);
                    hasAssertImport = true;
                }
                if(line.contains("assert")){
                    System.out.println(line);
                    hasAssertStatements = true;
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("Exception caught! " + e.getMessage());
            return false;
        }
        return hasTestImport && hasTestAnnotation && hasAssertImport && hasAssertStatements;
    }
}
