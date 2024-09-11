package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DaoFactory;
import dao.ImageDao;
import domain.ImageItem;

/**
 * Servlet implementation class GalleryServlet
 */
@WebServlet("/gallery")
public class GalleryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		ImageDao dao = DaoFactory.createImageDao();
		List<ImageItem> imageList = dao.allImageItem();

		System.out.println(imageList);
		request.setAttribute("imageList", imageList);

		request.getRequestDispatcher("/WEB-INF/view/gallery.jsp").forward(request, response);
	}

}
