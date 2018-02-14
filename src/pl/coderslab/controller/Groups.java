package pl.coderslab.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pl.coderslab.model.ActiveRecord;
import pl.coderslab.model.Group;

/**
 * Servlet implementation class Groups
 */
@WebServlet("/Groups")
public class Groups extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Groups() {
		super();
		// TODO Auto-generated constructor stub
	}

	public boolean validate(String text) {
		return text != null && !"".equals(text);
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ActiveRecord group = new Group(true);
		request.setAttribute("group", group);
		ArrayList<String> allGroup = new ArrayList<>();
		try {
			allGroup = group.loadAllResult();
		} catch (Exception e) {
			System.out.println(e);
		}
		int limit = group.getcountRecord();
		request.setAttribute("allGroup", allGroup);
		request.setAttribute("size", (group.getFieldsWithId().length));
		request.setAttribute("limit", limit);
		getServletContext().getRequestDispatcher("/WEB-INF/jsp/groups.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
