<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>


<head><title>Edit User</title></head>

<div class="row">
	<div class="col-md-4">
		<form id="updateUserForm" role="form" action="/secured/users" method="post">
			<h4>Edit user</h4>
			<input id="user-guid" name="guid" type="hidden" value="${u.guid}" />
			<div class="form-group">
				<label for="username">Username</label> 
				<input id="username" name="username" data-valid="true" type="text" class="form-control" value="${u.username}" readonly />
			</div>
			
			<button id="changePasswordButton" type="button" class="btn btn-primary btn-xs">Change Password</button>
			<div id="changePasswordDiv" style="display: none;">
				<div class="form-group">
					<label for="password">Password</label>
					<input id="password" name="password" type="password" data-oldpass="${u.password}" class="form-control" value="" />
				</div>
				<div class="form-group">
					<label for="passwordConfirm">Confirm Password</label>
					<input id="passwordConfirm" name="passwordConfirm" type="password" class="form-control" value="" />
				</div>
			</div>
			<div class="checkbox">
				<label>
					<input type="checkbox" name="enabled" value="true" <c:if test="${u.enabled==true}" >checked</c:if> /> Enabled
				</label>
			</div>
			
			<jsp:include page="_authorities.jsp" />
			
			<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
			<div id="formStatusMessage"></div>
			<button id="updateUserSubmit" type="button" class="btn btn-success">Update</button>
		</form>
	</div>
</div>


<script type="text/javascript">

	$("#changePasswordButton").click(function() {
		$("#changePasswordDiv").slideToggle();
		$("#changePasswordButton").button("toggle");
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
	$("#updateUserSubmit").click(function(e) { 
		if(isFormValid()) {
			var formData = JSON.stringify($("#updateUserForm").serializeObject());
			var username = $("#username").val();
			var url = "<c:url value='/secured/users' />" + "/" + username + "/update";
			$.ajax({
			    url: url,
			    type: 'post',
			    data: formData,
			    success: function(result) {
			    	var alertData = createAlert("Success:", "User was updated", "alert-success", true);
					$.post("<c:url value='/alert' />", alertData, function(html){
						$("#formStatusMessage").hide().html(html).fadeIn();
					}, "html");
			    }
			});
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
		if( password != "" && !passwordsMatch() ) {
			valid = false;
		}
		return valid;
	}

	
</script>

