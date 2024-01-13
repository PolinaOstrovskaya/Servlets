import jakarta.servlet.http.HttpServlet;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/checkAge")
public class Age extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int age = Integer.parseInt(request.getParameter("age"));
        PrintWriter out = response.getWriter();
        if (age >= 18) {
            out.println("Adult");
        } else {
            out.println("Minor");
        }
    }
}
