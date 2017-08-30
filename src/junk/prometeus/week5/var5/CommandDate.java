package junk.prometeus.week5.var5;

import java.util.ArrayList;

/**
 * Описывает команду Date.
 * @author Hobbit Jedi
 */
public class CommandDate extends Command {

	public CommandDate(Object aReceiver)
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
				throw new Exception("Команда Date принимает только строковые аргументы.");
			}
			if (!((String)arg).toLowerCase().equals("now")) // Тут нужно перечислить через ИЛИ все корректные аргументы.
			{
				throw new Exception("Некорректный аргумент передан в команду Date.");
			}
		}
		super.setArguments(aArguments);
	}
	
	@Override
	public void execute() throws Exception
	{
		if (mArguments.size() == 1 && ((String)mArguments.get(0)).equals("now"))
		{
			((Receiver)mReceiver).dateNow();
			mArguments.clear(); // После выполнения команды очищаем список аргументов, чтобы при следующем ее выполнении нельзя было использовать аргумент с прошлого раза.
		}
		else
		{
			throw new Exception("Вызов команды Date без указания аргументов.");
		}
	}
	
}