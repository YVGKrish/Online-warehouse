import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;
public class viewpat extends HttpServlet
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
			String query="select * from patient where id=?";
			PreparedStatement ps=con.prepareStatement(query);
			ps.setString(1,patid);
			ResultSet rs=ps.executeQuery();
			boolean found=rs.next();
			if(found)
				{
					String id  = rs.getString("id");
					String docid = rs.getString("doc_id");
					String first = rs.getString("fname");
					String last = rs.getString("lname");
					String gender = rs.getString("gender");
					String email = rs.getString("email");
					String addr = rs.getString("address");
					int mob = rs.getInt("mobile");
					out.println("<center>");
					out.println("<h1>Patient Details:</h1>");
					out.println("<br>");
					out.println("ID:\n"+id);
					out.println("<br>");
					out.println("Doc ID:"+docid);
					out.println("<br>");
					out.println("First Name:"+first);
					out.println("<br>");
					out.println("Last Name:"+last);
					out.println("<br>");
					out.println("Gender:"+gender);
					out.println("<br>");
					out.println("Email:"+email);
					out.println("<br>");
					out.println("Address:"+addr);
					out.println("<br>");
					out.println("Mobile:"+mob);
					out.println("<br>");
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