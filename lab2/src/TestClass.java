public class TestClass {
    private int n;

    public TestClass(int n) {
        this.n = n;
    }

    @MeasureExecutionTime(testCount = 5)
    public int factorial() {
        if (this.n < 0)  {
            System.out.println("Факториал отрицательного числа не существует.");
            return 0;
        }
        if (this.n == 0 || this.n == 1) return 1;
        int f = 1;
        for (var i = 2; i <= this.n; i++) {
            f *= i;
        }

        return f;
    }
}
