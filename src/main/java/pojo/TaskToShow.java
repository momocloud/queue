package pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TaskToShow {
    private String id;
    private String userName;
    private String comment;
    private String location;
    private Date joinTime;
}
