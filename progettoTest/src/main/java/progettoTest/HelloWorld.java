package progettoTest;


public class HelloWorld
{
	private String message;

	public void setMessage(final String message)
	{
		this.message = message;
	}

	public void getMessage()
	{
		System.out.println("Your Message : " + message);
	}

	@Override
	public String toString()
	{
		return "HelloWorld [message=" + message + "]";
	}


}
