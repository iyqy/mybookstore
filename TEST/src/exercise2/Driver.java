package exercise2;

class Duration {
	private int hours, minutes, seconds;

	Duration() {
		hours = 6;
		minutes = 30;
		seconds = 20;
	}

	Duration(int is) {
		hours = is / 3600;
		minutes = is % 3600 / 60;
		seconds = is % 3600 % 60;
	}

	public int getHours() {
		return hours;
	}

	public void setHours(int hours) {
		this.hours = hours;
	}

	public int getMinutes() {
		return minutes;
	}

	public void setMinutes(int minutes) {
		this.minutes = minutes;
	}

	public void setSeconds(int seconds) {
		this.seconds = seconds;
	}

	public String toString() {
		return hours + "时 " + minutes + " 分 " + seconds + "秒";

	}

	public int getSeconds() {

		return seconds;
	}
}

class Track {
	private String title;
	private Duration duration;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Duration getDuration() {
		return duration;
	}

	public void setDuration(Duration duration) {
		this.duration = duration;
	}

	public String toString() {

		return "my Track title is: " + title + " duration is: " + duration;
	}
}

public class Driver {

	public static void main(String[] args) {
		Duration duration = new Duration(6666);
		Track track = new Track();
		track.setDuration(duration);
		track.setTitle("北京时间");
		System.out.println(track);
	}

}
