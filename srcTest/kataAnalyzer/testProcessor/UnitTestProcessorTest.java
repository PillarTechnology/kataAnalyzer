package kataAnalyzer.testProcessor;

import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.util.List;
import java.util.ArrayList;
import org.junit.Assert;

/**
 * Created by jwinters on 3/17/16.
 */
public class UnitTestProcessorTest {

    UnitTestProcessor testProcessor;
    List<File> testFiles;
    final String testClassPath = "../../out/test/kataAnalyzer";
    File successFile = new File(testClassPath + "/SuccessTests.class");
    File failFile = new File(testClassPath + "/FailureTests.class");

    @Before
    public void getUnitTestProcessor() {
        testProcessor = new UnitTestProcessor();
    }
    @Before
    public void getTestFilesList() {
        testFiles = new ArrayList<>();
    }

    @Test
    public void itReturnsFalseWhenNoTestFilesArePassed() {
        Assert.assertFalse( testProcessor.process(testFiles, testClassPath) );
    }

    @Test
    public void itReturnsTrueWhenAllTestFilesPass() {
        testFiles.add(successFile);
        testFiles.add(successFile);

        Assert.assertTrue( testProcessor.process(testFiles, testClassPath) );

    }

    @Test
    public void itReturnsFalseWhenAnyTestFileFails() {
        testFiles.add(failFile);
        testFiles.add(successFile);

        Assert.assertFalse( testProcessor.process(testFiles, testClassPath) );
    }
}
