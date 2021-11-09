import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;
public class dlogin extends HttpServlet
{
	protected void doPost(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException
	{
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/administrator", "root", "");
			String query="select * from doctor where id=? and password=?";
			PreparedStatement ps=con.prepareStatement(query);
			ps.setString(1,username);
			ps.setString(2,password);
			ResultSet rs=ps.executeQuery();
			boolean found=rs.next();
			if(found)
				response.sendRedirect("welcomedoctor.htm");
			else
				response.sendRedirect("bye.htm");
		}
		catch(Exception e)
		{
			out.println(e);
		}
	}
}