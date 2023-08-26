package Config;


import org.testng.annotations.Test;


/**
 * 
 * @author Sarath Banala
 *
 */
public class update_Config_Properties {
	
	@Test
	public static void Update_Config_Prop(String Value) throws Exception {
		try {

			Update_Config_Values.set_config_values("server.url", Value );
	        System.out.println("After updating properties file");
	        System.out.println("server.url: " + Update_Config_Values.get_Config_Val("server.url"));

		        
	}	 catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}



}