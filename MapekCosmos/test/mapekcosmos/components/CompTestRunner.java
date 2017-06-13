package mapekcosmos.components;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

/**
 * Created by ArchyWin on 6/9/2015.
 */
public class CompTestRunner {
    public static void main(String[] args) {
        Class<?>[] cls1 = {ComponentsTest.class};
        Result result = JUnitCore.runClasses(cls1);
        for (Failure failure : result.getFailures()) {
            System.out.println(failure.toString());
        }
        System.out.println("Results :");
        System.out.println(result.wasSuccessful());
    }
}
