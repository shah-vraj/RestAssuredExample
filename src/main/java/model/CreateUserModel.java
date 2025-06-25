package model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CreateUserModel {
    public String name;
    public String job;
}
