package fileGatherer;

import java.io.File;

import org.junit.Before;
import org.junit.Test;
import testUtils.TestConstants;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;


public class JUnitValidatorTests {

    private JUnitValidator junitValidator;

    @Before
    public void setup(){
        junitValidator = new JUnitValidator();
    }

    @Test
    public void shouldIndicateFileIsValidWhenProperImportsAreWithinTheTestFile() throws Exception {
        final File fileUnderTest = new File(TestConstants.TEST_FILE_DIR, "JavaTestThatIsProperlyWritten.java");

        boolean isFileValid = junitValidator.validateFile(fileUnderTest);
        assertTrue(isFileValid);
    }

    @Test
    public void returnsFalseWhenThereAreNoTestAnnotations(){
        final File fileUnderTest = new File(TestConstants.TEST_FILE_DIR, "JavaTestWithAsserts.java");

        boolean isFileValid = junitValidator.validateFile(fileUnderTest);
        assertFalse(isFileValid);
    }

    @Test
    public void shouldNotIndicateFileIsValidWhenProperImportsDoNotExist() throws Exception {
        final File fileUnderTest = new File(TestConstants.TEST_FILE_DIR, "NotAJavaTestClass.java");

        boolean isFileValid = junitValidator.validateFile(fileUnderTest);
        assertFalse(isFileValid);
    }

    @Test
    public void shouldNotIndicateFileIsValidWhenFileDoesNotExist() throws Exception {
        final File fileUnderTest = new File("");

        boolean isFileValid = junitValidator.validateFile(fileUnderTest);
        assertFalse(isFileValid);
    }


}
