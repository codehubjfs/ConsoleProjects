package com.ticket.mapper;


import com.ticket.model.RoutesBean;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface RoutesMapper {

    @Select("SELECT * FROM route WHERE ROUTE_AVAILABILITY='Y'")
    List<RoutesBean> getAllRoutes();

  @Insert("INSERT INTO route (route_id, startlocation, endlocation, distance, estimatedduration,ROUTE_AVAILABILITY) " +
  "VALUES (route_id_seq.NEXTVAL, #{startLocation}, #{endLocation}, #{distance}, #{estimatedDuration},'Y')")
void insertRoute(RoutesBean route);

  @Select("SELECT * FROM route WHERE route_id = #{routeId}")
  RoutesBean getRouteById(int routeId);

  @Update("UPDATE route SET startlocation = #{startLocation}, endlocation = #{endLocation}, distance = #{distance}, estimatedduration = #{estimatedDuration} WHERE route_id = #{route_id}")
  void updateRoute(RoutesBean route);
    @Update("UPDATE route SET ROUTE_AVAILABILITY='N' WHERE route_id = #{routeId}")
    	void delteRoute(int routeId);
}
