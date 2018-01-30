package eking.controller;

import eking.common.pojo.EasyUIDataGridResult;
import eking.common.utils.E3Result;
import eking.pojo.TbItem;
import eking.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by wd.pang on 2018/1/16.
 */
@Controller
public class ItemController {

    @Autowired
    private ItemService itemService;

    @RequestMapping("/item/{itemId}")
    @ResponseBody
    public TbItem getItemById(@PathVariable Long itemId)
    {
        TbItem tbItem=itemService.getItemById(itemId);
        return tbItem;
    }
    @RequestMapping("/item/list")
    @ResponseBody
    EasyUIDataGridResult getItemList(int page, int rows){
        EasyUIDataGridResult result = itemService.getItemList(page, rows);
        return result;
    }
    @RequestMapping("/item/save")
    @ResponseBody
    public E3Result saveItem(TbItem item, String desc) {
        E3Result result = itemService.addItem(item, desc);
        return result;
    }

}
