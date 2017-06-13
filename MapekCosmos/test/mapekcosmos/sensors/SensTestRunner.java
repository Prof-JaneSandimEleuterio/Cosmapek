package mapekcosmos.sensors;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

/**
 * Created by ArchyWin on 6/9/2015.
 */
public class SensTestRunner {
    public static void main(String[] args) {
        Class<?>[] cls = {SensorsTest.class};
        Result result = JUnitCore.runClasses(cls);
        for (Failure failure : result.getFailures()) {
            System.out.println(failure.toString());
        }
        System.out.println("Results :");
        System.out.println(result.wasSuccessful());
    }
}
