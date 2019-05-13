<!DOCTYPE html>
<html lang="en">

  <head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>SB Admin - Login</title>

    <!-- Bootstrap core CSS-->
    <link href="vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom fonts for this template-->
    <link href="vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">

    <!-- Custom styles for this template-->
    <link href="css/sb-admin.css" rel="stylesheet">

  </head>
<script>
	$(document).ready(function() {
		$('input[id="log"]').click(function() {
			var id = $('input[name="id"]').val();
			var pwd = $('input[name="password"]').val();
			if (id == null || id == '') {
				alert('ID Madatory Filled !');
				return;
			}
			if (pwd == null || pwd == '') {
				alert('PWD Madatory Filled !');
				return;
			}

		});
	});
</script>
  <body class="bg-dark">

    <div class="container">
      <div class="card card-login mx-auto mt-5">
        <div class="card-header">Login</div>
        <div class="card-body">
          <form action="wloginimpl.myr" method="post" name="login"
					id="login-form">
            <div class="form-group">
              <div class="form-label-group">
                <input type="text" name="id" class="form-control"  >
                <label for="inputID">ID</label>
              </div>
            </div>
            <div class="form-group">
              <div class="form-label-group">
                <input type="password"  name="password" class="form-control" >
                <label for="inputPassword">Password</label>
              </div>
            </div>
            <div class="form-group">
              <div class="checkbox">
                <label>
                  <input type="checkbox" value="remember-me">
                  Remember Password
                </label>
              </div>
            </div>
            <br> <input type="submit" name="log" value="Login"
								class="button">
          </form>
        </div>
      </div>
    </div>

    <!-- Bootstrap core JavaScript-->
    <script src="vendor/jquery/jquery.min.js"></script>
    <script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

    <!-- Core plugin JavaScript-->
    <script src="vendor/jquery-easing/jquery.easing.min.js"></script>

  </body>

</html>
