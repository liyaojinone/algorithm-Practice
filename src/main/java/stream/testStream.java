package stream;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class testStream {
    public static void main(String[] args) {
        user user = new user("张三",1,80);
        user user1 = new user("李四",2,60);
        user user2 = new user("王五",3,50);
        user user3 = new user("赵九",4,100);
        ArrayList<user> users = new ArrayList<>();
        users.add(user);
        users.add(user1);
        users.add(user2);
        users.add(user3);


    }
}
