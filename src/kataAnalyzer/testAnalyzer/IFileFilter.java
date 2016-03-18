package kataAnalyzer.testAnalyzer;


import java.io.File;
import java.util.List;

public interface IFileFilter {

    List<File> filterFiles(List<File> fileList);

}
