package com.myspring.bootstrap.shared.response;


import lombok.Data;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;

@Data
public class ResponseSuccessPaging<T> {

    private String status;
    private List<?> data;
    private Pageable pageable;
    private boolean last;
    private int totalPages;
    private long totalElements;
    private int size;
    private int number;
    private Sort sort;
    private boolean first;
    private int numberOfElements;
    private boolean empty;

    public ResponseSuccessPaging(Page<T> page) {
        this.status = "success";
        convertFromPaging(page);
    }

    public void convertFromPaging(Page<?> page) {
        this.data = page.getContent();
        this.pageable = page.getPageable();
        this.last = page.isLast();
        this.totalPages = page.getTotalPages();
        this.totalElements = page.getTotalElements();
        this.size = page.getSize();
        this.number = page.getNumber();
        this.sort = page.getSort();
        this.first = page.isFirst();
        this.numberOfElements = page.getNumberOfElements();
        this.empty = page.isEmpty();
    }
}
