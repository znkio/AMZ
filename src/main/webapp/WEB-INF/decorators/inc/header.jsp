<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="decorator" uri="http://www.opensymphony.com/sitemesh/decorator"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>



<!-- Fixed navbar -->
<div class="navbar navbar-default navbar-fixed-top" role="navigation">
    <div class="container">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="<c:url value="/mobile"/>">nTax</a>
        </div>
        <div class="navbar-collapse collapse navbar-right">
            <ul class="nav navbar-nav">
                <li class="active"><a class="navbar-brand" href="<c:url value="/mobile"/>">HOME</a></li>
                <li><a class="navbar-brand" href="<c:url value="/about"/>">ABOUT</a></li>
                <li><a class="navbar-brand" href="<c:url value="/nearme"/>">ΕΠΙΧΕΙΡΗΣΕΙΣ</a></li>
                <li><a class="navbar-brand" href="<c:url value='/mobile/view/report/customer/' />">ΑΝΑΦΟΡΕΣ ΠΕΛΑΤΗ</a></li>
                <li><a class="navbar-brand" href="<c:url value='/createoffer/'/>">ΔΗΜΙΟΥΡΓΙΑ ΠΡΟΣΦΟΡΑΣ</a></li>
                <li><a class="navbar-brand" href="<c:url value='/customerprofile/' />">ΠΡΟΦΙΛ ΧΡΗΣΤΗ</a></li>
                <li><a class="navbar-brand" href="<c:url value='/companyprofile/' />">ΠΡΟΦΙΛ ΕΠΙΧΕΙΡΗΣΗΣ</a></li>
                <li><a class="navbar-brand" href="<c:url value="/register"/>">REGISTER</a></li>
                <li><a class="navbar-brand" href="<c:url value="/contact"/>">CONTACT</a></li>
            </ul>
        </div><!--/.nav-collapse -->
    </div>
</div>
