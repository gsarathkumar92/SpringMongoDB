package MongoProj.mongo1;

import java.io.StringWriter;
import java.net.UnknownHostException;
import java.util.HashMap;
import java.util.Map;





import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;

import spark.Request;
import spark.Response;
import spark.Route;
import spark.Spark;
import freemarker.template.Configuration;
import freemarker.template.Template;

public class HelloSparkFreeMarkerMongoDB {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		final Configuration conf=new Configuration();
		conf.setClassForTemplateLoading(HelloSparkFreeMarkerMongoDB.class, "/");
		
		MongoClient cli=new MongoClient();
		DB db=cli.getDB("ConnectingAll");
		final DBCollection col=db.getCollection("Test");
		col.drop();
		col.insert(new BasicDBObject("name","MongoDB"));
		
		Spark.get("/", new Route(){

			public Object handle(Request arg0, Response arg1) throws Exception {
				// TODO Auto-generated method stub
				StringWriter wri=new StringWriter();
				try {
					Template temp=conf.getTemplate("hello.ftl");
					
					DBObject doc=new BasicDBObject();
					doc=col.findOne();
					
					temp.process(doc, wri);
					
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				return wri;
			}
		
});
		
				
		
	}

}
