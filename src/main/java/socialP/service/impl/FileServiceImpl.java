package socialP.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import socialP.dao.DocumentMapper;

public class FileServiceImpl {

    @Autowired
    @Qualifier("documentMapper")
    private DocumentMapper documentMapper;
}
