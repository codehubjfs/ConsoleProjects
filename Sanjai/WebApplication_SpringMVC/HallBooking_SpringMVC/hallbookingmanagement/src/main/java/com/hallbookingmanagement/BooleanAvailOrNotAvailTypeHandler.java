package com.hallbookingmanagement;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.TypeHandler;

public class BooleanAvailOrNotAvailTypeHandler implements TypeHandler<Boolean>{
    @Override
    public void setParameter(PreparedStatement ps, int i, Boolean parameter, JdbcType jdbcType) throws SQLException {
        if (parameter == null) {
            ps.setString(i, null);
        } else {
            ps.setString(i, parameter ? "A" : "N");
        }
    }

    @Override
    public Boolean getResult(ResultSet rs, String columnName) throws SQLException {
        String value = rs.getString(columnName);
        return "A".equalsIgnoreCase(value);
    }

    @Override
    public Boolean getResult(ResultSet rs, int columnIndex) throws SQLException {
        String value = rs.getString(columnIndex);
        return "A".equalsIgnoreCase(value);
    }

    @Override
    public Boolean getResult(CallableStatement cs, int columnIndex) throws SQLException {
        String value = cs.getString(columnIndex);
        return "A".equalsIgnoreCase(value);
    }
}
