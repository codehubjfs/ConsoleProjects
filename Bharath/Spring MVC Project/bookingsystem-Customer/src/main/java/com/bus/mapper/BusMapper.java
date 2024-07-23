package com.bus.mapper;

import java.time.LocalDate;
import java.util.List;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Param;

import com.bus.model.Bus;
import com.bus.model.Routes;

public interface BusMapper {

	    @Select("SELECT BUS_ID, BUSNAME, BUSTYPE, BUSCAPACITY, FARE, ROUTE_ID, DAYOFROUTE, DEPARTURETIME, ARRIVALTIME FROM BUS WHERE BUS_AVAILABILITY='Y'")
	    @Results({
	    	 @Result(property="busid", column="BUS_ID"),
		        @Result(property="busName", column="BUSNAME"),
		        @Result(property="busType", column="BUSTYPE"),
		        @Result(property="busCapacity", column="BUSCAPACITY"),
		        @Result(property="busFare", column="FARE"),
		        @Result(property="route.index", column="Route_ID"),
		        @Result(property="dateOfBus", column="DAYOFROUTE"),
		        @Result(property="departureTime", column="DEPARTURETIME"),
		        @Result(property="arrivalTime", column="ARRIVALTIME"),
	    })
	    List<Bus> busList();
	      
	    @Select("SELECT b.BUS_ID,b.BUSNAME, b.BUSTYPE, b.BUSCAPACITY, b.FARE, b.ROUTE_ID, b.DAYOFROUTE, b.DEPARTURETIME, b.ARRIVALTIME, " +
	            "r.STARTLOCATION, r.ENDLOCATION " +
	            "FROM BUS b " +
	            "JOIN ROUTE r ON b.ROUTE_ID = r.ROUTE_ID " +
	            "WHERE r.STARTLOCATION = #{source} AND r.ENDLOCATION = #{destination} AND b.DAYOFROUTE = #{travelDate}")
	    @Results({
	        @Result(property="busid", column="BUS_ID"),
	        @Result(property="busName", column="BUSNAME"),
	        @Result(property="busType", column="BUSTYPE"),
	        @Result(property="busCapacity", column="BUSCAPACITY"),
	        @Result(property="busFare", column="FARE"),
	        @Result(property="dateOfBus", column="DAYOFROUTE"),
	        @Result(property="departureTime", column="DEPARTURETIME"),
	        @Result(property="arrivalTime", column="ARRIVALTIME"),
	        @Result(property="route", column="ROUTE_ID", javaType=Routes.class, one=@One(select="selectRouteById"))
	    })
	    List<Bus> searchBuses(@Param("source") String source, @Param("destination") String destination, @Param("travelDate") LocalDate travelDate);

	    
	    @Select("SELECT * FROM ROUTE WHERE ROUTE_ID = #{routeId}")
	    @Results({
	        @Result(property="index", column="ROUTE_ID"),
	        @Result(property="source", column="SOURCE"),
	        @Result(property="destination", column="DESTINATION")
	    })
	    Routes selectRouteById(@Param("routeId") int routeId);
	}