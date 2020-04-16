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

    <header class = "colorgr">
      <!--Home button-->
      <?php
      $i = 0;
      if( $i == 1)
        include 'navBarLoggedin.php';
      else
        include 'navBarnotLoggedin.php';
       ?>
    </header>

    <section class ="article spc" >
      <p>For complaints and queries you can contact us at the following e-mail: dontdoit@wedontcare.com</p>
      <p>We can also be reached at the following phone number: 088 126 3160</p>
    </section>


    <footer class = "colorgr" >
      <p class = "spc">Copyright stuff....</p>
    </footer>
  </body>
</html>
