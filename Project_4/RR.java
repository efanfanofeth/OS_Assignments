import java.util.*;

// using round robin which runs each task at a set time interval
public class RR implements Algorithm 
{
    private List<Task> list;
    // creates list
    public RR(List<Task> Q) 
    {
        this.list = new ArrayList<Task>(Q);
    }

    public void schedule() 
    {
        Task CT;
        int time = 0;
        //loops until empty, or NULL
        while (list != null) 
        {
            CT = pickNextTask();
            if(CT == null)
            {
                break;
            }
            //runs the given task for ten seconds
            time = CT.getBurst() - 10;
            //if the time is 0, the task is finished and removed from the queue
            if (time <= 0) 
            {
                CPU.run(CT, CT.getBurst());
                list.remove(CT);
            } 
            //if there is still time needed to run task, 10 seconds will be subtracted and task will be added to the end of the queue
            else 
            {
                CPU.run(CT, 10);
                CT.setBurst(time);
                addTask(CT);
            }
        }
    }

    //if empty, will add NULL
    public Task pickNextTask() 
    {
        if (list.isEmpty()) 
        {
            return null;
        }
        return list.remove(0);
    }
    // adds task
    public void addTask(Task T) 
    {
        list.add(T);
    }
}