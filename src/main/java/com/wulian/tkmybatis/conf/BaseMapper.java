package com.wulian.tkmybatis.conf;

import tk.mybatis.mapper.common.ExampleMapper;
import tk.mybatis.mapper.common.IdsMapper;
import tk.mybatis.mapper.common.MySqlMapper;
import tk.mybatis.mapper.common.RowBoundsMapper;
import tk.mybatis.mapper.common.base.BaseDeleteMapper;
import tk.mybatis.mapper.common.base.BaseInsertMapper;
import tk.mybatis.mapper.common.base.BaseSelectMapper;
import tk.mybatis.mapper.common.base.update.UpdateByPrimaryKeySelectiveMapper;

/**
 * @Description 基础配置类，决定了哪些mapper的方法可以被使用
 * @Author xiaolin
 * @Date 2020/2/8 16:00
 **/
public interface BaseMapper<T> extends MySqlMapper<T>,
        IdsMapper<T>, ExampleMapper<T>, RowBoundsMapper<T>,
        BaseSelectMapper<T>, BaseInsertMapper<T>,
        UpdateByPrimaryKeySelectiveMapper<T>, BaseDeleteMapper<T> {
}
