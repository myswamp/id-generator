package com.myswamp.idgenerator.service;

import java.util.concurrent.locks.Lock;

import com.myswamp.idgenerator.dao.IdRuleDao;
import com.myswamp.idgenerator.domain.IdRule;
import com.myswamp.idgenerator.dto.IdBatch;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.integration.redis.util.RedisLockRegistry;
import org.springframework.stereotype.Service;

@Service
public class IdService {

    @Autowired
    private IdRuleDao idRuleDao;

    @Autowired
    private RedisLockRegistry redisLockRegistry;

    public IdBatch getIdBatchByBusinessTag(String businessTag) {

        Lock lock = redisLockRegistry.obtain(businessTag);


        boolean locked = lock.tryLock();

        if(locked) {
            IdRule idRule = idRuleDao.getByBusinessTag(businessTag);
        
            IdBatch idBatch = new IdBatch();
            idBatch.setStart(idRule.getMaxId());
            idBatch.setBusinessTag(businessTag);
            idBatch.setStep(idRule.getStep());

            lock.unlock();
    
            return idBatch;
        } else {
            return null;
        }
        
    }
}