package ntou.cs.java;

import java.util.Arrays;

public class TemperatureBundle
{
	String location; // 地理區域名稱
	String weekDates[]; // 本周日期 (從今天開始)
	String dayTemps[]; // 本周白天氣溫 (從今天開始)
	String nightTemps[]; // 本周晚上氣溫 (從今天開始)

	public TemperatureBundle (String location, String[] weekDates,
			String[] dayTemps, String[] nightTemps)
	{
		this.location = location;
		this.weekDates = weekDates;
		this.dayTemps = dayTemps;
		this.nightTemps = nightTemps;
	}

	public String getLocation ()
	{
		return location;
	}

	public String[] getWeekDates ()
	{
		return weekDates;
	}

	public String[] getDayTemps ()
	{
		return dayTemps;
	}

	public String[] getNightTemps ()
	{
		return nightTemps;
	}

	@Override
	public String toString ()
	{
		return "TemperatureBundle [location=" + location + ", weekDates="
				+ Arrays.toString(weekDates) + ", dayTemps="
				+ Arrays.toString(dayTemps) + ", nightTemps="
				+ Arrays.toString(nightTemps) + "]";
	}
}
