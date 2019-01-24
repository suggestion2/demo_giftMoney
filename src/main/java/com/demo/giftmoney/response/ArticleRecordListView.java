package com.demo.giftmoney.response;

import com.sug.core.platform.web.pagination.PaginationView;
import org.springframework.beans.factory.annotation.Autowired;
import com.demo.giftmoney.domain.ArticleRecord;

import java.util.List;

public class ArticleRecordListView extends PaginationView<ArticleRecordListItemView> {

    @Autowired
    public ArticleRecordListView() {
    }

    public ArticleRecordListView(List<ArticleRecordListItemView> list, int count) {
        this.setList(list);
        this.setCount(count);
    }

    public ArticleRecordListView(List<ArticleRecordListItemView> list) {
        this.setList(list);
    }
}
