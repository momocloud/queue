package service;

import pojo.Task;
import pojo.TaskToShow;

import java.util.List;

public interface TaskService {
    public int insertTask(Task task);

    public int deleteTaskById(String id);

    public int updateTask(Task task);

    public Task selectTaskById(String id);

    public List<Task> selectTaskByUId(Integer uId);

    public List<Task> selectTaskByQId(Integer qId);

    public List<Task> selectTaskByDoubleId(Integer uId, Integer qId);

    public List<Task> selectTasks();

    public List<TaskToShow> selectTaskToShowByQId(Integer qId);
}
