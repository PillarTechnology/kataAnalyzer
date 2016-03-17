/**
 * Created by jwinters on 3/16/16.
 */

import org.junit.Before;
import org.junit.Test;
import org.junit.Assert;

public class UnitTestAnalyzerTest {

    UnitTestAnalyzer testAnalyzer;

    private final String SUCCESS_STRING = "JUnit version 4.12\n" +
            "..\n" +
            "Time: 0.002\n" +
            "\n" +
            "OK (2 tests)";

    private final String FAILURE_STRING = "JUnit version 4.12\n" +
            ".E\n" +
            "Time: 0.011\n" +
            "There was 1 failure:\n" +
            "1) intentionallyFailingTest(FailureTests)\n" +
            "java.lang.AssertionError\n" +
            "\tat org.junit.Assert.fail(Assert.java:86)\n" +
            "\tat org.junit.Assert.assertTrue(Assert.java:41)\n" +
            "\tat org.junit.Assert.assertTrue(Assert.java:52)\n" +
            "\tat FailureTests.intentionallyFailingTest(FailureTests.java:11)\n" +
            "\tat sun.reflect.NativeMethodAccessorImpl.invoke0(Native Method)\n" +
            "\tat sun.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:62)\n" +
            "\tat sun.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)\n" +
            "\tat java.lang.reflect.Method.invoke(Method.java:497)\n" +
            "\tat org.junit.runners.model.FrameworkMethod$1.runReflectiveCall(FrameworkMethod.java:50)\n" +
            "\tat org.junit.internal.runners.model.ReflectiveCallable.run(ReflectiveCallable.java:12)\n" +
            "\tat org.junit.runners.model.FrameworkMethod.invokeExplosively(FrameworkMethod.java:47)\n" +
            "\tat org.junit.internal.runners.statements.InvokeMethod.evaluate(InvokeMethod.java:17)\n" +
            "\tat org.junit.runners.ParentRunner.runLeaf(ParentRunner.java:325)\n" +
            "\tat org.junit.runners.BlockJUnit4ClassRunner.runChild(BlockJUnit4ClassRunner.java:78)\n" +
            "\tat org.junit.runners.BlockJUnit4ClassRunner.runChild(BlockJUnit4ClassRunner.java:57)\n" +
            "\tat org.junit.runners.ParentRunner$3.run(ParentRunner.java:290)\n" +
            "\tat org.junit.runners.ParentRunner$1.schedule(ParentRunner.java:71)\n" +
            "\tat org.junit.runners.ParentRunner.runChildren(ParentRunner.java:288)\n" +
            "\tat org.junit.runners.ParentRunner.access$000(ParentRunner.java:58)\n" +
            "\tat org.junit.runners.ParentRunner$2.evaluate(ParentRunner.java:268)\n" +
            "\tat org.junit.runners.ParentRunner.run(ParentRunner.java:363)\n" +
            "\tat org.junit.runners.Suite.runChild(Suite.java:128)\n" +
            "\tat org.junit.runners.Suite.runChild(Suite.java:27)\n" +
            "\tat org.junit.runners.ParentRunner$3.run(ParentRunner.java:290)\n" +
            "\tat org.junit.runners.ParentRunner$1.schedule(ParentRunner.java:71)\n" +
            "\tat org.junit.runners.ParentRunner.runChildren(ParentRunner.java:288)\n" +
            "\tat org.junit.runners.ParentRunner.access$000(ParentRunner.java:58)\n" +
            "\tat org.junit.runners.ParentRunner$2.evaluate(ParentRunner.java:268)\n" +
            "\tat org.junit.runners.ParentRunner.run(ParentRunner.java:363)\n" +
            "\tat org.junit.runner.JUnitCore.run(JUnitCore.java:137)\n" +
            "\tat org.junit.runner.JUnitCore.run(JUnitCore.java:115)\n" +
            "\tat org.junit.runner.JUnitCore.runMain(JUnitCore.java:77)\n" +
            "\tat org.junit.runner.JUnitCore.main(JUnitCore.java:36)\n" +
            "\n" +
            "FAILURES!!!\n" +
            "Tests run: 1,  Failures: 1\n";

    private final String UNKNOWN_STRING = "Something terrible happened";

    @Before
    public void createUnitTestAnalyzer() {
        testAnalyzer = new UnitTestAnalyzer();
    }

    @Test
    public void itReturnsSuccessWhenAllTestsPass() {
        Assert.assertEquals( "Success", testAnalyzer.analyzeResults(SUCCESS_STRING) );
    }

    @Test
    public void itReturnsFailureWhenAtLeastOneTestFails() {
        Assert.assertEquals( "Failure", testAnalyzer.analyzeResults(FAILURE_STRING) );
    }

    @Test
    public void itReturnsFailureWhenTestsDoNotRun() {
        Assert.assertEquals( "Failure", testAnalyzer.analyzeResults(UNKNOWN_STRING) );
    }
}
