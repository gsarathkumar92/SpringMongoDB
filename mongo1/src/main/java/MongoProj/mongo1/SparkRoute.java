package MongoProj.mongo1;

import spark.Request;
import spark.Response;
import spark.Route;
import spark.Spark;

public class SparkRoute {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Spark.get("/", new Route(){
			public Object handle(Request request, Response response)
					throws Exception {
		
				return "Empty";
			}
		});
		Spark.get("/test", new Route(){
			public Object handle(Request request, Response response)
					throws Exception {
		
				return "Hiii";
			}
		});
		Spark.get("/echo/:thing", new Route(){
			public Object handle(Request request, Response response)
					throws Exception {
		
				return request.params(":thing");
			}
		});
		
	}

}
