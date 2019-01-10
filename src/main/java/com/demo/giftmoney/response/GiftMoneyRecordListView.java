package com.demo.giftmoney.response;

import com.sug.core.platform.web.pagination.PaginationView;
import org.springframework.beans.factory.annotation.Autowired;
import com.demo.giftmoney.domain.GiftMoneyRecord;

import java.util.List;

public class GiftMoneyRecordListView extends PaginationView<GiftMoneyRecord>{

        @Autowired
        public GiftMoneyRecordListView() {
        }

        public GiftMoneyRecordListView(List<GiftMoneyRecord> list,int count) {
            this.setList(list);
            this.setCount(count);
        }

        public GiftMoneyRecordListView(List<GiftMoneyRecord> list) {
            this.setList(list);
        }
}
