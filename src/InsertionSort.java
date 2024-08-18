import javax.swing.*;

public class InsertionSort {
    public static int[] sort(int[] array, JTextArea outputArea) {
        int n = array.length;
        for (int i = 1; i < n; i++) {
            int key = array[i];
            int j = i - 1;
            while (j >= 0 && array[j] > key) {
                array[j + 1] = array[j];
                j--;
            }
            array[j + 1] = key;
            outputArea.append("Paso " + i + ": " + java.util.Arrays.toString(array) + "\n");
        }
        return array;
    }
}
