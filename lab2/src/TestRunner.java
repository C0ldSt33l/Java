import java.lang.reflect.Method;
import java.util.Objects;

public class TestRunner {
    private Object obj;

    public TestRunner(Object obj) {
        this.obj = obj;
    }

    public void runTests() {
        try {
            this.check();
            var c = this.obj.getClass();
            System.out.println("Start tests for class: " + c.getSimpleName());
            for (var method : c.getDeclaredMethods()) {
                this.runMethodTest(method, this.obj);
            }
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private void runMethodTest(Method m, Object obj) throws Exception {
        if (!m.isAnnotationPresent(MeasureExecutionTime.class)) return;

        float totalTime = 0;
        var times = ((MeasureExecutionTime)m.getAnnotation(MeasureExecutionTime.class)).testCount();
        System.out.println("Method: " + m.getName());
        for (var i = 0; i < times; i++) {
            var start = System.nanoTime();
            m.invoke(obj);
            var end = System.nanoTime();
            var res =  (end - start) / 1000000.0f;
            System.out.println("Test. " + (i + 1) + " " + res + " ms");
            totalTime += res;
        }
        System.out.println("Avg time: " + (totalTime / times) + " ms");
    }

    private void check() throws Exception {
        if (Objects.isNull(this.obj)) throw new Exception("The object to run tests is null");
    }
}
