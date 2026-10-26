import java.io.*;
import java.sql.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.WebServlet;

@WebServlet("/AddFlightServlet")
public class AddFlightServlet extends HttpServlet
{
    public void doPost(HttpServletRequest req,
                       HttpServletResponse res)
            throws IOException, ServletException
    {
        res.setContentType("text/html");

        PrintWriter pw1 = res.getWriter();

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

        HttpSession session = req.getSession(false);
        if(session == null)
        {
            System.out.println("ADD FLIGHT: NO SESSION");
            res.sendRedirect("company-login.jsp");
            return;
        }

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
                    "insert into FLIGHT "
                    + "(FLIGHT_ID, FLIGHT_NO, SOURCE, "
                    + "DESTINATION, DEPARTURE_TIME, "
                    + "ARRIVAL_TIME, FARE, TOTAL_SEATS, "
                    + "AVAILABLE_SEATS, COMPANY_ID) "
                    + "values "
                    + "(FLIGHT_SEQ.NEXTVAL, '"
                    + flightNo + "', '"
                    + source + "', '"
                    + destination + "', "
                    + "TO_TIMESTAMP('"
                    + departureTime
                    + "', 'YYYY-MM-DD\"T\"HH24:MI'), "
                    + "TO_TIMESTAMP('"
                    + arrivalTime
                    + "', 'YYYY-MM-DD\"T\"HH24:MI'), "
                    + fare + ", "
                    + totalSeats + ", "
                    + totalSeats + ", "
                    + companyId + ")";

            int x =
                    stmt.executeUpdate(q1);

            if(x > 0)
            {
                pw1.println(
                    "<html><body>"
                    + "<h2>Flight Added Successfully</h2>"
                    + "<a href='ViewFlightServlet'>"
                    + "View Flights"
                    + "</a><br><br>"
                    + "<a href='company-dashboard.jsp'>"
                    + "Dashboard"
                    + "</a>"
                    + "</body></html>"
                );
            }
            else
            {
                pw1.println(
                    "Flight insertion unsuccessful"
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