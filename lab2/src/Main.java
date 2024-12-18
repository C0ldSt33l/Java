public class Main {
    public static void main(String[] args) {
        var t = new TestClass(10);
        var tester = new TestRunner(t);
        tester.runTests();
    }
}