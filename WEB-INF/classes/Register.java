import java.io.*;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.sql.*;

public class Register extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        String n = request.getParameter("userName");
        String p = request.getParameter("userPass");
        String e = request.getParameter("userEmail");
        String c = request.getParameter("userCountry");

        try {

            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/san1", "root", "tiger");

            String q1 = "insert into san1tb(name,rollno,namess,hello) values(?,?,?,?)";

            try (PreparedStatement ps = con.prepareStatement(q1)) {
                ps.setString(1, n);
                ps.setString(2, p);
                ps.setString(3, e);
                ps.setString(3, c);

                int q = ps.executeUpdate();

                if (q > 0) {
                    out.println("Successfull");
                }

            }

            catch (Exception ex) {
                out.println(ex);
            }
        } catch (Exception ex) {
            out.println(ex);
        }

    }
}
