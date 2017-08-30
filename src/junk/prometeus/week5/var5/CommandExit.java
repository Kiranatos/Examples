package junk.prometeus.week5.var5;

/**
 * Описывает команду Exit.
 * @author Hobbit Jedi
 */
public class CommandExit extends Command {

	public CommandExit(Object aReceiver)
	{
		super(aReceiver);
	}

	@Override
	public void execute() throws Exception
	{
		((Receiver)mReceiver).exit();
	}
	
}