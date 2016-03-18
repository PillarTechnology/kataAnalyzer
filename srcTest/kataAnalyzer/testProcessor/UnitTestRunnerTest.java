package kataAnalyzer.testProcessor;

import org.junit.*;
import org.junit.Test;

/**
 * Created by jwinters on 3/17/16.
 */
public class UnitTestRunnerTest {

    @Test
    public void itRunsTestsAndReturnsAStringOfResults() {
        UnitTestRunner testRunner = new UnitTestRunner();

        Assert.assertTrue(testRunner.runTests("SuccessTests", "../../out/test/kataAnalyzer") instanceof String);
    }
}
