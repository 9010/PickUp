package com.self.pickup.common.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.self.pickup.common.myMapper.MyMapper;
import com.self.pickup.common.service.BaseService;
import com.self.pickup.common.utils.QueryExample;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * 数据库基本操作类
 * return: 如果数值大于0则成功，null为失败
 * @param <T>
 * @param <ID>
 */
@Service
public abstract class BaseServiceImpl<T, ID> implements BaseService<T, ID> {

    protected final Logger logger = LoggerFactory.getLogger(getClass());

    public abstract MyMapper<T> getMapper();

    /**
     * 保存一个实体，null的属性不会保存，会使用数据库默认值
     *
     * @param t
     * @return int
     */
    @Override
    @Transactional(rollbackFor = Exception.class) //事务回滚
    public Integer add(T t) {
        return getMapper().insertSelective(t); //封装单表操作方法
    }

    /**
     * 保存一个list实体，null的属性不会保存，会使用数据库默认值
     *
     * @param list
     * @return
     */
    @Override
    @Transactional(rollbackFor = Exception.class) //事务回滚
    public Integer batchAdd(List<T> list) {
        int result = 0;
        for (T record : list) {
            int count = getMapper().insertSelective(record);
            result += count;
        }
        return result;
    }

    /**
     * 根据id删除
     *
     * @param id
     * @return
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public Integer deleteById(ID id) {
        return getMapper().deleteByPrimaryKey(id);
    }

    /**
     * 根据实体属性作为条件进行删除，查询条件使用等号
     *
     * @param t
     * @return
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public Integer delete(T t) {
        return getMapper().delete(t);
    }

    /**
     * 根据主键更新属性不为null的值
     *
     * @param t
     * @return
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public Integer updateByPrimaryKey(T t) {
        return getMapper().updateByPrimaryKeySelective(t);
    }

    /**
     * 根据主键更新属性不为null的值
     *
     * @param list
     * @return
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public Integer batchUpdateByPrimaryKey(List<T> list) {
        int result = 0;
        for (T record : list) {
            int count = getMapper().updateByPrimaryKeySelective(record);
            result += count;
        }
        return result;
    }

    /**
     * 根据实体中的属性进行查询，只能有一个返回值，有多个结果是抛出异常，查询条件使用等号
     *
     * @param t
     * @return
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public T findOne(T t) {
        return getMapper().selectOne(t);
    }

    /**
     * 查询全部结果
     *
     * @return
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public List<T> findAll() {
        return getMapper().select(null);
    }

    /**
     * 根据主键查询
     *
     * @param id
     * @return
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public T findById(ID id) {
        return getMapper().selectByPrimaryKey(id);
    }

    /**
     * 根据实体中的属性值进行查询，查询条件使用等号
     *
     * @param t
     * @return
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public List<T> find(T t) {
        return getMapper().select(t);
    }

    /**
     * 根据Example条件更新实体`record`包含的不是null的属性值
     *
     * @return
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public Integer updateByExampleSelective(QueryExample<T> queryExample) {
        //todo
        return null;
    }

    /**
     * 根据实体中的属性值进行分页查询，查询条件使用等号
     *
     * @param t
     * @param pageNum
     * @param pageSize
     * @return
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public PageInfo<T> findPage(T t, Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<T> list =  getMapper().select(t);
        return new PageInfo<T>(list);
    }

    /**
     * 根据query条件查询数据
     *
     * @param query  查询条件
     * @return
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public List<T> findByExample(Example query) {
        //todo
        return null;
    }

    /**
     * 根据query条件更新record数据
     *
     * @param record 要更新的数据
     * @param query  查询条件
     * @return
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public Integer updateByExampleSelective(T record, Example query) {
        //todo
        return null;
    }

    /**
     * 根据query条件更新record数据
     *
     * @param record 要更新的数据
     * @param query  查询条件
     * @return
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public Integer updateByExampleSelective(T record, T query) {
        //todo
        return null;
    }

    /**
     * 查询数量
     *
     * @param record
     * @return
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public Integer findCount(T record) {
        return getMapper().selectCount(record);
    }

    /**
     * 查询数量
     *
     * @param query
     * @return
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public Integer findCountByExample(Example query) {
        //todo
        return null;
    }

}
