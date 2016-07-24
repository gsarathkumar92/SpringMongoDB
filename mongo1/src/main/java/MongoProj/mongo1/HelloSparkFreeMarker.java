package MongoProj.mongo1;

import java.io.StringWriter;
import java.util.HashMap;
import java.util.Map;

import freemarker.template.Configuration;
import freemarker.template.Template;
import spark.Request;
import spark.Response;
import spark.Route;
import spark.Spark;

public class HelloSparkFreeMarker {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		final Configuration conf=new Configuration();
		conf.setClassForTemplateLoading(HelloSparkFreeMarker.class, "/");
		
		
		Spark.get("/", new Route(){

			public Object handle(Request arg0, Response arg1) throws Exception {
				// TODO Auto-generated method stub
				StringWriter wri=new StringWriter();
				try {
					Template temp=conf.getTemplate("hello.ftl");
					
					Map<String,Object> helloMap=new HashMap<String,Object>();
					helloMap.put("name","freemarker");
					
					temp.process(helloMap, wri);
					
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				return wri;
			}
		
	});
}
}