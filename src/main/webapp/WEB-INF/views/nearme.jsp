<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="true" %>


<head><title>Επιχειρήσεις που συμμετέχουν ενεργά και είναι κοντά μου</title>
 <script src="https://maps.googleapis.com/maps/api/js?v=3.exp&amp;sensor=false"></script>
</head>

<div class="row">
	<div class="col-md-12">
        <h1>Επιχειρήσεις που συμμετέχουν ενεργά και βρίσκονται κοντά μου</h1>
        <div class=" col-md-6 text-center">
            <form role="form">
            <div class="form-group">
                <label for="sel1">Απόσταση σε χιλιόμετρα</label>
                <select name="radius" class="form-control" id="sel1">
                    <option>0.1</option>
                    <option>0.2</option>
                    <option>0.3</option>
                    <option>0.4</option>
                    <option>0.5</option>
                </select>
            </form>
            </div>
            <img src="/resources/assets/img/epixiriseis.png">            
        </div>
            
	</div>
    <script>

[14:49:04] jSon karaoglanis: function initialize() {
                var mapOptions = {
                    zoom: 7,
                    mapTypeId: google.maps.MapTypeId.ROADMAP
                };
                map = new google.maps.Map(document.getElementById('map-canvas'),
                        mapOptions);
                var pos = new google.maps.LatLng(37.89982, 29.509026);
                var image = '../img/fatsa6s.png';
                var myLatlng;
                var marker;
            #{apController.markers}

                map.setCenter(pos);
            }
    </script>    
</div>