package bg.mobile;

import com.plamenti.Browser;;

public class HomePage extends BasePage{

	private final String url = "https://www.mobile.bg/";
	private final String title = "Mobile.bg – Българският автомобилен пазар: нови и втора употреба автомобили, джипове, камиони, мотоциклети...";
	
	public void navigateTo() {
		Browser.navigate(url);
	}
	
	public boolean isCorrectTitle() {
		return Browser.title().equals(this.title);
	}
}
