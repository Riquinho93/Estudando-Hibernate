package App;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.protocol.http.WebApplication;

import com.myFirstProject.Start;

import View.Colecao;
import View.HomePage;

/**
 * Application object for your web application.
 * If you want to run this application without deploying, run the Start class.
 * 
 * @see com.myFirstProject.Start#main(String[])
 */
public class WicketApplication extends WebApplication
{
	/**
	 * @see org.apache.wicket.Application#getHomePage()
	 */
	@Override
	public Class<? extends WebPage> getHomePage()
	{
		return Colecao.class;
	}

	/**
	 * @see org.apache.wicket.Application#init()
	 */
	@Override
	public void init()
	{
		super.init();

		// add your configuration here
	}
}
