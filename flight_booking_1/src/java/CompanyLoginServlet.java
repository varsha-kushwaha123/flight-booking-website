

import java.io.*;
import java.sql.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.WebServlet;

@WebServlet("/CompanyLoginServlet")
public class CompanyLoginServlet extends HttpServlet
{
    public void doPost(HttpServletRequest req,
                       HttpServletResponse res)
            throws IOException, ServletException
    {
        res.setContentType("text/html");

        PrintWriter pw1 =
                res.getWriter();


        String email =
                req.getParameter("email");

        String password =
                req.getParameter("password");


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
                    "select * from FLIGHT_COMPANY "
                    + "where EMAIL='"
                    + email
                    + "' "
                    + "and PASSWORD='"
                    + password
                    + "'";


            ResultSet rs =
                    stmt.executeQuery(q1);


            if(rs.next())
            {
                HttpSession session =
                        req.getSession();


                session.setAttribute(
                        "companyId",
                        rs.getInt("COMPANY_ID")
                );


                session.setAttribute(
                        "companyName",
                        rs.getString("COMPANY_NAME")
                );
                System.out.println("LOGIN: Company ID= " + session.getAttribute("companyId"));
                System.out.println("LOGIN: Session ID =" +session.getId());


                session.setAttribute(
                        "companyEmail",
                        rs.getString("EMAIL")
                );


                res.sendRedirect(
                        "company-dashboard.jsp"
                );
            }
            else
            {
                pw1.println(
                    "<html>"
                    + "<body>"
                    + "<h2>Invalid Email or Password</h2>"
                    + "<a href='company-login.jsp'>"
                    + "Go Back to Login"
                    + "</a>"
                    + "</body>"
                    + "</html>"
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