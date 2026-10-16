package gui;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;

public class Main extends JFrame {

    private PredictionWindow predictionWindow;

    public Main() {
        setTitle("Simple Application");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        // Build Menu Bar
        JMenuBar menuBar = new JMenuBar();

        // --- File Menu ---
        JMenu fileMenu = new JMenu("File");
        JMenuItem newItem = new JMenuItem("New");
        JMenuItem openItem = new JMenuItem("Open");
        JMenuItem exitItem = new JMenuItem("Exit");
        exitItem.addActionListener((ActionEvent e) -> System.exit(0));

        fileMenu.add(newItem);
        fileMenu.add(openItem);
        fileMenu.addSeparator();
        fileMenu.add(exitItem);

        // --- Tools Menu ---
        JMenu toolsMenu = new JMenu("Tools");
        JMenuItem predictionsItem = new JMenuItem("Predictions");
        predictionsItem.addActionListener((ActionEvent e) -> openPredictionsWindow());
        toolsMenu.add(predictionsItem);

        // --- Help Menu ---
        JMenu helpMenu = new JMenu("Help");
        JMenuItem aboutItem = new JMenuItem("About");
        aboutItem.addActionListener((ActionEvent e) -> {
            JOptionPane.showMessageDialog(this, 
                "Simple Swing App\nVersion 1.0", 
                "About", 
                JOptionPane.INFORMATION_MESSAGE);
        });
        helpMenu.add(aboutItem);

        // Assemble Menu Bar
        menuBar.add(fileMenu);
        menuBar.add(toolsMenu);
        menuBar.add(helpMenu);

        setJMenuBar(menuBar);
    }

    private void openPredictionsWindow() {
        // Reuse or recreate window if closed
        if (predictionWindow != null && predictionWindow.isDisplayable()) {
            predictionWindow.setState(JFrame.NORMAL);
            predictionWindow.toFront();
            predictionWindow.requestFocus();
            return;
        }

        predictionWindow = new PredictionWindow();
        predictionWindow.setLocationRelativeTo(this); // Position relative to main frame
        predictionWindow.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Main app = new Main();
            app.setVisible(true);
        });
    }
}