import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

public class AdvancedNotepad extends JFrame {
    private JTextArea textArea;
    private File currentFile;
    private JFileChooser fileChooser;

    public AdvancedNotepad() {
        // Create the text area
        textArea = new JTextArea(20, 40);
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);

        // Create a scroll pane for the text area
        JScrollPane scrollPane = new JScrollPane(textArea);

        // Create the menu bar
        JMenuBar menuBar = new JMenuBar();

        // Create the File menu
        JMenu fileMenu = new JMenu("File");
        JMenuItem newMenuItem = new JMenuItem("New");
        JMenuItem openMenuItem = new JMenuItem("Open");
        JMenuItem saveMenuItem = new JMenuItem("Save");
        JMenuItem saveAsMenuItem = new JMenuItem("Save As");
        JMenuItem closeMenuItem = new JMenuItem("Close");

        // Add action listeners to the menu items
        newMenuItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String command = e.getActionCommand();
                if (command.equals("New")) {
                    // Clear the text area for a new file
                    textArea.setText("");
                    currentFile = null;
                }
            }
        });

        openMenuItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String command = e.getActionCommand();
                if (command.equals("Open")) {
                    // Open file chooser
                    fileChooser = new JFileChooser();
                    int action = fileChooser.showOpenDialog(null);

                    if (action == JFileChooser.APPROVE_OPTION) {
                        // Open the selected file
                        currentFile = fileChooser.getSelectedFile();
                        try {
                            // Read the file content into the text area
                            BufferedReader reader = new BufferedReader(new FileReader(currentFile));
                            textArea.read(reader, null);
                            reader.close();
                        } catch (Exception ex) {
                            JOptionPane.showMessageDialog(AdvancedNotepad.this, ex.getMessage());
                        }
                    }
                }
            }
        });

        saveMenuItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String command = e.getActionCommand();
                if (command.equals("Save")) {
                    if (currentFile != null) {
                        try {
                            // Save the text area content to the current file
                            BufferedWriter writer = new BufferedWriter(new FileWriter(currentFile));
                            textArea.write(writer);
                            writer.close();
                        } catch (Exception ex) {
                            JOptionPane.showMessageDialog(AdvancedNotepad.this, ex.getMessage());
                        }
                    } else {
                        // Open file chooser
                        fileChooser = new JFileChooser();
                        int action = fileChooser.showSaveDialog(null);

                        if (action == JFileChooser.APPROVE_OPTION) {
                            // Save the text area content to the selected file
                            currentFile = fileChooser.getSelectedFile();
                            try {
                                BufferedWriter writer = new BufferedWriter(new FileWriter(currentFile));
                                textArea.write(writer);
                                writer.close();
                            } catch (Exception ex) {
                                JOptionPane.showMessageDialog(AdvancedNotepad.this, ex.getMessage());
                            }
                        }
                    }
                }
            }
        });

        saveAsMenuItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String command = e.getActionCommand();
                if (command.equals("Save As")) {
                    // Open file chooser
                    fileChooser = new JFileChooser();
                    int action = fileChooser.showSaveDialog(null);

                    if (action == JFileChooser.APPROVE_OPTION) {
                        // Save the text area content to the selected file
                        currentFile = fileChooser.getSelectedFile();
                        try {
                            BufferedWriter writer = new BufferedWriter(new FileWriter(currentFile));
                            textArea.write(writer);
                            writer.close();
                        } catch (Exception ex) {
                            JOptionPane.showMessageDialog(AdvancedNotepad.this, ex.getMessage());
                        }
                    }
                }
            }
        });

        closeMenuItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String command = e.getActionCommand();
                if (command.equals("Close")) {
                    AdvancedNotepad.this.dispose();
                }
            }
        });

        // Add the menu items to the File menu
        fileMenu.add(newMenuItem);
        fileMenu.add(openMenuItem);
        fileMenu.add(saveMenuItem);
        fileMenu.add(saveAsMenuItem);
        fileMenu.add(closeMenuItem);

        // Create the Edit menu
        JMenu editMenu = new JMenu("Edit");
        JMenuItem cutMenuItem = new JMenuItem("Cut");
        JMenuItem copyMenuItem = new JMenuItem("Copy");
        JMenuItem pasteMenuItem = new JMenuItem("Paste");
        JMenuItem deleteMenuItem = new JMenuItem("Delete");

        // Add action listeners to the menu items
        cutMenuItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String command = e.getActionCommand();
                if (command.equals("Cut")) {
                    // Cut the selected text
                    textArea.cut();
                }
            }
        });

        copyMenuItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String command = e.getActionCommand();
                if (command.equals("Copy")) {
                    // Copy the selected text
                    textArea.copy();
                }
            }
        });

        pasteMenuItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String command = e.getActionCommand();
                if (command.equals("Paste")) {
                    // Paste the copied text
                    textArea.paste();
                }
            }
        });

        deleteMenuItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String command = e.getActionCommand();
                if (command.equals("Delete")) {
                    // Delete the selected text
                    textArea.replaceSelection("");
                }
            }
        });

        // Add the menu items to the Edit menu
        editMenu.add(cutMenuItem);
        editMenu.add(copyMenuItem);
        editMenu.add(pasteMenuItem);
        editMenu.add(deleteMenuItem);

        // Create the Help menu
        JMenu helpMenu = new JMenu("Help");
        JMenuItem aboutMenuItem = new JMenuItem("About");

        // Add action listener to the menu item
        aboutMenuItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String command = e.getActionCommand();
                if (command.equals("About")) {
                    // Show the about dialog
                    JOptionPane.showMessageDialog(AdvancedNotepad.this, "Advanced Notepad\nVersion 1.0\nCopyright 2024");
                }
            }
        });

        // Add the menu item to the Help menu
        helpMenu.add(aboutMenuItem);

        // Add the menus to the menu bar
        menuBar.add(fileMenu);
        menuBar.add(editMenu);
        menuBar.add(helpMenu);

        // Set the menu bar
        setJMenuBar(menuBar);

        // Add the scroll pane to the frame
        add(scrollPane, BorderLayout.CENTER);

        // Set the title and size of the frame
        setTitle("Advanced Notepad");
        setSize(400, 400);

        // Center the frame on the screen
        setLocationRelativeTo(null);

        // Set the default close operation
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        // Make the frame visible
        setVisible(true);
    }

    public static void main(String[] args) {
        new AdvancedNotepad();
    }
}