import java.util.Random;
import java.util.stream.IntStream;

public class task1 {
    public static void main(String[] args) {
        Random random = new Random();
        
        int[] array = IntStream.generate(() -> random.nextInt(100) + 1)
            .limit(10)
            .toArray();
        
        System.out.println("Array:");
        IntStream.of(array).forEach(element -> System.out.print(element + " "));
        System.out.println("\n");
        
        int max = IntStream.of(array)
            .max()
            .orElseThrow(() -> new RuntimeException("Array is empty"));
        
        int min = IntStream.of(array)
            .min()
            .orElseThrow(() -> new RuntimeException("Array is empty"));

        System.out.println("Biggest element: " + max);
        System.out.println("Smallest element: " + min);
    }
}