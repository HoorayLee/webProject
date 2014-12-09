<%@page import="java.io.FileInputStream"%>
<%@page import="java.io.OutputStream"%><%@ page
    contentType="text/html; charset=utf-8"%>
<%
    String fileName = "";  // 文件名
    String filePath = "E://";    //路径名
 
    out.clear();
    response.reset();
    response.setContentType("application/x-download");
    response.addHeader("Content-Disposition", "attachment;filename=" + fileName);
    OutputStream os = response.getOutputStream();
    try {
        FileInputStream fis = new FileInputStream(filePath + fileName);
        try {
            byte[] buffer = new byte[1024 * 10];
            for (int read; (read = fis.read(buffer)) != -1;) {
                os.write(buffer, 0, read);
            }
        } finally {
            fis.close();
        }
    } finally {
        os.close();
    }
%>