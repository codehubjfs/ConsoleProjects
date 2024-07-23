package controllers;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import bean.RoutesBean;
import dao.RouteDao;

/**
 * Servlet implementation class AddRoutesController
 */
public class AddRoutesController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       private RouteDao routeDao;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddRoutesController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		routeDao=new RouteDao();
	}

	/**
	 * @see Servlet#getServletInfo()
	 */
	public String getServletInfo() {
		// TODO Auto-generated method stub
		return null; 
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("Running...");

        try {
            String source = request.getParameter("source");
            System.out.println(source);
            String destination = request.getParameter("end");
            System.out.println(destination);
            int distance = Integer.parseInt(request.getParameter("dis"));
            int duration = Integer.parseInt(request.getParameter("time"));
            System.out.println(source + " " + destination + " " + distance + " " + duration);

            RoutesBean route = new RoutesBean();
            route.setSource(source);
            route.setDestination(destination);
            route.setDistance(distance);
            route.setDuration(duration);
            routeDao.addRoute(route);
            request.getRequestDispatcher("ViewRoutesController").forward(request, response);
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
    }
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
