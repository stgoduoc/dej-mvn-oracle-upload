package cl.duoc.dej.erp.test;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.Test;

/**
 *
 * @author Santiago Neira <sant.neira@profesor.duoc.cl>
 */
public class BaseDatosTest {

    @Test
    public void hello() {
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Properties properties = new Properties();
            properties.put("user", "duoc");
            properties.put("password", "Duocadmin2017");
            Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@192.168.56.101:1521:XE", properties);
            String sql = "CREATE TABLE prueba(id long, nombre nvarchar2(20))";
            PreparedStatement prepareStatement = connection.prepareStatement(sql);
            prepareStatement.execute();
            Logger.getLogger(BaseDatosTest.class.getName()).log(Level.INFO, "Tabla creada");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(BaseDatosTest.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(BaseDatosTest.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(BaseDatosTest.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
