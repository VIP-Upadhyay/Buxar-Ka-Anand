<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>App Settings</title>
    <style>
    /* Modal styles */
    .modal {
        display: none; /* Hidden by default */
        position: fixed; /* Stay in place */
        z-index: 1000; /* Sit on top */
        left: 0;
        top: 0;
        width: 100%;
        height: 100%;
        overflow: auto; /* Enable scroll if needed */
        background-color: rgba(0, 0, 0, 0.4); /* Black w/ opacity */
    }

    /* Modal content */
    .modal-content {
        background-color: #fefefe;
        margin: 15% auto; /* 15% from the top and centered */
        padding: 20px;
        border: 1px solid #888;
        width: 80%; /* Could be more or less, depending on screen size */
        border-radius: 10px;
        box-shadow: 0 4px 8px rgba(0, 0, 0, 0.2);
    }

    /* Close button */
    .close {
        color: #aaa;
        float: right;
        font-size: 28px;
        font-weight: bold;
    }

    .close:hover,
    .close:focus {
        color: black;
        text-decoration: none;
        cursor: pointer;
    }
</style>
    
<link href="/css/style.css" rel="stylesheet"/>
</head>
<body>

	<div class="navbar">
        <a href="/admin">Donation List</a> 
        <a   href="/admin/suggestion">Suggstion List</a> 
        <a class="active" href="/admin/settings">App Settings</a><!-- New link -->
        <a class="logout" href="/logout">Logout</a>
    </div>
	
    <div class="container">
        <h1>App Settings</h1>
        <form action="${pageContext.request.contextPath}/admin/saveSettings" method="post">
            <label for="upiId">UPI ID:</label>
            <input type="text" id="upiId" name="upiId" value="${appSetting.upiId}" >
            <div class="error-message">${errorMessage}</div>
            
            <label for="address">Address:</label>
            <input type="text" id="address" name="address" value="${appSetting.address}" >
            <div class="error-message">${errorMessage}</div>
            
            <label for="facebookLink">Facebook Link:</label>
            <input type="text" id="facebookLink" name="facebookLink" value="${appSetting.facebookLink}" >
            <div class="error-message">${errorMessage}</div>
            
            <label for="twitterLink">Twitter Link:</label>
            <input type="text" id="twitterLink" name="twitterLink" value="${appSetting.twitterLink}" >
            <div class="error-message">${errorMessage}</div>
            
            <label for="instagramLink">Instagram Link:</label>
            <input type="text" id="instagramLink" name="instagramLink" value="${appSetting.instagramLink}" >
            <div class="error-message">${errorMessage}</div>
            
            <label for="linkedinLink">LinkedIn Link:</label>
            <input type="text" id="linkedinLink" name="linkedinLink" value="${appSetting.linkedinLink}" >
            <div class="error-message">${errorMessage}</div>
            
            <label for="phoneNo">Phone Number:</label>
            <input type="text" id="phoneNo" name="phoneNo" value="${appSetting.phoneNo}" >
            <div class="error-message">${errorMessage}</div>
            
            <label for="email">Email:</label>
            <input type="email" id="email" name="email" value="${appSetting.email}" >
            <div class="error-message">${errorMessage}</div>
            
            <input type="submit" value="Save Settings">
            
        </form>
    </div>
    
    <div id="updateModal" class="modal" style="display: none;">
        <div class="modal-content">
            <span class="close" onclick="closeModal()">&times;</span>
            <p>Settings updated successfully!</p>
        </div>
    </div>

    <script>
        // Function to show modal if isUpdate is true
        function showModal() {
            var isUpdate = "${isUpdate}";
            if (isUpdate === "true") {
                document.getElementById('updateModal').style.display = "block";
            }
            console.log(isUpdate);
        }

        // Function to close modal
        function closeModal() {
            document.getElementById('updateModal').style.display = "none";
        }

        // Call showModal function when the page loads
        window.onload = showModal;
    </script>
    
    
</body>
</html>
