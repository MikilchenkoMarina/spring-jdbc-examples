package contactdatabase.dao.helpers;

import com.mysql.jdbc.JDBC4PreparedStatement;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.LinkedHashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static java.sql.Date.valueOf;

/**
 * Created by mmikilchenko on 20.12.2016.
 */
public class SqlQueryHelper {
    private String sqlWithUndefinedParams;


    public String getSqlQueryWithBindParams(DataSource dataSource, String sqlNamedParams, LinkedHashMap<String, Object> params) {
        sqlWithUndefinedParams = sqlNamedParams;
        Matcher matcher = Pattern.compile(":\\s*(\\w+)").matcher(sqlNamedParams);

        while (matcher.find()) {
            String replacedParameter = String.format(":%s", matcher.group(1));
            sqlWithUndefinedParams = sqlWithUndefinedParams.replace(replacedParameter, "?");

        }
        System.out.println("Final SQL  " + sqlWithUndefinedParams);

        PreparedStatement sqlWithParam = null;
        String parametrizedSql = "";
        try {
            sqlWithParam = getConnect(dataSource).prepareStatement(sqlWithUndefinedParams);

        int ind = 1;
        for (Object paramValue : params.values()) {
            if (paramValue instanceof Integer) {
                sqlWithParam.setInt(ind, (Integer) paramValue);
            }
            if (paramValue instanceof String) {
                sqlWithParam.setString(ind, (String) paramValue);
            }
            if (paramValue instanceof LocalDate) {
                sqlWithParam.setDate(ind, valueOf((LocalDate) paramValue));

            }
            ind++;
        }
       parametrizedSql = ((JDBC4PreparedStatement) sqlWithParam).asSql();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return parametrizedSql ;
    }


    private final Connection getConnect(DataSource dataSource) {
        try {
            return dataSource.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
