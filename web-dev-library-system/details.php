<!DOCTYPE html>
<html lang="en" dir="ltr">
  <head>
    <meta charset="utf-8">
    <title>Book Library</title>
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
    <!--Header-->
    <?php include 'navbar.php';?>


    <!--Content area -->
    <div class="content_wrap">
      <?php

        $con = mysqli_connect("localhost", "root", "", "web2");
        if(mysqli_connect_errno())
          echo "can't connect\n".mysqli_connect_errno();

        if(isset($_GET['isbn']) || isset($_GET['bmark']))
        {
          if(isset($_GET['isbn']))
            $isbn =$_GET['isbn'];
          else $isbn =$_GET['bmark'];

          $get_books_sql = "select * from books where ISBN like '$isbn';";

          $run_sql = mysqli_query($con, $get_books_sql);
          #get data
          $book = mysqli_fetch_array($run_sql);
          #store it for print
          $image = $book['Book_image'];
          $title = $book['Title'];
          $author = $book['Author'];
          $description = $book['Description'];
          $genre = $book['Genre'];
          $pub = $book['Publisher'];
          $pub_year = $book['Publication_year'];

          if(isset($_COOKIE["username"]))
          {//with Bookmark button
            echo
            "
              <div>
                <div class='book_img_ext'>
                  <img src='photos/$image' alt=''>
                  </div>
                  <p>Title: $title</p>
                  <p>Author: $author</p>
              <p>Description: $description</p>
              <p>Genre: $genre</p>
              <p>Publisher: $pub</p>
              <p>Publication Year: $pub_year</p>
              <p>ISBN: $isbn</p>
              <a href='details.php?bmark=$isbn'>
                <button class='btn btn-secondary' id = 'Bookmark' >Bookmark</button>
              </a>
            </div>
          ";
          }
          else
          {//without Bookmark button
            echo
            "
              <div>
                <div class='book_img_ext'>
                  <img src='photos/$image' alt=''>
                  </div>
                  <p>Title: $title</p>
                  <p>Author: $author</p>
              <p>Description: $description</p>
              <p>Genre: $genre</p>
              <p>Publisher: $pub</p>
              <p>Publication Year: $pub_year</p>
              <p>ISBN: $isbn</p>
            </div>
          ";
          }
        }
        mysqli_close($con);

      ?>
    </div>
    <!--Content area end-->

    <!--Footer-->
    <div class = "footer">
      <?php include 'footer.php';?>
    </div>
  </body>
</html>
