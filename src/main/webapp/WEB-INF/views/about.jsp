<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="true" %>


<head><title>Σχετικά</title></head>

<div class="row">
    <div class="col-md-12">
        <div class="jumbotron">
            <br>
            <br>
            <h2>Εφαρμογή Ηλεκτρονικής Απόδειξης</h2>
            <p class="lead">Ο έξυπνότερος τρόπος να διαχειρίζεστε τις αποδείξεις σας κερδίζοντας προσφορές!</p>
            <a id="signUp" class="btn btn-large btn-success text-center"  href="#">Εγγραφείτε Σήμερα</a>
        </div>
    </div>
</div>
<div class="row">
    <div class="col-md-1">

    </div>
    <div class="col-md-8">
        <h4>Εύκολη καταχώρηση με ένα κλικ!</h4>
        <p>Καταχωρήστε εύκολα τις αποδείξεις από κάθε αγορά σας απλά με ένα scan.</p>

        <h4>Διατήρηση Αρχείου</h4>
        <p>Οργανώστε τις αποδείξεις σας και αποκτήστε καλύτερη εικόνα και έλεγχο των αγορών σας.</p>

        <h4>Μοναδικές Προσφορές!</h4>
        <p>Κάθε συνεργαζόμενη επιχείρηση ανταμοίβει την συμμετοχή σας με κυλιόμενες προσφορές.</p>
    </div>

    <div class="col-md-4">
        <h4>Development Team</h4>
        <p>AMZ</p>

        <h4>Lead Programmmer</h4>
        <p>GMOTUX.</p>

        <h4>Minions</h4>
        <p>Maecenas sed diam eget risus varius blandit sit amet non
            magna.</p>
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

