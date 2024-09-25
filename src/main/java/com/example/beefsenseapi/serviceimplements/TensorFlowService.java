package com.example.beefsenseapi.serviceimplements;

import org.tensorflow.SavedModelBundle;
import org.tensorflow.Session;
import org.tensorflow.Tensor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.FloatBuffer;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@Service
public class TensorFlowService {
    private static final Logger logger = Logger.getLogger(TensorFlowService.class.getName());
    private final SavedModelBundle model;
    private final String[] classNames;

    public TensorFlowService() {
        try {
            logger.info("Loading TensorFlow model...");
            model = SavedModelBundle.load("file:/app/src/main/resources/saved3/1", "serve");
            logger.info("TensorFlow model loaded successfully.");

            logger.info("Loading class names...");
            classNames = loadClassNames("file:/app/src/main/resources/saved3/1/labels.txt");
            logger.info("Class names loaded successfully.");
        } catch (Exception e) {
            logger.log(Level.SEVERE, "Failed to load TensorFlow model or labels", e);
            throw new RuntimeException("Failed to load TensorFlow model or labels", e);
        }
    }


    public String predict(MultipartFile file) throws IOException {
        // Convert the uploaded image to a BufferedImage
        BufferedImage image = ImageIO.read(file.getInputStream());

        // Preprocess the image
        float[] input = preprocessImage(image);

        // Run the prediction
        float[] prediction = predict(input);

        // Find the class with the highest confidence score
        int index = getMaxIndex(prediction);
        String className = classNames[index];
        float confidenceScore = prediction[index];

        // Return the result
        return "Class: " + className + ", Confidence Score: " + confidenceScore;
    }

    private float[] preprocessImage(BufferedImage image) {
        int targetWidth = 224;
        int targetHeight = 224;
        BufferedImage resizedImage = new BufferedImage(targetWidth, targetHeight, BufferedImage.TYPE_INT_RGB);

        // Resize the image
        resizedImage.getGraphics().drawImage(image, 0, 0, targetWidth, targetHeight, null);

        // Normalize pixel values to the range [-1, 1]
        float[] input = new float[targetWidth * targetHeight * 3];
        int index = 0;
        for (int y = 0; y < targetHeight; y++) {
            for (int x = 0; x < targetWidth; x++) {
                int rgb = resizedImage.getRGB(x, y);
                input[index++] = (((rgb >> 16) & 0xFF) / 127.5f) - 1; // Red
                input[index++] = (((rgb >> 8) & 0xFF) / 127.5f) - 1;  // Green
                input[index++] = ((rgb & 0xFF) / 127.5f) - 1;         // Blue
            }
        }
        return input;
    }

    private float[] predict(float[] input) {
        try (Tensor<Float> inputTensor = Tensor.create(new long[]{1, 224, 224, 3}, FloatBuffer.wrap(input))) {
            Session.Runner runner = model.session().runner();
            runner.feed("serving_default_sequential_61_input", inputTensor);
            runner.fetch("StatefulPartitionedCall");
            List<Tensor<?>> result = runner.run();
            try (Tensor<?> outputTensor = result.get(0)) {
                float[][] output = new float[1][(int) outputTensor.shape()[1]];
                outputTensor.copyTo(output);
                return output[0];  // Returning the first (and only) row
            }
        } catch (Exception e) {
            logger.log(Level.SEVERE, "Error during TensorFlow prediction", e);
            throw new RuntimeException("Error during TensorFlow prediction", e);
        }
    }

    private int getMaxIndex(float[] predictions) {
        int maxIndex = 0;
        for (int i = 1; i < predictions.length; i++) {
            if (predictions[i] > predictions[maxIndex]) {
                maxIndex = i;
            }
        }
        return maxIndex;
    }

    private String[] loadClassNames(String filePath) throws IOException {
        return Files.readAllLines(Paths.get(filePath)).toArray(new String[0]);
    }

}