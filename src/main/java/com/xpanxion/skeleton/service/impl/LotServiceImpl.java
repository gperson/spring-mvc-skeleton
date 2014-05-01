package com.xpanxion.skeleton.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.xpanxion.skeleton.dao.LotDao;
import com.xpanxion.skeleton.dto.beans.Lot;
import com.xpanxion.skeleton.service.LotService;

@Transactional
@Service
public class LotServiceImpl implements LotService {

    private LotDao lotDao;

    @Override
    public Lot getLot() {
        return new Lot(this.lotDao.getLot());
    }

    @Resource
    public void setLotDao(LotDao doa) {
        this.lotDao = doa;
    }
}
