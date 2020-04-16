<!DOCTYPE html>
<html lang="en" dir="ltr">
  <head>
    <meta charset="utf-8">
    <title>Book Store</title>
    <!--Stylesheets-->
    <link rel="stylesheet"
          href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
          crossorigin="anonymous">
    <link rel="stylesheet" href="styles/style.css">

    <!--Scripts-->
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
            integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
            crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"
            integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1"
            crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
            integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
            crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.0/umd/popper.min.js"
            integrity="sha384-cs/chFZiN24E4KMATLdqdvsezGxaGsi4hLGOzlXwp5UZB1LY//20VyM2taTB4QvJ"
            crossorigin="anonymous"></script>
    <link href="https://fonts.googleapis.com/css?family=Source+Sans+Pro" rel="stylesheet">
  </head>

  <body>

  <!--Header Section -->
  <?php include 'navbar.php';?>

  <!--this is the code for register part  -->
  <div class='content_wrap'>
    <div >
      <form action="regdb.php" method="post" enctype="multipart/form-data">
        <table>
          <tr>
            <h4>Create Account</h4>
          </tr>
          <tr>
            <td>Username: </td>
            <td>
              <input  class="form-control" name = "username" type ="text" placeholder ="Enter Name" required>
            </td>
          </tr>
          <tr>
            <td>Firstname: </td>
            <td>
              <input  class="form-control" name = "firstname" type ="text" placeholder ="Enter Firstname" required>
            </td>
          </tr>
          <tr>
            <td>Lastname: </td>
            <td>
              <input  class="form-control" name = "lastname" type ="text" placeholder ="Enter Lastname" required>
            </td>
          </tr>
          <tr>
            <td>Password: </td>
            <td>
              <input class="form-control" name="password" type="text" placeholder ="Password" pattern = ".{5,10}" required title ="5 to 10 characters">
            </td>
          </tr>
          <tr>
            <td>E-mail: </td>
            <td>
              <input class="form-control" name="email"  type="email" placeholder ="Email" required>
            </td>
          </tr>
          <tr>
            <td>Eircom code: </td>
            <td>
              <input class="form-control" name="code" type="text"  placeholder="Eircom Code" required>
            </td>
          </tr>
          <tr>
            <td>Phone Number: </td>
            <td>
              <input class="form-control" name="phone_no"  type="text" placeholder ="Phone Number" required>
            </td>
          </tr>
          <tr>
            <td>Profile Image :</td>
            <td ><input type="file" name='image' ></td>
          </tr>
        </table>
        <button class="btn btn-secondary" type="submit">Submit</button>
      </form>
    </div>
  </div>

  <!--using the footer.php  -->
  <div class = "footer">
    <?php include 'footer.php';?>
  </div>

  </body>
</html>
