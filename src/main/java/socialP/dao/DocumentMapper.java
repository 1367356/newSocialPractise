package socialP.dao;

import org.springframework.stereotype.Component;
import socialP.pojo.dao.Document;

import java.util.Date;
import java.util.List;

@Component
public interface DocumentMapper {
    int deleteByPrimaryKey(Integer documentId);

    int insert(Document record);

    int insertSelective(Document record);

    Document selectByPrimaryKey(Integer documentId);

    int updateByPrimaryKeySelective(Document record);

    int updateByPrimaryKey(Document record);


    //通过documentStatus、documentType、startTime、endTime筛选document
    List<Document> selectByStatusTypeAndTime(Integer documentStatus, String documentType, Date startTime,Date endTime);

}