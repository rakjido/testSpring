<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>

<style>
	#insert, #lotteDiv {
		margin-top: 50px;
		margin-right: 100px;
		margin-bottom: 50px;
		margin-left: 100px;
	}
	
	textarea {
		width: 100%;
		height: 70%;
		overflow: visible;
	}
</style>

<title>Web</title>
</head>
<body>
	<div id="insert">
		<form action="${pageContext.request.contextPath}/" method="post">
			<div class="form-group">
				<input type="password"
					class="form-control" id="inputTitle" name="password" placeholder="password">
			</div>
			<div class="form-group">
				<input type="radio" name="transtype" value="encrypt" checked> Encrypt 
  				<input type="radio" name="transtype" value="decrypt"> Decrypt <br>
			</div>
			<div class="form-group">
				<textarea id="contents" class="form-control" name="contents"
					rows="15" placeholder="내 용"></textarea>
			</div>
			<div class="form-group">
				<button type="submit" class="btn btn-primary">Submit</button>
				
			</div>
		</form>
		
	</div>
</body>
</html>