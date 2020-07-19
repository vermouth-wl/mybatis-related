package com.mybatis.mapper;

import com.mybatis.pojo.AdminInfo;

public interface AdminMapper {
    AdminInfo findAdminById(Integer id);
}
