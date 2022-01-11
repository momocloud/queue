package service;

import dao.TaskMapper;
import pojo.Task;
import pojo.TaskToShow;

import java.util.List;

public class TaskServiceImpl implements TaskService{
    private TaskMapper taskMapper;

    public void setTaskMapper(TaskMapper taskMapper) {
        this.taskMapper = taskMapper;
    }

    @Override
    public int insertTask(Task task) {
        return taskMapper.insertTask(task);
    }

    @Override
    public int deleteTaskById(String id) {
        return taskMapper.deleteTaskById(id);
    }

    @Override
    public int updateTask(Task task) {
        return taskMapper.updateTask(task);
    }

    @Override
    public Task selectTaskById(String id) {
        return taskMapper.selectTaskById(id);
    }

    @Override
    public List<Task> selectTaskByUId(Integer uId) {
        return taskMapper.selectTaskByUId(uId);
    }

    @Override
    public List<Task> selectTaskByQId(Integer qId) {
        return taskMapper.selectTaskByQId(qId);
    }

    @Override
    public List<Task> selectTaskByDoubleId(Integer uId, Integer qId) {
        return taskMapper.selectTaskByDoubleId(uId, qId);
    }

    @Override
    public List<Task> selectTasks() {
        return taskMapper.selectTasks();
    }

    @Override
    public List<TaskToShow> selectTaskToShowByQId(Integer qId) {
        return taskMapper.selectTaskToShowByQId(qId);
    }
}
