import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;
public class enterpatdetails extends HttpServlet
{
	protected void doPost(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException
	{
		String patid=request.getParameter("pid");
		String doc=request.getParameter("did");
		String fname=request.getParameter("fname");
		String lname=request.getParameter("lname");
		String gender=request.getParameter("gender");
		String email=request.getParameter("email");
		String disease=request.getParameter("disease");
		String address=request.getParameter("address");
		String mobile=request.getParameter("mobile");
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/administrator", "root", "");
			String query="insert into patient(id,doc_id,fname,lname,gender,email,disease,address,mobile) values (?,?,?,?,?,?,?,?,?)";
			PreparedStatement ps=con.prepareStatement(query);
			ps.setString(1,patid);
			ps.setString(2,doc);
			ps.setString(3,fname);
			ps.setString(4,lname);
			ps.setString(5,gender);
			ps.setString(6,email);
			ps.setString(7,disease);
			ps.setString(8,address);
			ps.setString(9,mobile);
			int rows=ps.executeUpdate();
			out.println("INSERTED..!!");
		}
		catch(Exception e)
		{
			out.println(e);
		}
	}
}