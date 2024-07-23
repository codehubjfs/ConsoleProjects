package controllers;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import bean.RoutesBean;
import dao.RouteDao;

/**
 * Servlet implementation class EditRoutesController
 */
public class EditRoutesController extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int sNo = Integer.parseInt(request.getParameter("editRouteID"));
        String source = request.getParameter("editStartLocation");
        String destination = request.getParameter("editEndLocation");
        int distance = Integer.parseInt(request.getParameter("editDestination"));
        int duration =Integer.parseInt(request.getParameter("editDuration"));
        RoutesBean route=new RoutesBean();
        route.setIndex(sNo);
        route.setSource(source);
        route.setDestination(destination);
        route.setDistance(distance);
        route.setDuration(duration);
        boolean update=new RouteDao().updateRoute(route);
        
//        boolean updated = routeDao.updateRoute(sNo, source, destination, distance, duration);

        if (update) {
            response.sendRedirect("ViewRoutesController");
            System.out.println(update);
        } else {
            response.getWriter().println("Failed to update route.");
        }
    
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
