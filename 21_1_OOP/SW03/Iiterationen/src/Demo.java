public class Demo {

    public static void print1To10() {
        for (var i = 0; i <= 10; i++){
            System.out.println(i);
        }

        var count = 0;
        do {
            System.out.println(count);
        } while (count++ < 10);

        count = 0;
        while (count <= 10){
            System.out.println(count);
            count++;
        }
    }

    public static void exitWhenHitting1(){
        var start = 0.9f;

        var count = 0;
        while (start < 1f){
            start += 0.000025f;
            System.out.println(count++);
        }
    }

    public static void Print4000Iterations(){
        var start = 0.9f;

        for(var i = 0; i < 4000; i++){
            start += 0.000025f;
        }

        System.out.println(start);
    }

    public static void printBox(final int height, final int width){
        var top = "";
        for(var i = 0; i < width; i++){
            top += "#";
        }

        var middle = "#";
        for(var i = 0; i < width - 2; i++){
            middle += " ";
        }
        middle += "#";

        System.out.println(top);
        for(var i = 0; i < height - 2; i++){
            System.out.println(middle);
        }
        System.out.println(top);
    }
}
