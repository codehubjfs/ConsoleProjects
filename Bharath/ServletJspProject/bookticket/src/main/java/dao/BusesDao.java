package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import bean.BookingBean;
import bean.Bus;
import bean.BusStop;
import bean.RoutesBean;
import util.Database;

public class BusesDao {

	public List<Bus> busList(){
		List<Bus> busList=new ArrayList<>();
		
		try {
			RouteDao routeDao=new RouteDao();
			Connection con=Database.getConnection();
			String sql="SELECT BUS_ID,BUSNAME,BUSTYPE,BUSCAPACITY,FARE,ROUTE_ID,DAYOFROUTE,DEPARTURETIME,ARRIVALTIME FROM BUS where BUS_AVAILABILITY='Y'";
			PreparedStatement statement = con.prepareStatement(sql);
			ResultSet resultSet = statement.executeQuery(); 
            while(resultSet.next()) {
            	Bus bus=new Bus();
            	int busId=resultSet.getInt("BUS_ID");
            	String busName=resultSet.getString("busname");
            	String busType=resultSet.getString("bustype");
            	int busCapacity=resultSet.getInt("buscapacity");
            	int fare=resultSet.getInt("fare");
            	LocalDate dayOfRoute=resultSet.getDate("dayofroute").toLocalDate();
            	LocalDateTime arrivalTime=resultSet.getTimestamp("arrivaltime").toLocalDateTime();
            	LocalDateTime departureTime=resultSet.getTimestamp("departuretime").toLocalDateTime();
            	bus.setBusid(busId);
            	bus.setBusName(busName);
            	bus.setBusType(busType);
            	bus.setBusCapacity(busCapacity);
            	bus.setBusFare(fare);
            	bus.setDateOfBus(dayOfRoute);
            	bus.setDepartureTime(departureTime);
            	bus.setArrivalTime(arrivalTime);
            	RoutesBean routesBean=new RoutesBean();
            	int routeId=resultSet.getInt("ROUTE_ID");
            	RoutesBean route=routeDao.getAllRoutes().stream().filter(x->x.getIndex()==routeId).findFirst().orElse(null);
            	bus.setRoute(route);
            	busList.add(bus);
            }
            System.out.println(busList);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return busList;
}
//	public Bus findBus(int busid) throws SQLException {
//        Connection con = null;
//        PreparedStatement ps = null;
//        ResultSet rs = null;
//        Bus bus = null;
//        BookingBean book=null;
//        String query = "SELECT * FROM bus WHERE busid = ?";
//        try {
//            con = Database.getConnection();
//            ps = con.prepareStatement(query);
//            ps.setInt(1, busid); 
//            rs = ps.executeQuery();
//            if (rs.next()) {
//                bus = new Bus();
//                bus.setBusid(rs.getInt("busid"));                  
//                bus.setBusName(rs.getString("Busname"));
//                bus.setBusType(rs.getString("bustype"));
//                bus.setBusCapacity(rs.getInt("buscapacity"));
//                bus.setBusFare(rs.getInt("busfare"));
//                
//            }
//            
//        }
//        catch(Exception e) {
//        	e.printStackTrace();
//        }
//		return bus;
//	}
//	public List<BusStop> getStoppingPointsByBusId() {
//        List<BusStop> stoppingList = new ArrayList<>();
//
//        try {
//        	RouteDao routeDao=new RouteDao();
//        	Connection con=Database.getConnection();
//            String query = "SELECT stop_id, pickuppoint, droppingpoint, route_id, bus_id FROM stopping_table";
//            PreparedStatement stmt = con.prepareStatement(query);
//            ResultSet rs = stmt.executeQuery();
//            while (rs.next()) {
//            	BusStop busStop=new BusStop();
//                int stopId = rs.getInt("stop_id");
//                String pickupPoint = rs.getString("pickuppoint");
//                String droppingPoint = rs.getString("droppingpoint");
//                busStop.setStopId(stopId);
//                busStop.setPickupPoint(pickupPoint);
//                busStop.setDroppingPoint(droppingPoint);
//                Bus bus=new Bus();
//                int busId=rs.getInt("Bus_id");
//                BusStop stops=routeDao.getAllStop().stream().filter(x->x.getBus().getBusid()==busId).findFirst().orElse(null);
//                busStop.setBus(bus);
//                stoppingList.add(stops);
//            }
//            System.out.println(stoppingList);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return stoppingList;
//    }

}
