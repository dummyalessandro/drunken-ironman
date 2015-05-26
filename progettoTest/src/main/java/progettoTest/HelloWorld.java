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

	public HelloWorld(final String message)
	{
		super();
		this.message = message;
	}

	@Override
	public int hashCode()
	{
		final int prime = 31;
		int result = 1;
		result = prime * result + ((message == null) ? 0 : message.hashCode());
		return result;
	}

	@Override
	public boolean equals(final Object obj)
	{
		if (this == obj)
		{
			return true;
		}
		if (obj == null)
		{
			return false;
		}
		if (getClass() != obj.getClass())
		{
			return false;
		}
		final HelloWorld other = (HelloWorld) obj;
		if (message == null)
		{
			if (other.message != null)
			{
				return false;
			}
		}
		else if (!message.equals(other.message))
		{
			return false;
		}
		return true;
	}




}
