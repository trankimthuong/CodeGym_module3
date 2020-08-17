import java.io.IOException;
import java.io.PrintWriter;

import static java.lang.Double.parseDouble;

@javax.servlet.annotation.WebServlet(name = "DiscountServlet", urlPatterns = "/calculator")
public class DiscountServlet extends javax.servlet.http.HttpServlet {
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        String description = request.getParameter("txtDescription");
        double price = parseDouble(request.getParameter("txtPrice"));
        double percent = parseDouble(request.getParameter("txtPercent")) / 100;

        double discountAmount = price * percent;
        double discountPrice = price - discountAmount;
        PrintWriter writer = response.getWriter();
        writer.println("<html>");
        writer.println("description: " + description);
        writer.println("price: " + price);
        writer.println("discount percent: " + percent);
        writer.println("result: ");
        writer.println("discount amount = " + discountAmount);
        writer.println("discount price = " + discountPrice);
        writer.println("</html>");
    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {

    }
}
