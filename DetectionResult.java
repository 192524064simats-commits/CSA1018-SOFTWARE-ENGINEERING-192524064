public class DetectionResult {

    private double confidence;
    private String status;
    private String reason;

    public DetectionResult(double confidence,
                           String status,
                           String reason) {

        this.confidence = confidence;
        this.status = status;
        this.reason = reason;
    }

    public double getConfidence() {
        return confidence;
    }

    public String getStatus() {
        return status;
    }

    public String getReason() {
        return reason;
    }
}