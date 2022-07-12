import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int length = scan.nextInt();
        int[] array = new int[length];
        for (int i = 0 , k; i < array.length; i++) {

            array[i] = scan.nextInt();
        }
        int n = scan.nextInt();
        int count=0;
        for (int i = 0 , k; i < array.length; i++) {
            if (array[i] == n){
                count++;
            }
        }
        System.out.println(count);
    }
}