package gui;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;

public class PredictionWindow extends JFrame {

    public PredictionWindow() {
        // Configure frame settings
        setTitle("Predictions");
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // Close only this window
        
        // Layout and UI construction
        initUI();
    }

    private void initUI() {
        JPanel panel = new JPanel(new BorderLayout());

        JLabel titleLabel = new JLabel("Predictions Module", JLabel.CENTER);
        titleLabel.setFont(new Font("SansSerif", Font.BOLD, 18));
        panel.add(titleLabel, BorderLayout.NORTH);

        JPanel contentPanel = new JPanel(new FlowLayout());
        contentPanel.add(new JLabel("Configure inputs or display prediction results here."));
        panel.add(contentPanel, BorderLayout.CENTER);

        add(panel);
    }
}