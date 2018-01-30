package eking.service;

import eking.common.pojo.EasyUIDataGridResult;
import eking.common.utils.E3Result;
import eking.pojo.TbItem;

/**
 * Created by wd.pang on 2018/1/16.
 */
public interface ItemService {
    TbItem getItemById(long itemId);
    EasyUIDataGridResult getItemList(int page,int rows);
    E3Result addItem(TbItem item, String desc);
}
