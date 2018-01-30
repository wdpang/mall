package eking.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import eking.common.pojo.EasyUIDataGridResult;
import eking.common.utils.E3Result;
import eking.common.utils.IDUtils;
import eking.mapper.TbItemDescMapper;
import eking.mapper.TbItemMapper;
import eking.pojo.TbItem;
import eking.pojo.TbItemDesc;
import eking.pojo.TbItemExample;
import eking.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * Created by wd.pang on 2018/1/16.
 */
@Service
public class ItemServiceImpl implements ItemService{
    @Autowired
    private TbItemMapper tbItemMapper;
    @Autowired
    private TbItemDescMapper itemDescMapper;
    @Override
    public TbItem getItemById(long itemId){
//        TbItem tbItem=  tbItemMapper.selectByPrimaryKey(itemId);
        TbItemExample example=new TbItemExample();
        TbItemExample.Criteria criteria=example.createCriteria();
        criteria.andIdEqualTo(itemId);
        List<TbItem> list=tbItemMapper.selectByExample(example);

        return list.get(0);
    }
    @Override
    public EasyUIDataGridResult getItemList(int page, int rows){
        //设置分页信息
        PageHelper.startPage(page, rows);
        //执行查询
        TbItemExample example = new TbItemExample();
        List<TbItem> list = tbItemMapper.selectByExample(example);
        //取分页信息
        PageInfo<TbItem> pageInfo = new PageInfo<>(list);

        //创建返回结果对象
        EasyUIDataGridResult result = new EasyUIDataGridResult();
        result.setTotal(pageInfo.getTotal());
        result.setRows(list);

        return result;

    }


    @Override
    public E3Result addItem(TbItem item, String desc) {
        // 1、生成商品id
        long itemId = IDUtils.genItemId();
        // 2、补全TbItem对象的属性
        item.setId(itemId);
        //商品状态，1-正常，2-下架，3-删除
        item.setStatus((byte) 1);
        Date date = new Date();
        item.setCreated(date);
        item.setUpdated(date);
        // 3、向商品表插入数据
        tbItemMapper.insert(item);
        // 4、创建一个TbItemDesc对象
        TbItemDesc itemDesc = new TbItemDesc();
        // 5、补全TbItemDesc的属性
        itemDesc.setItemId(itemId);
        itemDesc.setItemDesc(desc);
        itemDesc.setCreated(date);
        itemDesc.setUpdated(date);
        // 6、向商品描述表插入数据
        itemDescMapper.insert(itemDesc);
        // 7、E3Result.ok()
        return E3Result.ok();
    }


}
