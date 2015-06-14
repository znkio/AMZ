<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="true" %>


<head><title>Επιχειρήσεις που συμμετέχουν ενεργά και είναι κοντά μου</title></head>

<div class="row">
	<div class="col-md-12">
        <h1>Επιχειρήσεις που συμμετέχουν ενεργά και βρίσκονται κοντά μου</h1>
        <div class=" col-md-12 text-center">
            <img src="resources/assets/img/epixiriseis.png">
            
            <form role="form">
            <div class="form-group">
                <label for="sel1">Ακτίνα σε</label>
                <select name="radius" class="form-control" id="sel1">
                    <option>0.1</option>
                    <option>0.2</option>
                    <option>0.3</option>
                    <option>0.4</option>
                    <option>0.5</option>
                </select>
            </form>
            </div>
            
        </div>
            
	</div>
    <script>
       function draw(){
           console.log("submited");
       }
    </script>    
</div>