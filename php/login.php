<?php
$servername = "localhost";
$username = "hakanozcan";
$password = "0561995hH*";
$dbname = "neverdoitalone";
$email = '';
$pass='';
//echo "trying";
// if (isset($_GET['email']) && isset($_GET['pass'] ) {
     $email =  $_GET['email'];
	 $pass=$_GET['pass'];
	
	//Create connection
	 $conn = new mysqli($servername, $username, $password,$dbname);

	//Check connection
	 if ($conn->connect_error) {
		die("Connection failed: " . $conn->connect_error);
	} 
	
	 $query = "SELECT user_email, password_hash FROM User WHERE user_email='$email' AND password_hash='$pass'";
	 //$query = "select * from User;";
     

	//Perform Query
	 $result = $conn->query($query);
	//$rows = array();
	 if ($result->num_rows > 0) {
		echo "success";
    // output data of each row
		//while($row = $result->fetch_assoc()) {
			//echo "id: " . $row["id"]. " - Name: " . $row["name_surname"]. " " . $row["user_name"]. "<br>";
			//$rows[]=$row;
			
		//}
	} else {
		echo "fail";
	}
	
	//print json_encode($rows,JSON_UNESCAPED_UNICODE);

	//Free the resources associated with the result set
	//This is done automatically at the end of the script
	 mysql_free_result($result);
	 $conn->close();
	
// }else{
    //Fallback behaviour goes here
	// echo "could not connect";
//}

?>