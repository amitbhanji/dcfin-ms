package com.entitlementservice;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import com.repositoryservice.Entitlement;

@Component
public class PaginationImplementation implements PaginationService {

	public PaginationImplementation()
	{
		
	}
	@Override
	public PaginationResponse getAllRecords(int pageNo, int pageSize,Page<Entitlement> recordList) {
		
		List<Entitlement> entitlements = recordList.getContent();
		PaginationResponse response = new PaginationResponse(entitlements,pageNo,pageSize,recordList.getTotalElements(),recordList.getTotalPages(),recordList.isLast());
		return response;
		
	}


}
