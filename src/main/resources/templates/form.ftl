
<head>
<title>Welcome Page</title>
</head>
<body>
<h1>Enter Details</h1>

<form action="/add" method="POST">
<table>
    
          <tr><td>Employee Name:</td><td> <input type = "text" name = "name" required></td> </tr>
          
         <br>
          <tr><td>Employee Email Id:</td><td> <input type = "email" name = "email" pattern="[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,3}$" required></td> </tr>
         <br>
          <tr><td>Employee Phone No:</td><td> <input type = "text" name = "phoneno" pattern="(7|8|9)\d{9}" required></td> </tr>
         <br><br>
          
           <tr><td></td><td><input type="submit" value="Submit"/></td></tr>
           
           </table>
      </form>
      
    
   </body>
	
	 

 