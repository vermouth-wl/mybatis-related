package com.mybatis.mapper;

import com.mybatis.pojo.Functions;

public interface FunctionsMapper {
    Functions findFunctionsByAid(Integer id);
}
