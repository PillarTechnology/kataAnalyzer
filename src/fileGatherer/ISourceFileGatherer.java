package fileGatherer;

import java.io.File;
import java.nio.file.Path;
import java.util.List;
import java.util.HashMap;

public interface ISourceFileGatherer {

    HashMap<SourceType, List<File>> Gather(Path sourcePath);

}
