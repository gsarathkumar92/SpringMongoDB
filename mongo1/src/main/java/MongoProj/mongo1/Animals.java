package MongoProj.mongo1;

import java.net.UnknownHostException;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.MongoClient;

public class Animals {

	public static void main(String[] args) {
		MongoClient c;
		c = new MongoClient();
		DB db=c.getDB("test");
		DBCollection animals=db.getCollection("animals");
      

      BasicDBObject animal = new BasicDBObject("animal", "monkey");

		animals.insert(animal);
		animal.remove("animal");
		animal.append("animal", "cat");
		animals.insert(animal);
		animal.remove("animal");
		animal.append("animal", "lion");
		animals.insert(animal);
		

	}

}
