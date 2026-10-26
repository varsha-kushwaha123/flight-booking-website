<!DOCTYPE html>
<html>
<head>

    <title>Company Login</title>

    <style>

        body {
            margin: 0;
            font-family: Arial, sans-serif;
            background: linear-gradient(135deg, #141e30, #243b55);
        }

        .container {
            width: 400px;
            margin: 100px auto;
            background: white;
            padding: 40px;
            border-radius: 15px;
            box-shadow: 0px 10px 30px rgba(0,0,0,0.3);
        }

        h2 {
            text-align: center;
            margin-bottom: 30px;
            color: #243b55;
        }

        label {
            font-weight: bold;
        }

        input {
            width: 100%;
            padding: 12px;
            margin: 8px 0 20px;
            border: 1px solid #ccc;
            border-radius: 6px;
            box-sizing: border-box;
        }

        button {
            width: 100%;
            padding: 13px;
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

        .back {
            display: block;
            text-align: center;
            margin-top: 20px;
            text-decoration: none;
            color: #243b55;
        }

    </style>

</head>

<body>

<div class="container">

    <h2>Flight Company Login</h2>

    <form action="CompanyLoginServlet" method="post">

        <label>Email</label>

        <input
            type="email"
            name="email"
            required
        >

        <label>Password</label>

        <input
            type="password"
            name="password"
            required
        >

        <button type="submit">
            Login
        </button>

    </form>

    <a href="index.jsp" class="back">
         Back to Home
    </a>

</div>

</body>
</html>