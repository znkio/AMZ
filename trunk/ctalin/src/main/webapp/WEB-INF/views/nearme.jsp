<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="true" %>
<head>
    <title>Επιχειρήσεις που συμμετέχουν ενεργά και είναι κοντά μου</title>
    <script src="http://maps.googleapis.com/maps/api/js?v=3.exp&sensor=false&libraries=visualization,drawing,places,weather,geometry"></script>
    <script src="http://ajax.googleapis.com/ajax/libs/jquery/2.0.3/jquery.min.js"></script>
    <script>
        var width = 900,
                height = 600,
                globalOverlay = null,
                map = null;


        function initialize() {
            map = new google.maps.Map(document.getElementById('map-canvas'), {
                zoom: 14,
                center: {lat: 37.9937679, lng: 23.7271820}
            });

            var rad = $("#rad").val();
            var WindCollection = [];

            $.getJSON("<c:url value='/mobile/api/companies/nearme?lat=37.9870858&lot=23.7285054&radius='/>" + rad, function (companies) {
                companies.forEach(function (data) {
                    var latVal = parseFloat(data[2]);
                    var lotVal = parseFloat(data[3]);
                    var marker = new google.maps.Marker({position: {lat: latVal, lng: lotVal}, clickable: true, map: map, animation: google.maps.Animation.DROP});


                    google.maps.event.addListener(marker, 'click', function () {
                        var infowindow = new google.maps.InfoWindow();
                        var infolist = jQuery('<ul></ul>');
                        for (attribute in data) {
                            infolist.append('<li><b>' + attribute + '</b>: ' + data[attribute] + '</li>');
                        }
                        infowindow.setContent('<div class="infowindow">' + infolist.html() + '</div>');
                        infowindow.open(map, marker);
                        map.panTo(marker.getPosition());
                    });
                });
            });

            var latVal = parseFloat("37.9870858");
            var lotVal = parseFloat("23.7285054")
            );
                    var marker = new google.maps.Marker({position: {lat: latVal, lng: lotVal}, clickable: true, map: map, animation: google.maps.Animation.DROP});


            google.maps.event.addListener(marker, 'click', function () {
                var infowindow = new google.maps.InfoWindow();
                var infolist = jQuery('<ul></ul>');

                infolist.append('<li><b>' + "Έχετε έκπτωση 25% στα ρούχα!!" + '</b></li>');

                infowindow.setContent('<div class="infowindow">' + infolist.html() + '</div>');
                infowindow.open(map, marker);
                map.panTo(marker.getPosition());
            });
        }
        google.maps.event.addDomListener(window, 'load', initialize);

    </script>
</head>

<div class="row"><br></div>
<div class="row"><br></div>
<div class="row"><br></div>
<div class="row">
    <div class="col-md-12">
        <h3>Επιχειρήσεις που συμμετέχουν ενεργά και βρίσκονται κοντά μου</h3>
        <div class="row">
            <div class=" col-md-12 text-center">
                <form role="form">
                    <div class="form-group">
                        <label for="sel1">Απόσταση σε χιλιόμετρα</label>
                        <select name="radius" class="form-control" id="rad" onchange="initialize()">
                            <option value="0.1">0.1km</option>
                            <option value="0.2">0.2km</option>
                            <option value="0.3">0.3km</option>
                            <option value="0.4">0.4km</option>
                            <option value="0.5">0.5km</option>
                        </select>
                </form>
            </div>
        </div>
    </div>
    <div class=" col-md-12 text-center">
        <div id="map-canvas"></div>
    </div>

</div>
</div>