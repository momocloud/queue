package service;

import pojo.Queue;

import java.util.List;

public interface QueueService {
    public int insertQueue(Queue queue);

    public int deleteQueueById(Integer id);

    public int updateQueue(Queue queue);

    public Queue selectQueueById(Integer id);

    public List<Queue> selectQueueByName(String name);

    public List<Queue> selectQueues();
}
