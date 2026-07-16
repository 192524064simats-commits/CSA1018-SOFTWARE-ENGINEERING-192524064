import javax.swing.*;
import java.awt.*;
import java.io.File;

public class Dashboard extends JFrame {

    private JLabel imageLabel;
    private JTextArea resultArea;
    private File selectedFile;

    public Dashboard() {

        setTitle("Deepfake Detection Alert System");
        setSize(800,600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        JButton uploadBtn = new JButton("Upload Image");
        JButton analyzeBtn = new JButton("Analyze");

        JPanel topPanel = new JPanel();
        topPanel.add(uploadBtn);
        topPanel.add(analyzeBtn);

        add(topPanel, BorderLayout.NORTH);

        imageLabel = new JLabel("No Image Selected", SwingConstants.CENTER);
        add(imageLabel, BorderLayout.CENTER);

        resultArea = new JTextArea();
        resultArea.setEditable(false);

        add(new JScrollPane(resultArea), BorderLayout.SOUTH);

        uploadBtn.addActionListener(e -> uploadImage());
        analyzeBtn.addActionListener(e -> analyzeImage());

        setVisible(true);
    }

    private void uploadImage() {

        JFileChooser chooser = new JFileChooser();

        if (chooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {

            selectedFile = chooser.getSelectedFile();

            ImageIcon icon = new ImageIcon(selectedFile.getAbsolutePath());

            Image img = icon.getImage()
                    .getScaledInstance(300,300,Image.SCALE_SMOOTH);

            imageLabel.setIcon(new ImageIcon(img));
            imageLabel.setText("");
        }
    }

    private void analyzeImage() {

        if(selectedFile == null) {
            JOptionPane.showMessageDialog(this,
                    "Please upload image first");
            return;
        }

        Analyzer analyzer = new Analyzer();

        DetectionResult result =
                analyzer.detectDeepfake(selectedFile);

        resultArea.setText(
                "Confidence Score : "
                + result.getConfidence()
                + "%\n\n"

                + "Status : "
                + result.getStatus()

                + "\n\nReason : "
                + result.getReason()
        );

        AlertGenerator.generateAlert(result);
    }

    public static void main(String[] args) {

        SwingUtilities.invokeLater(
                Dashboard::new
        );
    }
}