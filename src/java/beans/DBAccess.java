package beans;

/**
 *
 * @author am
 */
public class DBAccess extends SuperBb {

    protected Integer user_id;
    protected Integer theater_id;
    protected Integer seat_id;
    protected String field_users;
    protected String search_users;
    protected String operator_users;
    protected String field_theaters;
    protected String search_theaters;
    protected String operator_theaters;

    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    public Integer getTheater_id() {
        return theater_id;
    }

    public void setTheater_id(Integer theater_id) {
        this.theater_id = theater_id;
    }

    public Integer getSeat_id() {
        return seat_id;
    }

    public void setSeat_id(Integer seat_id) {
        this.seat_id = seat_id;
    }

    public String getField_users() {
        return field_users;
    }

    public void setField_users(String field_users) {
        this.field_users = field_users;
    }

    public String getSearch_users() {
        return search_users;
    }

    public void setSearch_users(String search_users) {
        this.search_users = search_users;
    }

    public String getOperator_users() {
        return operator_users;
    }

    public void setOperator_users(String operator_users) {
        this.operator_users = operator_users;
    }

    public String getField_theaters() {
        return field_theaters;
    }

    public void setField_theaters(String field_theaters) {
        this.field_theaters = field_theaters;
    }

    public String getSearch_theaters() {
        return search_theaters;
    }

    public void setSearch_theaters(String search_theaters) {
        this.search_theaters = search_theaters;
    }

    public String getOperator_theaters() {
        return operator_theaters;
    }

    public void setOperator_theaters(String operator_theaters) {
        this.operator_theaters = operator_theaters;
    }

    private void init() {
    }

    public void addUser() {
    }

    public void updateUser() {
    }

    public void searchUsers() {
    }

    public void deleteUser() {
    }

    public void addTheater() {
    }

    public void updateTheater() {
    }

    public void searchTheaters() {
    }

    public void deleteTheater() {
    }

    public void getResultTheaters() {
    }

    public void getHasSeat() {
    }
}
