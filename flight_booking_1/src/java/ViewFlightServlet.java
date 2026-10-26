import java.io.*;
import java.sql.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.WebServlet;

@WebServlet("/ViewFlightServlet")
public class ViewFlightServlet extends HttpServlet
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
                    "select * from FLIGHT "
                    + "where COMPANY_ID="
                    + companyId
                    + " order by FLIGHT_ID";

            ResultSet rs =
                    stmt.executeQuery(q1);

            pw1.println(
                "<html>"
                + "<head>"
                + "<title>Manage Flights</title>"
                + "<style>"
                + "body{font-family:Arial;background:#f4f6f8;}"
                + ".container{width:95%;margin:40px auto;}"
                + "h2{text-align:center;color:#243b55;}"
                + "table{width:100%;border-collapse:collapse;"
                + "background:white;}"
                + "th{background:#243b55;color:white;"
                + "padding:12px;}"
                + "td{padding:10px;text-align:center;"
                + "border-bottom:1px solid #ddd;}"
                + "a{padding:7px 12px;"
                + "text-decoration:none;"
                + "border-radius:5px;}"
                + ".edit{background:#3498db;color:white;}"
                + ".delete{background:#e74c3c;color:white;}"
                + ".back{display:inline-block;"
                + "margin-top:20px;"
                + "background:#243b55;color:white;"
                + "padding:12px;}"
                + "</style>"
                + "</head>"
                + "<body>"
                + "<div class='container'>"
                + "<h2>Manage Flights</h2>"
            );

            pw1.println("<table>");

            pw1.println(
                "<tr>"
                + "<th>ID</th>"
                + "<th>Flight No</th>"
                + "<th>Source</th>"
                + "<th>Destination</th>"
                + "<th>Departure</th>"
                + "<th>Arrival</th>"
                + "<th>Fare</th>"
                + "<th>Total Seats</th>"
                + "<th>Available Seats</th>"
                + "<th>Action</th>"
                + "</tr>"
            );

            while(rs.next())
            {
                pw1.println(
                    "<tr>"
                    + "<td>"
                    + rs.getInt("FLIGHT_ID")
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
                    + rs.getTimestamp("DEPARTURE_TIME")
                    + "</td>"

                    + "<td>"
                    + rs.getTimestamp("ARRIVAL_TIME")
                    + "</td>"

                    + "<td>"
                    + rs.getDouble("FARE")
                    + "</td>"

                    + "<td>"
                    + rs.getInt("TOTAL_SEATS")
                    + "</td>"

                    + "<td>"
                    + rs.getInt("AVAILABLE_SEATS")
                    + "</td>"

                    + "<td>"

                    + "<a class='edit' href='Edit Flight.jsp?id="
                    + rs.getInt("FLIGHT_ID")
                    + "'>Edit</a> "

                    + "<a class='delete' href='DeleteFlightServlet?id="
                    + rs.getInt("FLIGHT_ID")
                    + "' "
                    + "onclick=\"return confirm('Delete this flight?');\">"
                    + "Delete</a>"

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