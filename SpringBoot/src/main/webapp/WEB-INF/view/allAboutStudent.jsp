<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
     <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<link type="text/css" rel="stylesheet"
	href="css/main.css" />
<link rel="stylesheet"
	href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<script src="https://co.4.js"></script>
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
<script src="js/mask.js"></script>
<script src="js/main.js"></script>

<style>
label, input {
	display: block;
}

input.text {
	margin-bottom: 12px;
	width: 95%;
	padding: .4em;
}

h1 {
	font-size: 1.2em;
	margin: .6em 0;
}

.ui-dialog .ui-state-error {
	padding: .3em;
}

.validateTips {
	border: 1px solid transparent;
	padding: 0.3em;
}
</style>

</head>

<body id="body" onload="refreshTable();">


	<div class="content">
		<h1>Student List</h1>

		<div class="left">
			<table id="contactTable" class="contactTable">
				<thead>
					<tr>
						<th>#</th>
						<th>Name</th>
						<th>Geder</th>
						<th>Student Number</th>
						<th colspan="2">Options</th>
					</tr>
				</thead>
			</table>
			
		</div>
		<div class="right">
			<button id="contactAddButton" class="contactAddButton"
				onclick="openAddPopup();">Add</button>
		</div>
		<div id="dialog-form" title="Add Student">
			<p class="validateTips">All form fields are required.</p>
			<form>
				<fieldset>
					<table>
						<tr>
							<td><label for="nameInput">Name:</label></td>
							<td><input type="text" name="name" id="nameInput"
								class="text ui-widget-content ui-corner-all"></td>
						</tr>
						<tr>
							<td><label for="genderInput">Gender:</label></td>
							<td><input type="text" name="gender" id="genderInput"
								class="text ui-widget-content ui-corner-all"></td>
						</tr>
						<tr>
							<td><label for="studentNumberInput">Student Number:</label></td>
							<td><input type="text" name="studentNumber"
								id="studentNumberInput"
								class="text ui-widget-content ui-corner-all"></td>
						</tr>
						<!-- Allow form submission with keyboard without duplicating the dialog button -->
						<input type="submit" tabindex="-1"
							style="position: absolute; top: -1000px">
						</tr>
					</table>
				</fieldset>
			</form>
		</div>
		
		<div id="dialog-edit" title="Edit Student">
			<p class="validateTips">All form fields are required.</p>
			<form>
				<fieldset>
					<table>
						<tr>
							<td><label for="nameInput2">Name:</label></td>
							<td><input type="text" name="name2"
								id="nameInput2"
								class="text ui-widget-content ui-corner-all"></td>
						</tr>
						<tr>
							<td><label for="genderInput2">Gender:</label></td>
							<td><input type="text" name="gender2" id="genderInput2"
								class="text ui-widget-content ui-corner-all"></td>
						</tr>
						<tr>
							<td><label for="studentNumberInput2">Student number:</label></td>
							<td><input type="text" name="studentNumber2"
								id="studentNumberInput2"
								class="text ui-widget-content ui-corner-all"></td>
						</tr>
						<!-- Allow form submission with keyboard without duplicating the dialog button -->
						<input type="submit" tabindex="-1"
							style="position: absolute; top: -1000px">
						</tr>
					</table>
				</fieldset>
			</form>
		</div>
		
		<div id="dialog-confirm" title="Delete Student">
			<p>
				<span class="ui-icon ui-icon-alert"
					style="float: left; margin: 12px 12px 20px 0;"></span>This contact
				will be permanently deleted and cannot be recovered. Are you sure?
			</p>
		</div>
		
		<div id="dialog-message" title="Message">
			<p class="message">
				<span class="ui-icon ui-icon-circle-check"
					style="float: left; margin: 0 7px 50px 0;"></span>
			</p>
		</div>
	</div>
</body>
</html>