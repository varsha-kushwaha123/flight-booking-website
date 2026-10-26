import java.io.*;
import java.sql.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;

public class bookingservlet extends HttpServlet {

    public void doPost(HttpServletRequest req, HttpServletResponse res)
            throws IOException, ServletException {

        // Flight Details
        int flightId = Integer.parseInt(req.getParameter("flight_id"));
        String flightNo = req.getParameter("flight_no");
        String company = req.getParameter("company_name");
        String source = req.getParameter("source");
        String destination = req.getParameter("destination");
        String departure = req.getParameter("departure_time");
        String arrival = req.getParameter("arrival_time");

        // Passenger Details
        String name = req.getParameter("name");
        int age = Integer.parseInt(req.getParameter("age"));
        String gender = req.getParameter("gender");
        String phone = req.getParameter("phone");
        String email = req.getParameter("email");
        String seat = req.getParameter("seat");

        // Payment
        String payment = req.getParameter("payment");
        String account = req.getParameter("account");

        double fare = Double.parseDouble(req.getParameter("fare"));
        double total = fare + 200;

        try {

            Class.forName("oracle.jdbc.driver.OracleDriver");

            Connection con = DriverManager.getConnection(
                    "jdbc:oracle:thin:@localhost:1521:XE",
                    "system",
                    "manager");

            // Get latest passenger id
            Statement st = con.createStatement();

            ResultSet rs = st.executeQuery(
                "SELECT MAX(passenger_id) FROM passenger");

            int passengerId = 0;

            if(rs.next()){
                passengerId = rs.getInt(1);
            }

            // Insert booking
            String sql = "INSERT INTO booking "+"(booking_id,booking_date,total_amount,status,user_id,flight_id,paymnet)"+"VALUES(booking_seq.NEXTVAL,?,?,?,?,?,?)";

            PreparedStatement ps = con.prepareStatement(sql);
            

            ps.setDate(1, new java.sql.Date(System.currentTimeMillis()));
            ps.setDouble(2, total);
            ps.setString(3, "Confirmed");
            ps.setInt(4, passengerId);
            ps.setInt(5, flightId);
            ps.setString(6, payment);

            int i = ps.executeUpdate();

            if(i > 0){
                // Get generated Booking ID
            ResultSet rs2 = st.executeQuery("SELECT booking_seq.CURRVAL FROM dual");
            int bookingId = 0;
            if(rs2.next()){
                bookingId = rs2.getInt(1);
            }

            // Booking
            req.setAttribute("booking_id", bookingId);

            // Flight
            req.setAttribute("flight_id", flightId);
            req.setAttribute("flight_no", flightNo);
            req.setAttribute("company_name", company);
            req.setAttribute("source", source);
            req.setAttribute("destination", destination);
            req.setAttribute("departure_time", departure);
            req.setAttribute("arrival_time", arrival);
            req.setAttribute("fare", fare);

            // Passenger
            req.setAttribute("name", name);
            req.setAttribute("age", age);
            req.setAttribute("gender", gender);
            req.setAttribute("phone", phone);
            req.setAttribute("email", email);
            req.setAttribute("seat", seat);

            // Payment
            req.setAttribute("payment", payment);
            req.setAttribute("account", account);
            req.setAttribute("total", total);

            RequestDispatcher rd = req.getRequestDispatcher("eticket.jsp");
            rd.forward(req, res);

            }
            else{
                res.getWriter().println("Booking Failed!");
            }

            ps.close();
            rs.close();
            st.close();
            con.close();

        } catch(Exception e){
            res.getWriter().println(e);
        }
    }
}