package com.qr;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.imageio.ImageIO;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.BinaryBitmap;
import com.google.zxing.MultiFormatReader;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.NotFoundException;
import com.google.zxing.Result;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.common.HybridBinarizer;

public class QRCode {

	public static void main(String[] args) throws WriterException, IOException, NotFoundException {
		String qrCodeData = "http://localhost:8080/leaderboard";
		String filePath = "F:/Hack2Hire/QRCode.png";
		String charset = "UTF-8"; // or "ISO-8859-1"

		createQRCode(qrCodeData, filePath, charset, 200, 200);
		System.out.println("QR Code image created successfully!");


	}

	public static void createQRCode(String qrCodeData, String filePath, String charset, int qrCodeheight,
			int qrCodewidth) throws WriterException, IOException {
		BitMatrix matrix = new MultiFormatWriter().encode(new String(qrCodeData.getBytes(charset), charset),
				BarcodeFormat.QR_CODE, qrCodewidth, qrCodeheight);
		MatrixToImageWriter.writeToFile(matrix, filePath.substring(filePath.lastIndexOf('.') + 1), new File(filePath));
	}

	
}