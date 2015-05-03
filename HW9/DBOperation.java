import java.sql.*;
public class DBOperation
{
    static String connStr="jdbc:mysql://localhost/";
    static String dbName="javaHW";
    static String userName="root";
    static String password="bullshitpassword";
    private Connection conn=null;
    public DBOperation()
    {
        
    }
    public Connection getConnection() throws Exception
    {
        if(conn==null)
        {
            Class.forName("com.mysql.jdbc.Driver");
            conn=DriverManager.getConnection(connStr,userName,password);
        }
        return conn;
    }
    public void execute(String sql)
    {
        try
        {
            conn=getConnection();
            Statement statement=conn.createStatement();
            statement.execute(sql);
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
    public ResultSet executeQuery(String sql)
    {
        ResultSet result=null;
        try
        {
            conn=getConnection();
            Statement statement=conn.createStatement();
            result=statement.executeQuery(sql);
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return result;
    }
    public void close()
    {
        if (conn!=null)
        {
            try{
                conn.close();
                }
            catch (Exception ex)
            {}
        }
    }
    public static void main(String [] args)throws Exception
    {
        DBOperation db=new DBOperation();
        System.out.println("creating database");
        db.execute("CREATE DATABASE IF NOT EXISTS hw9");
        System.out.println("creating table");
        db.execute("CREATE TABLE IF NOT EXISTS hw9.hw \r\n"
        +"(id INTEGER NOT NULL AUTO_INCREMENT, \r\n"
         +"title NVARCHAR(30) NOT NULL, \r\n"
         +"intro NVARCHAR(300), \r\n"
         +"PRIMARY KEY(id));");
        System.out.println("add two records");
        db.execute("INSERT INTO hw9.hw(title,intro)values('JDBC','database operation with Java')");
        db.execute("INSERT INTO hw9.hw(title,intro)values('IO','print file tree')");
        System.out.println("update one record");
        db.execute("UPDATE hw9.hw SET intro='print a tree view of a folder' WHERE title='IO'");
        ResultSet rsAll=db.executeQuery("SELECT * FROM hw9.hw");
        while (rsAll.next())
        {
            System.out.print(rsAll.getString(1)+"\t"+rsAll.getString(2)+"\t"+rsAll.getString(3)+'\n');
        }
        System.out.println("now delete one row");
        db.execute("DELETE FROM hw9.hw WHERE title='IO'");
        ResultSet rsCount=db.executeQuery("SELECT COUNT(*) FROM hw9.hw");
        if(rsCount.next())
            System.out.println("Number of records now "+rsCount.getString(1));
        
        ResultSet rs=db.executeQuery("SELECT id,title,intro from hw9.hw");
        db.close();
        
    }
}
