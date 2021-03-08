public class Demo {
    public static int max(int a, int b) {
        return a > b ? a : b;
    }

    public static int max(int... values){
        var max = values[0];
        for (int val:values) {
            if(val > max){
                max = val;
            }
        }

        return max;
    }
}
