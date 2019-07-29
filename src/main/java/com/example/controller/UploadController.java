package com.example.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.UUID;


@Controller
public class UploadController {

    @RequestMapping(value = "/upload",method = RequestMethod.POST)
    public String  onSubmit(HttpServletRequest request, Model model)throws Exception{
        SimpleDateFormat dateformat = new SimpleDateFormat("yyyy/MM/dd/HH");
        /** 构建文件保存的目录* */
        //String logoPathDir = "E:\\thereaders\\upload\\";
        //String contextPath = request.getContextPath();//空串：""
        /** 得到文件保存目录的真实路径* */
        String logoRealPathDir = request.getServletContext().getRealPath("/WEB-INF/upload");

        /** 根据真实路径创建目录* */
        try {
            File logoSaveFile = new File(logoRealPathDir);
            if (!logoSaveFile.exists()) {
                logoSaveFile.mkdirs();
            }

        System.out.println(logoSaveFile);
        MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
        //获取multiRequest 中所有的文件名
        Iterator iter=multipartRequest.getFileNames();
        while(iter.hasNext())
        {
            //一次遍历所有文件
            MultipartFile file=multipartRequest.getFile(iter.next().toString());
            if(file!=null)
            {
                String path=logoSaveFile+"\\"+file.getOriginalFilename();
                //上传
                try {
                    file.transferTo(new File(path));
                }catch (IOException e){
                    e.printStackTrace();
                }
            }

        }
        }catch (Exception e){
            e.printStackTrace();
        }
//        /** 页面控件的文件流* */
//        MultipartFile multipartFile = multipartRequest.getFile("file");
//        System.out.println(multipartFile.getOriginalFilename());
//        /** 获取文件的后缀* */
//        String suffix = multipartFile.getOriginalFilename().substring(multipartFile.getOriginalFilename().lastIndexOf("."));
//        /** 使用UUID生成文件名称* */
//        String logImageName = UUID.randomUUID().toString() + suffix;// 构建文件名称  
//        /** 拼成完整的文件保存路径加文件* */
//        String fileName = logoRealPathDir + File.separator + logImageName;
//        File file = new File(fileName);
//        try{
//            multipartFile.transferTo(file);
//        } catch (IllegalStateException e){
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
        //}/** 打印出上传到服务器的文件的绝对路径* */
        //System.out.println("****************"+fileName+"**************");
        //insertDate(fileName);
        model.addAttribute("handleField","upload");
        return "success";
    }

}
