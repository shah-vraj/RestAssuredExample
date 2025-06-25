package model;

import lombok.Data;

@Data
public class UserDataModel {
    public int id;
    public String email;
    public String first_name;
    public String last_name;
    public String avatar;
}
