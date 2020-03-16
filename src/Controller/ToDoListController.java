package Controller;

import com.juan.DAOImpl.ToDoListDAOImpl;
import com.juan.DAO.ToDoListDAO;
import com.juan.ToDoAppHibernateWeb.ToDoList;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ToDoListController
 */
@WebServlet("/ToDoListController")
public class ToDoListController extends HttpServlet {
	ToDoList toDoList = new ToDoList();
	ToDoListDAOImpl toDoListDaoImpl = new ToDoListDAOImpl();
	ToDoListDAO tdao;

	@Override
	/**
	 * Method that handles GET requests in the servlet
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		if (request.getParameter("addItem") != null) {
			String listItem = request.getParameter("listItem");
			toDoList.setItemEntry(listItem);
			toDoListDaoImpl.saveItem(toDoList);
			RequestDispatcher rd = request.getRequestDispatcher("saveItem.jsp");
			response.getWriter().append("Served at: ").append(request.getContextPath());
			rd.forward(request, response);
		}

	}

	@Override
	/**
	 * Method that handles POST requests in the servlet
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		if (request.getParameter("showItem") != null) {
			List<ToDoList> listOfItems = new ArrayList();
			listOfItems = toDoListDaoImpl.showAllListItems();
			request.setAttribute("listOfItems", listOfItems);
			RequestDispatcher rd = request.getRequestDispatcher("showAllItems.jsp");
			rd.forward(request, response);
		}

		if (request.getParameter("deleteItemSelection") != null) {
			List<ToDoList> listOfItems = new ArrayList();
			listOfItems = toDoListDaoImpl.showAllListItems();
			request.setAttribute("listOfItems", listOfItems);
			RequestDispatcher rd = request.getRequestDispatcher("deleteToDoItem.jsp");
			rd.forward(request, response);
		}

		if (request.getParameter("deleteItem") != null) {
			int id2 = Integer.parseInt(request.getParameter("itemId"));
			toDoList.setItemId(id2);
			toDoListDaoImpl.deleteItem(toDoList);
			List<ToDoList> listOfItems = new ArrayList();
			listOfItems = toDoListDaoImpl.showAllListItems();
			request.setAttribute("listOfItems", listOfItems);
			RequestDispatcher rd = request.getRequestDispatcher("deleteToDoItem.jsp");
			rd.forward(request, response);
		}

	}

	public String getServletInfo() {
		return "Short description";
	}

}
