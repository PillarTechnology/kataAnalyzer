package kataAnalyzer.testAnalyzer;

import java.io.File;
import java.util.HashMap;

public class MockTestFileValidator implements ITestFileValidator {

    private HashMap<File, Boolean> mapOfFilesToIsValidFile;

    public MockTestFileValidator(){
        mapOfFilesToIsValidFile = new HashMap<>();
    }

    @Override
    public boolean validateFile(File file) {
        return mapOfFilesToIsValidFile.get(file);
    }

    public void setValueToReturnFromValidate(File file, boolean isValid){
        mapOfFilesToIsValidFile.put(file, isValid);
    }
}
