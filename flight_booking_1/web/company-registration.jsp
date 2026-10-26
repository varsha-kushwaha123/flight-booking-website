<!DOCTYPE html>
<html>

<head>

    <title>Company Registration</title>

    <style>

        * {
            box-sizing: border-box;
        }

        body {
            margin: 0;
            font-family: Arial, sans-serif;
            background: linear-gradient(135deg, #141e30, #243b55);
            min-height: 100vh;
        }

        .container {
            width: 500px;
            margin: 60px auto;
            background: white;
            padding: 40px;
            border-radius: 15px;
            box-shadow: 0 10px 30px rgba(0,0,0,0.3);
        }

        h2 {
            text-align: center;
            color: #243b55;
            margin-bottom: 30px;
        }

        label {
            display: block;
            font-weight: bold;
            color: #333;
            margin-top: 12px;
        }

        input {
            width: 100%;
            padding: 12px;
            margin-top: 7px;
            border: 1px solid #ccc;
            border-radius: 6px;
            font-size: 15px;
        }

        input:focus {
            border-color: #243b55;
            outline: none;
        }

        button {
            width: 100%;
            padding: 13px;
            margin-top: 25px;
            background: #243b55;
            color: white;
            border: none;
            border-radius: 6px;
            cursor: pointer;
            font-size: 16px;
        }

        button:hover {
            background: #141e30;
        }

        .login {
            text-align: center;
            margin-top: 20px;
        }

        .login a {
            color: #243b55;
            text-decoration: none;
            font-weight: bold;
        }

        .back {
            display: block;
            text-align: center;
            margin-top: 15px;
            color: #555;
            text-decoration: none;
        }

    </style>

</head>

<body>

<div class="container">

    <h2>Company Registration</h2>

    <form action="CompanyRegistrationServlet" method="post">

        <label>Company Name</label>

        <input
            type="text"
            name="companyName"
            placeholder="Enter company name"
            required
        >


        <label>Email</label>

        <input
            type="email"
            name="email"
            placeholder="Enter email"
            required
        >


        <label>Contact Number</label>

        <input
            type="tel"
            name="contact"
            placeholder="Enter contact number"
            pattern="[0-9]{10}"
            maxlength="10"
            required
        >


        <label>Password</label>

        <input
            type="password"
            name="password"
            placeholder="Enter password"
            required
        >


        <label>Confirm Password</label>

        <input
            type="password"
            name="confirmPassword"
            placeholder="Confirm password"
            required
        >


        <button type="submit">
            Register Company
        </button>

    </form>


    <div class="login">

        Already registered?

        <a href="company-login.jsp">
            Login here
        </a>

    </div>


    <a href="index.jsp" class="back">
         Back to Home
    </a>

</div>

</body>
</html>