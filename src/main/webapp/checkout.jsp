<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Buxar Ka Anand Donation Page</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f4;
            margin: 0;
            padding: 0;
        }
        .container {
            max-width: 800px;
            margin: 20px auto;
            background-color: #fff;
            padding: 20px;
            border-radius: 8px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        }
        h1 {
            text-align: center;
            color: #333;
        }
        h2 {
            color: #555;
        }
        .payment-details {
            margin-bottom: 20px;
        }
        .qr-code {
            text-align: center;
            margin-bottom: 20px;
        }
        img {
            max-width: 100%;
            height: auto;
            border: 1px solid #ddd;
            border-radius: 8px;
        }
        .payment-button {
            text-align: center;
        }
        button {
            padding: 10px 20px;
            background-color: #007bff;
            color: #fff;
            border: none;
            border-radius: 5px;
            cursor: pointer;
        }
        button:hover {
            background-color: #0056b3;
        }

        /* Responsive Styles */
        @media only screen and (max-width: 600px) {
            .container {
                padding: 10px;
            }
        }
    </style>
</head>
<body>
    <div class="container">
        <h1>Buxar Ka Anand Donation Page</h1>
        <div class="payment-details">
            <h2>Payment Details</h2>
            <p>Total Amount: ${sessionScope.user.amount}</p> <!-- Access amount attribute -->
            <p>Name: ${sessionScope.user.name}</p> <!-- Access name attribute -->
            <p>Email Address: ${sessionScope.user.email}</p> <!-- Access email attribute -->
            <p>Phone No: ${sessionScope.user.phoneNo}</p> <!-- Access phone number attribute -->
            <p>Location: ${sessionScope.user.address}</p> <!-- Access location attribute -->
        </div>
        <div class="qr-code">
            <h2>Scan below QR Code to donate money through UPI</h2>
            <img src="${pageContext.request.contextPath}/generateQRCodeWithLogo/${sessionScope.user.amount}" alt="QR Code"> <!-- Adjust the URL and parameters dynamically -->
        </div>
        <div class="payment-button">
            <p>Click below button if your donation payment is completed</p>
            <form action="${pageContext.request.contextPath}/completePayment" method="post">
                <input type="hidden" name="amount" value="${sessionScope.user.amount}"> <!-- Pass the amount dynamically -->
                <button type="submit">Payment Completed !!</button>
            </form>
        </div>
    </div>
</body>
</html>
