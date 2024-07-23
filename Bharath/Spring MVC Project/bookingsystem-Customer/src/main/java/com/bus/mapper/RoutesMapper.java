package com.bus.mapper;


import com.bus.model.Routes;

import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface RoutesMapper {

    @Select("SELECT * FROM route WHERE ROUTE_AVAILABILITY='Y'")
    @Results({
    	 @Result(property="index", column="route_id"),
	        @Result(property="source", column="startlocation"),
	        @Result(property="destination", column="endlocation"),
	        @Result(property="duration", column="distance"),
	        @Result(property="distance", column="estimatedduration"),
    })
    List<Routes> getAllRoutes();

  @Insert("INSERT INTO route (route_id, startlocation, endlocation, distance, estimatedduration,ROUTE_AVAILABILITY) " +
  "VALUES (route_id_seq.NEXTVAL, #{startLocation}, #{endLocation}, #{distance}, #{estimatedDuration},'Y')")
void insertRoute(Routes route);

  @Select("SELECT * FROM route WHERE route_id = #{routeId}")
  Routes getRouteById(int routeId);

  @Update("UPDATE route SET startlocation = #{startLocation}, endlocation = #{endLocation}, distance = #{distance}, estimatedduration = #{estimatedDuration} WHERE route_id = #{route_id}")
  void updateRoute(Routes route);
    @Update("UPDATE route SET ROUTE_AVAILABILITY='N' WHERE route_id = #{routeId}")
    	void delteRoute(int routeId);
}
