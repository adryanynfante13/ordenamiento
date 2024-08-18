import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SortingApp extends JFrame {

    private JTextField inputField;
    private JTextArea outputArea;
    private JComboBox<String> algorithmSelection;
    private JButton sortButton;

    public SortingApp() {
        setTitle("Algoritmos de clasificación");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Panel superior para la entrada de datos y selección de algoritmos
        JPanel topPanel = new JPanel(new GridLayout(2, 1));
        inputField = new JTextField();
        algorithmSelection = new JComboBox<>(new String[]{"Bubble Sort", "Insertion Sort", "Quick Sort"});
        sortButton = new JButton("Ordenar");

        topPanel.add(new JLabel("Introduce los elementos de la matriz (separados por comas):"));
        topPanel.add(inputField);
        topPanel.add(new JLabel("Seleccione el algoritmo de clasificación:"));
        topPanel.add(algorithmSelection);
        topPanel.add(sortButton);

        add(topPanel, BorderLayout.NORTH);

        // Área de salida para mostrar el paso a paso
        outputArea = new JTextArea();
        outputArea.setEditable(false);
        add(new JScrollPane(outputArea), BorderLayout.CENTER);

        sortButton.addActionListener(new SortButtonListener());

        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(SortingApp::new);
    }

    private class SortButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String inputText = inputField.getText();
            String[] inputStrings = inputText.split(",");
            int[] array = new int[inputStrings.length];

            try {
                for (int i = 0; i < inputStrings.length; i++) {
                    array[i] = Integer.parseInt(inputStrings[i].trim());
                }
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(SortingApp.this, "Entrada no válida. Por favor ingrese números enteros separados por comas.");
                return;
            }

            String selectedAlgorithm = (String) algorithmSelection.getSelectedItem();
            outputArea.setText("");  // Limpiar el área de salida

            switch (selectedAlgorithm) {
                case "Bubble Sort":
                    BubbleSort.sort(array, outputArea);
                    break;
                case "Insertion Sort":
                    InsertionSort.sort(array, outputArea);
                    break;
                case "Quick Sort":
                    QuickSort.sort(array, 0, array.length - 1, outputArea);
                    break;
            }

            outputArea.append("Matriz ordenada: " + java.util.Arrays.toString(array));
        }
    }
}
