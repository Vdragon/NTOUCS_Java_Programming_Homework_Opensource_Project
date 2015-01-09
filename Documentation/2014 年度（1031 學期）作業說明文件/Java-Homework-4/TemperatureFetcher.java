package ntou.cs.java;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import org.jsoup.Connection;
import org.jsoup.Connection.Method;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class TemperatureFetcher
{
	public static String url = "http://www.cwb.gov.tw/V7/forecast/week/week.htm";

	// 取得指定地理位置其當週逐日白天或晚上的高低氣溫
	public static TemperatureBundle getTemperature (String location)
			throws IOException, IndexOutOfBoundsException
	{

		Connection.Response res = Jsoup
				.connect(url)
				.userAgent(
						"Mozilla/5.0 (Windows NT 6.1; WOW64; rv:26.0) Gecko/20100101 Firefox/26.0")
				.method(Method.GET).execute();

		Document doc = res.parse();
		
		Element weekDays = doc.select("tr:contains(星期日)")
				.get(0);
		String weekDates[] = getWeekDates(weekDays);
		
		Element dayWeathers = doc.select("tr:contains(" + location + ")")
				.get(0);
		Element nightWeathers = dayWeathers.nextElementSibling();

		String dayTemps[] = getTempratures(dayWeathers);
		String nightTemps[] = getTempratures(nightWeathers);

		TemperatureBundle tempBundle = new TemperatureBundle(location,
				weekDates, dayTemps, nightTemps);
		return tempBundle;
	}

	public static String[] getWeekDates(Element dateFragment) {
		ArrayList<String> datesList = new ArrayList<String>();
		Elements dates = dateFragment.getElementsByTag("th");
		
		for (Element cell : dates){
			if (cell.text().contains("星期")) {
				String text = cell.text();	
				int splitIndex = text.indexOf(" ");
				String dateStr = text.substring(0, splitIndex);
				datesList.add(dateStr);
			}
		}
		String[] datesAry = new String[datesList.size()];
		datesAry = datesList.toArray(datesAry);
		return datesAry;
	}
	
	// 取得白天或晚上的當週所有高低氣溫
	public static String[] getTempratures (Element tempFragment)
			throws IOException, IndexOutOfBoundsException
	{
		ArrayList<String> tempsList = new ArrayList<String>();
		Elements temps = tempFragment.getElementsByTag("td");
		for (Element cell : temps)
		{
			String seperator = " ~ ";
			// String description = cell.getElementsByTag("img").attr("title");
			if (cell.text().contains(seperator))
			{
				String temp = cell.text();
				tempsList.add(temp);				
			}
		}
		String[] tempsAry = new String[tempsList.size()];
		tempsAry = tempsList.toArray(tempsAry);
		return tempsAry;
	}

	public static void main (String args[])
	{
		try
		{
			TemperatureBundle tempBundle = getTemperature("基隆");
			System.out.println(tempBundle);
		} catch (IOException ie)
		{
			System.err.println(ie);
		} catch (IndexOutOfBoundsException iobe)
		{
			System.err.println(iobe);
		}
	}
}
