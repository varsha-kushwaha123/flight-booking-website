<%@ page contentType="text/html;charset=UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Confirm Cancellation</title>

<style>
body{
font-family:Arial;
background:#eef5ff;
}
.card{
width:700px;
margin:30px auto;
background:white;
padding:25px;
border-radius:10px;
box-shadow:0 0 10px gray;
}
h2{
color:#dc3545;
}
.grid{
display:grid;
grid-template-columns:1fr 1fr;
gap:15px;
margin-top:20px;
}
.item label{
color:gray;
display:block;
}
.item p{
font-weight:bold;
}
button{
width:100%;
padding:14px;
background:#dc3545;
color:white;
border:none;
margin-top:25px;
cursor:pointer;
}
</style>
</head>

<body>

<div class="card">

<h2>Confirm Ticket Cancellation</h2>

<div class="grid">

<div class="item">
<label>Booking ID</label>
<p><%=request.getAttribute("booking_id")%></p>
</div>

<div class="item">
<label>Booking Date</label>
<p><%=request.getAttribute("booking_date")%></p>
</div>

<div class="item">
<label>Passenger</label>
<p><%=request.getAttribute("name")%></p>
</div>

<div class="item">
<label>Gender</label>
<p><%=request.getAttribute("gender")%></p>
</div>

<div class="item">
<label>Flight</label>
<p><%=request.getAttribute("flight_no")%></p>
</div>

<div class="item">
<label>Airline</label>
<p><%=request.getAttribute("company_name")%></p>
</div>

<div class="item">
<label>Route</label>
<p>
<%=request.getAttribute("source")%>
→
<%=request.getAttribute("destination")%>
</p>
</div>

<div class="item">
<label>Amount Paid</label>
<p>₹<%=request.getAttribute("total")%></p>
</div>

</div>

<form action="CancelBookingServlet" method="post">

<input type="hidden" name="booking_id"
value="<%=request.getAttribute("booking_id")%>">

<button type="submit">
Confirm Cancellation
</button>

</form>

</div>

</body>
</html>