/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Library;

import DataBase.DB_Connection;
import static Interface.HomePage.view;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Catalin
 */
public class Reader
{
    private String readerCNP;
    private String readerName;
    private int readerID;
    private int readerGroup;
    private int numberOfBooks;
    
    //Cannot use since the object dies after ending the application
    //private Book borrowedBooks[]=new Book[4];
    
    public void PrintReader()
    {
            if(readerID>0)
            {
                System.out.println(readerID+" "+readerCNP+" "+readerName+" "+readerGroup);
            }
            
            else
            {
                System.out.println("This reader doesnt exist book!");
                
            }
           
        
        
        
        
        //De finisat!!!
    }
    
    
    private Reader()
    {
        //Internal use
    }
    
    
    // <editor-fold defaultstate="collapsed" desc="Create new reader">
    
    //Create new reader
    public Reader(int newID,String newCNP,String newName,int newGroup) throws SQLException
    {
        readerID=newID;
        readerName=newName;
        readerCNP=newCNP;
        readerGroup=newGroup;
        numberOfBooks=0;
        
        
        
        
        Connection connection=DB_Connection.InitializeConnection();
        Statement statement = connection.createStatement();
        
        
        //Insert into data base is next step
        try
        {
            String querry="INSERT INTO `library`.`readers` (`ReaderID`, `ReaderCNP`, `ReaderName`, `ReaderGroup`)"
                    + "VALUES ('"+readerID+"', '"+readerCNP+"', '"+readerName+"', '"+readerGroup+"');";
            statement.executeUpdate(querry);
            
            //Reader has been created
            
            JOptionPane.showMessageDialog (null, "The reader has been added ! \n "
                    , "", JOptionPane.INFORMATION_MESSAGE);
            Object[] row = { readerID, readerCNP, readerName , readerGroup };
                    

                    DefaultTableModel model = (DefaultTableModel) view.jTable2.getModel();

                    model.addRow(row);
            
            
            
        }
        catch(Exception err)
        {
            JOptionPane.showMessageDialog (null, "The reader CNP, reader ID or Both are used ! \n "
                    , "Warning", JOptionPane.WARNING_MESSAGE);
            //System.out.println("The readerCNP, readerID or Both are used !");
            //Reader already exist !
            //System.out.println(err);
        }
        
        
    }
    
// </editor-fold> 
    
    
    
    
    
    
    //Deleation of reader
    //By ID
    public static void DeletReaderByID(int readerID) throws SQLException
    {
        Connection connection=DB_Connection.InitializeConnection();
        Statement statement = connection.createStatement();
        try
        {
            String querry;
            ResultSet resultSet;
            querry="SELECT * FROM readers WHERE readerID="+readerID;
            resultSet=statement.executeQuery(querry);
            
            if(resultSet.next())
            {
                querry = "DELETE FROM `library`.`readers` WHERE `readers`.`ReaderID` = "+readerID+";";
                statement.executeUpdate(querry);
            //Reader has been created
            } 
            else
            {
                System.out.println("This reader doesnt exist !");
            }
        }
        catch(Exception err)
        {
            System.out.println(err);
        }
        
    }
    
    //ByCNP
    public static void DeletReaderByCNP(String readerCNP) throws SQLException
    {
        Connection connection=DB_Connection.InitializeConnection();
        Statement statement = connection.createStatement();
        try
        {
            String querry;
            ResultSet resultSet;
            querry="SELECT * FROM readers WHERE readerCNP="+readerCNP;
            resultSet=statement.executeQuery(querry);
            
            if(resultSet.next())
            {
                querry = "DELETE FROM `library`.`readers` WHERE `readers`.`ReaderCNP` = "+readerCNP+";";
                statement.executeUpdate(querry);
            //Reader has been created
            } 
            else
            {
                System.out.println("This reader doesnt exist !");
            }
        }
        catch(Exception err)
        {
            System.out.println(err);
        }
        
    }
    
    
    
    
    
    
    
    
    
    //Reader data extraction
    
