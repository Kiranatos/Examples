package junk.prometeus.week5.var5;

import java.util.ArrayList;

/**
 * Описывает команду вообще и методы, которые она должна предоставлять.
 * @author Hobbit Jedi
 */
abstract public class Command {
	protected final Object mReceiver;             // Объект, на который воздействует команда.
	protected int mNumOfArguments;          // Количество принимаемых командой аргументов.
	protected ArrayList<Object> mArguments; // Аргументы команды, если они есть.
	
	public Command(Object aReceiver)
	{
		mReceiver = aReceiver;
		mNumOfArguments = 0; // В реализации по умолчанию команда аргументов не принимает.
		mArguments = null;   // В реализации по умолчанию команда аргументов не принимает.
	}
	
	/**
	 * Получить количество аргументов команды.
	 * @return - Количество принимаемых командой аргументов.
	 */
	public int getNumOfArguments()
	{
		return mNumOfArguments;
	}
	
	/**
	 * Установить аргументы команды.
	 * @param aArguments - Массив аргументов команды.
	 * @throws Exception - Если аргументы команде не понравятся, то метод выбросит исключение.
	 */
	public void setArguments(ArrayList<Object> aArguments) throws Exception
	{
		mArguments.clear();
		if (aArguments.size() == mNumOfArguments)
		{
			mArguments.addAll(aArguments);
		}
		else
		{
			throw new Exception("Некорректное количество аргументов.");
		}
	}
	
	/**
	 * Выполнить команду.
	 */
	abstract public void execute() throws Exception;
	
}