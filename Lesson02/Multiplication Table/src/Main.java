public class Main {
        public static void main(String[] args) {
            int j =0;
            while (j < 10)
            {
                for (int i = 0; i < 10; i++) {
                    System.out.printf("%4s", i * j);
                }
                System.out.print("\n");
                j++;
            }
        }
    }


