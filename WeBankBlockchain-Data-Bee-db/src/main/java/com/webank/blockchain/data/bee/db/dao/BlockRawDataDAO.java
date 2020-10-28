package com.webank.blockchain.data.bee.db.dao;

import cn.hutool.core.bean.BeanUtil;
import com.webank.blockchain.data.bee.common.bo.data.BlockRawDataBO;
import com.webank.blockchain.data.bee.db.entity.BlockRawData;
import com.webank.blockchain.data.bee.db.repository.BlockRawDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author wesleywang
 * @Description:
 * @date 2020/10/23
 */
@Component
public class BlockRawDataDAO implements SaveInterface<BlockRawDataBO>{

    @Autowired
    private BlockRawDataRepository blockRawDataRepository;

    @Override
    public void save(BlockRawDataBO blockRawDataBO) {
        BlockRawData blockRawData = new BlockRawData();
        BeanUtil.copyProperties(blockRawDataBO, blockRawData, true);
        save(blockRawData);
    }

    public void save(BlockRawData blockRawData) {
        BaseDAO.saveWithTimeLog(blockRawDataRepository, blockRawData);
    }
}
