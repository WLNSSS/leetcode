package lettercode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FindItinerary_332 {
	
	public List<String> findItinerary(List<List<String>> tickets) {
		List<String> result = new ArrayList<String>();
		result.add("JFK");
		dfs(tickets,"JFK",result,tickets.size(),"000");
		return result;
    }
	
	public boolean dfs(List<List<String>> tickets,String target,List<String> result,int ticketsSize,String preToS) {
		if(result.size() == ticketsSize + 1) {
			return true;
		}
		String toS = "aaa";
		int index = 0;
		int resultIndex = 0;
		List<List<String>> newTickets = new ArrayList<List<String>>();
		for(List<String> tempList : tickets) {
			if(tempList.get(0).equals(target)) {
				if(tempList.get(1).compareTo(toS) < 0 && tempList.get(1).compareTo(preToS) > 0) {
					toS = tempList.get(1);
					resultIndex = index;
				}
			}
			index++;
			newTickets.add(tempList);
		}
		
		newTickets.remove(resultIndex);
		if(toS.equals("aaa"))
			return false;
		result.add(toS);
		if(dfs(newTickets,toS,result,ticketsSize,"000")) {
		}else {
			result.remove(result.size() - 1);
			newTickets.add(tickets.get(resultIndex));
			dfs(newTickets,target,result,ticketsSize,toS);
		}
		return false;
	}

	public static void main(String[] args) {
		List<List<String>> tickets = new ArrayList<List<String>>();
		List<String> tempList = new ArrayList<String>();
//		tempList.add("JFK");
//		tempList.add("SFO");
//		tickets.add(tempList);
//		tempList = new ArrayList<String>();
//		tempList.add("JFK");
//		tempList.add("ATL");
//		tickets.add(tempList);
//		tempList = new ArrayList<String>();
//		tempList.add("SFO");
//		tempList.add("ATL");
//		tickets.add(tempList);
//		tempList = new ArrayList<String>();
//		tempList.add("ALT");
//		tempList.add("JFK");
//		tickets.add(tempList);
//		tempList = new ArrayList<String>();
//		tempList.add("ALT");
//		tempList.add("SFO");
//		tickets.add(tempList);
		
		
		tempList.add("EZE");
		tempList.add("TIA");
		tickets.add(tempList);
		tempList = new ArrayList<String>();
		tempList.add("EZE");
		tempList.add("HBA");
		tickets.add(tempList);
		tempList = new ArrayList<String>();
		tempList.add("AXA");
		tempList.add("TIA");
		tickets.add(tempList);
		tempList.add("JFK");
		tempList.add("AXA");
		tickets.add(tempList);
		tempList = new ArrayList<String>();
		tempList.add("ANU");
		tempList.add("JFK");
		tickets.add(tempList);
		tempList = new ArrayList<String>();
		tempList.add("ADL");
		tempList.add("ANU");
		tickets.add(tempList);
		tempList.add("TIA");
		tempList.add("AUA");
		tickets.add(tempList);
		tempList = new ArrayList<String>();
		tempList.add("ANU");
		tempList.add("AUA");
		tickets.add(tempList);
		tempList = new ArrayList<String>();
		tempList.add("ADL");
		tempList.add("EZE");
		tickets.add(tempList);
		tempList.add("ADL");
		tempList.add("EZE");
		tickets.add(tempList);
		tempList = new ArrayList<String>();
		tempList.add("EZE");
		tempList.add("ADL");
		tickets.add(tempList);
		tempList = new ArrayList<String>();
		tempList.add("AXA");
		tempList.add("EZE");
		tickets.add(tempList);
		tempList.add("AUA");
		tempList.add("AXA");
		tickets.add(tempList);
		tempList = new ArrayList<String>();
		tempList.add("JFK");
		tempList.add("AXA");
		tickets.add(tempList);
		tempList = new ArrayList<String>();
		tempList.add("AXA");
		tempList.add("AUA");
		tickets.add(tempList);
		tempList.add("AUA");
		tempList.add("ADL");
		tickets.add(tempList);
		tempList = new ArrayList<String>();
		tempList.add("ANU");
		tempList.add("EZE");
		tickets.add(tempList);
		tempList = new ArrayList<String>();
		tempList.add("TIA");
		tempList.add("ADL");
		tickets.add(tempList);
		tempList.add("EZE");
		tempList.add("ANU");
		tickets.add(tempList);
		tempList = new ArrayList<String>();
		tempList.add("AUA");
		tempList.add("ANU");
		tickets.add(tempList);
		FindItinerary_332 fi = new FindItinerary_332();
		fi.findItinerary(tickets);

	}

}
