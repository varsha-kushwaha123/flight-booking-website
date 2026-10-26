import java.io.*;
import java.sql.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;

public class CancelBookingServlet extends HttpServlet {

    public void doPost(HttpServletRequest req, HttpServletResponse res)
            throws IOException, ServletException {

        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");

            Connection con = DriverManager.getConnection(
                "jdbc:oracle:thin:@localhost:1521:XE",
                "system",
                "manager"
            );

            int bookingId = Integer.parseInt(req.getParameter("booking_id"));

            String sql = "UPDATE booking SET booking_status=? WHERE booking_id=?";

            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, "Cancelled");
            ps.setInt(2, bookingId);

            int i = ps.executeUpdate();

            if (i > 0) {

                req.setAttribute("booking_id", bookingId);
                req.setAttribute("refund_amount", "5300");
                req.setAttribute("status", "Cancelled");

                RequestDispatcher rd = req.getRequestDispatcher("refund.jsp");
                rd.forward(req, res);

            } else {
                res.getWriter().println("<h2>Cancellation Failed!</h2>");
            }

            ps.close();
            con.close();

        } catch (Exception e) {
            res.getWriter().println(e);
        }
    }
}