package pl.coderslab.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pl.coderslab.model.ActiveRecord;
import pl.coderslab.model.User;

/**
 * Servlet implementation class UsersFromGroup
 */
@WebServlet("/UsersFromGroup")
public class UsersFromGroup extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UsersFromGroup() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ActiveRecord user = new User(true);
		String idParameter = request.getParameter("id");
		request.setAttribute("user", user);
		ArrayList<String> searchingUsers = new ArrayList<>();
		String word = "where user_group_id=" + idParameter;
		try {
			int id = Integer.parseInt(idParameter);
			searchingUsers = user.loadAllResult(word);
		} catch (Exception e) {
			System.out.println(e);
		}
		int limit = user.getcountRecord();
		request.setAttribute("searchingUsers", searchingUsers);
		request.setAttribute("size", (user.getFieldsWithId().length));
		request.setAttribute("limit", limit);
		getServletContext().getRequestDispatcher("/WEB-INF/jsp/allUsersFromGroup.jsp").forward(request, response);
	}
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
