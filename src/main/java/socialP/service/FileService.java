package socialP.service;

import socialP.pojo.dao.Document;
import socialP.pojo.vo.DocumentSearchObjectVo;
import socialP.pojo.vo.DocumentVo;

import java.util.List;

public interface FileService {

    public List<DocumentVo> getDocumentByNDocumentId(DocumentSearchObjectVo documentSearchObjectVo);

    public DocumentVo saveDocument(Document document);

    public DocumentVo updateDocument(Document document);
}
