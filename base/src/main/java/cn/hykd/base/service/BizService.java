package cn.hykd.base.service;

import cn.hykd.base.domain.BizDomain;
import cn.hykd.base.repository.BizRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;

/** 
 * @author  蒋维 
 * @date 创建时间：2018年3月29日 下午2:25:44 
 * @version 1.0 
 * @parameter  
 * @since  
 * @return  
 */
public abstract class BizService<T extends BizDomain<I>, I extends Serializable> extends BaseService<T, I>  {
    @Autowired
    private BizRepository<T, I> bizRepository;
    
    @Override
    public T findOne(I id) {
        T t = super.findOne(id);
        if (t == null || t.isDeleted()) {
            return null;
        }
        return t;
    }
    @Override
    public List<T> findAll() {
        return bizRepository.findByDeletedIsFalse();
    }
    @Override
    public void delete(I id) {
    	super.delete(id);
    }
    @Override
    public void delete(T t) {
    	super.delete(t);
    }
    @Override
    public T save(T t) {
    	return super.save(t);
    }
    @Override
    public T update(T t) throws SQLException {
    	return super.update(t);
    }
}
