/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package supply.data;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Ngoc
 */
public class DBUtil {
    public static void closeStatement(Statement s){
        try{if (s != null){
            s.close();
        }
        }catch(SQLException sqle){
            System.out.println(sqle);    
        }
                
    }
    
    public static void closePrepareStatement(PreparedStatement ps){
        try{if (ps != null){
            ps.close();
        }
        }catch(SQLException sqle){
            System.out.println(sqle);    
        }
                
    }
    public static void closeResultSet(ResultSet rs){
        try{if (rs != null){
            rs.close();
        }
        }catch(SQLException sqle){
            System.out.println(sqle);    
        }
                
    }
    
}
