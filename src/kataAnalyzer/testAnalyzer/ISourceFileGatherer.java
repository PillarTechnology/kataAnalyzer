package kataAnalyzer.testAnalyzer;

import java.io.File;
import java.util.List;
import java.util.HashMap;

public interface ISourceFileGatherer {

    HashMap<SourceType, List<File>> Gather(String sourcePath);

}
