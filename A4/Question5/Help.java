import java.util.*;
import java.util.Map;

public class Help
{
	
	public Map<String,Command> commandMap = new LinkedHashMap<String,Command>();
	
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
		StringBuilder listOfCommands = new StringBuilder("Commands: ");
		List<String> keyList = new ArrayList<String>(commandMap.keySet());
		for(int i=0;i<keyList.size();i++)
		{
			String key = keyList.get(i);
			listOfCommands.append(key);
			if(i!=keyList.size()-1)
			{
				listOfCommands.append(", ");
			}
		}
		
		return listOfCommands.toString();
	}
}
