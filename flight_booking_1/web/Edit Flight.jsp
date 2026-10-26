<%
    if(session.getAttribute("companyId") == null)
    {
        response.sendRedirect("company-login.jsp");
        return;
    }

    String id = request.getParameter("id");
%>

<!DOCTYPE html>
<html>

<head>

    <title>Edit Flight</title>

    <style>

        body {
            margin: 0;
            font-family: Arial;
            background: #f4f6f8;
        }

        .container {
            width: 600px;
            margin: 50px auto;
            background: white;
            padding: 35px;
            border-radius: 12px;
            box-shadow: 0 5px 20px rgba(0,0,0,0.1);
        }

        h2 {
            text-align: center;
            color: #243b55;
        }

        label {
            font-weight: bold;
        }

        input {
            width: 100%;
            padding: 11px;
            margin: 7px 0 18px;
            box-sizing: border-box;
            border: 1px solid #ccc;
            border-radius: 5px;
        }

        button {
            width: 100%;
            padding: 13px;
            background: #243b55;
            color: white;
            border: none;
            border-radius: 6px;
            cursor: pointer;
        }

        .back {
            display: block;
            text-align: center;
            margin-top: 20px;
        }

    </style>

</head>

<body>

<div class="container">

    <h2>Edit Flight</h2>

    <form action="UpdateFlightServlet" method="post">

        <input
            type="hidden"
            name="flightId"
            value="<%= id %>"
        >

        <label>Flight Number</label>

        <input
            type="text"
            name="flightNo"
            required
        >

        <label>Source</label>

        <input
            type="text"
            name="source"
            required
        >

        <label>Destination</label>

        <input
            type="text"
            name="destination"
            required
        >

        <label>Departure Time</label>

        <input
            type="datetime-local"
            name="departureTime"
            required
        >

        <label>Arrival Time</label>

        <input
            type="datetime-local"
            name="arrivalTime"
            required
        >

        <label>Fare</label>

        <input
            type="number"
            name="fare"
            step="0.01"
            required
        >

        <label>Total Seats</label>

        <input
            type="number"
            name="totalSeats"
            required
        >

        <label>Available Seats</label>

        <input
            type="number"
            name="availableSeats"
            required
        >

        <button type="submit">
            Update Flight
        </button>

    </form>

    <a href="ViewFlightServlet" class="back">
         Back to Flights
    </a>

</div>

</body>
</html>