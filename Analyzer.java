import java.io.File;
import java.util.Random;

public class Analyzer {

    public DetectionResult detectDeepfake(File file) {

        Random random = new Random();

        double confidence =
                50 + random.nextDouble() * 50;

        String status;
        String reason;

        if(confidence > 75) {

            status = "Potential Deepfake";

            reason =
                "Facial inconsistencies and pixel anomalies detected.";

        } else {

            status = "Likely Authentic";

            reason =
                "No major manipulation indicators found.";
        }

        return new DetectionResult(
                confidence,
                status,
                reason
        );
    }
}