package com.teachy.coins.infrastructure.persistence;

import com.teachy.coins.infrastructure.jooq.tables.records.CoinListRecord;
import com.teachy.coins.model.bo.CoinListBo;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Repository;

@Repository
public class CoinListDao extends BaseDao {
    public void insert(CoinListBo coinListBo) {
        CoinListRecord coinListRecord = create.newRecord(COIN_LIST);
        BeanUtils.copyProperties(coinListBo, coinListRecord);
        coinListRecord.insert();
    }

    public CoinListBo queryOneById(String id) {
        return create.selectFrom(COIN_LIST).where(COIN_LIST.ID.eq(id)).fetchOneInto(CoinListBo.class);
    }
}