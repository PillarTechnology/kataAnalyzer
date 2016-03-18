package kataAnalyzer.testAnalyzer;


import java.io.File;
import java.util.ArrayList;
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

    public HashMap<SourceType, List<File>> gather(String sourcePath) {
        ArrayList<File> allFiles = new ArrayList<>();
        searchFoldersRecursively(sourcePath, allFiles);
        List<File> sortableFiles = this._fileFilter.filterFiles(allFiles);
        return this._sourceSorter.sortIntoSourceTypes(sortableFiles);
    }

    public boolean areAnyTestsAvailableAfterGathering(String sourcePath) {
        return (gather(sourcePath).get(SourceType.TEST_CODE).size() > 0);
    }

    private static void searchFoldersRecursively(String directoryName, ArrayList<File> files) {
        File directory = new File(directoryName);
        File[] newFoundFiles = directory.listFiles();
        for(int i = 0; i < newFoundFiles.length; i++) {
            if(newFoundFiles[i].isFile())
                files.add(newFoundFiles[i]);
            else if (newFoundFiles[i].isDirectory())
                searchFoldersRecursively(newFoundFiles[i].getPath(), files);
        }
    }
}
