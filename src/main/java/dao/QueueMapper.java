package dao;

import org.apache.ibatis.annotations.Param;
import pojo.Queue;

import java.util.List;

public interface QueueMapper {
    public int insertQueue(Queue queue);

    public int deleteQueueById(@Param("id") Integer id);

    public int updateQueue(Queue queue);

    public Queue selectQueueById(@Param("id") Integer id);

    public List<Queue> selectQueueByName(@Param("name") String name);

    public List<Queue> selectQueues();
}
