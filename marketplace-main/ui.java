package Utility;

public interface ui {
    void addUser(String name, int balance) throws Exception;
    void catalog() throws Exception;
    void purchase(int id) throws Exception;
    void userInfo(int id) throws Exception;
    void purchaseInfo(int id) throws Exception;
    void receipt(int id) throws Exception;
}