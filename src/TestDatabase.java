import java.net.URL;
import java.sql.*;
import java.io.PrintWriter;

class TestDatabase
{
   public static void main (String args[])
   {
      try
      {
         // Load driver's class, inilialize, register with DriverManager
         //Class.forName("oracle.jdbc.driver.OracleDriver");
         //Class.forName("org.gjt.mm.mysql.Driver");
	Class.forName("com.mysql.Driver");
      }
      catch (ClassNotFoundException e)
      {
         System.out.println("Unable to load driver class");
         return;
      }

      ResultSet rs = null;

      try
      {
         //
         // Call DriverManager's methods (all are static)
         //

         // To print log on sysout
         //DriverManager.setLogStream(System.out); //JDBC 1.x driver
         DriverManager.setLogWriter(new PrintWriter(System.out) );

         // Connect to database.  DriverManager loads each registered driver
         // in turn until one can handle the database URL format
         //Connection con = DriverManager.getConnection(
         //                     "jdbc:oracle:thin:@host.domain.com:1521:db_name"
         //                     ,"scott","tiger");
         Connection con = DriverManager.getConnection(
                              "jdbc:mysql://localhost:3306/civil2","","");

         // Check for warnings generated during connect
         areWarnings(con.getWarnings() );

         // Get the DatabaseMetaData object to display database info
         DatabaseMetaData dmd = con.getMetaData();

         // Display overall database info
         System.out.println( "\nConnected to " + dmd.getURL()
            + " using driver = " + dmd.getDriverName() + ", version = "
            + dmd.getDriverVersion() );

         System.out.println(
            "\nVendor product name is " + dmd.getDatabaseProductName()
            + ".\n\tDatabase software version is "
            + dmd.getDatabaseProductVersion()
            + ".\n\tUser name is " + dmd.getUserName()
            + ".\n\tCatalog is called " + dmd.getCatalogTerm()
            + ".\n\tSchema is called " + dmd.getSchemaTerm()
            + ".\n\tProcedure is called " + dmd.getProcedureTerm()
            + "." );

         System.out.println(
            "\nNumeric functions are:\n" + dmd.getNumericFunctions()
            + "\nString functions are:\n" + dmd.getStringFunctions()
            + "\nDate and Time functions are:\n" + dmd.getTimeDateFunctions()
            + "\nSystem functions are:\n" + dmd.getSystemFunctions()
            + "\n" );

         System.out.println(
            "Use the escape string \"" + dmd.getSearchStringEscape()
            + "\" to escape wildcard characters." );

         System.out.println(
            "Is the database in read only mode? Answer: " + dmd.isReadOnly()
            + "" );

         // Create a Statement object for submitting SQL commands to driver
         Statement stmt = con.createStatement();

         String sql;

         //DROP TABLE statement
         sql = "DROP TABLE users";
         try
         {
            stmt.executeUpdate(sql);  //throws SQLExecption if fails
            System.out.println("Dropped table \"users\"!");
         }
         catch(SQLException ex)
         {
            System.out.println("Could not drop table \"users\"!");
            printException(ex);
         }
         areWarnings(stmt.getWarnings() );

         //CREATE TABLE statement
         sql = "CREATE TABLE users ("
               + "login VARCHAR(30) PRIMARY KEY NOT NULL,"
               + "password VARCHAR(100),"
               + "first VARCHAR(50),"
               + "middle VARCHAR(50),"
               + "last VARCHAR(50),"
               + "nickname VARCHAR(30),"
               + "email VARCHAR(100),"
               + "city VARCHAR(50),"
               + "state VARCHAR(50),"
               + "country VARCHAR(50),"
               + "zip VARCHAR(30)"
               + ")";

         try
         {
            stmt.executeUpdate(sql); //throws SQLExecption if fails
            System.out.println("Created table \"users\"!");
         }
         catch(SQLException ex)
         {
            printException(ex);
         }
         areWarnings(stmt.getWarnings() );

         //
         // More Database meta data
         //

         // What type of tables (tables, views etc.)?
         rs = dmd.getTableTypes();
         printResultSet(rs);
         rs.close();

         // Any catalogs?
         rs = dmd.getCatalogs();
         printResultSet(rs);
         rs.close();

         // What are the defined schemas?
         rs = dmd.getSchemas();
         printResultSet(rs);
         rs.close();

         // Good One:  What are the defined tables?
         // Last arg is an array of strings (table types to get)
         //String[] tp = {"TABLE"};
         //rs = dmd.getTables(null, null, "addr%", null);
         rs = dmd.getTables(null, null, null, null);
         printResultSet(rs);
         rs.close();

         // For a table, what are the defined indexes?
         rs = dmd.getIndexInfo(null, null, "users", false, true);
         printResultSet(rs);
         rs.close();

         // For a table, what columns nake up its primary key
         rs = dmd.getPrimaryKeys(null, null, "users");
         printResultSet(rs);
         rs.close();

         // Any stored procedures defined?
         rs = dmd.getProcedures(null, null, null);
         printResultSet(rs);
         rs.close();

         // The connected user has these table privileges
         rs = dmd.getTablePrivileges(null, null, null);
         printResultSet(rs);
         rs.close();

         // The connected user has these column privileges
         rs = dmd.getColumnPrivileges(null, null, null, null);
         printResultSet(rs);
         rs.close();

         // Get all the tables with their column definitions
         rs = dmd.getColumns(null, null, null, null);
         printResultSet(rs);
         rs.close();


         // INSERT statement (UPDATE is similar)
         sql = "INSERT INTO users ("
                  + "login, password, nickname, "
                  +  "last, first, middle, email,"
                  +  "city, state, country, zip"
               + ") VALUES ("
                  + "'superman', 'foo has a meaning', 'S',"
                  + "NULL, NULL, NULL, 'iam@your.place',"
                  + "NULL, NULL, NULL, '56735-6453'"
               + ")";

         stmt.executeUpdate(sql);   //throws SQLExecption if fails
         areWarnings(stmt.getWarnings() );

         // Submit a query, driver hands back a ResultSet object
         sql = "SELECT * FROM users WHERE login IS NOT NULL";
         rs = stmt.executeQuery(sql); //throws SQLExecption if fails
         areWarnings(stmt.getWarnings() );
         // Process query results.
         printResultSet(rs);
         // Tell Java you are done and Java may release memory
         rs.close();

         // DELETE statement
         sql = "DELETE FROM users WHERE login IS NOT NULL";
         stmt.executeUpdate(sql);   //throws SQLExecption if fails
         areWarnings(stmt.getWarnings() );

         // Good people close explicitly to release db resources
         stmt.close();
         con.close();
      }
      catch(SQLException ex){printException(ex); }
   }


