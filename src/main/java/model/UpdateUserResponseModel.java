package model;

import lombok.Data;

@Data
public class UpdateUserResponseModel {
    public String name;
    public String job;
    public String updatedAt;
}
