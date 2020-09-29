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

<style>
#view {
	margin-top: 50px;
	margin-right: 100px;
	margin-bottom: 50px;
	margin-left: 100px;
}
#titles {
	width: 100%;
	height: 5%;
	border: 1px solid rgba(228, 222, 222, 0.788);
	border-radius: 5px;
}
#contents {
	width: 100%;
	height: 70%;
	border: 1px solid rgba(228, 222, 222, 0.788);
	border-radius: 5px;
}
.container {
	margin-right: 100px;
	margin-bottom: 100px;
	margin-left: 100px;
}
@media ( max-width : 480px ) {
	#titles {
		width: 460px;
		height: 10px;
		border: 1px solid rgba(228, 222, 222, 0.788);
		border-radius: 5px;
	}
	#contents {
		width: 460px;
		height: 70%;
		border: 1px solid rgba(228, 222, 222, 0.788);
		border-radius: 5px;
	}
}
</style>

<title>Web</title>
</head>
<body>
	<div id="view">
	<!-- 
	 	<div class="container" id="titles">${webVo.transtype}</div>
	 -->
		<div class="form-group">
			<textarea id="contents" class="form-control" name="contents"
				rows="15" placeholder="내 용">${webVo.contents}</textarea>
		</div>
		<div>
			<br>
		</div>
	</div>

	<div class="container">
		<button type="button" class="btn btn-primary" onclick="location.href='${pageContext.request.contextPath}/'">HOME</button>
	</div>

</body>
</html>