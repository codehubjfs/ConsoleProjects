package com.carrentalsystem.controller;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import com.carrentalsystem.beans.Car;
import com.carrentalsystem.dao.CarDao;
@WebServlet("/CarController")
public class CarController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private CarDao carDao;
    public void init() {
    	System.out.println("car21");
        carDao = new CarDao();
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        String email= (String) request.getSession().getAttribute("email");
        if (email == null) {
		         
			request.getRequestDispatcher("//logout").forward(request, response);
           return;
       }
        System.out.println("car1");
        if (action == null) {
            action = "list";
        }

        try {
            switch (action) {
                case "new":
                    showNewForm(request, response);
                    break;
                case "insert":
                    insertCar(request, response);
                    break;
                case "delete":
                    deleteCar(request, response);
                    break;
                case "edit":
                    showEditForm(request, response);
                    break;
                case "update":
                    updateCar(request, response);
                    break;
                default:
                    listCar(request, response);
                    break;
            }
        } catch (Exception ex) {
            throw new ServletException(ex);
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    private void listCar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
        List<Car> listCar = carDao.getAllCars();
        request.setAttribute("listCar", listCar);
        request.getRequestDispatcher("views/admin/carmanagement.jsp").forward(request, response);
    }

    private void showNewForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("car_form.jsp").forward(request, response);
    }
    
    private void showEditForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
        int id = Integer.parseInt(request.getParameter("id"));
        Car existingCar = carDao.getCar(id);
        request.setAttribute("car", existingCar);
        request.getRequestDispatcher("car_form.jsp").forward(request, response);
    }
   
    private void insertCar(HttpServletRequest request, HttpServletResponse response) throws IOException, SQLException {
    	int id=9;
        String carName = request.getParameter("carName");
        String vehicleNo = request.getParameter("vehicleNo");
        String available = request.getParameter("available");
        double rentalRate = Double.parseDouble(request.getParameter("rentalRate"));
        int seatCount = Integer.parseInt(request.getParameter("seatCount"));
        String fuelType = request.getParameter("fuelType");
        String carType = request.getParameter("carType");
        int bags = Integer.parseInt(request.getParameter("bags"));
        String carImageUrl = request.getParameter("carImageUrl");
        Car newCar = new Car(id,carName, vehicleNo, available, rentalRate, seatCount, fuelType, carType, bags, carImageUrl);
        carDao.saveCar(newCar);
        response.sendRedirect("${pageContext.request.contextPath}/listCar");
    }
    
    private void updateCar(HttpServletRequest request, HttpServletResponse response) throws IOException, SQLException {
        int id = Integer.parseInt(request.getParameter("id"));
        String carName = request.getParameter("carName");
        String vehicleNo = request.getParameter("vehicleNo");
        String available = request.getParameter("available");
        double rentalRate = Double.parseDouble(request.getParameter("rentalRate"));
        int seatCount = Integer.parseInt(request.getParameter("seatCount"));
        String fuelType = request.getParameter("fuelType");
        String carType = request.getParameter("carType");
        int bags = Integer.parseInt(request.getParameter("bags"));
        String carImageUrl = request.getParameter("carImageUrl");
        Car car = new Car(id, carName, vehicleNo, available, rentalRate, seatCount, fuelType, carType, bags, carImageUrl);
        carDao.updateCar(car);
        response.sendRedirect("CarController");
    }

    private void deleteCar(HttpServletRequest request, HttpServletResponse response) throws IOException, SQLException {
        int id = Integer.parseInt(request.getParameter("id"));
        carDao.deleteCar(id);
        response.sendRedirect("AdminListCarServlet");
    }
}

