package kataAnalyzer.testProcessor;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by jwinters on 3/16/16.
 */

public class UnitTestResultsAnalyzer {

    public String analyzeResults(String unitTestResults) {

        Pattern pattern = Pattern.compile(".*OK.*\\d+\\stests?.*", Pattern.DOTALL);
        Matcher matcher = pattern.matcher(unitTestResults);

        String analysisResult = "Failure";

        if (matcher.matches()) {
            analysisResult = "Success";
        }

        return analysisResult;
    }
}
