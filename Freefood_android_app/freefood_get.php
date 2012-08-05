<?php
mysql_connect("localhost","root","");
mysql_select_db("freefood_1");
$sql=mysql_query("select * from EVENTS where Date like '".$_REQUEST['date']."%'");
while($row=mysql_fetch_assoc($sql))
$output[]=$row;
print(json_encode($output));
mysql_close();
?>