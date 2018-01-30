package eking.controller;

import eking.common.pojo.EasyUITreeNode;
import eking.service.ItemCatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by wd.pang on 2018/1/23.
 */
@Controller
public class ItemCatController {

    @Autowired
    private ItemCatService itemCatService;
    @RequestMapping("/item/cat/list")
    @ResponseBody
    public List<EasyUITreeNode> getItemCatList(@RequestParam(value="id", defaultValue="0")Long parentId) {

        List<EasyUITreeNode> list = itemCatService.getItemCatlist(parentId);
        return list;
    }
}

