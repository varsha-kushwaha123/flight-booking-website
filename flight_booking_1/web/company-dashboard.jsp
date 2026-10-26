<%
    if(session.getAttribute("companyId") == null)
    {
        response.sendRedirect("company-login.jsp");
        return;
    }

    String companyName =
            (String)session.getAttribute("companyName");
%>

<!DOCTYPE html>
<html>

<head>

    <title>Company Dashboard</title>

    <style>

        body {
            margin: 0;
            font-family: Arial, sans-serif;
            background: #f4f6f8;
        }

        .navbar {
            background: #243b55;
            color: white;
            padding: 20px 40px;
            display: flex;
            justify-content: space-between;
        }

        .navbar a {
            color: white;
            text-decoration: none;
            margin-left: 20px;
        }

        .container {
            padding: 50px;
        }

        h1 {
            color: #243b55;
        }

        .cards {
            display: flex;
            gap: 25px;
            margin-top: 40px;
            flex-wrap: wrap;
        }

        .card {
            width: 250px;
            padding: 30px;
            background: white;
            border-radius: 12px;
            box-shadow: 0 5px 20px rgba(0,0,0,0.1);
            text-align: center;
        }

        .card h2 {
            color: #243b55;
        }

        .btn {
            display: inline-block;
            padding: 12px 20px;
            background: #243b55;
            color: white;
            text-decoration: none;
            border-radius: 6px;
        }

        .btn:hover {
            background: #141e30;
        }

    </style>

</head>

<body>

<div class="navbar">

    <b>Flight Company Panel</b>

    <div>
        <a href="company-dashboard.jsp">Dashboard</a>
        <a href="company-login.jsp">Logout</a>
    </div>

</div>

<div class="container">

    <h1>
        Welcome, <%= companyName %>
    </h1>

    <p>
        Manage your flights and bookings from here.
    </p>

    <div class="cards">

        <div class="card">

            <h2>Add Flight</h2>

            <p>
                Add a new flight to the system.
            </p>

            <a href="add-flight.jsp" class="btn">
                Add Flight
            </a>

        </div>

        <div class="card">

            <h2>Manage Flights</h2>

            <p>
                View, edit and delete your flights.
            </p>

            <a href="ViewFlightServlet" class="btn">
                Manage Flights
            </a>

        </div>

        <div class="card">

            <h2>Bookings</h2>

            <p>
                View passenger bookings.
            </p>

            <a href="ViewBookingServlet" class="btn">
                View Bookings
            </a>

        </div>

    </div>

</div>

</body>
</html>