package com.online.store.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.online.store.dao.BillDao;
import com.online.store.model.BillInfo;
import com.online.store.service.BillService;

@Service("billService")
@Transactional
public class BillServiceImpl implements BillService {
	
	@Autowired
	private BillDao billDao;

	@Override
	public void saveBill(BillInfo billInfo) {
		this.billDao.saveBill(billInfo);
	}
}
