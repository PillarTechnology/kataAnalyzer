package kataAnalyzer.testAnalyzer;

import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import kataAnalyzer.testUtils.TestHelper;

import java.io.File;
import java.util.List;
import java.util.HashMap;

public class SourceFileGathererTest {

    @Test
    public void shouldGatherAndSortSourceFilesWithinADirectory() {
        JavaFileFilter filter = new JavaFileFilter();
        JavaSourceSorter sorter = new JavaSourceSorter(new JUnitValidator());
        SourceFileGatherer sourceFileGatherer = new SourceFileGatherer(filter, sorter);

        HashMap<SourceType, List<File>> sourceFiles = sourceFileGatherer.gather(TestHelper.TEST_FILE_DIR);

        assertEquals(TestHelper.getAllTestJavaFilesFromTestDirectory(), sourceFiles.get(SourceType.TEST_CODE));
    }

    @Test
    public void shouldGatherAndSortSourceFilesWithinADirectoryAndReturnTrue() {
        JavaFileFilter filter = new JavaFileFilter();
        JavaSourceSorter sorter = new JavaSourceSorter(new JUnitValidator());
        SourceFileGatherer sourceFileGatherer = new SourceFileGatherer(filter, sorter);

        assertTrue(sourceFileGatherer.areAnyTestsAvailableAfterGathering(TestHelper.TEST_FILE_DIR));
    }

}
