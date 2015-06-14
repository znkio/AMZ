<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>


<head><title>Create User</title></head>

<div class="row">
	<div class="col-md-4">
		<form id="createUserForm" role="form" action="#" method="post">
			<h4>Create New User</h4>
			<div class="form-group">
				<label for="username">Username</label> 
				<input id="username" name="username" data-valid="true" type="text" class="form-control" placeholder="Enter username" required />
			</div>
			<div class="form-group">
				<label for="password">Password</label>
				<input id="password" name="password" type="password" class="form-control" placeholder="Password" required />
			</div>
			<div class="form-group">
				<label for="passwordConfirm">Confirm Password</label>
				<input id="passwordConfirm" name="passwordConfirm" type="password" class="form-control" placeholder="Type Password again" />
			</div>
			<div class="checkbox">
				<label>
					<input type="checkbox" name="enabled" value="true" /> Enabled
				</label>
			</div>
			
			<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
			<div id="formStatusMessage"></div>
			<button id="createUserSubmit" type="button" class="btn btn-primary">Submit</button>
		</form>
	</div>
</div>


<script type="text/javascript">

	// When focus is lost on the username input it takes the value of the input, checks if the user exists
	// on the server. If that is the case then it creates an alert.
	$("#username").blur(function() {
		$("#formStatusMessage").hide();
		var username = $("#username").val();
		if (username != "") {
			$("#username").attr("data-valid", "true");
			var url = "<c:url value = '/secured/users/" + username + "' />";
			
			$.getJSON(url, function(json) {
				var alertData = createAlert("Info:", "Username exists", "alert-info", true);
				$.post("<c:url value='/alert' />", alertData, function(html){
					$("#username").attr("data-valid", "false");
					$("#formStatusMessage").hide().html(html).fadeIn();
				}, "html");
			});
		}
	});

	// Checks if the passwords match when focus is lost from passwordConfirm
	$("#passwordConfirm").blur(function() {
		if(!passwordsMatch()) {
			var alertData = createAlert("Info:", "Passwords do not match", "alert-warning", true);
			$.post("<c:url value='/alert' />", alertData, function(html){
				$("#formStatusMessage").hide().html(html).fadeIn();
			}, "html");
		} else {
			$("#formStatusMessage").hide();
		}
	});
		
	// Submiting the form through ajax
	$("#createUserSubmit").click(function(e) { 
		if(isFormValid()) {
			var formData = JSON.stringify($("#createUserForm").serializeObject());
			$.post("<c:url value='/secured/users' />", formData, function(json){
				var href = "<c:url value='/secured/users/" + json.username + "' />" + "/edit";
				var anchor = '<a href="' + href + '">Edit</a>'; 
				var alertData = createAlert("Success:", "User was created. " + anchor, "alert-success", true);
				$.post("<c:url value='/alert' />", alertData, function(html){
					$("#formStatusMessage").hide().html(html).fadeIn();
				}, "html");
			}, "json");
			e.preventDefault();
		} else {
			var alertData = createAlert("Warning:", "Form is not valid", "alert-warning", true);
			$.post("<c:url value='/alert' />", alertData, function(html){
				$("#formStatusMessage").hide().html(html).fadeIn();
			}, "html");
		}
	});

	// Checks if the password and passwordConfirm inputs match
	function passwordsMatch() {
		match = true;
		var password = $("#password").val();
		var passwordConfirm = $("#passwordConfirm").val();
		if(password != passwordConfirm) {
			match = false;
		}
		return match;
	}
	
	// Checks each field and returns true if the form is valid
	function isFormValid() {
		valid = true;
		var username = $("#username").val();
		// Using data-valid attribute because we aquire the info from the server asynchronously
		var usernameValid = $("#username").attr("data-valid");
		var password = $("#password").val();
		if( username == "" ) {
			valid = false;
		} else if (username != "" && usernameValid == "false") {
			valid = false;
		}
		if( password == "" ) {
			valid = false;
		}
		if( !passwordsMatch() ) {
			valid = false;
		}
		return valid;
	}

	
</script>

