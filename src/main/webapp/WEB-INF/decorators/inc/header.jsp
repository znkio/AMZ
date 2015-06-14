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
            <li><a class="navbar-brand" href="<c:url value="/contact"/>">CONTACT</a></li>
            <li><a class="navbar-brand" href="<c:url value="/nearme"/>">ΕΠΙΧΕΙΡΗΣΕΙΣ</a></li>
            <li><a class="navbar-brand" href="<c:url value="/reports"/>">ΑΝΑΦΟΡΕΣ</a>
            <ul class="dropdown-menu">
                <li><a href="blog.html">ΠΕΛΑΤΗ</a></li>
                <li><a href="single-post.html">ΕΠΙΧΕΙΡΗΣΗ</a></li>
              </ul>
            </li>
          </ul>
        </div><!--/.nav-collapse -->
      </div>
    </div>
