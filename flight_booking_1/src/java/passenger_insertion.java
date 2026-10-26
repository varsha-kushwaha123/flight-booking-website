import java.io.*;
import java.sql.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;

public class passenger_insertion extends HttpServlet {

    public void doPost(HttpServletRequest req, HttpServletResponse res)
            throws IOException, ServletException {

        res.setContentType("text/html");
        PrintWriter out = res.getWriter();
        
     
        String name = req.getParameter("name");
        int age = Integer.parseInt(req.getParameter("age"));
        String gender = req.getParameter("gender");
        String phone = req.getParameter("phone");
        String email = req.getParameter("email");
        String flightId = req.getParameter("flight_id");
        String flightNo = req.getParameter("flight_no");
        String companyName = req.getParameter("company_name");
        String source = req.getParameter("source");
        String destination = req.getParameter("destination");
        String departureTime = req.getParameter("departure_time");
        String arrivalTime = req.getParameter("arrival_time");
        String fare = req.getParameter("fare");

        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");

            Connection con = DriverManager.getConnection(
                "jdbc:oracle:thin:@localhost:1521:XE",
                "system",
                "manager"
            );

            String sql = "INSERT INTO Passenger"+"(passenger_id,name, age, gender, phone, email)"+" VALUES(passenger_seq.NEXTVAL,?,?,?,?,?)";

            PreparedStatement ps = con.prepareStatement(sql);
            
    
            ps.setString(1, name);
            ps.setInt(2, age);
            ps.setString(3, gender);
            ps.setString(4, phone);
            ps.setString(5, email);

            int i = ps.executeUpdate();

            if(i > 0){
                req.setAttribute("name",name);
                req.setAttribute("age",age);
                req.setAttribute("gender",gender);
                req.setAttribute("phone",phone);
                req.setAttribute("email",email);
                req.setAttribute("seat",req.getParameter("seat"));
                req.setAttribute("travelClass",req.getParameter("travel_class"));
                              
            req.setAttribute("flight_id", flightId);
            req.setAttribute("flight_no", flightNo);
            req.setAttribute("company_name", companyName);
            req.setAttribute("source", source);
            req.setAttribute("destination", destination);
            req.setAttribute("departure_time", departureTime);
            req.setAttribute("arrival_time", arrivalTime);
            req.setAttribute("fare", fare);
                RequestDispatcher rd= req.getRequestDispatcher("confirm.jsp");
                rd.forward(req, res);
            }
            else{
                out.println("<h2>Passenger details not saved!</h2>");
            }

            ps.close();
            con.close();

        } catch(Exception e){
            out.println(e);
        }
    }
}