import java.util.Arrays;
import java.util.Random;

public class ArrayUtils {

    // Метод для сортування злиттям
    public static void mergeSort(int[] array) {
        if (array.length < 2) {
            return;
        }
        int mid = array.length / 2;
        int[] left = Arrays.copyOfRange(array, 0, mid);
        int[] right = Arrays.copyOfRange(array, mid, array.length);

        mergeSort(left);
        mergeSort(right);

        merge(array, left, right);
    }

    private static void merge(int[] array, int[] left, int[] right) {
        int i = 0, j = 0, k = 0;
        while (i < left.length && j < right.length) {
            if (left[i] <= right[j]) {
                array[k++] = left[i++];
            } else {
                array[k++] = right[j++];
            }
        }
        while (i < left.length) {
            array[k++] = left[i++];
        }
        while (j < right.length) {
            array[k++] = right[j++];
        }
    }

    // Метод для бінарного пошуку
    public static int binarySearch(int[] array, int target) {
        int left = 0, right = array.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (array[mid] == target) {
                return mid; // Повертаємо індекс знайденого елемента
            } else if (array[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1; // Якщо елемент не знайдено
    }

    // Демонстрація роботи алгоритмів
    public static void main(String[] args) {
        // Створення масиву та його заповнення випадковими числами
        int size = 20; // Розмір масиву
        int[] array = new int[size];
        Random random = new Random();
        for (int i = 0; i < size; i++) {
            array[i] = random.nextInt(100); // Заповнюємо числами від 0 до 99
        }

        System.out.println("Початковий масив:");
        System.out.println(Arrays.toString(array));

        // Сортування злиттям
        mergeSort(array);
        System.out.println("Відсортований масив:");
        System.out.println(Arrays.toString(array));

        // Бінарний пошук
        int target = random.nextInt(100); // Випадкове число для пошуку
        System.out.println("Цільове значення для пошуку: " + target);
        int index = binarySearch(array, target);

        if (index != -1) {
            System.out.println("Елемент знайдено на індексі: " + index);
        } else {
            System.out.println("Елемент не знайдено у масиві.");
        }
    }
}
