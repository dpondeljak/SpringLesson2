<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <meta name="description" content="">
    <meta name="author" content="">
    <!-- link rel="icon" href="../../favicon.ico" -->
	
	<title>Login Page</title>
    <!-- Bootstrap core CSS -->
    <link href="./assets/css/bootstrap.min.css" rel="stylesheet">

    <!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
    <!-- link href="/assets/css/ie10-viewport-bug-workaround.css" rel="stylesheet" -->

    <!-- Custom styles for this template -->
    <link href="./assets/app.css" rel="stylesheet">

    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->	
	
	</head>
	<body class="login-page">
	<div class="container"> 
		<div class="login-box">
			<div class="login-box-body">
				<p class="login-box-header"> Unesite svoje korisničke podatke </p>
				
				<p class="login-box-header" style="color:red;">${poruka}</p>
				<p class="login-box-header" style="color:red;">${pokusaji}</p>

				<form action="login" method="post">
					<div class="form-group has-feedback">
						<input name="korisnickoIme" class="form-control" placeholder="Korisničko ime" ${disabled}/>
						<span class="glyphicon glyphicon-user form-control-feedback"></span>
					</div>
					<div class="form-group has-feedback">
						<input type="password" name="lozinka" class="form-control has-feedback" placeholder="Vaša lozinka" ${disabled} />
						<span class="glyphicon glyphicon-lock form-control-feedback"></span>
					</div>
					<div class="row">
						<div class="col-xs-4 col-xs-offset-4">
							<button type="submit" class="btn btn-primary btn-block no-round-border" ${disabled} > Prijavi </button>
						</div>
					</div>
				</form>
			</div>
		</div>

	</div>
	<!-- Javascript assets -->	
	
	</body>
</html>