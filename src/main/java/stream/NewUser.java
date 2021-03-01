package stream;

public class NewUser {
    private Integer id;
    private String username;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public String toString() {
        return "NewUser{" +
                "id=" + id +
                ", username='" + username + '\'' +
                '}';
    }

    public NewUser(Integer id, String username) {
        this.id = id;
        this.username = username;
    }
}
