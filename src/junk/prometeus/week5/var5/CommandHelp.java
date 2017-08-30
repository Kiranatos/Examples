package junk.prometeus.week5.var5;

/**
 * Описывает команду Help.
 * @author Hobbit Jedi
 */
public class CommandHelp extends Command {

	public CommandHelp(Object aReceiver)
	{
		super(aReceiver);
	}

	@Override
	public void execute()
	{
		((Receiver)mReceiver).help();
	}
	
}