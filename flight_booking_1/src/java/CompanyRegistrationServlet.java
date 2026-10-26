package com.flight;

import java.io.*;
import java.sql.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.WebServlet;

@WebServlet("/CompanyRegistrationServlet")
public class CompanyRegistrationServlet extends HttpServlet
{
    public void doPost(HttpServletRequest req,
                       HttpServletResponse res)
            throws IOException, ServletException
    {
        res.setContentType("text/html");

        PrintWriter pw1 = res.getWriter();

        String companyName =
                req.getParameter("companyName");

        String email =
                req.getParameter("email");

        String contact =
                req.getParameter("contact");

        String password =
                req.getParameter("password");

        String confirmPassword =
                req.getParameter("confirmPassword");


        // Check password
        if(!password.equals(confirmPassword))
        {
            pw1.println(
                "<html>"
                + "<body>"
                + "<h2>Passwords do not match</h2>"
                + "<a href='company-registration.jsp'>"
                + "Go Back"
                + "</a>"
                + "</body>"
                + "</html>"
            );

            return;
        }


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


            // Check whether email already exists

            String checkQuery =
                    "select * from FLIGHT_COMPANY "
                    + "where EMAIL='"
                    + email
                    + "'";


            ResultSet rs =
                    stmt.executeQuery(checkQuery);


            if(rs.next())
            {
                pw1.println(
                    "<html>"
                    + "<body>"
                    + "<h2>Email already registered</h2>"
                    + "<a href='company-registration.jsp'>"
                    + "Try Again"
                    + "</a>"
                    + "</body>"
                    + "</html>"
                );

                con.close();

                return;
            }


            // Insert new company

            String q1 =
                    "insert into FLIGHT_COMPANY "
                    + "(COMPANY_ID, COMPANY_NAME, EMAIL, "
                    + "CONTACT_NO, PASSWORD) "
                    + "values "
                    + "(COMPANY_SEQ.NEXTVAL, '"
                    + companyName + "', '"
                    + email + "', '"
                    + contact + "', '"
                    + password + "')";


            int x =
                    stmt.executeUpdate(q1);


            if(x > 0)
            {
                pw1.println(
                    "<html>"
                    + "<head>"
                    + "<title>Registration Success</title>"
                    + "</head>"
                    + "<body>"
                    + "<h2>Company Registration Successful</h2>"
                    + "<p>Your company has been registered successfully.</p>"
                    + "<br>"
                    + "<a href='company-login.jsp'>"
                    + "Go to Company Login"
                    + "</a>"
                    + "</body>"
                    + "</html>"
                );
            }
            else
            {
                pw1.println(
                    "<h2>Registration Unsuccessful</h2>"
                );
            }


            con.close();

        }
        catch(Exception e)
        {
            pw1.println(
                "<h2>Error occurred:</h2>"
            );

            pw1.println(e);
        }
    }
}