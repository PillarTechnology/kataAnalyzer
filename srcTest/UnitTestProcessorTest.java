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

    @Before
    public void getUnitTestProcessor() {
        testProcessor = new UnitTestProcessor();
    }
    @Before
    public void getTestFilesList() {
        testFiles = new ArrayList<String>();
    }

    @Test
    public void itReturnsFailureWhenNoTestFilesArePassed() {
        Assert.assertEquals( "Failure", testProcessor.process(testFiles) );
    }

    @Test
    public void itReturnsSuccessWhenAllTestFilesPass() {
        testFiles.add("SuccessTests");
        testFiles.add("SuccessTests");

        Assert.assertEquals( "Success", testProcessor.process(testFiles) );

    }

    @Test
    public void itReturnsFailureWhenAnyTestFileFails() {
        testFiles.add("FailureTest");
        testFiles.add("SuccessTest");

        Assert.assertEquals( "Failure", testProcessor.process(testFiles) );
    }
}
