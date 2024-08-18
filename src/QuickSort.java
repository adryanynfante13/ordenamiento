import javax.swing.*;

public class QuickSort {
    public static void sort(int[] array, int low, int high, JTextArea outputArea) {
        if (low < high) {
            int pi = partition(array, low, high, outputArea);
            sort(array, low, pi - 1, outputArea);
            sort(array, pi + 1, high, outputArea);
        }
    }

    private static int partition(int[] array, int low, int high, JTextArea outputArea) {
        int pivot = array[high];
        int i = (low - 1);
        for (int j = low; j < high; j++) {
            if (array[j] < pivot) {
                i++;
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }
        }
        int temp = array[i + 1];
        array[i + 1] = array[high];
        array[high] = temp;
        outputArea.append("Dividir: " + java.util.Arrays.toString(array) + "\n");
        return i + 1;
    }
}
