package dao;

import org.apache.ibatis.annotations.Param;
import pojo.Task;
import pojo.TaskToShow;

import java.util.List;

public interface TaskMapper {
    public int insertTask(Task task);

    public int deleteTaskById(@Param("id") String id);

    public int updateTask(Task task);

    public Task selectTaskById(@Param("id") String id);

    public List<Task> selectTaskByUId(@Param("uId") Integer uId);

    public List<Task> selectTaskByQId(@Param("qId") Integer qId);

    public List<Task> selectTaskByDoubleId(@Param("uId") Integer uId, @Param("qId") Integer qId);

    public List<Task> selectTasks();

    public List<TaskToShow> selectTaskToShowByQId(@Param("qId") Integer qId);
}