      public static Reader ExtractReaderDatas(int readerID) throws SQLException
    {
        Reader extractedReader=new Reader();
        Connection connection=DB_Connection.InitializeConnection();
        Statement statement = connection.createStatement();
        String querry;
        ResultSet resultSet;
        
        
        querry="SELECT * FROM readers WHERE ReaderID="+readerID;
        resultSet=statement.executeQuery(querry); 
        if(!resultSet.next())
        {
            System.out.println("No readerID !");
        }
        else
        {
            try
            {
        
            querry="SELECT * FROM readers WHERE ReaderID = "+readerID;
            resultSet=statement.executeQuery(querry);    
                    
            
            
                while(resultSet.next())
                {
                    
            
                    int extractedReaderID=resultSet.getInt("ReaderID");
                    String extractedReaderCNP=resultSet.getString("ReaderCNP");
                    String extractedReaderName=resultSet.getString("ReaderName");
                    int extractedReaderGroup=resultSet.getInt("ReaderGroup");
                    extractedReader.SetReaderId(extractedReaderID);
                    extractedReader.SetReaderCNP(extractedReaderCNP);
                    extractedReader.SetReaderName(extractedReaderName);
                    extractedReader.SetReaderGroup(extractedReaderGroup);
                    
                   
                    
                    return extractedReader;
                    //other exception for this
                  
                
                }
            
            }
            catch(Exception ex)
            {
            System.out.println("Error : "+ex);
            
            
            }
        
            
        }
        
               
                return extractedReader;
    }
    
    
    //Borrow book
    public static void BorrowBook(int readerID,int bookID) throws SQLException
    {
       
        
        Connection connection=DB_Connection.InitializeConnection();
        Statement statement = connection.createStatement();
        String querry="SELECT BookID FROM books WHERE FK_ReaderID ="+readerID;
        ResultSet resultSet=statement.executeQuery(querry);
        int countBooksOfReader=1;
        
        while(resultSet.next())
        {
            countBooksOfReader++;
        }
            
        
        if(countBooksOfReader>4)
        {
            System.out.println("The reader has exceeded the maximum number of books !");
        }
        else
        {
            
            Statement statementAux = connection.createStatement();
            
            
            
            querry="SELECT * FROM readers WHERE ReaderID="+readerID;
            resultSet=statement.executeQuery(querry);
            
            String querryAux="SELECT * FROM books WHERE BookID="+bookID;
            ResultSet resultSetAux=statementAux.executeQuery(querryAux);
            
            
            if(!resultSet.next())
            {
                System.out.println("The reader doesn't existt !");
            }
            else if(!resultSetAux.next())
            {
                
                System.out.println("The book doesn't existt !");
            }
            else
            {
                querry="SELECT BookID FROM books WHERE FK_ReaderID="+readerID;
                resultSet=statement.executeQuery(querry);
                int check;
                boolean confirmer=true;
                
                while(resultSet.next())
                {
                    check=resultSet.getInt("BookID");
                    if(check==bookID)
                    {
                        System.out.println("This reader already has this book !");
                        confirmer =false;
                        break;
                    }
                       
                }
                
                
                
                if(confirmer==true)
                {
                    querry="UPDATE `library`.`books` SET `FK_ReaderID` = "+readerID+", `BorrowDate` = sysdate(),"
                    + " `ExceedDate` = date_add(sysdate(), INTERVAL 21 DAY) WHERE `books`.`BookID` ="+bookID;
            
                    statement.executeUpdate(querry);
                    System.out.println("Borrow has suceeded !");
                }
            
            
            }
            
            
        }
        
    }
    
    //Return book
    public static void ReturnBook(int bookID) throws SQLException
    {
        Connection connection=DB_Connection.InitializeConnection();
        Statement statement = connection.createStatement();
        
        String querry;
        
        
        
        
        
        Book book=Book.ExtractBookDatas(bookID);
        
        
        try
        {
            if((book.GetExceedDate().getTime()-book.GetBorrowDate().getTime())/60/60/24/1000>21)
        {   
            System.out.println("The term has exceeded !");
        }
        }
        catch(Exception ex)
        {
            System.out.println("The book has no dates of borrowing and exceeding, but the DataBase will refresh it to null anyway !!!");
            
        }
        
        try
        {
            querry="UPDATE `library`.`books` SET `FK_ReaderID` = NULL, `BorrowDate` = NULL, `ExceedDate` = NULL WHERE `books`.`BookID` = "+bookID;
            statement.executeUpdate(querry);
        }
        catch(Exception ex)
        {
        System.out.println(ex+"Error !!!");
        }
        System.out.println("The return has been finished !");
        
    }
    
    
    
    
    
    
    //Reader Update (Find by readerID)
    
