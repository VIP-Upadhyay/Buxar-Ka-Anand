package vip.example.buxarkaanand.service;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;

import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.geom.RoundRectangle2D;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.awt.image.BufferedImage;
import java.awt.image.ConvolveOp;
import java.awt.image.Kernel;
import java.awt.Graphics2D;
import java.awt.Color;
@Service
public class QRCodeService {

    public byte[] generateQRCodeWithLogo(String upiId, double amount, String transactionNote) throws WriterException, IOException {
        int qrCodeSize = 300;
        int logoSize = 60;

        Map<EncodeHintType, Object> hints = new HashMap<>();
        hints.put(EncodeHintType.CHARACTER_SET, "UTF-8");

        QRCodeWriter qrCodeWriter = new QRCodeWriter();
        BitMatrix bitMatrix = qrCodeWriter.encode(
                "upi://pay?pa=" + upiId + "&am=" + amount + "&tn=" + transactionNote,
                BarcodeFormat.QR_CODE,
                qrCodeSize,
                qrCodeSize,
                hints
        );

        BufferedImage qrCodeImage = new BufferedImage(qrCodeSize, qrCodeSize, BufferedImage.TYPE_INT_RGB);
        for (int x = 0; x < qrCodeSize; x++) {
            for (int y = 0; y < qrCodeSize; y++) {
                qrCodeImage.setRGB(x, y, bitMatrix.get(x, y) ? Color.BLACK.getRGB() : Color.WHITE.getRGB());
            }
        }

        BufferedImage logoImage = ImageIO.read(new ClassPathResource("static/image/qrImg.jpg").getInputStream());
        
        // Calculate position to center the logo
        int xPos = (qrCodeSize - logoSize) / 2;
        int yPos = (qrCodeSize - logoSize) / 2;

        Graphics2D graphics = qrCodeImage.createGraphics();
        graphics.drawImage(logoImage, xPos, yPos, logoSize, logoSize, null);
        graphics.dispose();

        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ImageIO.write(qrCodeImage, "png", baos);
        return baos.toByteArray();
    }
    public byte[] generateQRCodeWithLogo1(String upiId, double amount, String transactionNote) throws WriterException, IOException {
        int qrCodeSize = 300;
        int logoSize = 50; // Adjust this as needed

        Map<EncodeHintType, Object> hints = new HashMap<>();
        hints.put(EncodeHintType.CHARACTER_SET, "UTF-8");

        QRCodeWriter qrCodeWriter = new QRCodeWriter();
        BitMatrix bitMatrix = qrCodeWriter.encode(
                "upi://pay?pa=" + upiId + "&am=" + amount + "&tn=" + transactionNote,
                BarcodeFormat.QR_CODE,
                qrCodeSize,
                qrCodeSize,
                hints
        );

        BufferedImage qrCodeImage = new BufferedImage(qrCodeSize, qrCodeSize, BufferedImage.TYPE_INT_RGB);
        for (int x = 0; x < qrCodeSize; x++) {
            for (int y = 0; y < qrCodeSize; y++) {
                qrCodeImage.setRGB(x, y, bitMatrix.get(x, y) ? Color.BLACK.getRGB() : Color.WHITE.getRGB());
            }
        }

        BufferedImage logoImage = ImageIO.read(new ClassPathResource("static/image/qrImg.jpg").getInputStream());
        logoImage = blurImage(logoImage);
        // Calculate position to center the logo
        int xPos = (qrCodeSize - logoSize) / 2;
        int yPos = (qrCodeSize - logoSize) / 2;

        Graphics2D graphics = qrCodeImage.createGraphics();
        graphics.drawImage(logoImage, xPos, yPos, logoSize, logoSize, null);
        graphics.dispose();

        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ImageIO.write(qrCodeImage, "png", baos);
        return baos.toByteArray();
    }
    private BufferedImage blurImage(BufferedImage image) {
        float[] blurMatrix = {
            1/9f, 1/9f, 1/9f,
            1/9f, 1/9f, 1/9f,
            1/9f, 1/9f, 1/9f
        };
        Kernel kernel = new Kernel(3, 3, blurMatrix);
        ConvolveOp convolveOp = new ConvolveOp(kernel, ConvolveOp.EDGE_NO_OP, null);
        return convolveOp.filter(image, null);
    }
    
    public byte[] generateQRCode(String upiId, double amount, String transactionNote) throws WriterException, IOException {
        int width = 300;
        int height = 300;

        Map<EncodeHintType, Object> hints = new HashMap<>();
        hints.put(EncodeHintType.CHARACTER_SET, "UTF-8");

        QRCodeWriter qrCodeWriter = new QRCodeWriter();
        BitMatrix bitMatrix = qrCodeWriter.encode(
                "upi://pay?pa=" + upiId + "&am=" + amount + "&tn=" + transactionNote,
                BarcodeFormat.QR_CODE,
                width,
                height,
                hints
        );

        BufferedImage bufferedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                bufferedImage.setRGB(x, y, bitMatrix.get(x, y) ? 0xFF000000 : 0xFFFFFFFF);
            }
        }

        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ImageIO.write(bufferedImage, "png", baos);
        return baos.toByteArray();
    }

}
