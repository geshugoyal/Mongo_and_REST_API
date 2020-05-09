package com.project.ht.dao;

import java.util.List;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBObject;
import com.mongodb.Mongo;
import com.project.ht.model.Welcome;




@Service("userService")
@Transactional
public class UserDaoImpl implements UserDao{
	
	@SuppressWarnings("deprecation")
	Mongo mongo= new Mongo("localhost",27017);
	@SuppressWarnings("deprecation")
	DB db= mongo.getDB("logindetails");
	private static final String COLLECTION_NAME = "listUser";
	DBCollection collection= db.getCollection(COLLECTION_NAME);
	 
	
	@Autowired(required=true)
	 private MongoTemplate mongoTemplate;

	public List<Welcome> findAllUser() {
		
		
		System.out.println("From UserDao Implementation of listUser..");
		return mongoTemplate.findAll(Welcome.class, COLLECTION_NAME);

		//return mongoTemplate.findAll(Welcome.class);
	}
	
	
	public Welcome add(Welcome user) throws Exception{
		
		if (emailExist(user.getEmail())) {  
			
			return null;
			//throw new Exception("There is an account with that email address: "+  user.getEmail());
        }
		
		
		if(user.getId() != null && user.getId() != ""){
			   
			   DBObject query1 = new BasicDBObject();
			         query1.put("id", user.getId());
			         DBObject query = new BasicDBObject();
			   query.put("id", user.getId());
			  query.put("name", user.getName());
			   query.put("email", user.getEmail());
			   query.put("phoneno", user.getPhoneno());
			         
			        ((DBCollection) mongoTemplate.getDb().getCollection("listUser")).update(query1, query);
			     }else{
			         
			    	   user.setId(UUID.randomUUID().toString());
			    	    
			    	    mongoTemplate.save(user);
			    	   return user;
			    	         }
		return user;
			   
			    	     
	}
	public Welcome findByEmail(String email) {
		//Welcome user = mongoTemplate.findById(email, Welcome.class);
		Query query = new Query();
        query.addCriteria(Criteria.where("email").is(email));
        Welcome user = mongoTemplate.findOne(query, Welcome.class);
        if (user != null) {
            return null;
        }
        return user;
	}
	
	 private boolean emailExist(String email) {
		 Query query = new Query();
	        query.addCriteria(Criteria.where("email").is(email));
	        Welcome user = mongoTemplate.findOne(query, Welcome.class);
	        if (user != null) {
	            return true;
	        }
	        return false;
	 }
	 
      public Welcome update(Welcome user) {
    	  if (emailExist(user.getEmail())) {  
    		  System.out.println("Existing account with that email address: "+ user.getEmail());
  			return null;
  			
          }
    	
		mongoTemplate.save(user);
		System.out.println("There is an account with that email address: "+ user.getEmail());
		return user;
    	  }
	

/*
	public void update(Welcome user) {
		//Update update;
		//DBObject query = new BasicDBObject("_id", "user.getId().toString()");
		//DBObject update = new BasicDBObject();
		//update.put("$set", new BasicDBObject("phoneno", "user.setPhoneno().toString()"));
	    //collection.update(query, update);
		System.out.println("From UserDao Implementation of update method..");
		
		//Query query = new Query();
        //query.addCriteria(Criteria.where("id").is(id));
        //Welcome user = findUserById(id);
		//mongoTemplate.updateFirst(query, update, Welcome.class);
        //update.put("$set", new BasicDBObject("phoneno", "user.setPhoneno().toString()"));
       
        mongoTemplate.save(user);
		
	     //mongoTemplate.save( user);
		/*
		 DBObject query1 = new BasicDBObject();
         query1.put("id", user.getId());
         DBObject query2 = new BasicDBObject();
         query2.put("id", user.getId());
         query2.put("name", user.getName());
         query2.put("email", user.getEmail());
         query2.put("phoneno", user.getPhoneno());
         
        ((DBCollection) mongoTemplate.getDb().getCollection("listUser")).update(query1, query2);
        */
		//System.out.println("From UserDao Afterr Implementation of update method..");

		
		//WriteResult result = collection.update(query, update);
	//}


       public Welcome findUserById(String id) {
    	   // Query query = new Query();
   		   //query.addCriteria(Criteria.where("id").is("user.getId().toString()"));
           //return mongoTemplate.findOne(Query.query(Criteria.where("_id").is(id)) , Welcome.class, id);
    	   Query query = new Query();
           query.addCriteria(Criteria.where("id").is(id));
           Welcome user = mongoTemplate.findOne(query, Welcome.class);
   		   System.out.println("From UserDao Afterr Implementation of finduserbyid method.."+user.getName());

           return user;
    	   
	}
	

	
	public void delete(String id) {
		
		Query query = new Query();
        query.addCriteria(Criteria.where("id").is(id));
        Welcome account = mongoTemplate.findOne(query, Welcome.class);
   	 System.out.println("from delete method.."+account.getName());

        mongoTemplate.remove(account);
		//mongoTemplate.remove(user, COLLECTION_NAME );
		
		   // DBObject query = new BasicDBObject();
		   // query.put("user", user);
		  // Run the query and delete the entry
		  // ((DBCollection) mongoTemplate.getDb().getCollection("listUser")).findAndRemove(query);
		
		//mongoTemplate.remove("user", "user");
		
		//BasicDBObject document = new BasicDBObject();
		//document.put("_id","user.getId().toString()");
		//mongoTemplate.remove(document);
		
		/*
		DBObject query1 = new BasicDBObject();
        query1.put("id", user.getId());
        DBObject query = new BasicDBObject();
        query.put("id", user.getId());
        query.put("name", user.getName());
        query.put("email", user.getEmail());
        query.put("phoneno", user.getPhoneno());
		((DBCollection) mongoTemplate.getDb().getCollection("listUser")).remove(query);
		
		user.setId(UUID.randomUUID().toString());
		mongoTemplate.remove(user);
		*/
		
		

		
	}

	
	
}
