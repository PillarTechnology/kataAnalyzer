package fileGatherer;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class JavaFileFilter {

    public List<File> filterJavaFiles(List<File> fileList) {
        return fileList.
                stream().
                filter(file -> file.getName().endsWith(".java")).
                collect(Collectors.toCollection(ArrayList::new));
    }

}
