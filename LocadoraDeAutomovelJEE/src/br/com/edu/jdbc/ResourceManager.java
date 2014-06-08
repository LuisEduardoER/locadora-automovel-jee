package br.com.edu.jdbc;

import java.sql.*;

public class ResourceManager
{
    private static String JDBC_DRIVER   = "net.sourceforge.jtds.jdbc.Driver";
    private static String JDBC_DATABASE_NAME     = "DatabaseName=aluguel;";
    private static String JDBC_URL      = "jdbc:jtds:sqlserver://127.0.0.1:1433;";
    private static String JDBC_LOGIN     = "NamePipe=false;";

    private static String JDBC_USER     = "sa";
    private static String JDBC_PASSWORD = "1234";

    private static Driver driver = null;

    public static synchronized Connection getConnection()
	throws SQLException
    {
        if (driver == null)
        {
            try
            {
                Class jdbcDriverClass = Class.forName( JDBC_DRIVER );
                driver = (Driver) jdbcDriverClass.newInstance();
                DriverManager.registerDriver( driver );
            }
            catch (Exception e)
            {
                System.out.println( "Failed to initialise JDBC driver" );
                e.printStackTrace();
            }
        }

        
        
        return DriverManager.getConnection(
                JDBC_URL+JDBC_DATABASE_NAME+JDBC_LOGIN
               // JDBC_USER,
                //JDBC_PASSWORD
        );
    }


	public static void close(Connection conn)
	{
		try {
			if (conn != null) conn.close();
		}
		catch (SQLException sqle)
		{
			sqle.printStackTrace();
		}
	}

	public static void close(PreparedStatement stmt)
	{
		try {
			if (stmt != null) stmt.close();
		}
		catch (SQLException sqle)
		{
			sqle.printStackTrace();
		}
	}

	public static void close(ResultSet rs)
	{
		try {
			if (rs != null) rs.close();
		}
		catch (SQLException sqle)
		{
			sqle.printStackTrace();
		}

	}

}
