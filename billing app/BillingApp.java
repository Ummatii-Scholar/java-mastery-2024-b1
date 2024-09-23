import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.util.HashMap;
import java.util.Map;

public class BillingApp extends JFrame {
    private JTextField productField;
    private JTextField quantityField;
    private JTextArea billArea;
    private Map<String, Double> productData = new HashMap<>(); // Stores product name and price
    private Map<String, Integer> billData = new HashMap<>(); // Stores product and quantity

    public BillingApp() {
        setTitle("Billing App");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Manually defined product data
        loadProductData();

        // Create layout
        setLayout(new BorderLayout());

        // Input panel for product and quantity
        JPanel inputPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        inputPanel.add(new JLabel("Product: "));
        productField = new JTextField(10);
        inputPanel.add(productField);

        inputPanel.add(new JLabel("Quantity: "));
        quantityField = new JTextField(5);
        inputPanel.add(quantityField);

        JButton addButton = new JButton("Add to Bill");
        inputPanel.add(addButton);

        // Bill Area to display the bill
        billArea = new JTextArea(15, 40);
        billArea.setEditable(false);
        JScrollPane billScrollPane = new JScrollPane(billArea);

        // Action buttons
        JPanel actionPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        JButton totalButton = new JButton("Show Total");
        JButton printButton = new JButton("Print Bill");
        actionPanel.add(totalButton);
        actionPanel.add(printButton);

        // Add panels to the frame
        add(inputPanel, BorderLayout.NORTH);
        add(billScrollPane, BorderLayout.CENTER);
        add(actionPanel, BorderLayout.SOUTH);

        // Action: Add product to the bill
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addToBill();
            }
        });

        // Action: Show total bill
        totalButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showTotalBill();
            }
        });

        // Action: Print the bill (to file or console)
        printButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                printBill();
            }
        });
    }

    // Load product data manually
    private void loadProductData() {
        productData.put("Apple", 10.0);
        productData.put("Banana", 5.0);
        productData.put("Orange", 7.0);
        productData.put("Mango", 12.0);
    }

    // Add selected product and quantity to the bill
    private void addToBill() {
        String productName = productField.getText().trim();
        String quantityText = quantityField.getText().trim();

        if (productName.isEmpty() || quantityText.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please enter both product name and quantity");
            return;
        }

        int quantity;
        try {
            quantity = Integer.parseInt(quantityText);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Quantity must be a number");
            return;
        }

        // Check if the product exists in the loaded product data
        if (!productData.containsKey(productName)) {
            JOptionPane.showMessageDialog(this, "Product not found");
            return;
        }

        // Add the product and quantity to the bill
        billData.put(productName, billData.getOrDefault(productName, 0) + quantity);

        // Clear input fields
        productField.setText("");
        quantityField.setText("");

        // Display updated bill
        updateBillDisplay();
    }

    // Update the bill area with the current bill data
    private void updateBillDisplay() {
        StringBuilder billDetails = new StringBuilder("Bill:\n");
        for (Map.Entry<String, Integer> entry : billData.entrySet()) {
            String product = entry.getKey();
            int quantity = entry.getValue();
            double price = productData.get(product);
            double total = price * quantity;
            billDetails.append(product)
                    .append(" | Quantity: ").append(quantity)
                    .append(" | Price: ").append(price)
                    .append(" | Total: ").append(total).append("\n");
        }
        billArea.setText(billDetails.toString());
    }

    // Show total bill in the JTextArea
    private void showTotalBill() {
        double grandTotal = 0;
        StringBuilder billDetails = new StringBuilder("Bill Summary:\n\n");
        for (Map.Entry<String, Integer> entry : billData.entrySet()) {
            String product = entry.getKey();
            int quantity = entry.getValue();
            double price = productData.get(product);
            double total = price * quantity;
            billDetails.append(product)
                    .append(" | Quantity: ").append(quantity)
                    .append(" | Price: ").append(price)
                    .append(" | Total: ").append(total).append("\n");
            grandTotal += total;
        }
        billDetails.append("\nGrand Total: ").append(grandTotal);
        billArea.setText(billDetails.toString());
    }

    // Print the bill to a file
    private void printBill() {
        try (FileWriter fw = new FileWriter("bill.txt")) {
            fw.write(billArea.getText());
            billData.clear();
            JOptionPane.showMessageDialog(this, "Bill printed to bill.txt");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new BillingApp().setVisible(true);
            }
        });
    }
}
