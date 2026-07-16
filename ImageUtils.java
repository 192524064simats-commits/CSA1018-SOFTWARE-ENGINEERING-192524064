import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.io.File;

public class ImageUtils {

    public static int getImageWidth(File file) {

        try {

            BufferedImage img =
                    ImageIO.read(file);

            return img.getWidth();

        } catch(Exception e) {

            return 0;
        }
    }

    public static int getImageHeight(File file) {

        try {

            BufferedImage img =
                    ImageIO.read(file);

            return img.getHeight();

        } catch(Exception e) {

            return 0;
        }
    }
}