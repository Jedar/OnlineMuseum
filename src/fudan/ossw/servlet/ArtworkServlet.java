package fudan.ossw.servlet;

import com.alibaba.fastjson.JSONObject;
import fudan.ossw.dao.DaoFactory;
import fudan.ossw.entity.Artwork;
import fudan.ossw.entity.CriteriaArtwork;
import fudan.ossw.entity.User;
import fudan.ossw.service.ArtworkService;
import fudan.ossw.service.impl.ArtworkServiceImpl;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadBase;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Method;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

@WebServlet(name = "ArtworkServlet", value = "*.aws")
public class ArtworkServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        response.setCharacterEncoding("UTF-8");
        String servletPath = request.getServletPath();
        String methodName = servletPath.substring(5, servletPath.length() - 4);
        System.out.println(methodName);
        try {
            /*利用反射得到对应的方法*/
            Method method = getClass().getDeclaredMethod(methodName, HttpServletRequest.class, HttpServletResponse.class);
            /*调用方法*/
            method.invoke(this, request, response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void uploadArtwork(HttpServletRequest request, HttpServletResponse response) throws IOException {
        System.out.println("upload start");
        Artwork artwork = getArtworkInfo(request,response);
        ArtworkService service = new ArtworkServiceImpl();
        boolean flag = service.insert(artwork);
        if (!flag){
            System.out.println(service.getErrorMessage());
        }
        response.sendRedirect(request.getContextPath()+"/jsp/artworkmanagement.jsp");
    }

    private void deleteArtwork(HttpServletRequest request, HttpServletResponse response) {
        int artID = 0;
        try {
            String str = request.getParameter("artID");
            if (str != null){
                str = str.trim();
            }
            else {
                str = "";
            }
            artID = Integer.parseInt(str);
        }catch (Exception e){
            e.printStackTrace();
        }
        System.out.println(artID);

        ArtworkService service = new ArtworkServiceImpl();

        Artwork artwork = service.getArtworkByID(artID);

        if (artwork == null){
            JSONObject object = new JSONObject();
            object.put("success",false);
            object.put("message","藏品不存在");

            try {
                response.getWriter().println(object.toJSONString());
            } catch (IOException e) {
                e.printStackTrace();
            }
            return;
        }

        boolean flag = service.delete(artwork);
        if (flag){
            JSONObject object = new JSONObject();
            object.put("success",true);
            object.put("message","藏品删除成功");

            try {
                response.getWriter().println(object.toJSONString());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        else {
            JSONObject object = new JSONObject();
            object.put("success",false);
            object.put("message","藏品删除失败");
            try {
                response.getWriter().println(object.toJSONString());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    private void changeArtwork(HttpServletRequest request, HttpServletResponse response) throws IOException {
        System.out.println("change start");
        Artwork artwork = getArtworkInfo(request,response);
        ArtworkService service = new ArtworkServiceImpl();
        boolean flag = service.update(artwork);
        if (!flag){
            System.out.println(service.getErrorMessage());
        }
        response.sendRedirect(request.getContextPath()+"/jsp/artworkmanagement.jsp");
    }

    private void searchArtwork(HttpServletRequest request, HttpServletResponse response) {

        String title = request.getParameter("title");
        String description  = request.getParameter("description");
        String location = request.getParameter("location");
        String sortWay = request.getParameter("sortWay");
        int mark = Integer.parseInt(request.getParameter("mark"));

        int pageIndex = ((mark-1) * 6);

        int pageSize = Integer.parseInt(request.getParameter("pageSize"));

        ArtworkService artworkService = new ArtworkServiceImpl();
        List<Artwork> artworks = artworkService.searchPage(title, description, location, sortWay, pageIndex, pageSize);

        int totalNumber = artworkService.search(title, description, location, sortWay).size();

        int pageNumber = totalNumber%6==0?totalNumber/6:totalNumber/6+1;

        JSONObject object = new JSONObject();
        object.put("success",true);
        object.put("index",mark);
        object.put("artworkList",artworks);
        object.put("totalNumber",pageNumber);

        System.out.println(artworks);
        try {
            response.getWriter().println(object.toJSONString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void artworkDetail(HttpServletRequest request, HttpServletResponse response) {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }

    protected boolean processUploadField(FileItem item, Map<String, String> map) {
        try {
//          InputStream in = item.getInputStream();
            //找一个存放文件的位置；存放的文件名
            String id = item.getFieldName();
            String fileName = item.getName();//上传的文件的文件名  C:\Users\wzhting\Desktop\a.txt  a.txt(浏览器不同)
            if(fileName!=null&&!fileName.equals("")){
                //限定上传文件的类型，从他提供的方法中查看他是不是某一类型的文件
                //这个函数如果开启的话，那么就只能上传是图片类型的数据
//              if(!item.getContentType().startsWith("image")){
//                  return;
//              }
                fileName = FilenameUtils.getName(fileName);
                fileName = UUID.randomUUID().toString() +"_"+fileName;

                //存放路径
                String realPath = getServletContext().getRealPath("/WEB-INF/files");
                System.out.println(realPath);
                //生成一个子目录,也就是在realPath下面生成新的子目录，并且返回子目录
                //这个地方是根据日期来生成目录
                //如果是根据时间来上传东西的话，那么对于同一天上传的东西，都会在同一个目录下
                //并且每次上传即使是相同的名字，也会产生不同的hashcode从而都能偶得到保存
                String childDirectory = genChildDirectory(realPath,fileName);

                //创造新的存放目录
                File storeDirectory = new File(realPath+File.separator+childDirectory);
                //如果目录不存在，那么就创建它
                if(!storeDirectory.exists()){
                    storeDirectory.mkdirs();
                }

                File file = new File(storeDirectory, fileName);
                //这个方法会自动的进行临时文件的清理，也就是上传完毕之后，他会自动的清除临时文件
                item.write(file);

                System.out.println(item.getContentType());
                File imageDir = new File(getServletContext().getRealPath("/img/"));
                FileUtils.copyFileToDirectory(file,imageDir);

                System.out.println(fileName);
                map.put(id,fileName);
            }


        } catch (Exception e) {
            e.printStackTrace();
        }

        return true;
    }

    private String genChildDirectory(String realPath, String fileName) {
        int hashCode = fileName.hashCode();
        int dir1 = hashCode&0xf;
        int dir2 = (hashCode&0xf0)>>4;

        String str = dir1+File.separator+dir2;

        File file = new File(realPath,str);
        if(!file.exists()){
            file.mkdirs();
        }

        return str;

    }

    private boolean processFormField(FileItem item, Map<String, String> map) {
        //打印到控制台
        String fieldName = item.getFieldName();
        String fieldValue = "";
        try {
            //这里是为了解决表单提交的汉字在控制台输出乱码的问题，也就是得到表单里边的
            //数据在控制台输出不会乱码
            fieldValue = item.getString("utf-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        System.out.println(fieldName+"="+fieldValue);
        map.put(fieldName,fieldValue);

        return !"".equals(fieldValue);
    }

    private Artwork getArtworkInfo(HttpServletRequest request, HttpServletResponse response) throws IOException {
        try {
            request.setCharacterEncoding("UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        response.setContentType("text/html;charset=UTF-8");
        boolean isMultipart = ServletFileUpload.isMultipartContent(request);
        if(!isMultipart){
            throw new RuntimeException("The form's enctype attribute value must be multipart/form-data");
        }
        DiskFileItemFactory factory = new DiskFileItemFactory();//产生FileItem的工厂
        factory.setRepository(new File("/WEB-INF/files"));
        ServletFileUpload sfu = new ServletFileUpload(factory);
        sfu.setHeaderEncoding("utf-8");
//      sfu.setFileSizeMax(3*1024*1024);//单个文件大小限制
//      sfu.setSizeMax(5*1024*1024);//总文件大小
        List<FileItem> items = new ArrayList<FileItem>();
        try {
            items = sfu.parseRequest(request);
        }catch(FileUploadBase.FileSizeLimitExceededException e) {
            response.getWriter().write("单个文件不能超过3M");
        }
        catch(FileUploadBase.SizeLimitExceededException e) {
            response.getWriter().write("总文件不能超过5M");
        }catch (FileUploadException e) {
            e.printStackTrace();
            throw new RuntimeException("解析请求失败");
        }
        /* map储存上传的信息 */
        Map<String,String> map = new HashMap<>();

        for(FileItem item:items){
            boolean flag = true;
            if(item.isFormField()){
                flag = processFormField(item,map);//处理普通字段
            }else{
                flag = processUploadField(item,map);//处理上传字段
            }
            /* 异常情况 */
            if (!flag){
                response.sendRedirect("../WEB-INF/jsp/error.jsp");
            }
        }

        int artID = 0;
        if (map.get("artID") != null){
            try {
                artID = Integer.parseInt(map.get("artID"));
            }
            catch (Exception e){
                e.printStackTrace();
            }
        }

        User user = (User)request.getSession().getAttribute("user");
        int uploadID = 1;
        if (user != null){
            uploadID = user.getUserID();
        }

        return new Artwork(artID,map.get("title"),
                map.get("image"),
                map.get("video"),
                map.get("age"),
                map.get("size"),
                map.get("description"),
                map.get("location"),
                map.get("time"),
                uploadID);
    }
}
