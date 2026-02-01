package practice;

public class Dynamic {

    public static class Factorial {
        public int factorialFunc(int data) {
            if (data <= 1) {
                return data;
            }

            return this.factorialFunc(data - 1) + this.factorialFunc(data - 2);
        }
    }


    // 동적계획법 활용
    public int dynamicFunc(int data) {
        Integer[] cache = new Integer[data + 1];
        cache[0] = 0;
        cache[1] = 1;

        for (int index = 2; index < data + 1; index++) {
            cache[index] = cache[index - 1] + cache[index - 2];
        }
        return cache[data];
    }

    public static void main(String[] args) {
//        Factorial factorial = new Factorial();
//        int i = factorial.factorialFunc(10);
//        System.out.println("i = " + i);

        Dynamic dynamic = new Dynamic();
        int i = dynamic.dynamicFunc(10);
        System.out.println("i = " + i);
    }
}
