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

	jQuery(document).ready(function() {
		jQuery('#map-canvas').width(width);
		jQuery('#map-canvas').height(height);
	}); 
	function initialize() {
 		map = new google.maps.Map(document.getElementById('map-canvas'), {
			zoom: 6,
			center: {lat: 37.55, lng: -90.963}
		});

 		var WindCollection=[
 							 {name: 'Place 1', lat: 37.55,  lng:-90 , wind_speed:50, direction:'NW', temperature:'60'},
 							 {name: 'Place 2', lat: 36.15,  lng:-94 , wind_speed:45, direction:'N', temperature:'62'},
 							 {name: 'Place 3', lat: 36.12,  lng:-89 , wind_speed:55, direction:'SE', temperature:'59'}
 							];

 		WindCollection.forEach(function(windplace) {
 			var marker=new google.maps.Marker({position:{lat:windplace.lat, lng:windplace.lng}, clickable:true, map:map, animation:google.maps.Animation.DROP });
 			

 			google.maps.event.addListener(marker,'click',function() {
		 	var infowindow = new google.maps.InfoWindow();
		 	var infolist=jQuery('<ul></ul>');
		 	for (attribute in windplace) {
		 		infolist.append('<li><b>'+attribute+'</b>: '+windplace[attribute]+'</li>');
		 	}
		 	infowindow.setContent('<div class="infowindow">'+infolist.html()+'</div>');
			infowindow.open(map, marker);
			map.panTo(marker.getPosition());
		 	});
 		});

		
		 

		 
	}

	google.maps.event.addDomListener(window, 'load', initialize);

</script>
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
       
        </div>
       <div id="map-canvas"></div>     
	</div>
</div>