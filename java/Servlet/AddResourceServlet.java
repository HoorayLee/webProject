package Servlet;

import com.database.*;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;






import com.action.library.AddResourceAction;
import com.bean.library.*;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;


@WebServlet("/AddResourceServlet")

public class AddResourceServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public AddResourceServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	}

	/**
	 * @������Դ����ԴID��1��ʼ����
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		try 
		{
			request.setCharacterEncoding("utf-8");
		} catch (UnsupportedEncodingException e) 
		{
			e.printStackTrace();
		}
		
		long itemSize=0;
		//�����Ǳ����ļ�
		boolean isMultipart = ServletFileUpload.isMultipartContent(request);
		if (!isMultipart) return;
		// Create a factory for disk-based file items
		FileItemFactory factory = new DiskFileItemFactory();

		String path = "D:��/app/ResourceStore";

		((DiskFileItemFactory) factory).setRepository(new File(path));
		//�������1024*1024�Ŵ洢����ʱĿ¼�£����С�ھ�ֱ�Ӷ�ȡ���ڴ���
		((DiskFileItemFactory) factory).setSizeThreshold(1024 * 1024);

		// Create a new file upload handler
		ServletFileUpload upload = new ServletFileUpload(factory);
		// Set overall request size constraint
		upload.setSizeMax(10000000);
		// Parse the request
		List<FileItem> items = null;
		try
		{
			items = (List<FileItem>) upload.parseRequest(request);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		if (null == items) System.out.println("�ϲ��ļ�Error!");
		for (FileItem item : items)
		{
			if (item.isFormField())
			{
				continue;
			}
			else
			{
				String fieldName = item.getFieldName();
				itemSize=item.getSize();
				String value = item.getName();
				int start = value.lastIndexOf("\\");

				String fileName = value.substring(start + 1);

				//System.out.println("fieldName is:" + fieldName + " fieldValue is:" + fileName);
				//����
				try
				{
					item.write(new File(path, fileName));
				}
				catch (Exception e)
				{
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				

			}
		}
		
		//�����ļ�����,���µ�file
		int ResourceID = 0;
		String name;
		String authorID;
		int downloadTime=0;
		int size; //δ���
		int praise=0;
		int criticize=0;
		String colleage;
		int grade;
		String courseName;
		String description;
		
		name=request.getParameter("resourceName");
		authorID=request.getSession().getAttribute("account").toString();
		colleage=request.getParameter("colleage");
		grade=Integer.parseInt(request.getParameter("grade"));
		courseName=request.getParameter("className");
		description=request.getParameter("description");
		
		
		Resource resource=new Resource();
		CountDAOImp count=new CountDAOImp();
		try {
			ResourceID=count.getCount();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		resource.setiFileID(ResourceID);
		resource.setsFileName(name);
		resource.setsAuthorID(authorID);
		resource.setiDownloadNum(downloadTime);
		resource.setlSize(itemSize);
		resource.setiPraise(praise);
		resource.setiCriticize(criticize);
		resource.setsInstitute(colleage);
		resource.setiGrade(grade);
		resource.setsCourseName(courseName);
		resource.setsDescription(description);
		//����action
		AddResourceAction add=new AddResourceAction();
		boolean result=add.addResource(resource);
		
		
		if (result==true){
			System.out.println(authorID+"�ϴ�"+ResourceID+"���ļ����ļ�����"+name);
			response.sendRedirect("WebContent/uploadSuccess.html");
		}
		else {
			response.sendRedirect("WebContent/uploadFail.html");
		}
	}}


