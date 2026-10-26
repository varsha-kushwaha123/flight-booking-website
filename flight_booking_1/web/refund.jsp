<%@ page contentType="text/html;charset=UTF-8" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Refund Confirmation</title>

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
    width:650px;
    margin:40px auto;
}

.card{
    background:white;
    padding:30px;
    border-radius:12px;
    box-shadow:0 0 15px rgba(0,0,0,0.2);
}

h2{
    color:#dc3545;
    text-align:center;
    margin-bottom:20px;
}

.success{
    text-align:center;
    color:#16a34a;
    font-size:18px;
    font-weight:bold;
    margin-bottom:25px;
}

.row{
    display:flex;
    justify-content:space-between;
    padding:12px 0;
    border-bottom:1px solid #ddd;
    font-size:16px;
}

.total{
    color:#16a34a;
    font-size:22px;
    font-weight:bold;
}

.note{
    margin-top:20px;
    background:#f8f9fa;
    padding:15px;
    border-left:5px solid #0d6efd;
    color:#555;
}

button{
    width:100%;
    margin-top:25px;
    padding:12px;
    border:none;
    border-radius:6px;
    background:#0d6efd;
    color:white;
    font-size:16px;
    cursor:pointer;
}

button:hover{
    background:#084298;
}
</style>
</head>

<body>

<header>
    <h1>Flight Reservation System</h1>
</header>

<div class="container">

<div class="card">

<h2>Ticket Cancelled</h2>

<div class="success">
    Your ticket has been cancelled successfully.
</div>

<div class="row">
    <span>Booking ID</span>
    <strong><%= request.getAttribute("booking_id") %></strong>
</div>

<div class="row">
    <span>Status</span>
    <strong style="color:red;">
        <%= request.getAttribute("status") %>
    </strong>
</div>

<div class="row">
    <span>Refund Amount</span>
    <span class="total">
        ₹<%= request.getAttribute("refund_amount") %>
    </span>
</div>

<div class="note">
    **Refund Policy:** The refund will be credited to your original payment
    method within **5–7 working days**.
</div>

<button onclick="location.href='home.html'">
    Back to Home
</button>

</div>

</div>

</body>
</html>