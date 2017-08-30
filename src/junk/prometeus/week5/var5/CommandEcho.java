package junk.prometeus.week5.var5;

import java.util.ArrayList;

/**
 * Описывает команду Echo.
 * @author Hobbit Jedi
 */
public class CommandEcho extends Command {

	public CommandEcho(Object aReceiver)
	{
		super(aReceiver);
		mNumOfArguments = 1;
		mArguments = new ArrayList<>();
	}

	@Override
	public void setArguments(ArrayList<Object> aArguments) throws Exception
	{
		for (Object arg: aArguments)
		{
			if (!(arg instanceof String))
			{
				throw new Exception("Команда Echo принимает только строковые аргументы.");
			}
		}
		super.setArguments(aArguments);
	}
	
	@Override
	public void execute() throws Exception
	{
		if (mArguments.size() == 1)
		{
			((Receiver)mReceiver).echo((String)mArguments.get(0));
			mArguments.clear(); // После выполнения команды очищаем список аргументов, чтобы при следующем ее выполнении нельзя было использовать аргумент с прошлого раза.
		}
		else
		{
			throw new Exception("Вызов команды Echo без указания аргументов.");
		}
	}
	
}