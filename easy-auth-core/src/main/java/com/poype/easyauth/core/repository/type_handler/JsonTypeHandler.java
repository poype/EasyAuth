package com.poype.easyauth.core.repository.type_handler;


import com.alibaba.fastjson.JSON;
import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JsonTypeHandler<T> extends BaseTypeHandler<T> {

    private Class<T> clazz;

    public JsonTypeHandler() {
    }

    public JsonTypeHandler(Class<T> clazz) {
        this.clazz = clazz;
    }

    @Override
    public void setNonNullParameter(PreparedStatement preparedStatement, int i,
                                    T property, JdbcType jdbcType) throws SQLException {
        preparedStatement.setString(i, JSON.toJSONString(property));
    }

    @Override
    public T getNullableResult(ResultSet resultSet, String columnName) throws SQLException {
        return JSON.parseObject(resultSet.getString(columnName), clazz);
    }

    @Override
    public T getNullableResult(ResultSet resultSet, int columnIndex) throws SQLException {
        return JSON.parseObject(resultSet.getString(columnIndex), clazz);
    }

    @Override
    public T getNullableResult(CallableStatement callableStatement, int columnIndex) throws SQLException {
        return JSON.parseObject(callableStatement.getString(columnIndex), clazz);
    }
}