package kataAnalyzer.testAnalyzer;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class JavaSourceSorter implements ISourceSorter {

    private final ITestFileValidator jUnitValidator;

    public JavaSourceSorter(ITestFileValidator jUnitValidator) {
        this.jUnitValidator = jUnitValidator;
    }

    public HashMap<SourceType, List<File>> sortIntoSourceTypes(List<File> files){
        HashMap<SourceType, List<File>> sortedSource = new HashMap<>();
        ArrayList<File> testCodeFiles = new ArrayList<>();
        ArrayList<File> notTestCodeFiles = new ArrayList<>();

        for (File file: files)
        {
            if (this.jUnitValidator.validateFile(file)) {
                testCodeFiles.add(file);
            }
            else {
                notTestCodeFiles.add(file);
            }
        }

        sortedSource.put(SourceType.TEST_CODE, testCodeFiles);
        sortedSource.put(SourceType.NOT_TEST_CODE, notTestCodeFiles);
        return sortedSource;
    }
}
