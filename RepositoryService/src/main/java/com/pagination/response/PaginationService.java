package com.pagination.response;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import com.repository.data.User;

import jakarta.annotation.Resource;

@Service
public interface PaginationService  {

	public   PaginationResponse<User> getAllRecords(int pageNo,int pageSize,Page<User> recordList);
}
