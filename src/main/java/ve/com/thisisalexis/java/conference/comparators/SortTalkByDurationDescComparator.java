package ve.com.thisisalexis.java.conference.comparators;

import java.util.Comparator;

import ve.com.thisisalexis.java.conference.abstracts.AbstractTalk;

public class SortTalkByDurationDescComparator implements Comparator<AbstractTalk> {
	public int compare(AbstractTalk a, AbstractTalk b) {
        return b.getTalkDuration() - a.getTalkDuration();
    }
}