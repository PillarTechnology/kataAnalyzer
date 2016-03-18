package kataAnalyzer.testProcessor;

import java.util.List;

/**
 * Created by jwinters on 3/17/16.
 */
public class UnitTestProcessor {

    UnitTestRunner testRunner = new UnitTestRunner();
    UnitTestResultsAnalyzer testResultsAnalyzer = new UnitTestResultsAnalyzer();

    public boolean process(List<String> testFiles, String path) {

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
