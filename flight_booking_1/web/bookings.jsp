<!DOCTYPE html>
<html>

<head>

    <title>Bookings</title>

    <style>

        body {
            margin: 0;
            font-family: Arial;
            background: #f4f6f8;
        }

        .container {
            width: 95%;
            margin: 40px auto;
        }

        h2 {
            text-align: center;
            color: #243b55;
        }

        table {
            width: 100%;
            border-collapse: collapse;
            background: white;
        }

        th {
            background: #243b55;
            color: white;
            padding: 13px;
        }

        td {
            padding: 11px;
            text-align: center;
            border-bottom: 1px solid #ddd;
        }

        .back {
            display: inline-block;
            margin-top: 20px;
            padding: 12px 20px;
            background: #243b55;
            color: white;
            text-decoration: none;
            border-radius: 5px;
        }

    </style>

</head>

<body>

<div class="container">

    <h2>Flight Bookings</h2>

    <p style="text-align:center;">
        Booking information for your flights is displayed below.
    </p>

    <a href="ViewBookingServlet"
       class="back">
        Refresh Bookings
    </a>

    <br><br>

    <a href="company-dashboard.jsp"
       class="back">
         Dashboard
    </a>

</div>

</body>
</html>