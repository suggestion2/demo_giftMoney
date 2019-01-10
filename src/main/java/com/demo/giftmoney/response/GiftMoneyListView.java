package com.demo.giftmoney.response;

import com.sug.core.platform.web.pagination.PaginationView;
import org.springframework.beans.factory.annotation.Autowired;
import com.demo.giftmoney.domain.GiftMoney;

import java.util.List;

public class GiftMoneyListView extends PaginationView<GiftMoney>{

        @Autowired
        public GiftMoneyListView() {
        }

        public GiftMoneyListView(List<GiftMoney> list,int count) {
            this.setList(list);
            this.setCount(count);
        }

        public GiftMoneyListView(List<GiftMoney> list) {
            this.setList(list);
        }
}
