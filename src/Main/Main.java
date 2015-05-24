/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import DataBase.DB_Connection;
import Interface.HomePage;
import java.sql.Connection;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Catalin
 */
public class Main
{
    public static void main(String args[]) throws SQLException
    {
        
            Connection connection=DB_Connection.InitializeConnection();
            
            
            if(connection!=null)
            {
                HomePage homePage=new HomePage();
                homePage.setVisible(true);
            }
           else
            {
                JOptionPane.showMessageDialog (null, "The application cannot be started ! \n "
                    +"Please open you database !", "Warning", JOptionPane.WARNING_MESSAGE);
                System.exit(0);
            }
        
                
        
        
    }
}
