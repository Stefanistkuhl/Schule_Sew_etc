public class TimeHelper {
	private int hour;
	private int minute;
	private int seconds;

	public int getHour() {
		return hour;
	}

	public void setHour(int hour) {
		this.hour = hour % 12;
	}

	public int getMinute() {
		return minute;
	}

	public void setMinute(int minute) {
		this.minute = minute;
	}

	public int getSeconds() {
		return seconds;
	}

	public void setSeconds(int seconds) {
		this.seconds = seconds;
	}
}
