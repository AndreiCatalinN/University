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
      <form action="bookadd.php" method="post" enctype="multipart/form-data">
        <table>
          <tr>
            <h4>Insert new book</h4>
          </tr>
          <tr>
            <td>ISBN : </td>
            <td>
              <input  class="form-control" name = "isbn" type ="text" placeholder ="ISBN" required>
            </td>
          </tr>
          <tr>
            <td>Title: </td>
            <td>
              <input class="form-control" name="title" type="text" placeholder ="title" required>
            </td>
          </tr>
          <tr>
            <td>Author :</td>
            <td>
              <input class="form-control" name="author"  type="text" placeholder ="Author" required>
            </td>
          </tr>
          <tr>
            <td>Description :</td>
            <td>
              <textarea class="form-control" name="description" class="description" placeholder="Description" required></textarea>
            </td>
          </tr>
          <tr>
            <td>Genre :</td>
            <td>
              <input class="form-control" name="genre"  type="text" placeholder ="Genre" required>
            </td>
          </tr>
          <tr>
            <td>Publication Year :</td>
            <td>
              <input class="form-control" name="publication_year"  type="text" placeholder ="Publication Year" required>
            </td>
          </tr>
          <tr>
            <td>Publisher :</td>
            <td>
              <input class="form-control" name="publisher"  type="text" placeholder ="Publisher" required>
            </td>
          </tr>
          <tr>
            <td>Book Image :</td>
            <td ><input type="file" name="image" /></td>
          </tr>
        </table>
        <input class="btn btn-secondary" type="submit"/>
      </form>
    </div>
  </div>

  <!--using the footer.php  -->
  <div class = "footer">
    <?php include 'footer.php';?>
  </div>

  </body>
</html>
