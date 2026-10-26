import java.io.*;
import java.sql.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;

public class loginservlet extends HttpServlet {

    public void doPost(HttpServletRequest req, HttpServletResponse res)
            throws IOException, ServletException {

        res.setContentType("text/html");
        PrintWriter out = res.getWriter();

        String id = req.getParameter("t1");
        String ps = req.getParameter("t2");

        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");

            Connection con = DriverManager.getConnection(
                "jdbc:oracle:thin:@localhost:1521:XE",
                "system",
                "manager"
            );

            PreparedStatement pst = con.prepareStatement(
                "SELECT * FROM users WHERE email=? AND password=?"
            );

            pst.setString(1, id);
            pst.setString(2, ps);

            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
//                out.println("<html><body>");
//                out.println("<h2>Login Successful</h2>");
//                out.println("<h3>Welcome " + rs.getString("name") + "</h3>");
//                out.println("<a href='search.html'>Search Flights</a>");
//                out.println("</body></html>");

                res.sendRedirect("search_flight.html");
           } else {
                out.println("<html><body>");
                out.println("<h2>Invalid Email or Password</h2>");
                out.println("<a href='login.html'>Try Again</a>");
                out.println("</body></html>");
            }

            con.close();

        } catch (Exception e) {
            out.println(e);
        }
    }
}