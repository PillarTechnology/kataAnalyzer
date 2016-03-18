package kataAnalyzer.testAnalyzer;

import org.junit.Test;
import static org.junit.Assert.assertEquals;
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

        HashMap<SourceType, List<File>> sourceFiles = sourceFileGatherer.Gather(TestHelper.TEST_FILE_DIR);

        assertEquals(TestHelper.getAllTestJavaFilesFromTestDirectory(), sourceFiles.get(SourceType.TEST_CODE));
    }
}
