package MongoProj.mongo1;

import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Collections;

import javax.swing.text.Document;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.*;
import com.mongodb.DBCursor;
import com.mongodb.MongoClient;

public class CRUDOperation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		MongoClient c;
		c = new MongoClient();
		DB db=c.getDB("course");
		DBCollection col=db.getCollection("m2");
		 col.drop();
/*	BasicDBObject obj=new BasicDBObject("name", "MongoDB")
		.append("type", "database")
		.append("count", 1)
		.append("info", new BasicDBObject("x", 203).append("y", 102));	 
		col.insert(obj);	*/
for(int i=0;i<8;i++)
{
		col.insert(new BasicDBObject().append("_id", i)
				.append("x", i).append("y",true));
}
		 
//	col.update(new BasicDBObject("x",5), new BasicDBObject("$set",new BasicDBObject("x",20).append("updated", true)));	

/*	BasicDBObject upmany=new BasicDBObject();
upmany.put("x", new BasicDBObject("$gt",5));
col.updateMulti(upmany,new BasicDBObject("$inc",new BasicDBObject("x",1)));
*/

/*BasicDBObject del=new BasicDBObject();
del.put("x", 5);*/

/*BasicDBObject del=new BasicDBObject();
del.put("x", new BasicDBObject("$lt",5));
col.remove(del);*/
DBCursor cur=col.find();
while(cur.hasNext()){
		System.out.println(cur.next());
}
		
	}

}
