<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>


<head><title>Login</title></head>

<div class="row">
	<div class="col-md-4 col-md-offset-4">
		<form class="form-signin" role="form" action="<c:url value='/j_spring_security_check' />" method="post">
			<h2 class="form-signin-heading">Καταχώρηση απόδειξης</h2>
			<input name="companyAFM" type="text" class="form-control" placeholder="ΑΦΜ Επιχείρησης" required autofocus>
			<input name="amount" type="password" class="form-control" placeholder="Ποσό απόδειξης" required>
                        <input name="vat" type="afm" class="form-control" placeholder="Ποσό ΦΠΑ" required>
                        <input name="trdate" type="afm" class="form-control" placeholder="Ημερομηνία - Ώρα" required>
                        <input name="tamiaki" type="text" class="form-control" placeholder="Ταμειακή">
                        <input name="customerAFM" type="hidden" class="form-control" value="3e6ee681-11da-11e5-8b86-00155daf5915">
			<button class="btn btn-lg btn-primary btn-block" type="submit">Αποστολή</button>

		</form>
	</div>
</div>


