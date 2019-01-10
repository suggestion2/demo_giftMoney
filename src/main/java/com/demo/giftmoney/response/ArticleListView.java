package com.demo.giftmoney.response;

import com.sug.core.platform.web.pagination.PaginationView;
import org.springframework.beans.factory.annotation.Autowired;
import com.demo.giftmoney.domain.Article;

import java.util.List;

public class ArticleListView extends PaginationView<Article>{

        @Autowired
        public ArticleListView() {
        }

        public ArticleListView(List<Article> list,int count) {
            this.setList(list);
            this.setCount(count);
        }

        public ArticleListView(List<Article> list) {
            this.setList(list);
        }
}
