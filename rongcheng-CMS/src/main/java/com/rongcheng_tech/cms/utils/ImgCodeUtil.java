package com.rongcheng_tech.cms.utils;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.Random;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

public final class ImgCodeUtil {

	// 字符数量
	private static final int SIZE = 4;
	// 干扰线数量
	private static final int LINES = 5;
	// 宽度
	private static final int WIDTH = 90;
	// 高度
	private static final int HEIGHT = 43;
	// 字体大小
	private static final int FONT_SIZE = 40;

	/**
	 * 生成随机验证码及图片
	 */
	public static Object[] createImage() {
		// 验证码字符集
		char[] chars = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E',
				'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z' };
		StringBuffer imgCode = new StringBuffer();
		// 1.创建空白图片
		BufferedImage image = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);
		// 2.获取图片画笔
		Graphics graphic = image.getGraphics();
		// 3.设置画笔颜色
		graphic.setColor(Color.WHITE);
		// 4.绘制矩形背景
		graphic.fillRect(0, 0, WIDTH, HEIGHT);
		// 5.画随机字符
		Random ran = new Random();
		for (int i = 0; i < SIZE; i++) {
			// 取随机字符索引
			int n = ran.nextInt(chars.length);
			// 设置随机颜色
			graphic.setColor(getRandomColor());
			// 设置字体大小
			graphic.setFont(new Font(null, Font.ITALIC + Font.ITALIC, FONT_SIZE));
			// 画字符
			graphic.drawString(chars[n] + "", i * (WIDTH-5) / SIZE, HEIGHT / 2+16);
			// 记录字符
			imgCode.append(chars[n]);
		}
		// 6.画干扰线
		for (int i = 0; i < LINES; i++) {
			// 设置随机颜色
			graphic.setColor(getRandomColor());
			// 随机画线
			graphic.drawLine(ran.nextInt(WIDTH), ran.nextInt(HEIGHT), ran.nextInt(WIDTH), ran.nextInt(HEIGHT));
		}
		// 7.返回验证码和图片
		return new Object[] { imgCode.toString(), image };
	}

	/**
	 * 生成随机验证码及图片
	 * @throws ScriptException 
	 */
	public static Object[] createImage(int calculate) throws ScriptException {
		// 验证码字符集
		char[] chars = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9' };
		// 字符数量
		int SIZE = 3;
		StringBuffer imgCode = new StringBuffer();
		// 1.创建空白图片
		BufferedImage image = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);
		// 2.获取图片画笔
		Graphics graphic = image.getGraphics();
		// 3.设置画笔颜色
		graphic.setColor(Color.WHITE);
		// 4.绘制矩形背景
		graphic.fillRect(0, 0, WIDTH, HEIGHT);
		// 5.画随机字符
		Random ran = new Random();
		for (int i = 0; i < SIZE; i++) {
			// 取随机字符索引
			int n = ran.nextInt(chars.length);
			// 设置随机颜色
			graphic.setColor(getRandomColor());
			// 设置字体大小
			graphic.setFont(new Font(null, Font.ITALIC + Font.ITALIC, FONT_SIZE));
			if(i%2==0){
				// 画字符
				graphic.drawString(chars[n] + "", i * (WIDTH-5) / SIZE, HEIGHT / 2+16);
				// 记录字符
				imgCode.append(chars[n]);
			}else{
				int r = new Random().nextInt(3);
				if(r==0){
					graphic.drawString("+", i * (WIDTH-5) / SIZE, HEIGHT / 2+16);
					imgCode.append("+");
				}else if(r==1){
					graphic.drawString("-", i * (WIDTH-5) / SIZE+5, HEIGHT / 2+12);
					imgCode.append("-");
				}else if(r==2){
					graphic.drawString("×", i * (WIDTH-5) / SIZE, HEIGHT / 2+16);
					imgCode.append("*");
				}
			}
		}
		// 6.画干扰线
		for (int i = 0; i < LINES; i++) {
			// 设置随机颜色
			graphic.setColor(getRandomColor());
			// 随机画线
			graphic.drawLine(ran.nextInt(WIDTH), ran.nextInt(HEIGHT), ran.nextInt(WIDTH), ran.nextInt(HEIGHT));
		}
		
		/* 使用JS脚本引擎执行 */  
        ScriptEngineManager sem = new ScriptEngineManager();  
        ScriptEngine sEngine = sem.getEngineByName("javascript");  
        String result = sEngine.eval(imgCode.toString())+"";
		// 7.返回验证码和图片
		return new Object[] { result, image };
	}
	/**
	 * 随机取色
	 */
	public static Color getRandomColor() {
		Random ran = new Random();
		Color color = new Color(ran.nextInt(156), ran.nextInt(156), ran.nextInt(156));
		return color;
	}
}
