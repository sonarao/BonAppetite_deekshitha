<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isELIgnored="false"%>

<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style type="text/css">
.error {
	color: red;
}

.imgcontainer {
	text-align: center;
	margin: 24px 0 12px 0;
	position: relative;
}

img.avatar {
	width: 8%;
	border-radius: 4%;
}

input[type=submit] {
	background-color: #4CAF50;
	color: white;
	padding: 14px 20px;
	margin: 8px 0;
	border: none;
	cursor: pointer;
	width: 40%;
}

input[type=text], input[type=password] {
	width: 40%;
	padding: 12px 20px;
	margin: 8px 0;
	display: inline-block;
	border: 1px solid #ccc;
	box-sizing: border-box;
}

.login-box {
	width: 700px;
	position: absolute;
	top: 45%;
	left: 65%;
	transform: translate(-50%, -50%);
	color: white;
}

.textbox {
	width: 100%;
	overflow: hidden;
	font-size: 17px;
	padding: 8px 0;
	margin: 8px 0;
	align-items: center;
}

.login-box a.forgotpassword {
	color: #1366eb;
	font-family: sans-seriff;
	align-self: center;
}

.login-box a.register {
	color: #1366eb;
	font-family: sans-seriff;
	align-self: center;
}

body {
	background-image:
		url("https://media.gettyimages.com/photos/pasta-ingredients-picture-id635920906?s=2048x2048");
	height: 100%;
	background-position: center;
	background-repeat: no-repeat;
	background-size: auto;
	position: relative;
}
</style>
</head>
<body>

	<form:form action="/demopro/validate" method="POST"
		modelAttribute="login">
		<div class="imgcontainer">

			<img
				src="data:image/png;base64,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"
				alt="Avatar" class="avatar">
		</div>

		<div class="login-box">
			<div class="textbox">
				<b>EMAIL</b><br>
				<form:input path="email" placeholder="Enter Email" />

				<form:errors path="email" cssClass="error"></form:errors>
			</div>

			<div class="textbox">

				<b>PASSWORD</b><br>
				<form:input path="password" type="password" placeholder="Enter Password"></form:input>
				<form:errors path="password" type="password" cssClass="error"></form:errors>

			</div>




			<td colspan="3"><c:choose>
					<c:when test="${hasError}">
						<center>
							<h4 class="error">Invalid Credentials</h4>
						</center>
					</c:when>
					<c:otherwise>

					</c:otherwise>
				</c:choose></td> <input type="submit" value="Login" /><br> <br>

			<h3>
				<a href="/demopro/Login" class="register" style="text-align: center">New
					User? Sign up</a>
			</h3>

		</div>
		<center></center>

	</form:form>


</body>
</html>