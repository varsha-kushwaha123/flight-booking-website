import java.io.*;
import java.sql.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.WebServlet;

@WebServlet("/DeleteFlightServlet")
public class DeleteFlightServlet extends HttpServlet
{
    public void doGet(HttpServletRequest req,
                      HttpServletResponse res)
            throws IOException, ServletException
    {
        res.setContentType("text/html");

        PrintWriter pw1 =
                res.getWriter();

        String flightId =
                req.getParameter("id");

        HttpSession session =
                req.getSession();

        Object companyObject =
                session.getAttribute("companyId");

        if(companyObject == null)
        {
            res.sendRedirect("company-login.jsp");
            return;
        }

        int companyId =
                (Integer)companyObject;

        try
        {
            Class.forName(
                    "oracle.jdbc.driver.OracleDriver"
            );

            Connection con =
                    DriverManager.getConnection(
                            "jdbc:oracle:thin:@localhost:1521:XE",
                            "system",
                            "manager"
                    );

            Statement stmt =
                    con.createStatement();

            String q1 =
                    "delete from FLIGHT "
                    + "where FLIGHT_ID="
                    + flightId
                    + " and COMPANY_ID="
                    + companyId;

            int x =
                    stmt.executeUpdate(q1);

            if(x > 0)
            {
                res.sendRedirect(
                        "ViewFlightServlet"
                );
            }
            else
            {
                pw1.println(
                    "<h2>Flight Delete Failed</h2>"
                    + "<a href='ViewFlightServlet'>"
                    + "Back"
                    + "</a>"
                );
            }

            con.close();
        }
        catch(Exception e)
        {
            pw1.println(e);
        }
    }
}