package samplecheckingcode;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.LinkedHashMap;

import com.bookingbus.Bus;
import com.databaseconnection.DbConnection;
import com.persondetails.BusOperator;

public class SampleDelete {

	public static void main(String[] args) {
		BusOperator bo=new BusOperator();
		bo.deleteBus();
		// TODO Auto-generated method stub
	}
}