package model;

public class Goal {

	private String GTitle;
	private String GDescription;

	/**
	 * A constructor.
	 * @param GTitle a String goal title.
	 * @param GDescription a String goal description.
	 */
	public Goal(String GTitle, String GDescription) {
		setGTitle(GTitle);
		setGDescription(GDescription);
		// this.GTitle = GTitle;
		// this.GDescription = GDescription;
	}

	/**
	 * Sets the goal title.
	 * @param title a String goal title.
	 */
	private void setGTitle(String title) {
		GTitle = title;
	}

	/**
	 * Gets the goal title.
	 * @return a String goal title
	 */
	public String getGTitle() {
		return GTitle;
	}

	/**
	 * Sets goal description.
	 * @param desc a String goal description.
	 */
	private void setGDescription(String desc) {
		GDescription = desc;
	}

	/**
	 * Gets goal description.
	 * @return a String goal description.
	 */
	public String getGDescription() {
		return GDescription;
	}

}
