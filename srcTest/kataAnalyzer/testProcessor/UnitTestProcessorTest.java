package kataAnalyzer.testProcessor;

import org.junit.Before;
import org.junit.Test;
import java.util.List;
import java.util.ArrayList;
import org.junit.Assert;

/**
 * Created by jwinters on 3/17/16.
 */
public class UnitTestProcessorTest {

    UnitTestProcessor testProcessor;
    List<String> testFiles;
    final String testClassPath = "../../out/test/kataAnalyzer";

    @Before
    public void getUnitTestProcessor() {
        testProcessor = new UnitTestProcessor();
    }
    @Before
    public void getTestFilesList() {
        testFiles = new ArrayList<String>();
    }

    @Test
    public void itReturnsFalseWhenNoTestFilesArePassed() {
        Assert.assertFalse( testProcessor.process(testFiles, testClassPath) );
    }

    @Test
    public void itReturnsTrueWhenAllTestFilesPass() {
        testFiles.add("SuccessTests");
        testFiles.add("SuccessTests");

        Assert.assertTrue( testProcessor.process(testFiles, testClassPath) );

    }

    @Test
    public void itReturnsFalseWhenAnyTestFileFails() {
        testFiles.add("FailureTest");
        testFiles.add("SuccessTest");

        Assert.assertFalse( testProcessor.process(testFiles, testClassPath) );
    }
}
