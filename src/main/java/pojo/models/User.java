package pojo.models;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

@Builder
@Data
@JsonInclude(JsonInclude.Include.NON_DEFAULT)
@NoArgsConstructor
@AllArgsConstructor
public class User {

    private String name;
    private String job;
    private String id;
    private String createdAt;

}
