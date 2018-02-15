package pl.coderslab.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pl.coderslab.model.ActiveRecord;
import pl.coderslab.model.Group;
import pl.coderslab.model.Solution;
import pl.coderslab.model.User;

/**
 * Servlet implementation class Update
 */
@WebServlet("/Update")
public class Update extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String className = null;
	private int id = 0;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Update() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	private ActiveRecord getObject() {
		ActiveRecord data = null;
		if ("User".equals(className)) {
			data = new User();
		} else if ("Group".equals(className)) {
			data = new Group();
		} else {
			data = new Solution();
		}
		return data;
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String idParameter = request.getParameter("id");
		setId(Integer.parseInt(idParameter));
		setClassName(request.getParameter("className"));
		ActiveRecord data = getObject();
		request.setAttribute("data", data);
		getServletContext().getRequestDispatcher("/WEB-INF/jsp/update.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	public boolean validate(String text) {
		return text != null && !"".equals(text);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ActiveRecord data = getObject();
		String update = "";
		for (String name : data.getFields()) {
			if (validate(request.getParameter(name))) {
				data.setValue(name, request.getParameter(name));
				update += name + "=" + "\"" + request.getParameter(name) + "\"" + ",";
			}
		}
		data.save(getId(), update.substring(0, update.length() - 1));
		response.sendRedirect("http://localhost:8080/Warsztaty_3/Edit");
	}

}
