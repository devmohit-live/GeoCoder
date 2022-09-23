<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>  
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="ie=edge">
<title>Add Todo Page</title>
<link href="webjars/bootstrap/5.1.3/css/bootstrap.min.css" rel="stylesheet">
<link rel="stylesheet" href="/todoApp/src/main/resources/META-INF/resources/WEB-INF/statics/css/login.css">
</head>
<body>
	<h2>Home</h2>
	<div class="container">
		<form method="post">
		<div class="mb-3">
		  <label for="formFile" class="form-label">Default file input example</label>
		  <input class="form-control" type="file" id="formFile">
		   <div class="col-auto">
    <button type="submit" class="btn btn-primary mb-3">Confirm identity</button>
  </div>
		</div>
		</form>
	</div>
	<script src="webjars/bootstrap/5.1.3/js/bootstrap.min.js"  type="text/javascript"></script>
	<script src="webjars/jquery/3.6.0/jquery.min.js"  type="text/javascript"></script>
</body>
</html>