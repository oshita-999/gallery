package controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;

/**
 * Servlet implementation class ContactServlet
 */
@WebServlet("/contact")
public class ContactServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	  
	  String test = null;
	  if( StringUtils.isEmpty(test)) {
		System.out.println("null");
	  }
		request.getRequestDispatcher("/WEB-INF/view/contact.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String[] itemList = request.getParameterValues("item");
		Map<String, String> itemMap = new HashMap<>();
		for(String items : itemList) {
		  String[] item = items.split("-");
		  itemMap.put(item[0], item[1]);
		}
		
		for(Entry<String, String> item: itemMap.entrySet()) {
		  System.out.println(item.getKey()+"→"+item.getValue());		  
		}

		doGet(request, response);
	}

}
