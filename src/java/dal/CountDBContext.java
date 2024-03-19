/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author admin
 */
public class CountDBContext extends DBContext {

    public int viewCount() {
        try {
            String sql = "select count from Count c where id =1";
            PreparedStatement stm = connection.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                return rs.getInt("count");
            }
        } catch (SQLException ex) {
            Logger.getLogger(CountDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }

    public void updateCount(int count) {
        try {
            String sql = "update Count\n"
                    + "set count =? where id = 1";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, count);
            stm.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(CountDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
