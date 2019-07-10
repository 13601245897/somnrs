package com.fm.integral.controller;

import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;

/**
 * 拼接图片
 * 
 * @author moese
 *
 */
public class DemoController {

	public static void main(String[] args) {

		try {
			/* 1 读取第一张图片 */
			File fileOne = new File(
					"/Users/moese/git/fm_integral/fm_integral/src/main/resources/static/WX20180831-153222@2x.png");
			BufferedImage imageFirst = ImageIO.read(fileOne);
			int width = imageFirst.getWidth();// 图片宽度
			int height = imageFirst.getHeight();// 图片高度
			int[] imageArrayFirst = new int[width * height];// 从图片中读取RGB
			imageArrayFirst = imageFirst.getRGB(0, 0, width, height, imageArrayFirst, 0, width);

			/* 1 对第二张图片做相同的处理 */
			File fileTwo = new File(
					"/Users/moese/git/fm_integral/fm_integral/src/main/resources/static/WX20180831-153241@2x.png");
			BufferedImage imageSecond = ImageIO.read(fileTwo);
			int[] imageArraySecond = new int[width * height];
			imageArraySecond = imageSecond.getRGB(0, 0, width, height, imageArraySecond, 0, width);

			// 生成新图片
			BufferedImage imageResult = new BufferedImage(width, height * 2, BufferedImage.TYPE_INT_RGB);
			imageResult.setRGB(0, 0, width, height, imageArrayFirst, 0, width);// 设置左半部分的RGB
			imageResult.setRGB(0, height, width, height, imageArraySecond, 0, width);// 设置右半部分的RGB
			File outFile = new File("/Users/moese/git/fm_integral/fm_integral/src/main/resources/static/cc.jpg");
			ImageIO.write(imageResult, "jpg", outFile);// 写图片
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
