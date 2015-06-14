<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="true" %>


<head><title>Αρχική</title></head>
	<!-- *****************************************************************************************************************
	HEADERWRAP
	***************************************************************************************************************** -->
	<div id="headerwrap">
	    <div class="container">
			<div class="row">
                                <div class="col-lg-8 col-lg-offset-2 himg">
                            		<img src="resources/assets/img/amz7.gif" class="img-responsive">
				</div>	
                                <div   class="col-lg-8 col-lg-offset-2">
					<h3>Συμμετέχω|Αποδίδω|Αμόιβομαι</h3>
					<h1>Εφαρμογή Ηλεκτρονική απόδειξης και ανταμοιβής</h1>
					<h5>για να είμαστε nTax(i)!</h5>
				</div>
				
			</div><!-- /row -->
	    </div> <!-- /container -->
	</div><!-- /headerwrap -->

	<!-- *****************************************************************************************************************
	 SERVICE LOGOS
	 ***************************************************************************************************************** -->
	 <div id="service">
	 	<div class="container">
 			<div class="row centered">
 				<div class="col-md-6">
 					<i class="fa fa-heart-o"></i>
 					<h4>Νέα απόδειξη</h4>
 					<p>Ποτέ δεν ήταν ευκολότερο να καταχωρήσετε τις αποδείξεις σας</p>
 					<p><br/><a href="closebr.html#qrcode" class="btn btn-theme">Σκανάρισμα</a></p>
 				</div>
 				<div class="col-md-6">
 					<i class="fa fa-flask"></i>
 					<h4>Προσφορές</h4>
 					<p>Βρείτε τις προσφoρές από επιχειρήσεις κοντά σας</p>
 					<p><br/><a href="#" class="btn btn-theme">Περισσότερα</a></p>
 				</div>
	 		</div>
	 	</div><! --/container -->
	 </div><! --/service -->
	
        
	 
	 
	
	 
    <!-- Bootstrap core JavaScript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js"></script>
    <script src="resources/assets/js/bootstrap.min.js"></script>
	<script src="resources/assets/js/retina-1.1.0.js"></script>
	<script src="resources/assets/js/jquery.hoverdir.js"></script>
	<script src="resources/assets/js/jquery.hoverex.min.js"></script>
	<script src="resources/assets/js/jquery.prettyPhoto.js"></script>
  	<script src="resources/assets/js/jquery.isotope.min.js"></script>
  	<script src="resources/assets/js/custom.js"></script>


    <script>
// Portfolio
(function($) {
	"use strict";
	var $container = $('.portfolio'),
		$items = $container.find('.portfolio-item'),
		portfolioLayout = 'fitRows';
		
		if( $container.hasClass('portfolio-centered') ) {
			portfolioLayout = 'masonry';
		}
				
		$container.isotope({
			filter: '*',
			animationEngine: 'best-available',
			layoutMode: portfolioLayout,
			animationOptions: {
			duration: 750,
			easing: 'linear',
			queue: false
		},
		masonry: {
		}
		}, refreshWaypoints());
		
		function refreshWaypoints() {
			setTimeout(function() {
			}, 1000);   
		}
				
		$('nav.portfolio-filter ul a').on('click', function() {
				var selector = $(this).attr('data-filter');
				$container.isotope({ filter: selector }, refreshWaypoints());
				$('nav.portfolio-filter ul a').removeClass('active');
				$(this).addClass('active');
				return false;
		});
		
		function getColumnNumber() { 
			var winWidth = $(window).width(), 
			columnNumber = 1;
		
			if (winWidth > 1200) {
				columnNumber = 5;
			} else if (winWidth > 950) {
				columnNumber = 4;
			} else if (winWidth > 600) {
				columnNumber = 3;
			} else if (winWidth > 400) {
				columnNumber = 2;
			} else if (winWidth > 250) {
				columnNumber = 1;
			}
				return columnNumber;
			}       
			
			function setColumns() {
				var winWidth = $(window).width(), 
				columnNumber = getColumnNumber(), 
				itemWidth = Math.floor(winWidth / columnNumber);
				
				$container.find('.portfolio-item').each(function() { 
					$(this).css( { 
					width : itemWidth + 'px' 
				});
			});
		}
		
		function setPortfolio() { 
			setColumns();
			$container.isotope('reLayout');
		}
			
		$container.imagesLoaded(function () { 
			setPortfolio();
		});
		
		$(window).on('resize', function () { 
		setPortfolio();          
	});
})(jQuery);
</script>

