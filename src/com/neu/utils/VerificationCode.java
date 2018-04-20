package com.neu.utils;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Random;

import javax.imageio.ImageIO;

public class VerificationCode {
	private static final String VERIFY_CODE = "ABCDEFGHJKLMNPQRSTUVWXYZ23456789";
	private static VerificationCode code = new VerificationCode();
	private Random random = new Random();

	public String generateVerification(int verificationSize, String sources) {
		if(sources == null || sources.length() == 0)
			sources = VERIFY_CODE;
		Random rand = new Random(System.currentTimeMillis());
		StringBuffer verification = new StringBuffer(verificationSize);
		for (int i = 0; i < verificationSize; i++) {
			char c = sources.charAt(rand.nextInt(sources.length()));
			verification.append(c);
		}
		return verification.toString();
	}
	
	
	/**
	 * @param width
	 * @param height
	 * @param verification
	 * @param outputFile
	 * @throws IOException
	 * 输出验证码文件流
	 */
	public void outputImage(int width, int height, String verification, File outputFile) throws IOException {
		File dir = outputFile.getParentFile();
		if(!dir.exists())
			dir.mkdirs();
		try {
			FileOutputStream fos = new FileOutputStream(outputFile);
			outputImage(width, height, verification, fos);
			fos.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * @param width
	 * @param height
	 * @param verification
	 * @param os
	 * @throws IOException
	 * 输出验证码图像流
	 */
	public void outputImage(int width, int height, String verification, OutputStream os) throws IOException {
		BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
		Graphics2D g2d = image.createGraphics();
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);
		
		//设置边框颜色
		g2d.setColor(Color.GRAY);
		g2d.fillRect(0, 0, width, height);
		
		//设置图片背景颜色
		g2d.setColor(getRandColor(200, 150));
		g2d.fillRect(0, 2, width, height - 4);
		
		//设置干扰线
		g2d.setColor(getRandColor(250, 200));
		for(int i = 0; i < 20; i++) {
			int x1 = random.nextInt(width);
			int y1 = random.nextInt(height);
			int x2 = random.nextInt(12);
			int y2 = random.nextInt(6);
			g2d.drawLine(x1, y1, x1+x2+40, y1+y2+20);
		}
		
		//设置噪点
		float f = 0.05f;	//设置噪声率
		int area = (int) (f * width * height);
		for(int i = 0; i < area; i++) {
			int x = random.nextInt(width);
			int y = random.nextInt(height);
			int rgb = getRandomIntColor();
			image.setRGB(x, y, rgb );
		}
		
		//设置图片字体
		g2d.setColor(getRandColor(150, 100));
		int fontSize = height - 4;
		Font font = new Font("Algerian", Font.ITALIC, fontSize);
		g2d.setFont(font);
		char[] chars = verification.toCharArray();
		int verificationSize = verification.length();
		for(int i = 0; i < verificationSize; i++) {
			AffineTransform affine = new AffineTransform();
			affine.setToRotation(Math.PI / 4 * random.nextDouble() * (random.nextBoolean() ? 1 : -1), 
					(width / verificationSize) * i, height / 2);
			g2d.setTransform(affine);
			g2d.drawChars(chars, i, 1, (width / verificationSize) * i, height / 2 + fontSize / 2 - 5);
		}
		
		g2d.dispose();
		ImageIO.write(image, "jpg", os);
	}
	
	//随机获取一种颜色
	private Color getRandColor(int fc, int bc) {
		if(fc > bc) {
			int swap = fc;
			fc = bc;
			bc = swap;
		}
		int r = fc + random.nextInt(bc - fc);
		int g = fc + random.nextInt(bc - fc);
		int b = fc + random.nextInt(bc - fc);
		
		return new Color(r, g, b);
	}
	
	//随机获得一个整数
	private int getRandomIntColor() {
		int rgb[] = getRandomRgb();
		int color = 0;
		for (int c : rgb) {
			color = color << 8;
			color = color | c;
		}
		return color;
	}

	// 随机生成一个整数数组
	private int[] getRandomRgb() {
		int[] rgb = new int[3];
		for (int i = 0; i < 3; i++) {
			rgb[i] = random.nextInt(255);
		}
		return rgb;
	}
	
	public static void main(String[] args) throws IOException {
		String verification = code.generateVerification(4, VERIFY_CODE);
		File dir = new File("f:/pictures");
		File file = new File(dir, verification+".jpg");
		code.outputImage(100, 30, verification, file);
	}
}
