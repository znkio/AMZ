<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="true" %>


<head><title>Οι αναφορές μου</title></head>
<div id="blue">
    <div class="container">
        <div class="row">
            <h3>Οι Αποδείξεις μου...</h3>
        </div><!-- /row -->
    </div> <!-- /container -->
</div><!-- /blue -->


<div class="container mtb">
    <div class="row">

        <div id="outhtml"></div>


    </div><! --/row -->
</div><! --/container -->

<script id="entry-template" type="text/x-handlebars-template">
    <div class="col-lg-8">{{companyID.catID.description}}
    <! -- Blog Post 1 -->
    <a href=""><h3 class="ctitle">{{companyID.title}}</h3></a>
    <p><csmall>ΑΦΜ {{companyID.companyAFM}}</csmall> | <csmall2>{{companyID.address}}</csmall2></p>
    <p><strong>ΠΟΣΟ {{totalAmount}}</strong> </p>
   
    <div class="hline"></div>

    <div class="spacing"></div>


    </div>      
</script>

<script type="text/javascript">

     var source = $("#entry-template").html();
     var template = Handlebars.compile(source);






    $.ajax({
        url: "<c:url value="http://172.16.177.148:8080/ctalin/mobile/api/receipts/customer/3aea8d5c-11da-11e5-8b86-00155daf5915"/>",
        type: "GET",
        // data: JSON.stringify(receipt),
        dataType: "json",
        contentType: "application/json; charset=utf-8",
    }).success(function (data, responce) {
        for (var i = 0; i < data.length; i++) {
            var receipt = data[i];
            $("#outhtml").append( template(receipt) );
        }
    }).error(function (data, responce)
    {
        alert("problem ")
    });



</script>


