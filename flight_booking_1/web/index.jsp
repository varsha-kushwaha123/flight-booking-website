<!DOCTYPE html>
<html>
<head>
    <title>Online Flight Reservation</title>

    <style>
        body {
            margin: 0;
            font-family: Arial, sans-serif;
            background: linear-gradient(135deg, #0f2027, #203a43, #2c5364);
            color: white;
        }

        .navbar {
            padding: 20px 60px;
            display: flex;
            justify-content: space-between;
            align-items: center;
            background: rgba(0,0,0,0.3);
        }

        .logo {
            font-size: 25px;
            font-weight: bold;
        }

        .container {
            text-align: center;
            margin-top: 150px;
        }

        h1 {
            font-size: 50px;
            margin-bottom: 20px;
        }

        p {
            font-size: 20px;
            margin-bottom: 40px;
        }

        .btn {
            display: inline-block;
            padding: 15px 30px;
            margin: 10px;
            background: white;
            color: #203a43;
            text-decoration: none;
            border-radius: 8px;
            font-weight: bold;
        }

        .btn:hover {
            background: #00c6ff;
            color: white;
        }
    </style>
</head>

<body>

<div class="navbar">
    <div class="logo"> Online Flight Reservation</div>
</div>

<div class="container">

    <h1>Welcome</h1>

    <p>
        Manage flights and bookings easily with our
        Online Flight Reservation System.
    </p>

    <a href="company-registration.jsp" class="btn">
      Register your Flight Company
    </a>

</div>

</body>
</html>