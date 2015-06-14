<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="true" %>


<head><title>Προφίλ Επιχείρησης</title></head>

<div class="row">
    <div class="col-md-12">
        <div class="jumbotron">
            <br>
            <br>
            <h2>Προφίλ Επιχείρησης</h2>


        </div>
    </div>
</div>
<div class="row">
    <div class="col-md-1 ">

    </div>
    <div class="col-md-4 ">

        <img src="<c:url value='/resources/assets/img/MyBusiness.jpg' />"</div>
</div>
<div class="col-md-4 counterbadge">
    <h2 >1000 Check In!</h2>


</div>
</div>

<div class="row">
    <div class="col-md-1">

    </div>
    <div class="col-md-8">
        <h4>Επωνυμία Επιχείρησης</h4>
        <br>

        <h4>Τοποθεσία</h4>
        <img src="<c:url value='/resources/assets/img/samplemap.png' />"</div>

</div>
<div class="col-md-4">
    <h4>Βρείτε μας στο Facebook</h4>
    <br>

    <h4>Βρείτε μας στο Foursquare</h4>
    <br>

    <h4>Επικοινωνία</h4>
    <p>210 616 2254</p>
    <p>myBusiness@nobusiness.nope</p>
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

