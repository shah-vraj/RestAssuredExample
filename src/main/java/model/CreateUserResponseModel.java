package model;

import lombok.Data;

@Data
public class CreateUserResponseModel {
    public String name;
    public String job;
    public String id;
    public String createdAt;
}
