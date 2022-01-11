package service;

import dao.QueueMapper;
import org.springframework.stereotype.Service;
import pojo.Queue;

import java.util.List;

@Service
public class QueueServiceImpl implements QueueService{

    private QueueMapper queueMapper;

    public void setQueueMapper(QueueMapper queueMapper) {
        this.queueMapper = queueMapper;
    }

    @Override
    public int insertQueue(Queue queue) {
        return queueMapper.insertQueue(queue);
    }

    @Override
    public int deleteQueueById(Integer id) {
        return queueMapper.deleteQueueById(id);
    }

    @Override
    public int updateQueue(Queue queue) {
        return queueMapper.updateQueue(queue);
    }

    @Override
    public Queue selectQueueById(Integer id) {
        return queueMapper.selectQueueById(id);
    }

    @Override
    public List<Queue> selectQueueByName(String name) {
        if (name == null || name.equals("")) {
            return selectQueues();
        } else {
            return queueMapper.selectQueueByName(name);
        }
    }

    @Override
    public List<Queue> selectQueues() {
        return queueMapper.selectQueues();
    }
}
