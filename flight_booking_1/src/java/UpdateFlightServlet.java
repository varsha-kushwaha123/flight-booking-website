import java.io.*;
import java.sql.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.WebServlet;

@WebServlet("/UpdateFlightServlet")
public class UpdateFlightServlet extends HttpServlet
{
    public void doPost(HttpServletRequest req,
                       HttpServletResponse res)
            throws IOException, ServletException
    {
        res.setContentType("text/html");

        PrintWriter pw1 =
                res.getWriter();

        String flightId =
                req.getParameter("flightId");

        String flightNo =
                req.getParameter("flightNo");

        String source =
                req.getParameter("source");

        String destination =
                req.getParameter("destination");

        String departureTime =
                req.getParameter("departureTime");

        String arrivalTime =
                req.getParameter("arrivalTime");

        String fare =
                req.getParameter("fare");

        String totalSeats =
                req.getParameter("totalSeats");

        String availableSeats =
                req.getParameter("availableSeats");

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
                    "update FLIGHT set "
                    + "FLIGHT_NO='" + flightNo + "', "
                    + "SOURCE='" + source + "', "
                    + "DESTINATION='" + destination + "', "
                    + "DEPARTURE_TIME="
                    + "TO_TIMESTAMP('"
                    + departureTime
                    + "', 'YYYY-MM-DD\"T\"HH24:MI'), "
                    + "ARRIVAL_TIME="
                    + "TO_TIMESTAMP('"
                    + arrivalTime
                    + "', 'YYYY-MM-DD\"T\"HH24:MI'), "
                    + "FARE=" + fare + ", "
                    + "TOTAL_SEATS=" + totalSeats + ", "
                    + "AVAILABLE_SEATS=" + availableSeats
                    + " where FLIGHT_ID="
                    + flightId
                    + " and COMPANY_ID="
                    + companyId;

            int x =
                    stmt.executeUpdate(q1);

            if(x > 0)
            {
                pw1.println(
                    "<html><body>"
                    + "<h2>Flight Updated Successfully</h2>"
                    + "<a href='ViewFlightServlet'>"
                    + "View Flights"
                    + "</a>"
                    + "</body></html>"
                );
            }
            else
            {
                pw1.println(
                    "<h2>Flight Update Failed</h2>"
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