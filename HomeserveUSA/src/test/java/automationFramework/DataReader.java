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


	public static String geturl() throws IOException {
		String url=null;
		configProperties=new Properties();
		configProperties.load(new FileInputStream((new File(System.getProperty("user.dir")+"/src/test/resources/config.properties"))));
		String env=configProperties.getProperty("server.env");
		String Site=configProperties.getProperty("server.site");
		System.out.println(env);
		System.out.println(Site);
		if(Site!=null){
			switch (Site){
				case"aepindianamichigan":
					url= "https://www.reghomeserve.com/sc/mail/" +Site;
					if(env.equalsIgnoreCase("preprod")){
						url = url;
					} else if (env.equalsIgnoreCase("test")) {
						url = url.replace("www.reg","www.uat");
					}else if (env.equalsIgnoreCase("prod")) {
						url = url.replace("www.reg","www.");
					}
					break;
				case"wvwachoice":
					url= "https://www.reghomeserve.com/sc/mail/" +Site;
					if(env.equalsIgnoreCase("preprod")){
						url = url.replace("www.reg","www.reg");
					} else if (env.equalsIgnoreCase("test")) {
						url = url.replace("www.reg","www.uat");
					}else if (env.equalsIgnoreCase("prod")) {
						url = url.replace("www.reg","www.");
					}
					break;
				case"buffalowaternipcnew":
					url= "https://www.reghomeserve.com/sc/mail/" +Site;
					if(env.equalsIgnoreCase("preprod")){
						url = url.replace("www.reg","www.reg");
					} else if (env.equalsIgnoreCase("test")) {
						url = url.replace("www.reg","www.uat");
					}else if (env.equalsIgnoreCase("prod")) {
						url = url.replace("www.reg","www.");
					}
					break;
				case"kypower-tabs":
					url= "https://www.reghomeserve.com/sc/mail/" +Site;
					if(env.equalsIgnoreCase("preprod")){
						url = url.replace("www.reg","www.reg");
					} else if (env.equalsIgnoreCase("test")) {
						url = url.replace("www.reg","www.uat");
					}else if (env.equalsIgnoreCase("prod")) {
						url = url.replace("www.reg","www.");
					}
					break;
				case"firstenergy-fundle":
					url= "https://www.reghomeserve.com/sc/mail/" +Site;
					if(env.equalsIgnoreCase("preprod")){
						url = url.replace("www.reg","www.reg");
					} else if (env.equalsIgnoreCase("test")) {
						url = url.replace("www.reg","www.uat");
					}else if (env.equalsIgnoreCase("prod")) {
						url = url.replace("www.reg","www.");
					}
					break;
				case "sanjose":
					url= "https://www.reghomeserve.com/sc/mail/" +Site;
					if(env.equalsIgnoreCase("preprod")){
						url = url.replace("www.reg","www.reg");
					} else if (env.equalsIgnoreCase("test")) {
						url = url.replace("www.reg","www.uat");
					}else if (env.equalsIgnoreCase("prod")) {
						url = url.replace("www.reg","www.");
					}
					break;
				case"lasanitation":
					url= "https://" + env + ".slwofa.com/mail/" +Site;
					break;
				case"ottawa":
					url= "https://" + env + ".slwofc.ca/mail/" +Site;
					break;
				case"Homeserve":
					url= "https://www.reghomeserve.com/?ncr=true";
					if(env.equalsIgnoreCase("preprod")){
						url = url.replace("www.reg","www.reg");
					} else if (env.equalsIgnoreCase("test")) {
						url = url.replace("www.reg","www.uat");
					}else if (env.equalsIgnoreCase("prod")) {
						url = url.replace("www.reg","www.");
					}
					break;
				case"slwofa":
					url= "https://" + env + ".slwofa.com/";
					break;
				case"slwofc":
					url= "https://" + env + ".slwofc.ca/";
					break;
				case"HomeServe-CE":
					url= "https://www.reghomeserve.com/sc/mail/homeserve-ce";
					if(env.equalsIgnoreCase("preprod")){
						url = url.replace("www.reg","www.reg");
					} else if (env.equalsIgnoreCase("test")) {
						url = url.replace("www.reg","www.uat");
					}else if (env.equalsIgnoreCase("prod")) {
						url = url.replace("www.reg","www.");
					}
					break;

				default:
					System.out.println("Invalid url entered");
					Assert.fail("Invalid url entered :: "+Site);
			}
		}
		System.out.println("URL under test: " + url);
		return url;
	}
//	public static void main(String args[]) throws IOException {
//		geturl();
//	}
}
