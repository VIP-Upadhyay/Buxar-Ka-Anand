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
        
        .copy-button {
            background-color: #007bff;
            color: #fff;
            border: none;
            padding: 10px 20px;
            border-radius: 5px;
            cursor: pointer;
            transition: background-color 0.3s ease;
            position: relative;
            margin:10px auto;
        }

        .copy-button:hover {
            background-color: #0056b3;
        }

        /* Tooltip container */
        .tooltip {
            visibility: hidden;
            background-color: black;
            color: #fff;
            text-align: center;
            padding: 5px;
            border-radius: 6px;
            position: absolute;
            z-index: 1;
            bottom: 125%;
            left: 50%;
            transform: translateX(-50%);
            opacity: 0;
            transition: opacity 0.3s;
        }

        /* Tooltip arrow */
        .tooltip::after {
            content: "";
            position: absolute;
            top: 100%;
            left: 50%;
            margin-left: -5px;
            border-width: 5px;
            border-style: solid;
            border-color: black transparent transparent transparent;
        }

        /* Show the tooltip */
        .show-tooltip {
            visibility: visible;
            opacity: 1;
        }

        /* Responsive Styles */
        @media only screen and (max-width: 600px) {
            .container {
                padding: 10px;
            }
        }
    </style>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.2/css/all.min.css">
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
            <img src="${pageContext.request.contextPath}/generateQRCodeWithLogo/${sessionScope.user.amount}" alt="QR Code"> 
            <h2>Donate money through Direct UPI Id if QR Code is not working</h2>
            <div class="ucontainer">
		        <div id="copyContent" class="content">
		       		${upiId}
			    </div>
			    <button class="copy-button" onclick="copyToClipboard()">
			        <i class="fas fa-copy"></i> Copy UPI ID
			        <span id="tooltip" class="tooltip">UPI ID Copied</span>
			    </button>
		    </div>
            <!-- Adjust the URL and parameters dynamically -->
        </div>
        <div class="qr-code">
            <h2>Bank Details to donate money through NEFT</h2>
            <p>ICICI Bank <br>
			Name: Anand Mishra <br>
			Account No: 046501510541 <br>
			IFSC Code: ICIC0000465</p> <!-- Access amount attribute -->
            
        </div>
        
        <style>
	        .fcontainer {
			    max-width: 400px;
			    margin: 50px auto;
			    background-color: #fff;
			    padding: 20px;
			    border-radius: 5px;
			    box-shadow: 0 2px 5px rgba(0, 0, 0, 0.1);
			}
			
			h1 {
			    text-align: center;
			    margin-bottom: 20px;
			}
			
			.form-group {
			    margin-bottom: 20px;
			}
			
			.input-file {
			    display: none;
			}
			
			.file-label {
			    background-color: #007bff;
			    color: #fff;
			    padding: 10px 15px;
			    border-radius: 5px;
			    cursor: pointer;
			    display: inline-block;
			}
			
			.btn {
			    background-color: #007bff;
			    color: #fff;
			    padding: 10px 20px;
			    border: none;
			    border-radius: 5px;
			    cursor: pointer;
			    display: block;
			    width: 100%;
			    transition: background-color 0.3s ease;
			}
			
			.btn:hover {
			    background-color: #0056b3;
			}
			#imageName{
				margin-bottom:10px;
			}
        
        </style>
         <div class="fcontainer">
	        <p>Upload your payment screenshot if donation is completed</p>
	        <form action="${pageContext.request.contextPath}/completePayment" method="post" enctype="multipart/form-data">
	            <div class="form-group">
	                <input type="file" name="file" id="file" class="input-file" onchange="showFileName()" accept="image/png, image/jpg, image/jpeg" required>
	                <label for="file" class="file-label">Upload a screenshot of your payment</label>
	            </div>
	            <div id="imageName"></div>
	            <button type="submit" class="btn">Submit Screenshot</button>
	        </form>
	    </div>
	    <div>
	    <input type="hidden" id="upiId" value="${upiId}">
        <script>
	        function redirectToUPIApp() {
	            // Replace "upi://pay" with the appropriate UPI URL scheme
	            // Append the amount parameter to the URL scheme
	          	var upi = document.getElementById("upiId");
	        	
	            var amt=${sessionScope.user.amount};
	            var tm = ${sessionScope.user.transactionMessage};
	            window.location.href = "paytmmp://pay?pa=" +  upi.value+ "&am=" + amt + "&tn=" +tm+"&mc=1234&tr=01234";
	        }
	    </script>
	    <script>
        function showFileName() {
            var fileInput = document.getElementById('file');
            var fileNameDisplay = document.getElementById('imageName');
            
            // Check if files are selected
            if (fileInput.files.length > 0) {
                // Display the name of the first selected file
                fileNameDisplay.innerHTML = "selected file is "+fileInput.files[0].name;
            }
        }
    </script>
      <script>
        function copyToClipboard() {
            var copyText = document.getElementById("copyContent");
            var range = document.createRange();
            range.selectNode(copyText);
            window.getSelection().removeAllRanges();
            window.getSelection().addRange(range);
            document.execCommand("copy");
            window.getSelection().removeAllRanges();

            var tooltip = document.getElementById("tooltip");
            tooltip.classList.add("show-tooltip");
            setTimeout(function() {
                tooltip.classList.remove("show-tooltip");
            }, 5000); // Hide tooltip after 5 seconds
        }
    </script>
    </div>
</body>
</html>
