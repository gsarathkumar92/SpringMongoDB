package MongoProj.mongo1;

import java.io.StringWriter;
import java.util.*;

import spark.Request;
import spark.Response;
import spark.Route;
import spark.Spark;
import freemarker.template.Configuration;
import freemarker.template.Template;

public class FruitSelect {

	public static void main(String[] args) {
		final Configuration conf=new Configuration();
		conf.setClassForTemplateLoading(FruitSelect.class, "/");
		
		Spark.get("/", new Route(){
			public Object handle(Request request, Response response)
					throws Exception {
				StringWriter wri=new StringWriter();
				try{
					Map<String,Object> fruitMap=new HashMap<String,Object>();
					fruitMap.put("fruits", Arrays.asList("apple","banana","orange"));
					
					Template fruitTemplate=conf.getTemplate("fruitpick.ftl");
					
					fruitTemplate.process(fruitMap, wri);
					
				}catch(Exception e){
					return null;
				}
				return wri;
			}
		});
		Spark.post("fav_fruit", new Route() {
			
			public Object handle(Request request, Response response) throws Exception {
				// TODO Auto-generated method stub
				final String fruit=request.queryParams("fruit");
				if(fruit==null){
					return"Why dont you pick any?";
				}else
				{
					return "Your fav fruit is "+fruit;
				}
			
			}
		});
	}

}
