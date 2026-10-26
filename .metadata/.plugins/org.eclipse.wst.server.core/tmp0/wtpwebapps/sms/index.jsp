<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>

<style>
    * {
        box-sizing: border-box;
        font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
    }

    body {
        margin: 0;
        height: 100vh;
        display: flex;
        justify-content: center;
        align-items: center;
        background: linear-gradient(135deg, #00c6ff, #0072ff, #8e2de2, #ff416c);
        background-size: 400% 400%;
        animation: gradientMove 10s ease infinite;
    }

    @keyframes gradientMove {
        0% { background-position: 0% 50%; }
        50% { background-position: 100% 50%; }
        100% { background-position: 0% 50%; }
    }

    .card {
        width: 400px;
        padding: 35px;
        border-radius: 20px;
        background: rgba(255, 255, 255, 0.15);
        backdrop-filter: blur(15px);
        box-shadow: 0 25px 50px rgba(0,0,0,0.3);
        text-align: center;
        color: white;
    }

    .card h1 {
        margin-bottom: 25px;
        font-size: 28px;
        letter-spacing: 1px;
        text-shadow: 0 0 12px rgba(255,255,255,0.8);
    }

    input {
        width: 100%;
        padding: 14px;
        margin: 10px 0;
        border-radius: 10px;
        border: none;
        outline: none;
        font-size: 15px;
        background: rgba(255,255,255,0.95);
        transition: 0.3s;
    }

    input:focus {
        transform: scale(1.04);
        box-shadow: 0 0 15px #00eaff;
    }

    .submit-btn {
        width: 100%;
        padding: 14px;
        margin-top: 15px;
        border-radius: 12px;
        border: none;
        background: linear-gradient(90deg, #ff512f, #dd2476);
        color: white;
        font-size: 16px;
        font-weight: bold;
        cursor: pointer;
        transition: 0.4s;
        box-shadow: 0 10px 25px rgba(221,36,118,0.6);
    }

    .submit-btn:hover {
        transform: translateY(-4px) scale(1.05);
        box-shadow: 0 20px 40px rgba(221,36,118,0.9);
    }

    .viewall-btn {
        display: block;
        margin-top: 18px;
        padding: 14px;
        border-radius: 12px;
        text-decoration: none;
        background: linear-gradient(90deg, #00f260, #0575e6);
        color: white;
        font-weight: bold;
        transition: 0.4s;
        box-shadow: 0 10px 25px rgba(5,117,230,0.6);
    }

    .viewall-btn:hover {
        transform: translateY(-4px) scale(1.05);
        box-shadow: 0 20px 40px rgba(5,117,230,0.9);
    }
</style>



</head>
<body>
<h1>welcome to student portal</h1>

<div class="card">
    <h1>Welcome to Student Portal</h1>

    <form action="save">
        <input type="text" name="id" placeholder="Enter Student ID">
        <input type="text" name="name" placeholder="Enter Student Name">
        <input type="email" name="email" placeholder="Enter Email">
        <input type="text" name="phoneno" placeholder="Enter Phone Number">
        <button type="submit" class="submit-btn">Submit</button>
    </form>

    <a href="viewall" class="viewall-btn">View All Students</a>
</div>






</body>
</html>