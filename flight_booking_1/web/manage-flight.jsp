<%
    if(session.getAttribute("companyId") == null)
    {
        response.sendRedirect("company-login.jsp");
        return;
    }
%>

<!DOCTYPE html>
<html>

<head>

    <title>Manage Flights</title>

    <style>

        body {
            font-family: Arial;
            background: #f4f6f8;
            margin: 0;
        }

        .container {
            text-align: center;
            padding: 100px;
        }

        h1 {
            color: #243b55;
        }

        .btn {
            display: inline-block;
            padding: 14px 25px;
            background: #243b55;
            color: white;
            text-decoration: none;
            border-radius: 6px;
            margin: 10px;
        }

    </style>

</head>

<body>

<div class="container">

    <h1>Manage Flights</h1>

    <a href="ViewFlightServlet" class="btn">
        View All Flights
    </a>

    <a href="add-flight.jsp" class="btn">
        Add New Flight
    </a>

    <a href="company-dashboard.jsp" class="btn">
        Dashboard
    </a>

</div>

</body>
</html>