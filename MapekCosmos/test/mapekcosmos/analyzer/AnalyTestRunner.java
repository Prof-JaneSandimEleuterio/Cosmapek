package mapekcosmos.analyzer;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

/**
 * Created by ArchyWin on 6/9/2015.
 */
public class AnalyTestRunner {

    public static void main(String[] args) {
        Class<?>[] cls = {AnalyzerTest.class};
        Result result = JUnitCore.runClasses(cls);
        for (Failure failure : result.getFailures()) {
            System.out.println(failure.toString());
        }
        System.out.println(result.wasSuccessful());
    }
}
