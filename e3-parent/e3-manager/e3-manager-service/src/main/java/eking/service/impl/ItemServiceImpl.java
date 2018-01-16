package eking.service.impl;

import eking.mapper.TbItemMapper;
import eking.pojo.TbItem;
import eking.pojo.TbItemExample;
import eking.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by wd.pang on 2018/1/16.
 */
@Service
public class ItemServiceImpl implements ItemService{
    @Autowired
    private TbItemMapper tbItemMapper;
    @Override
    public TbItem getItemById(long itemId){
//        TbItem tbItem=  tbItemMapper.selectByPrimaryKey(itemId);
        TbItemExample example=new TbItemExample();
        TbItemExample.Criteria criteria=example.createCriteria();
        criteria.andIdEqualTo(itemId);
        List<TbItem> list=tbItemMapper.selectByExample(example);

        return list.get(0);
    }
}
