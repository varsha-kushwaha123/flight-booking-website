import java.io.*;
import java.sql.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class t1 extends HttpServlet
{
    public void doPost(HttpServletRequest req, HttpServletResponse res)
            throws IOException, ServletException
    {
        res.setContentType("text/html");
        PrintWriter pw = res.getWriter();

        String name = req.getParameter("n1");
        String email = req.getParameter("n2");
        String pass = req.getParameter("n3");
        String address = req.getParameter("n4");
        String gender = req.getParameter("n5");
        String question = req.getParameter("n6");
        String answer = req.getParameter("n7");
        String contact = req.getParameter("n8");

        try
        {
            Class.forName("oracle.jdbc.driver.OracleDriver");

            Connection con = DriverManager.getConnection(
                "jdbc:oracle:thin:@localhost:1521:XE",
                "system",
                "manager");

            Statement stmt = con.createStatement();

            String q = "insert into users values('" + name + "','" +
                        email + "','" + pass + "','" + address + "','" +
                        gender + "','" + question + "','" + answer + "','" +
                        contact + "')";

            int x = stmt.executeUpdate(q);

            if(x > 0)
            {
                pw.println("<html><body>");
                pw.println("<h2>Registration Successful!</h2>");
                pw.println("<a href='home.html'>Go to home Page</a>");
                pw.println("</body></html>");
            }
            else
            {
                pw.println("Registration Failed");
            }

            con.close();
        }
        catch(Exception e)
        {
            pw.println(e);
        }
    }
}