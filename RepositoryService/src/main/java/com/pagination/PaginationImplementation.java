package com.pagination;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;


@Component
public class PaginationImplementation implements PaginationService {

	public PaginationImplementation()
	{
		
	}
	@Override
	public  <T> PaginationResponse<T> getAllRecords(int pageNo, int pageSize,Page<T> recordList) {
		
		List<T> records = recordList.getContent();
		PaginationResponse<T> response = new PaginationResponse<T>(records,pageNo,pageSize,recordList.getTotalElements(),recordList.getTotalPages(),recordList.isLast());
		return response;
		
	}

	

}