    public static void UpdateReaderID(int readerID,int newReaderID) throws SQLException
    {
        Connection connection=DB_Connection.InitializeConnection();
        Statement statement = connection.createStatement();
        String querry;
        ResultSet resultSet;
        
        
        
        try
        {
            
            querry="SELECT ReaderID FROM readers where ReaderID="+readerID;
            resultSet=statement.executeQuery(querry);
            
            if(!resultSet.next())
            {
                System.out.println("This readerID doesn't exist !");
            }
             else  
            {
                querry="SELECT BookID FROM books where FK_ReaderID="+readerID;
                resultSet=statement.executeQuery(querry);
            
            
            
                if(!resultSet.next())
                {
                
                    
                    querry="UPDATE `library`.`readers` SET `ReaderID` = "+newReaderID+" WHERE `readers`.`ReaderID` ="+readerID+" ;";
                    statement.executeUpdate(querry);
                    System.out.println("ReaderID has been changed !");
                    
                    
              
                
                }
                else
                {
                System.out.println("Unable to cahnage the readerID while he/she has at leat one book !");
                }
            }
                    
          
            
        }
        catch(Exception ex)
        {
            System.out.println("This ID is already used !");
            
        }
    }
    
    public static void UpdateReaderCNP(int readerID,String newReaderCNP) throws SQLException
    {
        Connection connection=DB_Connection.InitializeConnection();
        Statement statement = connection.createStatement();
        String querry;
        ResultSet resultSet;
        
        
        
        try
        {
            
            querry="SELECT ReaderID FROM readers where ReaderID="+readerID;
            resultSet=statement.executeQuery(querry);
            
            if(!resultSet.next())
            {
                System.out.println("This readerID doesn't exist !");
            }
             else  
            {
                
                    
                    querry="UPDATE `library`.`readers` SET `ReaderCNP` = "+newReaderCNP+" WHERE `readers`.`ReaderID` ="+readerID+" ;";
                    statement.executeUpdate(querry);
                    System.out.println("ReaderID has been changed !");
                    
                
            }
                    
          
            
        }
        catch(Exception ex)
        {
            System.out.println("This CNP is already used !");
            
        }
    }
    
    public static void UpdateReaderName(int readerID,String newReaderName) throws SQLException
    {
        Connection connection=DB_Connection.InitializeConnection();
        Statement statement = connection.createStatement();
        String querry;
        ResultSet resultSet;
        
        
        
        try
        {
            
            querry="SELECT ReaderID FROM readers where ReaderID="+readerID;
            resultSet=statement.executeQuery(querry);
            
            if(!resultSet.next())
            {
                System.out.println("This readerID doesn't exist !");
            }
             else  
            {
                
                    
                    querry="UPDATE `library`.`readers` SET `ReaderName` = '"+newReaderName+"' WHERE `readers`.`ReaderID` = "+readerID+";";
                    statement.executeUpdate(querry);
                    System.out.println("ReaderID has been changed !");
                    
                
            }
                    
          
            
        }
        catch(Exception ex)
        {
            System.out.println("Other errors");
            
        }
    }
    
    
    public static void UpdateReaderGroup(int readerID,int newReaderGroup) throws SQLException
    {
        Connection connection=DB_Connection.InitializeConnection();
        Statement statement = connection.createStatement();
        String querry;
        ResultSet resultSet;
        
        
        
        try
        {
            
            querry="SELECT ReaderID FROM readers where ReaderID="+readerID;
            resultSet=statement.executeQuery(querry);
            
            if(!resultSet.next())
            {
                System.out.println("This readerID doesn't exist !");
            }
             else  
            {
                
                    
                    querry="UPDATE `library`.`readers` SET `ReaderGroup` = "+newReaderGroup+" WHERE `readers`.`ReaderID` ="+readerID+" ;";
                    statement.executeUpdate(querry);
                    System.out.println("ReaderID has been changed !");
                    
                
            }
                    
          
            
        }
        catch(Exception ex)
        {
            System.out.println("Other errors !");
            
        }
    }
    
    
    
    
    
    
    
    
    //Reader Update (Find by readerCNP)
    
