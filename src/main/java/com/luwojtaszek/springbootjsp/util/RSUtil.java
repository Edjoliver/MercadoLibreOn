package com.luwojtaszek.springbootjsp.util;

/**
 * Created by andresdkm on 13/12/17.
 */
import java.math.BigDecimal;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.Timestamp;

/**
 * @author Franky Villadiego
 */
public class RSUtil {


    private RSUtil() {
    }

    public static String toString(BigDecimal bd) {
        Long l = (Long) bd.longValue();
        return l.toString();
    }

    public static Long getLong(ResultSet rs, String colName) {
        try {
            return rs.getLong(colName);
        } catch (Exception ex) {
        }
        return null;
    }


    public static String getString(ResultSet rs, String colName) {
        try {
            return rs.getString(colName);
        } catch (Exception ex) {
        }
        return null;
    }

    public static short getShort(ResultSet rs, String colName) {
        try {
            return rs.getShort(colName);
        } catch (Exception ex) {
        }
        return Short.parseShort(null);
    }

    public static Integer getInteger(ResultSet rs, String colName) {
        try {
            return rs.getInt(colName);
        } catch (Exception ex) {
        }
        return null;
    }

    public static Double getDouble(ResultSet rs, String colName) {
        try {
            return rs.getDouble(colName);
        } catch (Exception ex) {
        }
        return null;
    }

    public static Boolean getBoolean(ResultSet rs, String colName) {
        try {
            return rs.getBoolean(colName);
        } catch (Exception ex) {
        }
        return null;
    }


    public static BigDecimal getBigDecimal(ResultSet rs, String colName) {
        try {
            return rs.getBigDecimal(colName);
        } catch (Exception ex) {
        }
        return null;
    }


    public static Timestamp getTimestamp(ResultSet rs, String colName) {
        try {
            return rs.getTimestamp(colName);
        } catch (Exception ex) {
        }
        return null;
    }

    public static Date getDate(ResultSet rs, String colName) {
        try {
            return rs.getDate(colName);
        } catch (Exception ex) {
        }
        return null;
    }


}