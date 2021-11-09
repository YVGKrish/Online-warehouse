import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;
public class deldoc extends HttpServlet
{
	protected void doPost(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException
	{
		String docid=request.getParameter("docid");
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/administrator", "root", "");
			String query="delete from doctor where id=?";
			PreparedStatement ps=con.prepareStatement(query);
			ps.setString(1,docid);
			int rows=ps.executeUpdate();
			if(rows>=1)
				{
					out.println("<center>");
					out.println("<h1>Doctor Profile Successfully Deleted</h1>");
					out.println("</center>");
				}
			else
			{
				out.println("<center>");
				out.println("<h1>In Valid Doctor ID or Doctor Does Not Exist</h1>");
				out.println("</center>");
			}
		}
		catch(Exception e)
		{
			out.println(e);
		}
	}
}