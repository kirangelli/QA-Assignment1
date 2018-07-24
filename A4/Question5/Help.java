import java.util.HashMap;
import java.util.Map;

public class Help
{
	
	public Map<String,Command> commandMap = new HashMap<String,Command>();
	
	public Help()
	{

		
		Command command = new Print();
		commandMap.put("print",command);	
		command = new Open();
		commandMap.put("open", command);
		command = new Close();
		commandMap.put("close",command);
		
	}
	public String GetHelp(String command)
	{
		if (command != null && command.length() != 0)
		{		
			return commandMap.get(command).getCommand();
		}
		return ListAllCommands();
	}

	public String ListAllCommands()
	{
		
		return "Commands: print, open, close";
	}
}