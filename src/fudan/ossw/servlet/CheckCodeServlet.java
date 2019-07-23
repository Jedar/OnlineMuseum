package fudan.ossw.servlet;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

@WebServlet(name="CheckCodeServlet",value="/jsp/CheckCode")
public class CheckCodeServlet extends HttpServlet {

    public static String ATTR_NAME = "picCode";

    private static final long serialVersionUID = 1L;

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        this.doPost(request, response);
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // 设置图片宽高，图片显示的字母个数及字母范围
        final int imgWidth=85;
        final int imgHeight=28;
        final int imgCodeNum=4;
        /* 验证码字符列表 */
        char[] codeList = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghigklmnopqrstuvwxyz0123456789".toCharArray();

        // 设置图片的宽高
        BufferedImage img = new BufferedImage(imgWidth, imgHeight, BufferedImage.TYPE_INT_RGB);

        // 得到该图片的绘图对象，此方法返回 Graphics2D
        Graphics g = img.getGraphics();

        // 创建具有指定红色、绿色和蓝色值的不透明的 sRGB 颜色，这些值都在 (0 - 255) 的范围内。
        Color c = new Color(200, 150, 255);

        // 将此图形上下文的当前颜色设置为指定颜色。
        g.setColor(c);

        // 填充整个图片的颜色 ,0,0, 代表对象的左上角坐标
        g.fillRect(0, 0, imgWidth, imgHeight);

        // 向图片中输出数字和字母
        StringBuilder sb = new StringBuilder();

        int index, len = codeList.length;
        Random random = new Random();
        for (int i = 0; i < imgCodeNum; i++) {
            index = random.nextInt(len);
            g.setColor(new Color(random.nextInt(88), random.nextInt(188), random.nextInt(255)));
            // 输出的字体和大小
            g.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 22));
            // 写什么数字，在图片的什么位置画
            g.drawString("" + codeList[index], (i * 15) + 3, 18);
            sb.append(codeList[index]);
        }
        // 将生成的验证码保存到Session中。
        HttpSession session = request.getSession();
        session.setAttribute(ATTR_NAME, sb.toString());

        // 禁止图像缓存。
        response.setHeader("Pragma", "no-cache");
        response.setHeader("Cache-Control", "no-cache");
        response.setDateHeader("Expires", 0);
        response.setContentType("image/jpeg");

        // 将图像输出到Servlet输出流中。
        ServletOutputStream sos = response.getOutputStream();
        ImageIO.write(img, "jpeg", sos);
        sos.close();
    }

}
