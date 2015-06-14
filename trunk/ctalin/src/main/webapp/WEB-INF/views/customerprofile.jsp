<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="true" %>


<head><title>Προφίλ Χρήστη</title></head>

<div class="row">
    <div class="col-md-12">
        <div class="jumbotron">
            <br>
            <br>
            <h2>Προφίλ Χρήστη</h2>

        </div>
    </div>
</div>
<div class="row">
    <div class="col-md-1">

    </div>
    <div class="col-md-4">
        <img src="<c:url value='/resources/assets/img/profilepic.png' />"</div>
    </div>

    <div class="col-md-4">
        <h4>Επώνυμο</h4>
        <p>AMZ</p>

        <h4>Όνομα</h4>
        <p>GMOTUX.</p>

        <h4>Ανταμοιβές</h4>
        <p>Maecenas sed diam eget risus varius blandit sit amet non
            magna.</p>
    </div>
</div>
<div class="row">
    <div class="col-md-4"></div>
    <div class="col-md-4">
        <br>
        <h4>Ιστορικό Αγορών</h4>
    </div>
    <div class="col-md-4">
        <br>
        <h4>Κοντά σε Εμένα</h4>
        <img src="<c:url value='/resources/assets/img/epixiriseis.png' />"</div>
    </div>
</div>

<script type="text/javascript">
    $("#signUp").click(function () {
        url = "<c:url value = '/post' />";
        $.post(url, {data: "blah"}, function (json) {
            console.log(json);
        }, "json");
    });
</script>

