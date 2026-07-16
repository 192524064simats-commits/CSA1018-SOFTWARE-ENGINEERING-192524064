import javax.swing.*;

public class AlertGenerator {

    public static void generateAlert(
            DetectionResult result) {

        if(result.getConfidence() > 75) {

            JOptionPane.showMessageDialog(
                    null,
                    "ALERT!\nPotential Deepfake Detected.",
                    "Security Alert",
                    JOptionPane.WARNING_MESSAGE
            );
        }
    }
}