import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;
public class viewpresc extends HttpServlet
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
			String query="select * from prescription where p_id=?";
			PreparedStatement ps=con.prepareStatement(query);
			ps.setString(1,presid);
			ResultSet rs=ps.executeQuery();
			boolean found=rs.next();
			if(found)
				{
					String id  = rs.getString("p_id");
					String pid = rs.getString("patient_id");
					String did = rs.getString("doc_id");
					String curr = rs.getString("cerract");
					String sd = rs.getString("startdate");
					String ed = rs.getString("enddate");
					String prov = rs.getString("provider");
					String drug1 = rs.getString("dname1");
					String drug2 = rs.getString("dname2");
					String dosage = rs.getString("dosage");
					int mu = rs.getInt("medicineunits");
					int refills = rs.getInt("refills");
					String notes = rs.getString("notes");
					out.println("<center>");
					out.println("<h1>Prescription Details:</h1>");
					out.println("<br>");
					out.println("Prescription Id:\n"+id);
					out.println("<br>");
					out.println("Patient Id:"+pid);
					out.println("<br>");
					out.println("Doctor Id:"+did);
					out.println("<br>");
					out.println("Currently Active:"+curr);
					out.println("<br>");
					out.println("Start Date:"+sd);
					out.println("<br>");
					out.println("End Date:"+ed);
					out.println("<br>");
					out.println("Provider:"+prov);
					out.println("<br>");
					out.println("Drug 1:"+drug1);
					out.println("<br>");
					out.println("Drug 2:"+drug2);
					out.println("<br>");
					out.println("Dosage:"+dosage);
					out.println("<br>");
					out.println("Mesdicine Units:"+mu);
					out.println("<br>");
					out.println("Refills:"+refills);
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