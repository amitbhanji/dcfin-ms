package com.pagination;

import org.springframework.data.domain.Page;

public interface PaginationService {

	public  <T> PaginationResponse<T> getAllRecords(int pageNo,int pageSize,Page<T> recordList);
}
