import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;
public class delpat extends HttpServlet
{
	protected void doPost(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException
	{
		String patid=request.getParameter("patid");
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/administrator", "root", "");
			String query="delete from patient where id=?";
			PreparedStatement ps=con.prepareStatement(query);
			ps.setString(1,patid);
			int rows=ps.executeUpdate();
			if(rows>=1)
				{
					out.println("<center>");
					out.println("<h1>Patient details Successfully Deleted</h1>");
					out.println("</center>");
				}
			else
			{
				out.println("<center>");
				out.println("<h1>In Valid Patient ID or Patient Does Not Exist</h1>");
				out.println("</center>");
			}
		}
		catch(Exception e)
		{
			out.println(e);
		}
	}
}