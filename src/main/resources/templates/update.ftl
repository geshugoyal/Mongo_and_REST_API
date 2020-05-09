   <head>
      <title>Update User</title>
   </head>

   
<body>
 
   
        
     <#if user123?? >
        Your submitted data not accepted<br>
       
        <#else>
        <form action="/update?id=${user.id}" method="POST">
            <h3>Update User:</h3>
            Employee ID= ${user.id}<br><br>
            
            Employee Name:<br>
            <input type="text" name="name" value="${name}" required>
            <br><br>
            Employee Email:<br>
            <input type="email" name="email"  pattern="[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,3}$" value="${email}" required>
            <br><br>
            Employee Phone No:<br>
            <input type="text" name="phoneno" pattern="(7|8|9)\d{9}"  value="${phoneno}"  required>
            <br><br>
            <input type="submit" value="Update">
        </form>
        </#if>
    </body>
       
        
    </body>

