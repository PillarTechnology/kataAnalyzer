package kataAnalyzer.testProcessor;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * Created by jwinters on 3/17/16.
 */
public class UnitTestRunner {
    public String runTests(String filename) {
        Runtime runtime = Runtime.getRuntime();

        try {
            String command = "java -cp /Library/JUNIT/junit-4.12.jar:/Library/JUNIT/hamcrest-core-1.3.jar:./out/test/kataAnalyzer org.junit.runner.JUnitCore " + filename;
            Process process = runtime.exec(command);
            process.waitFor();

            String out = consumeInputStream(process.getInputStream());
            if ( out.equals("") ) {
                out = consumeInputStream(process.getErrorStream());
            }

            return out;
        }
        catch(IOException ioe){
            return ioe.getMessage();
        }
        catch (InterruptedException ie) {
            return ie.getMessage();
        }
    }

    public String consumeInputStream(InputStream in) {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(in));
            StringBuilder out = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                out.append(line);
            }
            return out.toString();
        }
        catch(IOException ioe){
            return ioe.getMessage();
        }
    }
}