    // <editor-fold defaultstate="collapsed" desc="Update reader ID">
    
    public static void UpdateReaderID(String readerCNP,int newReaderID) throws SQLException
    {
        Connection connection=DB_Connection.InitializeConnection();
        Statement statement = connection.createStatement();
        String querry;
        ResultSet resultSet;
        int theReaderID;
        
        
        
        try
        {
            
            querry="SELECT ReaderID,ReaderCNP FROM readers where ReaderCNP="+readerCNP;
            resultSet=statement.executeQuery(querry);
            
            if(!resultSet.next())
            {
                System.out.println("This readerCNP doesn't exist !");
            }
             else  
            {
                    theReaderID=resultSet.getInt("readerID");
                    querry="SELECT BookID FROM books where FK_ReaderID="+theReaderID;
                    resultSet=statement.executeQuery(querry);
                    
                    if(!resultSet.next())
                    {
                        querry="UPDATE `library`.`readers` SET `ReaderID` = "+newReaderID+" WHERE `readers`.`ReaderCNP` ="+readerCNP+" ;";
                        statement.executeUpdate(querry);
                        System.out.println("ReaderID has been changed !");
                    }
                    else
                    {
                        System.out.println("Unable to cahnage the readerID while he/she has at leat one book !");
                    }
            
                
            }
                    
          
        }
        catch(Exception ex)
        {
            System.out.println("This ID is already used !");
            
        }
    }
    
// </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="Update Reader CNP">
    public static void UpdateReaderCNP(String readerCNP,String newReaderCNP) throws SQLException
    {
        Connection connection=DB_Connection.InitializeConnection();
        Statement statement = connection.createStatement();
        String querry;
        ResultSet resultSet;
        
        
        
        try
        {
            
            querry="SELECT ReaderCNP FROM readers where ReaderCNP="+readerCNP;
            resultSet=statement.executeQuery(querry);
            
            if(!resultSet.next())
            {
                System.out.println("This readerCNP doesn't exist !");
            }
             else  
            {
                
                    
                    querry="UPDATE `library`.`readers` SET `ReaderCNP` = "+newReaderCNP+" WHERE `readers`.`ReaderCNP` ="+readerCNP+" ;";
                    statement.executeUpdate(querry);
                    System.out.println("ReaderCNP has been changed !");
                    
                
            }
                    
          
            
        }
        catch(Exception ex)
        {
            System.out.println("This CNP is already used !");
            
        }
    }
// </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="Update Reader Name">
    public static void UpdateReaderName(String readerCNP,String newReaderName) throws SQLException
    {
        Connection connection=DB_Connection.InitializeConnection();
        Statement statement = connection.createStatement();
        String querry;
        ResultSet resultSet;
        
        
        
        try
        {
            
            querry="SELECT ReaderCNP FROM readers where ReaderCNP="+readerCNP;
            resultSet=statement.executeQuery(querry);
            
            if(!resultSet.next())
            {
                System.out.println("This readerCNP doesn't exist !");
            }
             else  
            {
                
                    
                    querry="UPDATE `library`.`readers` SET `ReaderName` = "+newReaderName+" WHERE `readers`.`ReaderCNP` ="+readerCNP+" ;";
                    statement.executeUpdate(querry);
                    System.out.println("ReaderName has been changed !");
                    
                
            }
                    
          
            
        }
        catch(Exception ex)
        {
            System.out.println("Other errors !");
            
        }
    }
// </editor-fold>
    
    
    // <editor-fold defaultstate="collapsed" desc="Update reader group">
    public static void UpdateReaderGroup(String readerCNP,int newReaderGroup) throws SQLException
    {
       Connection connection=DB_Connection.InitializeConnection();
        Statement statement = connection.createStatement();
        String querry;
        ResultSet resultSet;
        
        
        
        try
        {
            
            querry="SELECT ReaderCNP FROM readers where ReaderCNP="+readerCNP;
            resultSet=statement.executeQuery(querry);
            
            if(!resultSet.next())
            {
                System.out.println("This readerCNP doesn't exist !");
            }
             else  
            {
                
                    
                    querry="UPDATE `library`.`readers` SET `ReaderGroup` = "+newReaderGroup+" WHERE `readers`.`ReaderCNP` ="+readerCNP+" ;";
                    statement.executeUpdate(querry);
                    System.out.println("ReaderCNP has been changed !");
                    
                
            }
                    
          
            
        }
        catch(Exception ex)
        {
            System.out.println("Other errors !");
            
        } 
    }
// </editor-fold>
    
    
    
    
    //Seacrh reader
    
    
    // <editor-fold defaultstate="collapsed" desc="By readerID">
    
