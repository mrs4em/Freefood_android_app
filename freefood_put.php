<?php
mysql_connect("localhost","root","");
mysql_select_db("freefood_1");
$sql=mysql_query("insert into EVENTS (Name,Description,Date,Time,Location)values('".$_REQUEST['name']."','".$_REQUEST['description']."','".$_REQUEST['date']."','".$_REQUEST['time']."','".$_REQUEST['location']."')");

$r=mysql_query($sql);
if(!$r)
echo "Error in query: ".mysql_error();
mysql_close();
?>