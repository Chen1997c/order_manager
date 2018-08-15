package com.blank.util;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sun.image.codec.jpeg.JPEGCodec;
import com.sun.image.codec.jpeg.JPEGImageEncoder;

/**
 * <p>
 * 功能描述: 生成图片验证码
 * </p>
 *
 * @author :Team Blank
 * @since :2018.08.06
 */
public class VerifyCodeUtil {

    /*
     * 验证码随机字符
     */
    private static final char[] CODE_CHARS = "qwertyuiopasdfghjklzxcvbnmQWERTYUIOPASDFGHJKLZXCVBNM123456".toCharArray();

    /*
     * 随机数
     */
    private static final Random random = new Random();

    /*
     * 生成4位验证码
     */
    private static String getRandomString() {
        StringBuffer buffer = new StringBuffer();
        for (int i = 0; i < 4; i++) {
            buffer.append(CODE_CHARS[random.nextInt(CODE_CHARS.length)]);
        }
        return buffer.toString();
    }


    public static void outputCode(HttpServletRequest request, HttpServletResponse response) throws IOException {

        //定义验证码图片类型
        response.setContentType("image/jpeg");

        // 获取验证码并存入session中
        String verifyCode = getRandomString();
        request.getSession().setAttribute("verifyCode", verifyCode);

        //定义验证码图片高、宽
        int width = 100;
        int height = 35;

        // 获取随机颜色
        Color color = new Color(255, 255, 255);

        //获取该随机颜色的反色
        Color reverseColor = new Color(0, 0, 0);

        BufferedImage bImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        Graphics2D g = bImage.createGraphics();
        g.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 28));
        g.setColor(color);
        g.fillRect(0, 0, width, height);
        g.setColor(reverseColor);
        g.drawString(verifyCode, 18, 20);
        for (int i = 0, n = random.nextInt(100); i < n; i++) {
            g.drawRect(random.nextInt(width), random.nextInt(height), 1, 1);
        }

        //转换为jpeg格式输出
        ServletOutputStream servletOutputStream = response.getOutputStream();
        JPEGImageEncoder encoder = JPEGCodec.createJPEGEncoder(servletOutputStream);
        encoder.encode(bImage);
        servletOutputStream.flush();
    }

}
