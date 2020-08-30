package com.dunamis.leadManagement.service;
import com.dunamis.leadManagement.domain.GridDisplay;
import java.util.List;

public interface GridDisplayService {
    public GridDisplay getListItems(String gridTag, Integer param1, Integer param2, Integer param3) ;
}