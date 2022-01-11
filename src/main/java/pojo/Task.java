package pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Task {
    private String id;
    private int uId;
    private int qId;
    private String comment;
    private String location;
    private Date joinTime;
}
