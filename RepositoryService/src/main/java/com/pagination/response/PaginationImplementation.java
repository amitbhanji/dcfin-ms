package com.pagination.response;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.repository.data.User;

import jakarta.annotation.Resource;


@Component
public class PaginationImplementation implements PaginationService{

	public PaginationImplementation()
	{
		
	}
	@Override
	public   PaginationResponse<User> getAllRecords(int pageNo, int pageSize,Page<User> recordList) {
		
		List<User> records = recordList.getContent();
		PaginationResponse<User> response = new PaginationResponse<User>(records,pageNo,pageSize,recordList.getTotalElements(),recordList.getTotalPages(),recordList.isLast());
		return response;
		
	}

	

}
