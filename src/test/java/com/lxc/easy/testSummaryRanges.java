package com.lxc.easy;

import org.junit.Test;

public class testSummaryRanges {
    @Test
    public void testSummaryRanges(){
        int nums[]={0,1,2,4,5,7};
        System.out.println(new SummaryRanges().summaryRanges(nums));
    }
    @Test
    public void testSummaryRangesBest(){
        int nums[]={0,1,2,4,5,7};
        System.out.println(new SummaryRanges().summaryRangesBest(nums));
    }

}
