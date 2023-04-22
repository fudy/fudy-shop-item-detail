package com.fudy.itemdetail.interfaces.web.manager;

import com.fudy.itemdetail.interfaces.web.vo.ItemVO;

public interface ItemManagerInterface {
    ItemVO getItem(Long id) throws Exception;
}
