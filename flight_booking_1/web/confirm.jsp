<%@ page contentType="text/html;charset=UTF-8" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Confirm Ticket</title>

<style>
*{
    margin:0;
    padding:0;
    box-sizing:border-box;
    font-family:Arial, Helvetica, sans-serif;
}

body{
    background:#eef5ff;
}

header{
    background:#0d6efd;
    color:white;
    text-align:center;
    padding:18px;
}

.container{
    width:720px;
    margin:30px auto;
}

.card{
    background:white;
    border-radius:12px;
    padding:20px;
    box-shadow:0 0 12px rgba(0,0,0,0.15);
    margin-bottom:20px;
}

h2{
    color:#0d6efd;
    margin-bottom:15px;
}

.flight-box{
    border:1px solid #4d8dff;
    background:#f2f7ff;
    border-radius:10px;
    padding:15px;
}

.grid{
    display:grid;
    grid-template-columns:1fr 1fr;
    gap:15px;
}

.item label{
    color:#666;
    font-size:13px;
    display:block;
}

.item p{
    font-size:17px;
    font-weight:bold;
    margin-top:4px;
}

.row{
    display:flex;
    justify-content:space-between;
    margin:8px 0;
    font-size:16px;
}

.total{
    font-size:22px;
    font-weight:bold;
    color:#16a34a;
}

input[type=text]{
    width:100%;
    padding:10px;
    border:1px solid #bbb;
    border-radius:6px;
    margin-top:5px;
    margin-bottom:12px;
}

button{
    width:100%;
    padding:13px;
    background:#16a34a;
    color:white;
    border:none;
    border-radius:6px;
    font-size:17px;
    cursor:pointer;
}

button:hover{
    background:#15803d;
}
</style>

</head>

<body>

<header>
    <h1>Flight Reservation System</h1>
</header>

<div class="container">

    <!-- Flight Details -->
    <div class="card">
        <h2>Flight Details</h2>

        <div class="flight-box">
            <div class="grid">
                <div class="item">
                        <label>Flight No</label>
                        <p><%= request.getAttribute("flight_no") %></p>
                    </div>

                    <div class="item">
                        <label>Airline</label>
                        <p><%= request.getAttribute("company_name") %></p>
                    </div>

                    <div class="item">
                        <label>Route</label>
                        <p>
                            <%= request.getAttribute("source") %> →
                            <%= request.getAttribute("destination") %>
                        </p>
                    </div>

                    <div class="item">
                        <label>Fare</label>
                        <p>₹<%= request.getAttribute("fare") %></p>
                    </div>

                    <div class="item">
                        <label>Departure</label>
                        <p><%= request.getAttribute("departure_time") %></p>
                    </div>

                    <div class="item">
                        <label>Arrival</label>
                        <p><%= request.getAttribute("arrival_time") %></p>
                    </div>

                    </div>
                </div>
            </div>

            <!-- Passenger Details -->
            <div class="card">
                <h2>Passenger Details</h2>

                <div class="grid">

                    <div class="item">
                        <label>Name</label>
                        <p><%= request.getAttribute("name") %></p>
            </div>

            <div class="item">
                <label>Age</label>
                <p><%= request.getAttribute("age") %></p>
            </div>

            <div class="item">
                <label>Gender</label>
                <p><%= request.getAttribute("gender") %></p>
            </div>

            <div class="item">
                <label>Phone</label>
                <p><%= request.getAttribute("phone") %></p>
            </div>

            <div class="item">
                <label>Email</label>
                <p><%= request.getAttribute("email") %></p>
            </div>

            <div class="item">
                <label>Seat</label>
                <p><%= request.getAttribute("seat") %></p>
            </div>

        </div>
    </div>

    <!-- Payment -->
    <div class="card">

        <h2>Payment</h2>

        <div class="row">
            <span>Ticket Fare</span>
             <p>₹<%= request.getAttribute("fare") %></p>
            
        </div>

        <div class="row">
            <span>Service Charge</span>
            <strong>₹200</strong>
        </div>

        <hr style="margin:15px 0;">
        
          <% 
               double fare=Double.parseDouble(request.getAttribute("fare").toString());
               double total=fare+200;

            %>
        <div class="row total">
            <span>Total Amount</span>
            &#8377;<span><%= total %></span>
        </div>

        <br>

        <form action="bookingservlet" method="post">
            
            <!-- Flight -->
            <input type="hidden" name="flight_id" value="<%=request.getAttribute("flight_id")%>">
            <input type="hidden" name="flight_no" value="<%=request.getAttribute("flight_no")%>">
            <input type="hidden" name="company_name" value="<%=request.getAttribute("company_name")%>">
            <input type="hidden" name="source" value="<%=request.getAttribute("source")%>">
            <input type="hidden" name="destination" value="<%=request.getAttribute("destination")%>">
            <input type="hidden" name="departure_time" value="<%=request.getAttribute("departure_time")%>">
            <input type="hidden" name="arrival_time" value="<%=request.getAttribute("arrival_time")%>">
            <input type="hidden" name="fare" value="<%=request.getAttribute("fare")%>">

            <!-- Passenger -->
            <input type="hidden" name="name" value="<%=request.getAttribute("name")%>">
            <input type="hidden" name="age" value="<%=request.getAttribute("age")%>">
            <input type="hidden" name="gender" value="<%=request.getAttribute("gender")%>">
            <input type="hidden" name="phone" value="<%=request.getAttribute("phone")%>">
            <input type="hidden" name="email" value="<%=request.getAttribute("email")%>">
            <input type="hidden" name="seat" value="<%=request.getAttribute("seat")%>">
             <input type="radio" name="payment" value="UPI" checked> UPI


           
            <br><br>

            <label><b>UPI ID / Card Number</b></label>
            <input type="text" name="account" placeholder="Enter UPI ID or Card Number" required>

            <button type="submit">Pay ₹<%= total %> & Confirm Ticket</button>

        </form>

    </div>

</div>

</body>
</html>