package eking.service.impl;

import eking.common.pojo.EasyUITreeNode;
import eking.mapper.TbItemCatMapper;
import eking.pojo.TbItemCat;
import eking.pojo.TbItemCatExample;
import eking.service.ItemCatService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wd.pang on 2018/1/23.
 */
@org.springframework.stereotype.Service
public class ItemCatServiceImpl implements ItemCatService{
    @Autowired
    private TbItemCatMapper tbItemCatMapper;
    @Override
    public List<EasyUITreeNode> getItemCatlist(long parentId){

        // 1、根据parentId查询节点列表
        TbItemCatExample example = new TbItemCatExample();
        //设置查询条件
        TbItemCatExample.Criteria criteria = example.createCriteria();
        criteria.andParentIdEqualTo(parentId);
        List<TbItemCat> list = tbItemCatMapper.selectByExample(example);
        // 2、转换成EasyUITreeNode列表。
        List<EasyUITreeNode> resultList = new ArrayList<>();
        for (TbItemCat tbItemCat : list) {
            EasyUITreeNode node = new EasyUITreeNode();
            node.setId(tbItemCat.getId());
            node.setText(tbItemCat.getName());
            node.setState(tbItemCat.getIsParent()?"closed":"open");
            //添加到列表
            resultList.add(node);
        }
        // 3、返回。
        return resultList;

    }

}
