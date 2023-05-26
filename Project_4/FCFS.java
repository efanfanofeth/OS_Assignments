import java.util.*;

// uses FCFS which is running the first tasks that come in
public class FCFS implements Algorithm 
{
    private List<Task> list;

    public FCFS(List<Task> list) 
    {
        this.list = list;
    }

    // the schedule keeps repeating through the list until empty.
    public void schedule() 
    {
        List<Task> copy = new ArrayList<>(list); // make a copy of the list
        for (Task task:copy) 
        {
            CPU.run(task, task.getBurst());
            list.remove(task);
        }
    }
    
    //function not in use, but needed in order to satisy Algorithm
    public Task pickNextTask() 
    {
        return null;
    }
}