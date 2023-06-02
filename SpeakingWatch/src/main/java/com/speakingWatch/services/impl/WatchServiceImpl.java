package com.speakingWatch.services.impl;

import com.speakingWatch.entities.Counting;
import com.speakingWatch.entities.CountingHelper;
import com.speakingWatch.repo.ContingHelperRepo;
import com.speakingWatch.repo.ContingRepo;
import com.speakingWatch.services.WatchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class WatchServiceImpl implements WatchService {


    @Autowired
    ContingRepo contingRepo;

    @Autowired
    ContingHelperRepo contingHelperRepo;

    @Override
    public String getWatchTime(String time) {
        String finalHoursValue = "";
        String finalMinutesValue = "";

        String newTime = "Its ";
        try {
            String[] asd = time.split(":");

            if(asd[0].equals("24") && asd[1].equals("00")) {
                return "Its Midnight";
            }

            if(asd.length !=2 ) {
                return "Please send the right format";
            }

            if(asd[0].length() > 2 || Integer.parseInt(asd[0]) > 23 || asd[1].length() > 2 || Integer.parseInt(asd[1]) > 59) {
                return "Please send the right format";
            }

            String hours = asd[0];

            if(asd[0].equals("12") && asd[1].equals("00")) {
                return "Its Midday";
            }

            if(hours.length() == 1) {
                finalHoursValue = getObjectOfSingleDigit(hours);
            } else if (hours.length() == 2) {
                if(Integer.parseInt(hours) > 19) {
                    char[] timeHoursConverterhours = hours.toCharArray();
                    finalHoursValue = getCountingHelper(timeHoursConverterhours[0]+"")+" "+getObjectOfSingleDigit(timeHoursConverterhours[1]+"") ;
                    } else {
                    finalHoursValue = getObjectOfSingleDigit(hours);
                }
            }


            String minutes = asd[1];
            if(hours.length() == 1) {
                finalMinutesValue = getObjectOfSingleDigit(minutes);
            } else if (minutes.length() == 2) {
                if(Integer.parseInt(minutes) > 19) {
                    char[] timeHoursConverterhours = minutes.toCharArray();
                    finalMinutesValue = getCountingHelper(timeHoursConverterhours[0]+"")+" "+getObjectOfSingleDigit(timeHoursConverterhours[1]+"") ;
                } else {
                    finalMinutesValue = getObjectOfSingleDigit(minutes);
                }
            }


        } catch (Exception e) {
            e.printStackTrace();
        }
        return newTime +" " + finalHoursValue + " " + finalMinutesValue;
    }


    String getObjectOfSingleDigit(String hours) {
        String returnValue = "";
        Optional<Counting> counting = contingRepo.findById(hours);
        if(counting.isPresent()) {
            Counting counting1 = counting.get();
            returnValue = counting1.getValue();
        }
        return returnValue;
    }

    String getCountingHelper(String hours) {
        String returnValue = "";
        Optional<CountingHelper> countingHelper = contingHelperRepo.findById(hours);
        if(countingHelper.isPresent()) {
            CountingHelper counting1 = countingHelper.get();
            returnValue = counting1.getValue();
        }
        return returnValue;

    }


}
