<%@ page contentType="text/html;charset=UTF-8" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>E-Ticket</title>

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
    width:760px;
    margin:30px auto;
}

.ticket{
    background:white;
    border-radius:15px;
    box-shadow:0 0 15px rgba(0,0,0,0.2);
    overflow:hidden;
}

.top{
    background:#0d6efd;
    color:white;
    padding:20px;
    display:flex;
    justify-content:space-between;
    align-items:center;
}

.status{
    background:#16a34a;
    padding:8px 16px;
    border-radius:20px;
    font-weight:bold;
}

.section{
    padding:20px;
}

.section h2{
    color:#0d6efd;
    margin-bottom:15px;
    border-bottom:2px solid #ddd;
    padding-bottom:5px;
}

.grid{
    display:grid;
    grid-template-columns:1fr 1fr;
    gap:15px;
}

.item label{
    display:block;
    color:#666;
    font-size:13px;
}

.item p{
    font-size:17px;
    font-weight:bold;
    margin-top:4px;
}

.route{
    text-align:center;
    margin:20px 0;
}

.route h1{
    color:#0d6efd;
    font-size:30px;
}

.payment{
    display:flex;
    justify-content:space-between;
    font-size:20px;
    font-weight:bold;
    color:#16a34a;
    margin-top:10px;
}

.btns{
    display:flex;
    gap:15px;
    margin-top:25px;
}

button{
    flex:1;
    padding:12px;
    border:none;
    border-radius:8px;
    font-size:16px;
    cursor:pointer;
}

.print{
    background:#0d6efd;
    color:white;
}

.home{
    background:#16a34a;
    color:white;
}
</style>

</head>

<body>

<header>
    <h1>Flight Reservation System</h1>
</header>

<div class="container">

<div class="ticket">

    <!-- Top -->
    <div class="top">
        <div>
            <h2>E - TICKET</h2>
            <p>Booking ID : <%= request.getAttribute("booking_id") %></p>
        </div>

        <div class="status">
            CONFIRMED
        </div>
    </div>

    <!-- Passenger -->
    <div class="section">

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

    <!-- Flight -->
    <div class="section">

        <h2>Flight Details</h2>

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
                <label>Departure</label>
                <p><%= request.getAttribute("departure_time") %></p>
            </div>

            <div class="item">
                <label>Arrival</label>
                <p><%= request.getAttribute("arrival_time") %></p>
            </div>

        </div>

        <div class="route">
            <h1>
                <%= request.getAttribute("source") %> ✈
                <%= request.getAttribute("destination") %>
            </h1>
        </div>

    </div>

    <!-- Payment -->
    <div class="section">

        <h2>Payment Details</h2>

        <div class="grid">

            <div class="item">
                <label>Payment Method</label>
                <p><%= request.getAttribute("payment") %></p>
            </div>

            <div class="item">
                <label>Status</label>
                <p style="color:green;">Paid</p>
            </div>

        </div>

        <div class="payment">
            <span>Total Paid</span>
            <span>₹<%= request.getAttribute("total") %></span>
        </div>

        <div class="btns">
            <button class="print" onclick="window.print()">Print Ticket</button>
            <button class="home" onclick="location.href='home.html'">Home</button>
        </div>

    </div>

</div>

</div>

</body>
</html>