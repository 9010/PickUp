package com.self.pickup.common.service.impl;

import com.self.pickup.common.myMapper.MyMapper;
import com.self.pickup.common.service.BaseService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public abstract class BaseServiceImpl<T, ID> implements BaseService<T, ID> {

    protected final Logger logger = LoggerFactory.getLogger(getClass());

    public abstract MyMapper<T> getMapper();

    @Override
    @Transactional(rollbackFor = Exception.class) //事务回滚
    public Integer add(T t) {
        return getMapper().insert(t); //封装单表操作方法
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Integer deleteById(ID id) {
        return getMapper().deleteByPrimaryKey(id);
    }
}
//@Service
//@Transactional(readOnly = true)
//public abstract class BaseServiceImpl<T, D extends MyMapper<T>> implements BaseService<T> {
//
//    @Autowired
//    private D dao;
//
//    @Override
//    @Transactional(readOnly = false)
//    public int insert(T t) {
//        return dao.insert(t);
//    }
//
//    @Override
//    @Transactional(readOnly = false)
//    public int delete(T t) {
//        return dao.delete(t);
//    }
//
//    @Override
//    @Transactional(readOnly = false)
//    public int update(T t, String updateBy) {
//        return dao.updateByPrimaryKey(t);
//    }
//
//    @Override
//    public int count(T t) {
//        return dao.selectCount(t);
//    }
//
//    @Override
//    public T selectOne(T t) {
//        return dao.selectOne(t);
//    }
//
//    @Override
//    public PageInfo<T> page(int pageNum, int pageSize, T t) {
//        PageHelper pageHelper = new PageHelper();
//        pageHelper.startPage(pageNum, pageSize);
//
//        PageInfo<T> pageInfo = new PageInfo<>(dao.select(t));
//        return pageInfo;
//    }
//}
