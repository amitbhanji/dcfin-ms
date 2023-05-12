package com.entitlementservice;

import org.springframework.data.domain.Page;

import com.repository.data.Entitlement;

public interface PaginationService {

	public PaginationResponse getAllRecords(int pageNo,int pageSize,Page<Entitlement> recordList);
}
