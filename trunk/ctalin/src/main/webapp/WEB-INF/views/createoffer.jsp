<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>


<head><title>Δημιουργία Προσφοράς</title></head>

<div class="row">
    <div class="col-md-4 col-md-offset-4">
        <form class="form-signin" role="form" action="<c:url value='/createoffer' />" method="post">
            <h2 class="form-signin-heading">Δημιουργία Προσφοράς</h2>
            <input name="reiceipstno" type="number" class="form-control" placeholder="Αριθ. Αποδείξεων" required autofocus>
            <input name="minamount" type="number" class="form-control" placeholder="Ελάχιστο Ποσό" required>
            <input name="descr" type="text" class="form-control" placeholder="Περιγραφή" required autofocus>
            <button class="btn btn-lg btn-primary btn-block" type="submit">Αποστολή</button>

        </form>
    </div>
</div>


