import java.io.*;
import java.sql.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.WebServlet;

@WebServlet("/ViewBookingServlet")
public class ViewBookingServlet extends HttpServlet
{
    public void doGet(HttpServletRequest req,
                      HttpServletResponse res)
            throws IOException, ServletException
    {
        res.setContentType("text/html");

        PrintWriter pw1 =
                res.getWriter();

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
                    "select B.BOOKING_ID, "
                    + "B.BOOKING_DATE, "
                    + "B.TOTAL_AMOUNT, "
                    + "B.STATUS, "
                    + "B.USER_ID, "
                    + "F.FLIGHT_NO, "
                    + "F.SOURCE, "
                    + "F.DESTINATION "
                    + "from BOOKING B, FLIGHT F "
                    + "where B.FLIGHT_ID=F.FLIGHT_ID "
                    + "and F.COMPANY_ID="
                    + companyId;

            ResultSet rs =
                    stmt.executeQuery(q1);

            pw1.println(
                "<html>"
                + "<head>"
                + "<title>Bookings</title>"
                + "<style>"
                + "body{font-family:Arial;"
                + "background:#f4f6f8;}"
                + ".container{width:95%;"
                + "margin:40px auto;}"
                + "h2{text-align:center;"
                + "color:#243b55;}"
                + "table{width:100%;"
                + "border-collapse:collapse;"
                + "background:white;}"
                + "th{background:#243b55;"
                + "color:white;padding:12px;}"
                + "td{padding:10px;"
                + "text-align:center;"
                + "border-bottom:1px solid #ddd;}"
                + ".back{display:inline-block;"
                + "margin-top:20px;"
                + "padding:12px 20px;"
                + "background:#243b55;"
                + "color:white;"
                + "text-decoration:none;"
                + "border-radius:5px;}"
                + "</style>"
                + "</head>"
                + "<body>"
                + "<div class='container'>"
                + "<h2>Flight Bookings</h2>"
            );

            pw1.println("<table>");

            pw1.println(
                "<tr>"
                + "<th>Booking ID</th>"
                + "<th>Booking Date</th>"
                + "<th>User ID</th>"
                + "<th>Flight No</th>"
                + "<th>Source</th>"
                + "<th>Destination</th>"
                + "<th>Total Amount</th>"
                + "<th>Status</th>"
                + "</tr>"
            );

            while(rs.next())
            {
                pw1.println(
                    "<tr>"

                    + "<td>"
                    + rs.getInt("BOOKING_ID")
                    + "</td>"

                    + "<td>"
                    + rs.getDate("BOOKING_DATE")
                    + "</td>"

                    + "<td>"
                    + rs.getInt("USER_ID")
                    + "</td>"

                    + "<td>"
                    + rs.getString("FLIGHT_NO")
                    + "</td>"

                    + "<td>"
                    + rs.getString("SOURCE")
                    + "</td>"

                    + "<td>"
                    + rs.getString("DESTINATION")
                    + "</td>"

                    + "<td>"
                    + rs.getDouble("TOTAL_AMOUNT")
                    + "</td>"

                    + "<td>"
                    + rs.getString("STATUS")
                    + "</td>"

                    + "</tr>"
                );
            }

            pw1.println("</table>");

            pw1.println(
                "<a class='back' "
                + "href='company-dashboard.jsp'>"
                + "← Dashboard"
                + "</a>"
            );

            pw1.println(
                "</div></body></html>"
            );

            con.close();
        }
        catch(Exception e)
        {
            pw1.println(e);
        }
    }
}