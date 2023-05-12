package com.entitlementservice;

import java.util.List;

import com.repository.data.Entitlement;

import jakarta.validation.constraints.Size;


public class PaginationResponse {

	    private List<Entitlement> content;
	    private int pageNo;
	    @Size(min=1,message="Page size must not be less than one")
	    private int pageSize;
	    private long totalElements;
	    private int totalPages;
	    private boolean last;
	    
	    public PaginationResponse()
	    {
	    	
	    }

		public PaginationResponse(List<Entitlement> content, int pageNo, int pageSize, long totalElements,
				int totalPages, boolean last) {
		
			this.content = content;
			this.pageNo = pageNo;
			this.pageSize = pageSize;
			this.totalElements = totalElements;
			this.totalPages = totalPages;
			this.last = last;
		}

		public List<Entitlement> getContent() {
			return content;
		}

		public int getPageNo() {
			return pageNo;
		}

		public int getPageSize() {
			return pageSize;
		}

		public long getTotalElements() {
			return totalElements;
		}

		public int getTotalPages() {
			return totalPages;
		}

		public boolean isLast() {
			return last;
		}

		
	    
	    
}
