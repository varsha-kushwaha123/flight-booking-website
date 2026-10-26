<%@ page contentType="text/html;charset=UTF-8" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Passenger Details</title>

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
    width:700px;
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

.flight-grid,.form-grid{
    display:grid;
    grid-template-columns:1fr 1fr;
    gap:15px;
}

.item label{
    font-size:13px;
    color:#666;
    display:block;
}

.item p{
    font-size:17px;
    font-weight:bold;
    margin-top:4px;
}

.full{
    grid-column:1/3;
}

label{
    display:block;
    font-weight:bold;
    margin-bottom:6px;
}

input,select{
    width:100%;
    padding:10px;
    border:1px solid #bbb;
    border-radius:6px;
    font-size:15px;
}

button{
    width:100%;
    padding:12px;
    background:#16a34a;
    color:white;
    border:none;
    border-radius:6px;
    font-size:17px;
    cursor:pointer;
    margin-top:15px;
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

<h2>Selected Flight</h2>

<div class="flight-box">

<div class="flight-grid">

<div class="item">
<label>Flight No</label>
<p><%= request.getParameter("flight_no") %></p>
</div>

<div class="item">
<label>Airline</label>
<p><%= request.getParameter("company_name") %></p>
</div>

<div class="item">
<label>Route</label>
<p>
<%= request.getParameter("source") %> →
<%= request.getParameter("destination") %>
</p>
</div>

<div class="item">
<label>Fare</label>
<p>₹<%= request.getParameter("fare") %></p>
</div>

<div class="item">
<label>Departure</label>
<p><%= request.getParameter("departure_time") %></p>
</div>

<div class="item">
<label>Arrival</label>
<p><%= request.getParameter("arrival_time") %></p>
</div>

</div>

</div>

</div>

<!-- Passenger Form -->
<div class="card">

<h2>Passenger Information</h2>

<form action="passenger_insertion" method="post">

<!-- Hidden Flight Details -->
<input type="hidden" name="flight_id" value="<%= request.getParameter("flight_id") %>">
<input type="hidden" name="flight_no" value="<%= request.getParameter("flight_no") %>">
<input type="hidden" name="company_name" value="<%= request.getParameter("company_name") %>">
<input type="hidden" name="source" value="<%= request.getParameter("source") %>">
<input type="hidden" name="destination" value="<%= request.getParameter("destination") %>">
<input type="hidden" name="departure_time" value="<%= request.getParameter("departure_time") %>">
<input type="hidden" name="arrival_time" value="<%= request.getParameter("arrival_time") %>">
<input type="hidden" name="fare" value="<%= request.getParameter("fare") %>">

<div class="form-grid">

<div>
<label>Full Name</label>
<input type="text" name="name" required>
</div>

<div>
<label>Age</label>
<input type="number" name="age" required>
</div>

<div>
<label>Gender</label>
<select name="gender" required>
<option value="">Select</option>
<option>Male</option>
<option>Female</option>
<option>Other</option>
</select>
</div>

<div>
<label>Phone</label>
<input type="tel" name="phone" required>
</div>

<div class="full">
<label>Email</label>
<input type="email" name="email" required>
</div>

<div>
<label>Seat Preference</label>
<select name="seat" required>
<option value="">Select Seat</option>
<option>Window</option>
<option>Aisle</option>
<option>Middle</option>
</select>
</div>

<div>
<label>Travel Class</label>
<input type="text" name="travel_class" value="Economy" readonly>
</div>

</div>

<button type="submit">Continue to Payment</button>

</form>

</div>

</div>

</body>
</html>