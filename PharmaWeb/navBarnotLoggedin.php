<!DOCTYPE html>
<html lang="en" dir="ltr">

  <head>
    <meta charset="utf-8">
    <title>Online Pharmacy</title>
    <!--bootstrap file-->
    <link rel="stylesheet" href="bootstrap.css">
    <!--javaScript related links-->
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.0/umd/popper.min.js" integrity="sha384-cs/chFZiN24E4KMATLdqdvsezGxaGsi4hLGOzlXwp5UZB1LY//20VyM2taTB4QvJ" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.0/js/bootstrap.min.js" integrity="sha384-uefMccjFJAIv6A+rW+L4AHf99KvxDjWSu1z9VI8SKNVmz4sk7buKt/6v9KI65qnm" crossorigin="anonymous"></script>
    <!--own styles-->
    <link rel="stylesheet" href="style.css">
    <!--Add the font from web 11-->
    <link href="https://fonts.googleapis.com/css?family=Source+Sans+Pro" rel="stylesheet">
  </head>

  <body>

    <header class = "colorgr" >

      <a href="index.php">
        <img id="hbutton"  src="Images/caduceus-1-hi.png" alt="">
      </a>
      <!--Navigation bag-->
      <nav class="navbar navbar-expand-lg navbar-light bg-light">
        <a class="navbar-brand">Online Pharmacy</a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
          <span class="navbar-toggler-icon"></span>
        </button>

        <div class="collapse navbar-collapse" id="navbarNav">
          <ul class="navbar-nav">
              <li class="nav-item active">
                <a class="nav-link" href="Register.php">Register</a>
              </li>
              <li class="nav-item">
                <a class="nav-link" onclick="document.getElementById('id01').style.display='block'" href="#">Log in</a>
              </li>
              <li class="nav-item">
                <a class="nav-link" href="contact_us.php">Contact Us</a>
              </li>
              <li class="nav-item">
                <a class="nav-link" href="Our_products.php">Our Products</a>
              </li>
              <li class="nav-item">
                <a class="nav-link" href="useful_information.php">Useful Information</a>
              </li>
          </ul>
        </div>
        </nav>
        <!--Pop-up login  -->
        <div id="id01" class="modal">
          <form class="modal-content animate " action="login.php"  method = "post">
            <div class="container">
              <div class="form-group row">
                <label for="inputEmail3" class="col-sm-3 col-form-label">User name</label>
                <div class="col-sm-9">
                  <input type="text" class="form-control inputwidth " name = "user" required>
                </div>
              </div>

              <div class="form-group row">
                <label for="inputPassword3" class = "col-sm-3 col-form-label">Password</label>
                <div class="col-sm-9">
                  <input type = "password" class = "form-control inputwidth" pattern = ".{5,30}" id = "inputPassword3" name = "pass" required>
                </div>
              </div>

              <button type="submit" class = "btn btn-success colorgr spc">Login</button>
              <button type="button" class = "btn btn-danger spc" onclick="document.getElementById('id01').style.display='none'" >Cancel</button>
            </div>
          </form>
        </div>

      </header>

  </body>
</html>
