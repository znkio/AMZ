<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>


<head><title>User list</title></head>

<div class="row">
	<div class="col-md-4">
		<div class="table-responsive">
			<table class="table table-hover table-bordered table-striped">
				<thead>
					<tr>
						<th>Username</th>
						<th>Enabled</th>
						<th></th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${users}" var="u">
						<tr id="tr-${u.username}">
							<td>${u.username}</td>
							<td><c:if test="${u.enabled==true}"><i class="glyphicon glyphicon-ok"></i></c:if></td>
							<td>
								<a href="<c:url value='/secured/users/${u.username}/edit' />" class="btn btn-xs btn-success">Edit</a>
								<button data-username="${u.username}" class="btn btn-danger btn-xs delete-user">Delete</button>
							</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div> <!--  table responsive -->
		<div id="statusMessage"></div>
	</div>
</div>


<script type="text/javascript">
	$(".delete-user").click(function(e) {
		var username = $(this).attr("data-username");
		var r = confirm("Are you user you want to delete user " + username + "?");
		if(r) {
			var url = "<c:url value='/secured/users/"  + username + "/delete' />";
			var postData = { username : username };
			$.ajax({
			    url: url,
			    type: 'post',
			    success: function(result) {
			    	$("#tr-" + username).remove();
			    }
			});
		}
		
	});
	
	
</script>

