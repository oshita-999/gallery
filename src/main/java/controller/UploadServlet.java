package controller;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import dao.DaoFactory;
import dao.ImageDao;

/**
 * Servlet implementation class UploadServlet
 */
@WebServlet("/upload")
// 【N2】
@MultipartConfig(location="C:/Users/zdis62/temp")
// L1
//@MultipartConfig(location = "/tmp")
public class UploadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/view/upload.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String title = request.getParameter("title");
//		Integer id = Integer.parseInt(request.getParameter("id"));
		Part upfile = request.getPart("upfile");
		String imageName = upfile.getSubmittedFileName();

		// 入力値の確認
		System.out.println(title); // タイトル
		System.out.println(upfile.getSize());// ファイルのサイズ
		System.out.println(upfile.getContentType());// ファイルの種類
		System.out.println(upfile.getSubmittedFileName());// ファイル名

		// DBへ保存
		ImageDao dao =  DaoFactory.createImageDao();
		dao.addImage(imageName, title, 1);
		// ファイルへ保存先
		ServletContext ctx = request.getServletContext();
		String path = ctx.getRealPath("/upload");
		// ユーザーがアップロードしたファイル名をそのまま指定
		upfile.write(path + "/" + upfile.getSubmittedFileName());
		response.sendRedirect(request.getContextPath() + "/gallery");
	}

}
