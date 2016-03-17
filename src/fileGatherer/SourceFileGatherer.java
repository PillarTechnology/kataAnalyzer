package fileGatherer;


import java.io.File;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class SourceFileGatherer implements ISourceFileGatherer {

    private final IFileFilter _fileFilter;
    private final ISourceSorter _sourceSorter;

    public SourceFileGatherer(
            IFileFilter fileFilter,
            ISourceSorter sourceSorter) {
        this._fileFilter = fileFilter;
        this._sourceSorter = sourceSorter;
    }

    public HashMap<SourceType, List<File>> Gather(String sourcePath) {
        File sourceDirectory = new File(sourcePath);
        List<File> sortableFiles = this._fileFilter.filterFiles(Arrays.asList(sourceDirectory.listFiles()));
        return this._sourceSorter.sortIntoSourceTypes(sortableFiles);
    }

}