    public static ResultSet SearchReaderByID(int readerID) throws SQLException
    {
        String querry="SELECT * FROM readers WHERE readerID = "+readerID+" ;";
        Connection connection=DB_Connection.InitializeConnection();
        Statement statement = connection.createStatement();
        ResultSet resultSet=statement.executeQuery(querry);
        
            return resultSet;
        
    }
    
    
// </editor-fold>
    
    
    
    // <editor-fold defaultstate="collapsed" desc="By bookName">
    
     public static ResultSet SearchReaderByCNP(String readerCNP) throws SQLException
    {
        String querry="SELECT * FROM readers WHERE readerCNP = \""+readerCNP+"\" ;";
        Connection connection=DB_Connection.InitializeConnection();
        Statement statement = connection.createStatement();
        ResultSet resultSet=statement.executeQuery(querry);
        
            return resultSet;
       
    }
    
// </editor-fold>
    
   
    
    // <editor-fold defaultstate="collapsed" desc="By Name">
    
    public static ResultSet SearchReaderByName(String readerName) throws SQLException
    {
        String querry="SELECT * FROM readers WHERE readerName = \""+readerName+"\" ;";
        Connection connection=DB_Connection.InitializeConnection();
        Statement statement = connection.createStatement();
        ResultSet resultSet=statement.executeQuery(querry);
        
        
            return resultSet;
        
    }
    
// </editor-fold>
    
    
    // <editor-fold defaultstate="collapsed" desc="List of Reader">
    public static ResultSet ListOfReaders() throws SQLException
    {
        
        try
        {   
            Connection connection=DB_Connection.InitializeConnection();
            Statement statement=connection.createStatement();
            String querry="SELECT * FROM `readers` ";
            ResultSet resultSet = statement.executeQuery(querry);
            return resultSet;
        }
        catch(Exception ex)
        {
            
            return null;
        }
    
    
    }
    
// </editor-fold>
    
    
    
    
     //Get/Set
    
    // <editor-fold defaultstate="collapsed" desc="Get/Set readerID">

    
     public void SetReaderId(int newID)
    {
        readerID=newID;
    }
    public int GetReaderID()
    {
        return readerID;
    }
    
    // </editor-fold>
    
    
   
    // <editor-fold defaultstate="collapsed" desc="Get/Set readerGroup">
    public void SetReaderGroup(int newGroup)
    {
        readerGroup=newGroup;
    }
    public int GetReaderGroup()
    {
        return readerGroup;
    }
    
    
// </editor-fold>
    
    
    
    // <editor-fold defaultstate="collapsed" desc="Get/Set readerCNP">
    
    
    //Get/Set readerCNP
    public void SetReaderCNP(String newCNP)
    {
        readerCNP=newCNP;
    }
    public String GetReaderCNP()
    {
        return readerCNP;
    }
    
// </editor-fold>
    
    
    
    // <editor-fold defaultstate="collapsed" desc="Get/Set readerName">
    
    public void SetReaderName(String newName)
    {
        readerName=newName;
    }
        
    public String GetReaderName()
    {
        return readerName;
    }
    
// </editor-fold>
    
    
    // <editor-fold defaultstate="collapsed" desc="Number of Books">

    
    public void SetReaderNumberOfBooks(int newNumberOfBooks)
    {
        numberOfBooks=newNumberOfBooks;
    }
    public int GetReaderNumberOfBooks()
    {
        return numberOfBooks;
    }


// </editor-fold>
    
    
    
    
    
    
}
