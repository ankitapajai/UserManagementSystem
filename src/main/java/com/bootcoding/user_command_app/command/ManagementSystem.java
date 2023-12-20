package com.bootcoding.user_command_app.command;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ManagementSystem {

    //Design user management system using command line interface!...
        private static Map<String, User> users = new HashMap<>();

        public static void main(String[] ar) {
            while (true){
                System.out.println("Welcome to the user management system!..");
                System.out.println("Enter the action that you want to perform: --action [create|read|update|delete]");
                Scanner scanner = new Scanner(System.in);
                String action1 = scanner.nextLine();
                String[] args = action1.split(" ");

                if (args.length < 2) {
                    System.out.println("Usage: --action [create|update|delete|read] --n \"username\" --m \"mail_id\" --p \"phone\" --a \"address\"");
                    return;
                }
                String action = args[1];
                switch (action) {
                    case "create":
                        createUser(args);
                        break;
                    case "read":
                        readUser(args);
                        break;
                    case "update":
                        updateUser(args);
                        break;
                    case "delete":
                        deleteUser(args);
                        break;
                    default:
                        System.out.println("Invalid action. Supported actions: create, read, update, delete");
                }
                System.out.println("Do you want to continue? (Y/N)");
                Scanner sc1 = new Scanner(System.in);
                String choice = sc1.nextLine();
                if(choice.equals("N")){
                    System.exit(0);
                }
                else if(choice.equals("Y")){
                    continue;
                }
                else{
                    System.out.println("Invalid choice");
                    System.exit(0);
                }
            }
        }

        //CREATE
        public static void createUser(String[] args) {
            String username = getValue(args, "--n");
            String mail_id = getValue(args, "--m");
            String phone = getValue(args, "--p");
            String address = getValue(args, "--a");

            if (username == null || mail_id == null || phone == null || address == null) {
                System.out.println("Missing required parameters. Please provide --n, --m, --p, --a");
                return;
            }
            User user = new User(generateUserId(), username, mail_id, phone, address);
            users.put(user.getId(), user);
            System.out.println("User created successfully. ID: " + user.getId());

        }

        //UPDATE
        public static void updateUser(String[] args) {
            String userId = getValue(args, "--id");
            if (userId == null) {
                System.out.println("Missing required parameter. Please provide --id");
                return;
            }

            User user = users.get(userId);
            if (user == null) {
                System.out.println("User not found with ID: " + userId);
                return;
            }

            if (args.length > 4) {
                user.setUsername(getValue(args, "--n"));
                user.setMail_id(getValue(args, "--m"));
                user.setPhone(getValue(args, "--p"));
                user.setAddress(getValue(args, "--a"));
                System.out.println("User updated successfully.");
            } else {
                System.out.println("No update parameters provided.");
            }
        }

        //DELETE
        public static void deleteUser(String[] args) {
            String userId = getValue(args, "--id");
            if (userId == null) {
                System.out.println("Missing required parameter. Please provide --id");
                return;
            }

            User user = users.remove(userId);
            if (user == null) {
                System.out.println("User not found with ID: " + userId);
            } else {
                System.out.println("User deleted successfully.");
            }
        }

        //READ
        public static void readUser(String[] args) {
            String userId = getValue(args, "--id");
            if (userId == null) {
                System.out.println("Missing required parameter. Please provide --id");
                return;
            }

            User user = users.get(userId);
            if (user == null) {
                System.out.println("User not found with ID: " + userId);
            } else {
                System.out.println("User Information:");
                System.out.println("ID: " + user.getId());
                System.out.println("Name: " + user.getUsername());
                System.out.println("Mail_id: " + user.getMail_id());
                System.out.println("Phone: " + user.getPhone());
                System.out.println("Address: " + user.getAddress());
            }
        }

        public static String getValue(String[] args, String key) {
            for (int i = 0; i < args.length - 1; i++) {
                if (args[i].equals(key)) {
                    return args[i + 1];
                }
            }
            return null;
        }

        public static String generateUserId() {
            return "U" + System.currentTimeMillis();
        }

    }
