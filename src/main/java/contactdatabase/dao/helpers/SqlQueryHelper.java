package contactdatabase.dao.helpers;

import com.mysql.jdbc.JDBC4PreparedStatement;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static java.sql.Date.valueOf;

/**
 * Created by mmikilchenko on 20.12.2016.
 */
public class SqlQueryHelper {
    private String sqlWithUndefinedParams;


    public String getSqlQueryWithBindParams(Connection con, String sqlNamedParams, LinkedHashMap<String, Object> params) throws SQLException {
        sqlWithUndefinedParams = sqlNamedParams;
        Matcher matcher = Pattern.compile(":\\s*(\\w+)").matcher(sqlNamedParams);

        while (matcher.find()) {
            String replacedParameter = String.format(":%s", matcher.group(1));
            System.out.println("Replaced parameter " + replacedParameter);
            sqlWithUndefinedParams = sqlWithUndefinedParams.replace(replacedParameter, "?");

        }
        System.out.println("Final SQL  " + sqlWithUndefinedParams);

        PreparedStatement sqlWithParam
                = con.prepareStatement(sqlWithUndefinedParams);
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
        return ((JDBC4PreparedStatement) sqlWithParam).asSql();
    }
}