   //
   // Work with ResultSetMetaData
   //

   private static void printResultSet(ResultSet rs) throws SQLException
   {
      ResultSetMetaData rsmd = rs.getMetaData();
      int numCols = rsmd.getColumnCount();

      // Display column titles
      System.out.println("-----------------------------------------");
      for(int i=1; i<=numCols; i++)
      {
         if(i > 1) System.out.print(",");
         System.out.print(rsmd.getColumnLabel(i));
      }
      System.out.println("");
      System.out.println("-----------------------------------------");

      // Display data, fetching until end of the result set
      // Calling next moves to first or next row and returns true if success
      while(rs.next() )
      {
         // Each rs after next() contains next rows data
         for(int i=1; i<=numCols; i++)
         {
            if(i > 1) System.out.print(",");
            // Almost all SQL types can be cast to a string by JDBC
            System.out.print(rs.getString(i));
            areWarnings(rs.getWarnings() );
         }
         System.out.println("");
      }
   }


   //
   // Check for warnings
   //
   private static boolean areWarnings(SQLWarning warn) throws SQLException
   {
      boolean rc = false;

      // Multiple warning smay have been chained to the passed SQLWarning object
      // Or, null may have been passed if there were no warnings
      if(warn != null)
      {
         System.out.println("\n *** Warning ***\n");
         rc = true;
         while(warn != null)
         {
            System.out.println("SQLState: " + warn.getSQLState() );
            System.out.println("Message:  " + warn.getMessage() );
            System.out.println("Vendor:   " + warn.getErrorCode ());
            System.out.println ("");
            warn = warn.getNextWarning ();
         }
      }
      return rc;
   }

   //
   //  Print all chained exceptions
   //
   public static void printException(SQLException ex)
   {
      // Multiple error objects may be chained together
      System.out.println("\n*** SQLException caught ***\n");
      while(ex != null)
      {
         System.out.println("SQLState: " + ex.getSQLState() );
         System.out.println("Message:  " + ex.getMessage() );
         System.out.println("Vendor:   " + ex.getErrorCode ());
         ex.printStackTrace(System.out);
         System.out.println ("");
         // Get next error object in chain. null if none.
         ex = ex.getNextException();
      }
   }
}