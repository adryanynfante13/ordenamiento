import javax.swing.*;

public class BubbleSort {
    public static int[] sort(int[] array, JTextArea outputArea) {
        int n = array.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
                outputArea.append("Paso " + (i * n + j) + ": " + java.util.Arrays.toString(array) + "\n");
            }
        }
        return array;
    }
}
