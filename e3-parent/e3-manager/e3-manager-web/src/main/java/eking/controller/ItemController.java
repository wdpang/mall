package eking.controller;

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
}
