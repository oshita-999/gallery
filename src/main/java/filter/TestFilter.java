package filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;

/**
 * Servlet Filter implementation class TestFilter
 */
// 【５】全てのURLに対応
@WebFilter("/*")
public class TestFilter extends HttpFilter implements Filter {
	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		/*
		// 【５】
		// 前処理　
		//System.out.println("Hello");
		chain.doFilter(request, response);
		// 【６】
		// 後処理
		System.out.println("Goodbye");
		

		// 【７】
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;
		// セッションスコープの中を調べることが出来る。例えばログインの証があるかどうか。無ければ強制リダイレクトなど
		HttpSession session = req.getSession();
		//これでdoGetやdoPostと同じようなことができるようになりました。

		// 【８】
		// /abcにアクセス→強制リダイレクト　
		String url = req.getServletPath();
//		if (url.equals("/abc")) {
//			res.sendRedirect(req.getContextPath() + "/contact");
//			return;
//		}
		if(!url.endsWith("/contact") && !url.endsWith("css")) {
			res.sendRedirect(req.getContextPath() + "/upload");
			return;
		}
*/
		chain.doFilter(request, response);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
