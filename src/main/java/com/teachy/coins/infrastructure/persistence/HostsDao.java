package com.teachy.coins.infrastructure.persistence;

import com.teachy.coins.infrastructure.jooq.tables.records.HostsRecord;
import com.teachy.coins.model.bo.HostsBo;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Repository;

/**
 * @author gang.tu
 * @ClassName HostsDao
 * @Description
 * @Date 2020/3/3 15:51
 */
@Repository
public class HostsDao extends BaseDao {

    public void insert(HostsBo hostsBo) {
        HostsRecord hostsRecord = create.newRecord(HOSTS);
        BeanUtils.copyProperties(hostsBo, hostsRecord);
        hostsRecord.insert();
    }

    public HostsBo selectByIp(String ip) {
        return create.selectFrom(HOSTS).where(HOSTS.IP.eq(ip)).fetchOneInto(HostsBo.class);
    }

    public void update(HostsBo hostsBo) {
        HostsRecord hostsRecord = create.newRecord(HOSTS);
        BeanUtils.copyProperties(hostsBo, hostsRecord);
        create.executeUpdate(hostsRecord);
    }
}