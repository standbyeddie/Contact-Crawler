package crawler.DAO;

import java.sql.Connection;
import java.sql.SQLException;

import crawler.EmailCrawlerConfig;

public class SalesgenieDAO {
	private static Connection connection = MySQLConnector.createConnection("EmailCrawlerDB", EmailCrawlerConfig.getConfig().readString("db-username"), EmailCrawlerConfig.getConfig().readString("db-password"));
	
	public static void reconnect() throws SQLException {
		connection.close();
		connection = MySQLConnector.createConnection("EmailCrawlerDB", EmailCrawlerConfig.getConfig().readString("db-username"), EmailCrawlerConfig.getConfig().readString("db-password"));
	}
	public static void insert(String sg_person_name, String sg_phone_number, String sg_title, String sg_company_name, String sg_street, String sg_city, String sg_state, String sg_zipcode) {
		MySQLConnector.executeQuery(connection, "INSERT INTO SalesGenie VALUES('" 
			+ sg_person_name + "', '" 
			+ sg_phone_number.replace("'", "''") + "', '"
			+ sg_title.replace("'", "''") + "', '"
			+ sg_company_name.replace("'", "''") + "', '"
			+ sg_street.replace("'", "''") + "', '"
			+ sg_city.replace("'", "''") + "', '" 
			+ sg_state + "', '" 
			+ sg_zipcode + "');", true);
	}
}
