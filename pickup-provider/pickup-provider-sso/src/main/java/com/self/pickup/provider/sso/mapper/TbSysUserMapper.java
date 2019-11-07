package com.self.pickup.provider.sso.mapper;

import com.funtl.itoken.common.domain.TbSysUser;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.MyMapper;

@Repository
public interface TbSysUserMapper extends MyMapper<TbSysUser> {
}