<!DOCTYPE html>

<?php
$con = mysqli_connect("localhost", "root", "", "web2");
if(mysqli_connect_errno())
  echo "can't connect\n".mysqli_connect_errno();

function bookmark()
{
  if(isset($_GET['bmark']))
  {
    $isbn = $_GET['bmark'];
    $user = $_COOKIE['username'];
    $query = "select * from bookmarks where isbn like '$isbn' and user like '$user';";

    global $con;
    $run_sql = mysqli_query($con, $query);

    if(mysqli_num_rows( $run_sql) > 0)
    {
      echo "<script>alert('Already Bookmarked')</script>";
    }
    else
    {

      $query = "insert into bookmarks (user, isbn) values('$user','$isbn');";
      $run_sql = mysqli_query($con, $query);
      echo "<script>alert('Bookmarked')</script>";
    }
  }
}


function getBooks()
{
  #Establish connection
  global $con;
  $get_books_sql = "select * from books;";
  $run_sql = mysqli_query($con, $get_books_sql);

  #get data
  $book = mysqli_fetch_array($run_sql);
  while($book)
  {
    #store it for print
    $isbn = $book['ISBN'];
    $title = $book['Title'];
    $author = $book['Author'];
    $image = $book['Book_image'];
    if(isset($_COOKIE["username"]))
    {//with Bookmark button
      echo
      "
        <div class='col-lg-3 col-md-6 col-sm-6 book'>
          <a href='details.php?isbn=$isbn'>
            <img class='book_img' src='photos/$image' alt=''>
          </a>
          <a href='details.php?isbn=$isbn'>
            <p>$title</p>
            <p>$author</p>
          </a>
          <a href='index.php?bmark=$isbn'>
            <button class='btn btn-secondary' id='Bookmark'>Bookmark</button>
          </a>
        </div>
      ";
    }
    else
    {//without Bookmark button
      echo
      "
        <div class='col-lg-3 col-md-6 col-sm-6 book'>
          <a href='details.php?isbn=$isbn'>
            <img class='book_img' src='photos/$image' alt=''>
          </a>
          <a href='details.php?isbn=$isbn'>
            <p>$title</p>
            <p>$author</p>
          </a>
        </div>
      ";
    }
    $book = mysqli_fetch_array($run_sql);
  }
  mysqli_close($con);
}


function getSearchBooks($get_book)
{
  #Establish connection
  global $con;

  $run_sql = mysqli_query($con, $get_book);

  #get data
  $book = mysqli_fetch_array($run_sql);
  while($book)
  {
    #store it for print
    $isbn = $book['ISBN'];
    $title = $book['Title'];
    $author = $book['Author'];
    $image = $book['Book_image'];

    if(isset($_COOKIE["username"]))
    {//with Bookmark button
      echo
      "
        <div class='col-lg-3 col-md-6 col-sm-6 book'>
          <a href='details.php?isbn=$isbn'>
            <img class='book_img' src='photos/$image' alt=''>
          </a>
          <a href='details.php?isbn=$isbn'>
            <p>$title</p>
            <p>$author</p>
          </a>
          <a href='index.php?bmark=$isbn'>
            <button class='btn btn-secondary' id='Bookmark'>Bookmark</button>
          </a>
        </div>
      ";
    }
    else
    {//without Bookmark button
      echo
      "
        <div class='col-lg-3 col-md-6 col-sm-6 book'>
          <a href='details.php?isbn=$isbn'>
            <img class='book_img' src='photos/$image' alt=''>
          </a>
          <a href='details.php?isbn=$isbn'>
            <p>$title</p>
            <p>$author</p>
          </a>
        </div>
      ";
    }
    $book = mysqli_fetch_array($run_sql);
  }
  mysqli_close($con);
}
?>
