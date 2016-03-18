package kataAnalyzer.testAnalyzer;

import java.io.File;
import java.util.HashMap;
import java.util.List;


public interface ISourceSorter {

    HashMap<SourceType, List<File>> sortIntoSourceTypes(List<File> files);

}
