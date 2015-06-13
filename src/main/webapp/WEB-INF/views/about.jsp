<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="true" %>


<head><title>Σχετικά</title></head>

<div class="row">
	<div class="col-md-12">
		<div class="jumbotron">
			<h1>Super awesome marketing speak!</h1>
			<p class="lead">Cras justo odio, dapibus ac facilisis in, egestas
				eget quam. Fusce dapibus, tellus ac cursus commodo, tortor mauris
				condimentum nibh, ut fermentum massa justo sit amet risus.</p>
			<a id="signUp" class="btn btn-large btn-success" href="#">Sign up today</a>
		</div>
	</div>
</div>
<div class="row">
	<div class="col-md-8">
		<h4>Subheading</h4>
		<p>Donec id elit non mi porta gravida at eget metus. Maecenas
			faucibus mollis interdum.</p>

		<h4>Subheading</h4>
		<p>Morbi leo risus, porta ac consectetur ac, vestibulum at eros.
			Cras mattis consectetur purus sit amet fermentum.</p>

		<h4>Subheading</h4>
		<p>Maecenas sed diam eget risus varius blandit sit amet non
			magna.</p>
	</div>

	<div class="col-md-4">
		<h4>Subheading</h4>
		<p>Donec id elit non mi porta gravida at eget metus. Maecenas
			faucibus mollis interdum.</p>

		<h4>Subheading</h4>
		<p>Morbi leo risus, porta ac consectetur ac, vestibulum at eros.
			Cras mattis consectetur purus sit amet fermentum.</p>

		<h4>Subheading</h4>
		<p>Maecenas sed diam eget risus varius blandit sit amet non
			magna.</p>
	</div>
</div>

<script type="text/javascript">
	$("#signUp").click(function() {
		url = "<c:url value = '/post' />";
		$.post(url, {data: "blah"}, function(json) {
			console.log(json);
		}, "json");
	});
</script>

