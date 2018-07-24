public class Print implements Command {

	@Override
	public String getCommand() {
		
		return "print -f <path> [-colour=0/1] [-two-sided=0/1]";
	}

}
