//import java.sql.Connection;
//import java.sql.PreparedStatement;
//
//public class Main {
//
//    public static void main(String[] args) throws Exception {
//
//        Connection conn = DatabaseConfig.getConnection();
//
//        PreparedStatement pstmt = conn.prepareStatement(
//                "INSERT INTO tasks (title, description) VALUES (?, ?)"
//        );
//
//        pstmt.setString(1, "JDBC Testing");
//        pstmt.setString(2, "This is the JDBC Testing description");
//
//        pstmt.executeUpdate();
//
//        System.out.println("Task added");
//
//        pstmt.close();
//        conn.close();
//    }
//}
import java.sql.*;
import java.util.Scanner;  // Import Scanner for user input

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);  // Create Scanner to read keyboard input

        try (Connection conn = DatabaseConfig.getConnection()) {  // Auto-closes connection
                                                    //Anything that needs closing is inside ()
                                                    //rest in {} after try.
            while (true) {  // Infinite loop - keeps running until we break
                System.out.println("\n=== ADD/DELETE/READ/UPDATE NEW TASK ===");
                System.out.print("Enter 'add'/'delete'/'read'/'update'  (or 'quit' to exit): ");
                String options = scanner.nextLine();  // Wait for user to type and press Enter
                // Check if user wants to quit
                if (options.equalsIgnoreCase("quit")) {  // equalsIgnoreCase = "quit", "QUIT", "Quit" all work
                    System.out.println("Exiting...");
                    break;  // Exit the while loop
                }
                else if(options.equalsIgnoreCase("add")){
                    System.out.print("Enter title: ");
                    String title = scanner.nextLine();

                System.out.print("Enter description: ");
                String description = scanner.nextLine();  // Get description from user

                // Insert into database
                String sql = "INSERT INTO tasks (title, description) VALUES (?, ?)";
                try (PreparedStatement pstmt = conn.prepareStatement(sql)) {  // Auto-closes statement
                    pstmt.setString(1, title);        // Set first ? with title
                    pstmt.setString(2, description);   // Set second ? with description

                    int rowsAffected = pstmt.executeUpdate();  // Run the insert
                    System.out.println("✅ Task added! (" + rowsAffected + " row(s) affected)");
                }catch (SQLException e) {
                    System.err.println("Error adding task: " + e.getMessage());
                }}
                else if(options.equalsIgnoreCase("read")) {
                    System.out.print("Enter title: ");
                    String title = scanner.nextLine();

                    String sql = "SELECT description FROM tasks WHERE title = ?";

                    try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
                        pstmt.setString(1, title);

                        // FIX 1: Use executeQuery() not executeUpdate()!
                        ResultSet rs = pstmt.executeQuery();  // Returns data, not row count

                        // FIX 2: Check if data exists and print it
                        if (rs.next()) {  // Move to first row (if any)
                            String description = rs.getString("description");  // Get by column name
                            System.out.println("✅ Description: " + description);
                        } else {
                            System.out.println("❌ No task found with title: " + title);
                        }

                        // ResultSet automatically closes with try-with-resources

                    } catch (SQLException e) {
                        System.err.println("Error reading task: " + e.getMessage());
                    }
                }
                else if(options.equalsIgnoreCase("update")){
                    System.out.print("Enter title: ");
                    String title1 = scanner.nextLine();
                    System.out.print("Enter description: ");
                    String description = scanner.nextLine();  // Get description from user
                    String sql = "UPDATE tasks SET description=? WHERE title=?";
                    try (PreparedStatement pstmt = conn.prepareStatement(sql)) {  // Auto-closes statement
                        pstmt.setString(1, description);        // Set first ? with description
                        pstmt.setString(2, title1);   // Set second ? with title

                        int rowsAffected = pstmt.executeUpdate();  // Run the insert
                        System.out.println("✅ Task updated! (" + rowsAffected + " row(s) affected)");
                    }
                    catch (SQLException e) {
                        System.err.println("Error updating task: " + e.getMessage());
                    }
                }
                else if(options.equalsIgnoreCase("delete")){
                    System.out.print("Enter title: ");
                    String title = scanner.nextLine();
                    String sql= "DELETE FROM tasks WHERE title=? ";
                    try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
                        pstmt.setString(1, title);

                        int rowsAffected = pstmt.executeUpdate();  // Run the insert
                        System.out.println("✅ Task deleted! (" + rowsAffected + " row(s) affected)");
                    }catch (SQLException e) {
                        System.err.println("Error deleting task: " + e.getMessage());
                    }}
                else{
                    System.out.println("Choose a proper option");
                }// pstmt automatically closed here
            }  // Loop back to start - ask for another task

        } catch (SQLException | ClassNotFoundException e) {  // Handle any database errors
            System.err.println("Database error: " + e.getMessage());
            e.printStackTrace();
        }

        scanner.close();  // Close the scanner when done
    }
}