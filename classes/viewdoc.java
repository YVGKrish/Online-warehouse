import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;
public class viewdoc extends HttpServlet
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
			String query="select * from doctor where id=?";
			PreparedStatement ps=con.prepareStatement(query);
			ps.setString(1,docid);
			ResultSet rs=ps.executeQuery();
			boolean found=rs.next();
			if(found)
				{
					String id  = rs.getString("id");
					String first = rs.getString("fname");
					String last = rs.getString("lname");
					String gender = rs.getString("gender");
					String depart = rs.getString("department");
					String email = rs.getString("email");
					String addr = rs.getString("address");
					int mob = rs.getInt("mobile");
					String pass = rs.getString("password");
					String qual = rs.getString("qualification");
					String exper = rs.getString("experience");
					String achi = rs.getString("achievements");
					out.println("<center>");
					out.println("<h1>Doctor Details:</h1>");
					out.println("<br>");
					out.println("ID:\n"+id);
					out.println("<br>");
					out.println("First Name:"+first);
					out.println("<br>");
					out.println("Last Name:"+last);
					out.println("<br>");
					out.println("Gender:"+gender);
					out.println("<br>");
					out.println("Department:"+depart);
					out.println("<br>");
					out.println("Email:"+email);
					out.println("<br>");
					out.println("Address:"+addr);
					out.println("<br>");
					out.println("Mobile:"+mob);
					out.println("<br>");
					out.println("Password:"+pass);
					out.println("<br>");
					out.println("Qualifications:"+qual);
					out.println("<br>");
					out.println("Experience:"+exper);
					out.println("<br>");
					out.println("Achievements:"+achi);
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