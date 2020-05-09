<body>
 <div>  
       
       <h3><a href="/add">Add New User</a></h3>
       
       
   </div>   
<h2>User List:</h2>
<table border="1">
         <tr>
               <th>Id</th>
               <th>Name</th>
               <th>Email</th>
               <th>Phone No</th>
               <th>Delete</th>
               <th>Update</th>
         </tr>
          <#list listUser as users>
         <tr>
            <td>${users.id}</td>
            <td>${users.name}</td>
            <td>${users.email}</td>
            <td>${users.phoneno}</td>
            <td><h4><a href="/delete?id=${users.id}">Delete</a></h4></td>
            <td><h4><a href="/update?id=${users.id}">Update</a></h4></td>
          
          <!-- 
           <td><input type="submit" onclick="location.href='/delete'" value="Delete" /></a></td> 
           -->
            
            
         </tr>
         </#list>
      </table> 
      <br>
     
      </body>