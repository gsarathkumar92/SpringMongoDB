package MongoProj.mongo1;

import java.net.UnknownHostException;
import java.util.Iterator;

import org.bson.Document;

import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

public class MongoRemote {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MongoClient c;
		//	c = new MongoClient(new MongoURI(" mongodb://<dbuser>:<dbpassword>@ds023105.mlab.com"),23105);
			/*List<ServerAddress> seeds = new ArrayList<ServerAddress>();
			seeds.add( new ServerAddress( "localhost" ));
			List<MongoCredential> credentials = new ArrayList<MongoCredential>();
			credentials.add(
			    MongoCredential.createMongoCRCredential(
			        "app_user",
			        "data",
			        "bestPo55word3v3r".toCharArray()
			    )
			);*/
			MongoClient mongo = new MongoClient( new MongoClientURI("mongodb://sarath:sarath123@ds023105.mlab.com:23105/samplemongo") );
		//	DB db=mongo.getDB("samplemongo");
			/*MongoClient mongo = new MongoClient("ds023105.mlab.com", 23105);
			DB db = mongo.getDB("samplemongo");*/
					
		//	boolean auth = db.authenticate("sarath","sarath123".toCharArray());
			MongoDatabase db=mongo.getDatabase("samplemongo");
			//DB db = mongo.getDB("samplemongo");
			//db.getCollection("test");
			MongoCollection col=db.getCollection("test");
			Iterable<Document> cur1=col.find();
			Iterator<Document> cur=cur1.iterator();
			while(cur.hasNext()){
				System.out.println(cur.next());
			}
		
	}

}
