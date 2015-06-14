<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>


<div class="table-responsive">
	<table id="authoritiesTable" class="table table-condensed table-bordered table-hover table-striped">
		<thead>
			<tr>
				<th>Authorities</th>
				<th><button id="addAuthority" data-username="${u.username}" type="button" class="btn btn-primary btn-xs"><i class="glyphicon glyphicon-plus"></i></button></th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${authorities}" var="a">
				<tr>
					<td>${a.authority}</td>
					<td><button type="button" data-authority="${a.authority}" data-username="${u.username}" class="btn btn-danger btn-xs delete-authority"><i class="glyphicon glyphicon-minus"></i></button></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</div>


<script type="text/javascript">
	$("#addAuthority").click(function() {
		var username = $(this).attr("data-username");
		var authority = prompt("Enter new authority for user:");
		if(authority != "") {
			var url = "<c:url value='/secured/users/" + username + "/authorities' />";
			var postData = JSON.stringify({username : username, authority : authority});
			$.post(url, postData, function(json) {
				var element = $('<tr><td>' + authority + '</td><td><button type="button" data-authority="' + authority + '" data-username="' + username + '" class="btn btn-danger btn-xs delete-authority"><i class="glyphicon glyphicon-minus"></i></button></td></tr>');	
				$('#authoritiesTable > tbody:last').append(element);
				// Binding click event to the newly created element which 
				// will be the last with class delete-authority
				$(".delete-authority:last").click(deleteAuthority);
			}, "json");
		}
	});

	function deleteAuthority() {
		var username = $(this).attr("data-username");
		var authority = $(this).attr("data-authority");
		
		var url = "<c:url value='/secured/users/" + username + "/authorities' />" + "/" + authority + "/delete";
		var $this = $(this);
		$.ajax({
		    url: url,
		    type: 'post',
		    success: function(result) {
		    	$this.closest("tr").remove();
		    }
		});
	}

	$(".delete-authority").click(deleteAuthority);
	
</script>