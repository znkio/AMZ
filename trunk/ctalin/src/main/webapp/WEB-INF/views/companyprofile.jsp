<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="true" %>


<head><title>Σχετικά</title></head>

<div class="row">
    <div class="col-md-12">
        <div class="jumbotron">
            <br>
            <br>
            <h2>Προφίλ Επιχείρησης</h2>

            <a id="signUp" class="btn btn-large btn-success text-center"  href="#">Εγγραφείτε Σήμερα</a>
        </div>
    </div>
</div>
<div class="row">
    <div class="col-md-1">

    </div>
    <div class="col-md-8">
        <img src="" width="200px" height="200px"

             <
    </div>

    <div class="col-md-4">
        <h4>Counter</h4>


    </div>
</div>
<div class="row">
    <h2>Επωνυμία Επιχείρησης</h2>
    <br>
    <div>MAP</div>
    
</div>

<script type="text/javascript">
    $("#signUp").click(function () {
        url = "<c:url value = '/post' />";
        $.post(url, {data: "blah"}, function (json) {
            console.log(json);
        }, "json");
    });
</script>

