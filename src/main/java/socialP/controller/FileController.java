package socialP.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import socialP.pojo.vo.DocumentSearchObjectVo;
import socialP.pojo.vo.DocumentVo;
import socialP.service.FileService;
import socialP.template.ResponseTemplate;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/socialPractise/document")
public class FileController {

    @Autowired
    @Qualifier("fileServiceImpl")
    private FileService fileService;


    @ResponseBody
    @RequestMapping("/saveDocument.do")
    public ResponseTemplate save(@RequestBody List<DocumentVo> documentVos, HttpServletRequest request){
        return null;
    }


    @ResponseBody
    @RequestMapping("/getDocument.do")
    public ResponseTemplate get(@RequestBody DocumentSearchObjectVo documentSearchObjectVo, HttpServletRequest request){


        return null;
    }

}
