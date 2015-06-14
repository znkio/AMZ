<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="true" %>


<head><title>Οι αναφορές μου</title></head>
<div id="blue">
    <div class="container">
        <div class="row">
            <h3>Αποστολή Προσφοράς</h3>
        </div><!-- /row -->
    </div> <!-- /container -->
</div><!-- /blue -->


<div class="container mtb">
    <div class="row">
        
          <div class="col-lg-8">
              <form id ="pushfrm">
                  <h4>Μήνυμα</h4>
<textarea id="message" style="width:350px;height:250px">
                      
</textarea><br />
<button id="btn" value="Αποστολή" >Αποστολή</button>
              </form>


    </div> 
        <div id="outhtml"></div>


    </div><! --/row -->
</div><! --/container -->


<script type="text/javascript">


$( "#btn" ).click(function() {
  alert( "Handler for .click() called." );
});


     var source = $("#entry-template").html();
     var template = Handlebars.compile(source);






    $.ajax({
        url: "<c:url value="/mobile/api/receipts/customer/3aea8d5c-11da-11e5-8b86-00155daf5915"/>",
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


