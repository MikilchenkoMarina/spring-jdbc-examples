package contactdatabase.dao.helpers;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Map;

/**
 * Created by mmikilchenko on 20.12.2016.
 */
public class SqlQueryHelper {
    public String getSqlQueryWithBindParams(Connection con, String sql, Map<String, Object> params) throws SQLException {

        PreparedStatement sqlWithParam
                = con.prepareStatement(sql);
        int ind = 0;
        for (String paramKey : params.keySet()) {
            if (params.get(paramKey) instanceof Integer) {
                sqlWithParam.setInt(ind, (Integer) params.get(paramKey));
            }
            if (params.get(paramKey) instanceof String) {
                sqlWithParam.setString(ind, (String) params.get(paramKey));
            }
            if (params.get(paramKey) instanceof Date) {
                sqlWithParam.setDate(ind, (Date) params.get(paramKey));
            } else {
                sqlWithParam.setObject(ind, params.get(paramKey));
            }
            ind++;
        }
        return sqlWithParam.toString();
    }
}
