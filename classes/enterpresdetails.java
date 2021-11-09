import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;
public class enterpresdetails extends HttpServlet
{
	protected void doPost(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException
	{
		String presid=request.getParameter("prescriptionid");
		String patid=request.getParameter("patientid");
		String docid=request.getParameter("doctorid");
		String curract=request.getParameter("patient");
		String jdate=request.getParameter("joineddate");
		String ddate=request.getParameter("dischargedate");
		String provider=request.getParameter("Provider");
		String medicine1=request.getParameter("medicine1");
		String medicine2=request.getParameter("medicine2");
		String dosage=request.getParameter("no.of");
		String medicineunits=request.getParameter("medicineunits");
		String noofrefills=request.getParameter("no.of.refills");
		String notes=request.getParameter("notes");
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/administrator", "root", "");
			String query="insert into prescription(p_id,patient_id,doc_id,cerract,startdate,enddate,provider,dname1,dname2,dosage,medicineunits,refills,notes) values (?,?,?,?,?,?,?,?,?,?,?,?,?)";
			PreparedStatement ps=con.prepareStatement(query);
			ps.setString(1,presid);
			ps.setString(2,patid);
			ps.setString(3,docid);
			ps.setString(4,curract);
			ps.setString(5,jdate);
			ps.setString(6,ddate);
			ps.setString(7,provider);
			ps.setString(8,medicine1);
			ps.setString(9,medicine2);
			ps.setString(10,dosage);
			ps.setString(11,medicineunits);
			ps.setString(12,noofrefills);
			ps.setString(13,notes);
			int rows=ps.executeUpdate();
			out.println("INSERTED..!!");
		}
		catch(Exception e)
		{
			out.println(e);
		}
	}
}