package kataAnalyzer.testProcessor;

import org.apache.commons.io.FilenameUtils;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by jwinters on 3/17/16.
 */
public class UnitTestProcessor {

    UnitTestRunner testRunner = new UnitTestRunner();
    UnitTestResultsAnalyzer testResultsAnalyzer = new UnitTestResultsAnalyzer();

    public boolean process(List<File> fileList, String path) {
        List<String> testFiles = new ArrayList<>();

        for ( int i = 0; i < fileList.size(); i++) {
            testFiles.add(FilenameUtils.removeExtension(fileList.get(i).getName()));
        }

        boolean unitTestsPassed = true;

        if ( testFiles.size() == 0 ) {
            unitTestsPassed = false;
        }

        for (int i = 0; i < testFiles.size(); i++) {
            if ( testResultsAnalyzer.analyzeResults(testRunner.runTests(testFiles.get(i), path)).equals("Failure") ) {
                unitTestsPassed = false;
            }
        }

        return unitTestsPassed;
    }
}
