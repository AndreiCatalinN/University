<!DOCTYPE html>

<?php

include("conndb.php");

$isbn = $_POST["isbn"];
$title = $_POST["title"];
$author = $_POST["author"];
$description = $_POST["description"];
$genre = $_POST["genre"];
$publication_year = $_POST["publication_year"];
$publisher = $_POST["publisher"];

$photo = $_FILES['image']['name'];
$photo_tmp = $_FILES['image']['tmp_name'];

@move_uploaded_file($photo_tmp,"photos/$photo");


$result ="insert into books (ISBN,Title,Author,Description,Genre,Publication_year,Publisher,Book_image) values('$isbn','$title','$author','$description','$genre','$publication_year','$publisher','$photo')";

$insert_b = mysqli_query($conn,$result);

if ($insert_b)
{
    echo "<script>alert('Book was inserted!')</script>";
    echo "<script>window.open('index.php','_self')</script>";
}
$conn->close();

?>
