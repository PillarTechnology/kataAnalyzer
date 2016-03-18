package kataAnalyzer.testProcessor;

import java.util.List;

/**
 * Created by jwinters on 3/17/16.
 */
public class UnitTestProcessor {

    UnitTestRunner testRunner = new UnitTestRunner();
    UnitTestResultsAnalyzer testResultsAnalyzer = new UnitTestResultsAnalyzer();

    public String process(List<String> testFiles, String path) {

        String analyzedResults = "Success";

        if ( testFiles.size() == 0 ) {
            analyzedResults = "Failure";
        }

        for (int i = 0; i < testFiles.size(); i++) {
            if ( testResultsAnalyzer.analyzeResults(testRunner.runTests(testFiles.get(i), path)).equals("Failure") ) {
                analyzedResults = "Failure";
            }
        }

        return analyzedResults;
    }
}
