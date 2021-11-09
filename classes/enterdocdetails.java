import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;
public class enterdocdetails extends HttpServlet
{
	protected void doPost(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException
	{
		String docid=request.getParameter("id");
		String password=request.getParameter("password");
		String fname=request.getParameter("fname");
		String lname=request.getParameter("lname");
		String gender=request.getParameter("gender");
		String dept=request.getParameter("dept");
		String email=request.getParameter("email");
		String address=request.getParameter("address");
		String qual=request.getParameter("qual");
		String exper=request.getParameter("Exper");
		String mobile=request.getParameter("mobile");
		String achi=request.getParameter("achievements");
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/administrator", "root", "");
			String query="insert into doctor(id,fname,lname,gender,department,email,address,mobile,password,qualification,experience,achievements) values (?,?,?,?,?,?,?,?,?,?,?,?)";
			PreparedStatement ps=con.prepareStatement(query);
			ps.setString(1,docid);
			ps.setString(2,fname);
			ps.setString(3,lname);
			ps.setString(4,gender);
			ps.setString(5,dept);
			ps.setString(6,email);
			ps.setString(7,address);
			ps.setString(8,mobile);
			ps.setString(9,password);
			ps.setString(10,qual);
			ps.setString(11,exper);
			ps.setString(12,achi);
			int rows=ps.executeUpdate();
			out.println("INSERTED..!!");
		}
		catch(Exception e)
		{
			out.println(e);
		}
	}
}