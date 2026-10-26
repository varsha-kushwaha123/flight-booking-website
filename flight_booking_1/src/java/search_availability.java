import java.io.*;
import java.sql.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;

public class search_availability extends HttpServlet {

    public void doPost(HttpServletRequest req, HttpServletResponse res)
            throws IOException, ServletException {

        res.setContentType("text/html");
        PrintWriter out = res.getWriter();

        String source = req.getParameter("from");
        String destination = req.getParameter("to");
        out.println("Source = " + source + "<br>");
        out.println("Destination = " + destination + "<br>");   

        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");

            Connection con = DriverManager.getConnection(
                "jdbc:oracle:thin:@localhost:1521:XE",
                "system",
                "manager"
            );
            
             String sql = "SELECT f.*, c.company_name " +
             "FROM flight f " +
             "JOIN flight_company c " +
             "ON f.company_id = c.company_id " +
             "WHERE f.source = ? AND f.destination = ?";
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, source);
            ps.setString(2, destination);

            ResultSet rs = ps.executeQuery();

            out.println("<html><body>");
            out.println("<h2>Available Flights</h2>");

            out.println("<table border='1' cellpadding='8'>");
            out.println("<tr>");
            out.println("<th>Flight No</th>");
            out.println("<th>Company</th>");
            out.println("<th>Source</th>");
            out.println("<th>Destination</th>");
            out.println("<th>Departure</th>");
            out.println("<th>Arrival</th>");
            out.println("<th>Fare</th>");
            out.println("<th>Action</th>");
            out.println("</tr>");

            boolean found = false;
            

            while (rs.next()) {
                found = true;
                  

                out.println("<tr>");
                out.println("<td>" + rs.getString("flight_no") + "</td>");
                out.println("<td>" + rs.getString("company_name") + "</td>");
                out.println("<td>" + rs.getString("source") + "</td>");
                out.println("<td>" + rs.getString("destination") + "</td>");
                out.println("<td>" + rs.getString("departure_time") + "</td>");
                out.println("<td>" + rs.getString("arrival_time") + "</td>");
               out.println("<td>₹" + rs.getDouble("fare") + "</td>");

                out.println("<td>");
                out.println("<form action='passenger.jsp' method='post'>");
                out.println("<input type='hidden' name='flight_id' value='" +
                   rs.getInt("flight_id") + "'>");
                out.println("<input type='hidden' name='flight_no' value='" +
                   rs.getString("flight_no") + "'>");
                out.println("<input type='hidden' name='company_name' value='" +
        rs.getString("company_name") + "'>");

out.println("<input type='hidden' name='source' value='" +
        rs.getString("source") + "'>");

out.println("<input type='hidden' name='destination' value='" +
        rs.getString("destination") + "'>");

out.println("<input type='hidden' name='departure_time' value='" +
        rs.getString("departure_time") + "'>");

out.println("<input type='hidden' name='arrival_time' value='" +
        rs.getString("arrival_time") + "'>");

out.println("<input type='hidden' name='fare' value='" +
        rs.getDouble("fare") + "'>");

                out.println("<input type='submit' value='Book Now'>");
             out.println("</form>");
                out.println("</td>");
             out.println("</tr>");
            }
            

            if (!found) {
                out.println("<tr><td colspan='8'>No flights available</td></tr>");
            }

            out.println("</table>");
            out.println("</body></html>");

            rs.close();
            ps.close();
            con.close();

        } catch (Exception e) {
            out.println(e);
        }
    }
}