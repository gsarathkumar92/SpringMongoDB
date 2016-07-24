package MongoProj.mongo1;

import java.io.IOException;
import java.io.StringWriter;
import java.util.HashMap;
import java.util.Map;

import freemarker.template.Configuration;
import freemarker.template.Template;

public class HelloFreeMarker {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Configuration conf=new Configuration();
		conf.setClassForTemplateLoading(HelloFreeMarker.class, "/");
		
		try {
			Template temp=conf.getTemplate("hello.ftl");
			StringWriter wri=new StringWriter();
			Map<String,Object> helloMap=new HashMap<String,Object>();
			helloMap.put("name","freemarker");
			
			temp.process(helloMap, wri);
			System.out.println(wri);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
