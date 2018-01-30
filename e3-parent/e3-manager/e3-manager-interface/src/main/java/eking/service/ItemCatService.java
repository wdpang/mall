package eking.service;

import eking.common.pojo.EasyUITreeNode;

import java.util.List;

/**
 * Created by wd.pang on 2018/1/23.
 */
public interface ItemCatService {
    List<EasyUITreeNode> getItemCatlist(long parentId);
}
