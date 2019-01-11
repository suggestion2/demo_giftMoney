package com.demo.giftmoney.response;

import com.sug.core.platform.web.pagination.PaginationView;
import org.springframework.beans.factory.annotation.Autowired;
import com.demo.giftmoney.domain.Customer;

import java.util.List;

public class CustomerListView extends PaginationView<CustomerListItemView> {

    @Autowired
    public CustomerListView() {
    }

    public CustomerListView(List<CustomerListItemView> list, int count) {
        this.setList(list);
        this.setCount(count);
    }

    public CustomerListView(List<CustomerListItemView> list) {
        this.setList(list);
    }
}
