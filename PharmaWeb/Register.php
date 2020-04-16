
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
<!--bootstrap code-->
    <header class = "colorgr" >
      <!--Home buttons-->
      <?php
        $i = 0;
        if( $i == 1)
          include "navBarLoggedin.php";
        else
          include "navBarnotLoggedin.php";
       ?>
    </header>
<!-- Start of the web-->


    <section class ="article spc" >
      <h3>Registration form</h3>
      <form action = "dbinsert.php" method = "post">

        <div class="form-group row">
          <label for="inputEmail3" class="col-sm-2 col-form-label">User name</label>
          <div class="col-sm-10">
            <input type="text" class="form-control inputwidth " name = "user" required>
          </div>
        </div>

        <div class="form-group row">
          <label for="inputPassword3" class="col-sm-2 col-form-label ">Password</label>
          <div class="col-sm-10">
            <input type="password" class="form-control inputwidth" pattern = ".{5,30}"  id="inputPassword3" name = "pass"   required>
          </div>
        </div>

        <div class="form-group row">
          <label for="inputPassword3" class="col-sm-2 col-form-label ">Confirm Password</label>
          <div class="col-sm-10">
            <input type="password" class="form-control inputwidth" pattern = ".{5,30}"  id="inputPassword3"  name = "repass"  required>
          </div>
        </div>

        <div class="form-group row">
          <label for="inputEmail3" class="col-sm-2 col-form-label">Email</label>
          <div class="col-sm-10">
            <input type="email" class="form-control inputwidth" id="inputEmail3" name = "email" required>
          </div>
        </div>

        <div class="form-group row">
          <label for="inputEmail3" class="col-sm-2 col-form-label">First name</label>
          <div class="col-sm-10">
            <input type="text" class="form-control inputwidth"  name = "fname"  required>
          </div>
        </div>

        <div class="form-group row">
          <label for="inputEmail3" class="col-sm-2 col-form-label">Surname</label>
          <div class="col-sm-10">
            <input type="text" class="form-control inputwidth "  name = "sname"  required>
          </div>
        </div>

        <div class="form-group row">
          <label for="inputEmail3" class="col-sm-2 col-form-label">Address</label>
          <div class="col-sm-10">
            <input type="text" class="form-control inputwidth2 " name = "address" required>
          </div>
        </div>

        <fieldset class="form-group">
          <div class="row">
            <legend class="col-form-label col-sm-2 pt-0">Gender</legend>
            <div class="col-sm-10">
              <div class="form-check">
                <input class="form-check-input" type="radio" name="gender" value = "M" id="gridRadios1">
                <label class="form-check-label" for="gridRadios1">
                  Male
                </label>
              </div>
              <div class="form-check">
                <input class="form-check-input" type="radio" name="gender" value = "F"  id="gridRadios2">
                <label class="form-check-label" for="gridRadios2">
                  Female
                </label>
              </div>
              <div class="form-check">
                <input class="form-check-input" type="radio" name="gender"  value = "O" id="gridRadios3"  checked>
                <label class="form-check-label" for="gridRadios3">
                  Other
                </label>
              </div>
            </div>
          </div>
        </fieldset>

        <div class="form-group row">
          <label for="inputEmail3" class="col-sm-2 col-form-label">Birthday </label>
          <div class="col-sm-10">
            <input type="date" class="form-control inputwidth" name="birthday" min="1945-01-01" max = "2018-04-04">
          </div>
        </div>

        <div class="form-group row">
          <div class="col-sm-2">I agree with the terms and conditions</div>
          <div class="col-sm-10">
            <div class="form-check">
              <input class="form-check-input" type="checkbox" id="gridCheck1" required>
            </div>
          </div>
        </div>

        <div class="form-group row col-sm-10">
          <button type="submit" class="btn btn-primary colorgr" name  = "signup">Register</button>
        </div>

      </form>
      <!-- end of bootstrap code-->
    </section>

    <footer class = "colorgr">
        <p class = "spc">Copyright stuff....</p>
    </footer>
  </body>
</html>
