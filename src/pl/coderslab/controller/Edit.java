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
import pl.coderslab.model.Group;
import pl.coderslab.model.Solution;

/**
 * Servlet implementation class Edit
 */
@WebServlet("/Edit")
public class Edit extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String className = null;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Edit() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int limit = 0;
		System.out.println(request.getParameter("form"));
		if (request.getParameter("form") != null) {
			String form = request.getParameter("form");
			setClassName(form);
		} else {
			getClassName();
		}
		ActiveRecord data = getObject();
		ArrayList<String> allData = new ArrayList<>();
		String limitParameter = request.getParameter("limit");
		if (validate(limitParameter)) {
			try {
				limit = Integer.parseInt(limitParameter);
				if (limit > 0) {
					allData = data.loadWithLimit(limit);
				}
			} catch (Exception e) {
				System.out.println(e);
			}
		} else {
			try {
				allData = data.loadAllResult("");
				limit = data.getcountRecord();
			} catch (Exception e) {
				System.out.println(e);
			}
		}

		request.setAttribute("data", data);
		request.setAttribute("allData", allData);
		request.setAttribute("size", (data.getFieldsWithId().length));
		request.setAttribute("limit", limit);
		request.setAttribute("className", className);
		getServletContext().getRequestDispatcher("/WEB-INF/jsp/edit.jsp").forward(request, response);

	}

	private ActiveRecord getObject() {
		ActiveRecord data = null;
		if ("User".equals(className)) {
			data = new User(true);
		} else if ("Group".equals(className)) {
			data = new Group(true);
		} else {
			data = new Solution(true);
		}
		return data;
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public boolean validate(String text) {
		return text != null && !"".equals(text);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String idParameter = request.getParameter("id");
		ActiveRecord data = getObject();
		try {
			int id = Integer.parseInt(idParameter);
			data.delete(id);
			response.sendRedirect("http://localhost:8080/Warsztaty_3/Edit");
		} catch (Exception e) {
			System.out.println(e);
			response.sendRedirect("http://localhost:8080/Warsztaty_3/Edit");
		}

	}

}
