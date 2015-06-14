<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="true" %>


<script type="text/javascript">
    var qstring = (window.location + "").split("?")[1];

//    var receipt = {
//        "receiptNumber": 1234,
//        "totalAmount": 145.45,
//        "vatAmount": 14.44,
//        "transactionDate": 1434204780775,
//        "tamiaki": 1,
//        "customerID": {
//            "customerId": "3aea8d5c-11da-11e5-8b86-00155daf5915"
//        }
//    };
    var receipt = {};
    var params = qstring.split("&");
    for (var index = 0; index < params.length; index++) {
        param = params[index];
        var key = param.split("=")[0];
        receipt[key] = decodeURI(param.split("=")[1]);
    }
    receipt.customerID = {
        "customerId": "3aea8d5c-11da-11e5-8b86-00155daf5915"
    }

    var custID = "3aea8d5c-11da-11e5-8b86-00155daf5915"
    //ajax to mobile/api/receipts/customer/{}
    $.ajax({
        url: "<c:url value="/mobile/api/receipts/customer/"/>" + custID,
        type: "POST",
        data: JSON.stringify(receipt),
        dataType: "json",
        contentType: "application/json; charset=utf-8",
    }).success(function (data, responce) {
        alert("success in submiting the receipt")
    }).error(function (data, responce)
    {
        alert("problem submiting the receipt.")
    });
</script>

