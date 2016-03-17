package fileGatherer;

import org.junit.Test;
import static org.junit.Assert.assertEquals;
import testUtils.TestHelper;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
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
