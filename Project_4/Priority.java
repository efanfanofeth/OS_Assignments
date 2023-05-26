import java.util.*;

// uses Priority which is running based on priority level from highest to lowest
public class Priority implements Algorithm 
{
    private List<Task> list;
    
    public Priority(List<Task> list) 
    {
        this.list = list;
    }
    
    public void schedule() 
    {
        //Expression used to takes 2 items and compare priority. If the expression is positive t2 has a higher priority,
        //negative means t1 has a higher priority, and 0 means they have the same priority
        Collections.sort(list, (T1, T2) -> T2.getPriority() - T1.getPriority());
        
        //loops through the list until empty
        List<Task> COPY = new ArrayList<>(list); 
        for (Task task:COPY) 
        {
            CPU.run(task, task.getBurst());
            list.remove(task);
        }   
    }
    //Not in use, kept to satisfy Algorithm
    public Task pickNextTask() 
    {
    return null;
    }
}