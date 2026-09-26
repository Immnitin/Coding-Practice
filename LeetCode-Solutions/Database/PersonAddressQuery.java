import java.sql.*;/**
 * Approach: Executes a predefined SQL query that selects firstName, lastName, city, state from Person left joined with Address.
 * Time Complexity: O(N) relative to the number of rows returned by the query, as the driver iterates through the ResultSet.
 * Space Complexity: O(1) additional space besides the ResultSet and JDBC objects.
 */
# Write your MySQL query statement below
select firstName, lastName, city, state from Person
left join Address
on Person.PersonId=Address.personId;
public class Driver {
    public static void main(String[] args) throws Exception {
        String url = "jdbc:h2:mem:testdb";
        try (Connection conn = DriverManager.getConnection(url);
             Statement stmt = conn.createStatement()) {
            stmt.execute("CREATE TABLE Person(PersonId INT PRIMARY KEY, firstName VARCHAR(50), lastName VARCHAR(50))");
            stmt.execute("CREATE TABLE Address(personId INT, city VARCHAR(50), state VARCHAR(50))");
            stmt.execute("INSERT INTO Person VALUES(1,'John','Doe'),(2,'Jane','Smith')");
            stmt.execute("INSERT INTO Address VALUES(1,'New York','NY'),(2,'Los Angeles','CA')");
            String query = "select firstName, lastName, city, state from Person left join Address on Person.PersonId=Address.personId";
            try (ResultSet rs = stmt.executeQuery(query)) {
                while (rs.next()) {
                    System.out.printf("%s %s - %s, %s%n", rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4));
                }
            }
        }
    }
}