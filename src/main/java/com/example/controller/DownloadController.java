package com.example.controller;



import org.apache.commons.io.FileUtils;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.net.URLEncoder;


@Controller
public class DownloadController {

    @RequestMapping(value = "/download",method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<byte[]> filedownload(HttpServletRequest request, @RequestParam String filename) throws Exception{
        String path = request.getServletContext().getRealPath("/WEB-INF/upload/");
        File file = new File(path+File.separator+filename);
        filename = this.getFilename(request,filename);
        System.out.println(filename);
        HttpHeaders headers = new HttpHeaders();
        headers.setContentDispositionFormData("attachment",filename);
        headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
        return new ResponseEntity<byte[]>(FileUtils.readFileToByteArray(file),headers, HttpStatus.OK);
    }
    public String getFilename(HttpServletRequest request,String filename) throws Exception{
        String[] IEBrowserKeyWord = {"MSIE","Trident","Edge"};
        String userAgent = request.getHeader("User-Agent");
        for(String keyWord:IEBrowserKeyWord){
            if(userAgent.contains(keyWord)){
                return URLEncoder.encode(filename,"UTF-8");
            }
        }
        return new String(filename.getBytes("UTF-8"),"ISO-8859-1");
    }

}
