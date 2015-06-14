<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>


<head><title>Login</title></head>

<div class="row">
	<div class="col-md-4 col-md-offset-4">
		<form class="form-signin" role="form" action="<c:url value='/j_spring_security_check' />" method="post">
			<h2 class="form-signin-heading">Please sign in</h2>
			<c:if test="${not empty param.login_error}">
				<div class="alert alert-danger"> Invalid username and password. </div>
			</c:if>
			<c:if test="${not empty param.logout}">
				<div class="alert alert-success"> You have been logged out. </div>
			</c:if>
			<input name="j_username" type="text" class="form-control" placeholder="Email address" required autofocus>
			<input name="j_password" type="password" class="form-control" placeholder="Password" required>
			<label class="checkbox">
				<input type="checkbox" name='_spring_security_remember_me' value="true"> Remember me
			</label>
			<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
			<button class="btn btn-lg btn-primary btn-block" type="submit">Sign in</button>
		</form>
	</div>
</div>


