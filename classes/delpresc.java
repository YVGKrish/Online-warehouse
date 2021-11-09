import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;
public class delpresc extends HttpServlet
{
	protected void doPost(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException
	{
		String presid=request.getParameter("presid");
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/administrator", "root", "");
			String query="delete from prescription where p_id=?";
			PreparedStatement ps=con.prepareStatement(query);
			ps.setString(1,presid);
			int rows=ps.executeUpdate();
			if(rows>=1)
				{
					out.println("<center>");
					out.println("<h1>Prescription Successfully Deleted</h1>");
					out.println("</center>");
				}
			else
			{
				out.println("<center>");
				out.println("<h1>In Valid Prescription ID or Prescription Does Not Exist</h1>");
				out.println("</center>");
			}
		}
		catch(Exception e)
		{
			out.println(e);
		}
	}
}