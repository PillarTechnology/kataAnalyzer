package fileGatherer;

import java.io.File;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;


public class JUnitValidatorTests {

    @Test
    public void shouldIndicateFileIsValidWhenJUnitTestImportIsWithinTheTestFile() throws Exception {
        final File fileUnderTest = new File("testResources/AnActualJavaTest.java");

        JUnitValidator junitValidator = new JUnitValidator();
        boolean isFileValid = junitValidator.validateFile(fileUnderTest);
        assertTrue(isFileValid);
    }

    @Test
    public void shouldNotIndicateFileIsValidWhenFileDoesNotExist() throws Exception {
        final File fileUnderTest = new File("");

        JUnitValidator junitValidator = new JUnitValidator();
        boolean isFileValid = junitValidator.validateFile(fileUnderTest);
        assertFalse(isFileValid);
    }

    @Test
    public void shouldNotIndicateFileIsValidWhenJUnitTestImportDoesNotExist() throws Exception {
        final File fileUnderTest = new File("testResources/NotAJavaTestClass.java");

        JUnitValidator junitValidator = new JUnitValidator();
        boolean isFileValid = junitValidator.validateFile(fileUnderTest);
        assertFalse(isFileValid);
    }

}
