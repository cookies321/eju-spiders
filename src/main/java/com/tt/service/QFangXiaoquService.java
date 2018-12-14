package com.tt.service;

import com.tt.entity.QFangXiaoqu;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface QFangXiaoquService {
    List<QFangXiaoqu> getQFangXiaoqu();
    void insertQFangXiaoqu(QFangXiaoqu qFangXiaoqu);
    void updateQFangXiaoqu(QFangXiaoqu qFangXiaoqu);

}
