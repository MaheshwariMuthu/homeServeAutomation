package automationFramework;

import java.io.*;
import java.nio.file.Files;
import java.util.Properties;
import java.util.ResourceBundle;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.testng.Assert;

public class DataReader {
	public static Properties configProperties;

	public static Object getFileLocation()
			throws FileNotFoundException, IOException, org.json.simple.parser.ParseException {
		JSONParser parser = new JSONParser();
		return parser.parse(new FileReader(System.getProperty("user.dir")+"/DataFiles/schneiderData.json"));
	}

	/**
	 * Description: To read the jason data 
	 * @param key
	 * @param node
	 * @return
	 * @throws FileNotFoundException
	 * @throws IOException
	 * @throws org.json.simple.parser.ParseException
	 */
	public static String getParameterString(String key, String node)
			throws FileNotFoundException, IOException, org.json.simple.parser.ParseException {
		geturl();
		Object obj = getFileLocation();
		JSONArray array = new JSONArray();
		array.add(obj);
		JSONObject jsonObject = (JSONObject) array.get(0);
		JSONObject record = (JSONObject) jsonObject.get(node);
		String value = (String) record.get(key);
		return value;
	}

	public static String geturl() throws IOException {
		String url=null;
		configProperties=new Properties();
		configProperties.load(new FileInputStream((new File(System.getProperty("user.dir")+"/src/test/resources/config.properties"))));
		String env=configProperties.getProperty("server.env");
		String Site=configProperties.getProperty("server.url");
		System.out.println(env);
		System.out.println(Site);
		if(Site!=null){
			switch (Site){

				case"aepindianamichigan":
					url="https://www.reghomeserve.com/sc/mail/"+Site;
					break;
				case"wvwachoice":
					url="https://www.reghomeserve.com/sc/mail/"+Site;
					break;
				case"buffalowaternipcnew":
					url="https://www.reghomeserve.com/sc/mail/"+Site;
					break;
				case"kypower-tabs":
					url="https://www.reghomeserve.com/sc/mail/"+Site;
					break;
				case"firstenergy-fundle":
					url="https://www.reghomeserve.com/sc/mail/"+Site;
					break;
				case "sanjose":
					url="https://www.reghomeserve.com/sc/mail/"+Site;
					break;
				case"lasanitation":
					url="https://preprod.slwofa.com/mail/"+Site;
					break;
				case"ottawa-french":
					url="https://preprod.slwofc.ca/mail/"+Site;
					break;
				case"Homeserve":
					url="https://www.reghomeserve.com/?ncr=true";
					break;
				case"slwofa":
					url="https://preprod.slwofa.com/";
					break;
				case"slwofc":
					url="https://preprod.slwofc.ca/";
					break;
				case"HomeServe-CE":
					url="https://www.reghomeserve.com/sc/mail/homeserve-ce";
					break;

				default:
					System.out.println("Invalid url entered");
					Assert.fail("Invalid url entered :: "+Site);
			}
		}
		return url;
	}
//	public static void main(String args[]) throws IOException {
//		geturl();
//	}
}
