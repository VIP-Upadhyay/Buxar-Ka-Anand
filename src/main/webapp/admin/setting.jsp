<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>App Settings</title>
    
<link href="/css/style.css" rel="stylesheet"/>
</head>
<body>

	<div class="navbar">
        <a href="/admin">Donation List</a> 
        <a class="active" href="/admin/settings">App Settings</a><!-- New link -->
        <a class="logout" href="/logout">Logout</a>
    </div>
	
    <div class="container">
        <h1>App Settings</h1>
        <form action="${pageContext.request.contextPath}/admin/saveSettings" method="post">
            <label for="upiId">UPI ID:</label>
            <input type="text" id="upiId" name="upiId" value="${appSetting.upiId}" required>
            <div class="error-message">${errorMessage}</div>
            
            <label for="address">Address:</label>
            <input type="text" id="address" name="address" value="${appSetting.address}" required>
            <div class="error-message">${errorMessage}</div>
            
            <label for="facebookLink">Facebook Link:</label>
            <input type="text" id="facebookLink" name="facebookLink" value="${appSetting.facebookLink}" required>
            <div class="error-message">${errorMessage}</div>
            
            <label for="twitterLink">Twitter Link:</label>
            <input type="text" id="twitterLink" name="twitterLink" value="${appSetting.twitterLink}" required>
            <div class="error-message">${errorMessage}</div>
            
            <label for="instagramLink">Instagram Link:</label>
            <input type="text" id="instagramLink" name="instagramLink" value="${appSetting.instagramLink}" required>
            <div class="error-message">${errorMessage}</div>
            
            <label for="linkedinLink">LinkedIn Link:</label>
            <input type="text" id="linkedinLink" name="linkedinLink" value="${appSetting.linkedinLink}" required>
            <div class="error-message">${errorMessage}</div>
            
            <label for="phoneNo">Phone Number:</label>
            <input type="text" id="phoneNo" name="phoneNo" value="${appSetting.phoneNo}" required>
            <div class="error-message">${errorMessage}</div>
            
            <label for="email">Email:</label>
            <input type="email" id="email" name="email" value="${appSetting.email}" required>
            <div class="error-message">${errorMessage}</div>
            
            <input type="submit" value="Save Settings">
        </form>
    </div>
</body>
</html>
