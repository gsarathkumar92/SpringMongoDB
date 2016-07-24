package MongoProj.mongo1;

import java.net.UnknownHostException;
import java.util.*;

import javax.swing.plaf.basic.BasicArrowButton;

import com.mongodb.*;
public class OrphanRemove {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MongoClient c;
		int id=0,s=0,k=0;
		String p,sp[];
		HashSet hset=new HashSet();
		Map l=new HashMap<String,Integer>();
		c=new MongoClient();
		DB db=c.getDB("photo_sharing");
		DBCollection album=db.getCollection("albums");
		DBCollection images=db.getCollection("images");
		DBObject unwind=new BasicDBObject("$unwind","$images");
		l.put("images",1);
		l.put("_id", 0);
		DBObject project=new BasicDBObject("$project",l);
		DBObject sort=new BasicDBObject("$sort",new BasicDBObject("images",1));
		AggregationOutput aout=album.aggregate(unwind,project,sort);
		Iterable<DBObject> iterable=aout.results();
		Iterator i=iterable.iterator();
		while(i.hasNext())
		{
			DBObject l1=(DBObject) i.next();
			k=	(Integer) l1.get("images");
			//System.out.println(k);
			hset.add(k);
		
		}
		System.out.println(hset.size());
		
		DBCursor cur=images.find();
		while(cur.hasNext())
		{
			DBObject v=cur.next();
			 id=(Integer) v.get("_id");
			if(!hset.contains(id))
			{
				
				images.remove(v);
				s=s+1;
			}
			
		}
		System.out.println(s);
	}

}
