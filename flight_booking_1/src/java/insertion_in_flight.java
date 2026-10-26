import java.io.*;
import java.sql.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;

public class insertion_in_flight extends HttpServlet {

    public void doPost(HttpServletRequest req, HttpServletResponse res)
            throws IOException, ServletException {

        res.setContentType("text/html");
        PrintWriter out = res.getWriter();

        int flightId = Integer.parseInt(req.getParameter("flight_id"));
        String flightNo = req.getParameter("flight_no");
        String company = req.getParameter("company_name");
        String source = req.getParameter("source");
        String destination = req.getParameter("destination");
        String departure = req.getParameter("departure_time");
        String arrival = req.getParameter("arrival_time");
        double fare = Double.parseDouble(req.getParameter("fare"));

        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");

            Connection con = DriverManager.getConnection(
                "jdbc:oracle:thin:@localhost:1521:XE",
                "system",
                "manager"
            );

            String sql = "INSERT INTO flight "
                    + "(flight_id, flight_no, company_name, source, destination, departure_time, arrival_time, fare) "
                    + "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setInt(1, flightId);
            ps.setString(2, flightNo);
            ps.setString(3, company);
            ps.setString(4, source);
            ps.setString(5, destination);
            ps.setString(6, departure);
            ps.setString(7, arrival);
            ps.setDouble(8, fare);

            int i = ps.executeUpdate();

            out.println("<html><body>");

            if (i > 0) {
                out.println("<h2 style='color:green;text-align:center;'>Flight Added Successfully!</h2>");
                out.println("<br><center><a href='addFlight.html'>Add Another Flight</a></center>");
            } else {
                out.println("<h2 style='color:red;text-align:center;'>Failed to Add Flight!</h2>");
            }

            out.println("</body></html>");

            ps.close();
            con.close();

        } catch (Exception e) {
            out.println("<h3>Error: " + e.getMessage() + "</h3>");
        }
    }
}