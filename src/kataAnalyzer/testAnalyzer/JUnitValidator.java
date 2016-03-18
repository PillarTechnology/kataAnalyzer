package kataAnalyzer.testAnalyzer;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


public class JUnitValidator implements ITestFileValidator {

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
                    hasTestImport = true;
                }
                if(line.contains("@Test")){
                    hasTestAnnotation = true;
                }
                if(line.contains("org.junit.Assert.")){
                    hasAssertImport = true;
                }
                if(line.trim().startsWith("assert")){
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
