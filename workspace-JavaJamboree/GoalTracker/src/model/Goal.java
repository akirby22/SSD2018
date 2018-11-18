package model;

public class Goal {

	private String GTitle;
	private String GDescription;

	public Goal(String GTitle, String GDescription) {
		setGTitle(GTitle);
		setGDescription(GDescription);
		// this.GTitle = GTitle;
		// this.GDescription = GDescription;
	}

	private void setGTitle(String title) {
		GTitle = title;
	}

	public String getGTitle() {
		return GTitle;
	}

	private void setGDescription(String desc) {
		GDescription = desc;
	}

	public String getGDescription() {
		return GDescription;
	}

}
