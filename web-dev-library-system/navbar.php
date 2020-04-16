<!--Header Section -->
<header >
  <img  id="banner" src="photos/BANNER-Books.jpg" alt="">
</header>
<!--Header Section End-->

<!--Navigation bar-->
<nav class="navbar navbar-expand-lg navbar-light bg-light">
  <a class="navbar-brand" href='index.php'>Good Reads</a>

  <div id="navbarNav">
    <div class="float-left">
    <ul class="navbar-nav">
      <li class="nav-item">
        <a class="nav-link" href="index.php">Home</a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="useful_info.php">Useful Information</a>
      </li>
      <?php
        include 'functions.php';
        bookmark();

        if(isset($_COOKIE["username"]))
        {

          echo '
          <li class="nav-item">
            <a class="nav-link hidden" id="MyBooks" href="my_books.php">My books</a>
          </li>
          <li class="nav-item">
             <a class="nav-link" href="insert_book.php">Add Book</a>
           </li>
           <li class="nav-item">
             <a class="nav-link hidden"  id="Account" href="account.php">Account</a>
           </li>
           <li class="nav-item">
             <a class="nav-link"  href="logout.php">Log Out</a>
           </li>
           <li class="nav-item">
             <a class="nav-link"  href="delete.php">Delete Account</a>
           </li>
          ';
        }
        else
        {
          echo "
          <li class='nav-item'>
            <a class='nav-link' id='Login' href='login_form.php'>Log In</a>
          </li>
          <li class='nav-item'>
            <a class='nav-link' id='Register' href='Register.php'>Register</a>
          </li>
          ";
        }
      ?>
      <li class="nav-item">
        <form class="form-inline my-2 my-lg-0" action="results.php" method="get" enctype="multipart/form-data">
          <input type="text" name="search_book" class="form-control mr-sm-2"   placeholder="Search" aria-label="Search">
          <input type="submit" name="search"  class="btn btn-light" value="Search" href="results.php">
        </form>
      </li>
    </ul>
  </div>
</nav>
<!--nav Bar end-->
