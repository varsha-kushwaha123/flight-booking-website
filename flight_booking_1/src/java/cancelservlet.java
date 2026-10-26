import java.io.*;
import java.sql.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;

public class cancelservlet extends HttpServlet{

public void doPost(HttpServletRequest req,HttpServletResponse res)
throws IOException,ServletException{

try{

Class.forName("oracle.jdbc.driver.OracleDriver");

Connection con=DriverManager.getConnection(
"jdbc:oracle:thin:@localhost:1521:XE",
"system",
"manager");

int bookingId=Integer.parseInt(req.getParameter("booking_id"));

String sql=
"SELECT b.booking_id,b.booking_date,b.total_amount,"+
"p.name,p.gender,p.age,"+
"f.flight_no,f.company_name,f.source,f.destination,f.departure_time,f.arrival_time "+
"FROM booking b, passenger p, flight f "+
"WHERE b.passenger_id=p.passenger_id "+
"AND b.flight_id=f.flight_id "+
"AND b.booking_id=?";

PreparedStatement ps=con.prepareStatement(sql);

ps.setInt(1,bookingId);

ResultSet rs=ps.executeQuery();

if(rs.next()){

req.setAttribute("booking_id",rs.getInt("booking_id"));
req.setAttribute("booking_date",rs.getDate("booking_date"));

req.setAttribute("name",rs.getString("name"));
req.setAttribute("gender",rs.getString("gender"));
req.setAttribute("age",rs.getInt("age"));

req.setAttribute("flight_no",rs.getString("flight_no"));
req.setAttribute("company_name",rs.getString("company_name"));
req.setAttribute("source",rs.getString("source"));
req.setAttribute("destination",rs.getString("destination"));
req.setAttribute("departure_time",rs.getString("departure_time"));
req.setAttribute("arrival_time",rs.getString("arrival_time"));

req.setAttribute("total",rs.getDouble("total_amount"));

RequestDispatcher rd=req.getRequestDispatcher("cancle.confirm.jsp");

rd.forward(req,res);

}
else{
res.getWriter().println("<h2>Booking ID Not Found</h2>");
}

rs.close();
ps.close();
con.close();

}catch(Exception e){
res.getWriter().println(e);
}

}
}